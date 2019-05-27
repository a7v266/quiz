package com.softaria.quiz.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class FileUtils {

    public static InputStream getInputStream(String path) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        return classLoader.getResourceAsStream(path);
    }

    public static Reader createReader(String resourcePath, Charset charset) {
        InputStream inputStream = getInputStream(resourcePath);
        return new InputStreamReader(inputStream, charset);
    }
}
