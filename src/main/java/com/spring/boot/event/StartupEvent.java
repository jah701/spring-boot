package com.spring.boot.event;

import com.spring.boot.dto.ReviewDto;
import com.spring.boot.model.Comment;
import com.spring.boot.model.Product;
import com.spring.boot.model.Role;
import com.spring.boot.model.User;
import com.spring.boot.model.Word;
import com.spring.boot.security.AuthenticationService;
import com.spring.boot.service.CommentService;
import com.spring.boot.service.ProductService;
import com.spring.boot.service.RoleService;
import com.spring.boot.service.UserService;
import com.spring.boot.service.WordService;
import com.spring.boot.service.mapper.CommentMapper;
import com.spring.boot.service.mapper.ProductMapper;
import com.spring.boot.service.mapper.UserMapper;
import com.spring.boot.util.CustomCsvLoader;
import com.spring.boot.util.CustomCsvParser;
import java.io.File;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class StartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    @Value("${csv.file.url}")
    private String csvFileUrl;
    @Value("${load.into.path}")
    private String loadedFile;
    @Value("${file.from.path}")
    private String file;

    private final RoleService roleService;
    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final ProductService productService;
    private final CommentService commentService;
    private final CustomCsvLoader customCsvLoader;
    private final CustomCsvParser customCsvParser;
    private final UserMapper userMapper;
    private final CommentMapper commentMapper;
    private final ProductMapper productMapper;
    private final WordService wordService;

    @Autowired
    public StartupEvent(RoleService roleService,
                        UserService userService,
                        AuthenticationService authenticationService, ProductService productService,
                        CommentService commentService, CustomCsvLoader customCsvLoader,
                        CustomCsvParser customCsvParser,
                        UserMapper userMapper,
                        CommentMapper commentMapper,
                        ProductMapper productMapper, WordService wordService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
        this.commentService = commentService;
        this.customCsvLoader = customCsvLoader;
        this.customCsvParser = customCsvParser;
        this.userService = userService;
        this.productService = productService;
        this.userMapper = userMapper;
        this.commentMapper = commentMapper;
        this.productMapper = productMapper;
        this.wordService = wordService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("Injecting roles. . .");
        Role user = Role.of("USER");
        Role admin = Role.of("ADMIN");
        roleService.add(user);
        roleService.add(admin);
        log.info("Roles have been added successfully");

        if (!new File(loadedFile).exists()) {
            log.info("Loading CSV file. URL - " + csvFileUrl);
            customCsvLoader.loadCsvFile(csvFileUrl, loadedFile);
            log.info("CSV file has been loaded successfully");
        } else {
            log.info("File " + loadedFile + " already exists. Download omitted.");
        }

        log.info("Starting file parsing. . .");
        List<ReviewDto> reviews = customCsvParser.csvToReview(file);
        log.info("File has been parsed");

        log.info("Injecting entities. . .");
        List<User> users = userMapper.mapAll(reviews);
        users.forEach(authenticationService::register);
        log.info("Users have been added");

        List<Comment> comments = commentMapper.mapAll(reviews);
        comments.forEach(commentService::add);
        log.info("Comments have been added");

        List<Product> products = productMapper.mapAll(reviews);
        products.forEach(productService::add);
        log.info("Products have been added");

        List<Word> mappedWords = wordService.getAllMappedWords();
        mappedWords.forEach(wordService::add);
        log.info("Words have been added");
        log.info("All entities have been added successfully");
    }
}
