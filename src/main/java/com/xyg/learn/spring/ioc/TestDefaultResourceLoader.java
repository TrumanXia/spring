package com.xyg.learn.spring.ioc;

import org.springframework.core.io.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import static junit.framework.TestCase.*;

/**
 * @author 97994
 * @since 2020-09-26
 */
public class TestDefaultResourceLoader {
    public static void main(String[] args) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fakeFileResource = resourceLoader.getResource("D:/spring21site/README");
        assertTrue(fakeFileResource instanceof ClassPathResource);
        assertFalse(fakeFileResource.exists());
        Resource urlResource1 = resourceLoader.getResource("file:D:/spring21site/README");
        assertTrue(urlResource1 instanceof UrlResource);
        Resource urlResource2 = resourceLoader.getResource("http://www.spring21.cn");
        assertTrue(urlResource2 instanceof UrlResource);
        // try {
        // fakeFileResource.getFile();
        // fail("no such file with path[" + fakeFileResource.getFilename() + "] exists in classpath");
        // } catch (FileNotFoundException e) {
        // System.out.println("ss");
        // }
        fail("no such file with path[" + fakeFileResource.getFilename() + "] exists in classpath");
        try {
            urlResource1.getFile();
        } catch (FileNotFoundException e) {
            fail();
        }

    }
}
