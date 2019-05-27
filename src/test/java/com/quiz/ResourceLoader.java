package com.quiz;

import java.io.IOException;

public interface ResourceLoader {

    void loadResources() throws IOException;

    void testResources() throws IOException;

    <T> T load(Class<T> clazz, String resource) throws IOException;
}
