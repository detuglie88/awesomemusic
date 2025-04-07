package com.awesomemusic.awesomemusic.controller;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.TestInfo;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BaseTest {

    protected static String mapJsonToString(TestInfo testInfo, String suffisso) throws IOException {
        String path = getPath(testInfo, suffisso, "json");
        return getRisorsaString(path);
    }

    private static String getRisorsaString(String path) throws IOException {
        try{
            ClassLoader classLoader = BaseTest.class.getClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
            return FileUtils.readFileToString(file, "UTF-8");
        }catch (Exception e){
            throw new IOException("Path che genera errore: "+path+" - "+e.getMessage());
        }
    }

    private static String getPath(TestInfo testInfo, String suffisso, String estensione) {
        String path = suffisso + "." + estensione;
        if(testInfo!=null && testInfo.getTestClass().isPresent() && testInfo.getTestMethod().isPresent() && estensione!=null) {
            path = testInfo.getTestClass().get().getSimpleName()
                    + "/"
                    + testInfo.getTestMethod().get().getName()
                    +(suffisso!=null ? "-"+suffisso : "")
                    +"."+estensione;
        }
        return path;
    }
}
