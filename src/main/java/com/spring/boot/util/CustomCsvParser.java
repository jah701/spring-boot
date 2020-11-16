package com.spring.boot.util;

import java.util.List;

public interface CustomCsvParser {
    List<String[]> csvToModel(String path);
}
