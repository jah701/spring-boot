package util;

import com.spring.boot.repository.RoleRepository;
import com.spring.boot.service.RoleService;
import com.spring.boot.service.impl.RoleServiceImpl;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RoleServiceImplTest {
    private static RoleService roleService;

    @BeforeAll
    static void beforeAll() {
        RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
        roleService = new RoleServiceImpl(roleRepository);
    }

    @Test
    public void getRoleByRoleExceptionThrown_ok() {
        Assertions.assertThrows(EntityNotFoundException.class,
                () -> roleService.getByRoleName("ADMIN"));
    }
}
