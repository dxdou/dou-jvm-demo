package com.dou.demo.classpath.impl;

import com.dou.demo.classpath.Entry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: dxdou
 * @Date: 2025/02/18/20:51
 * @Description:
 */
public class WildcardEntry extends CompositeEntry {

    public WildcardEntry(String pathList) {
        super(toPathList(pathList));
    }

    private static String toPathList(String pathList) {
        String baseDir = pathList.replace("*", "");

        try {
            return Files.walk(Paths.get(baseDir))
                    .filter(Files::isRegularFile)
                    .map(Path::toString)
                    .filter(s -> s.endsWith(".jar") || s.endsWith(".JAR"))
                    .collect(Collectors.joining(File.pathSeparator));
        } catch (IOException e) {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(toPathList(Paths.get(System.getenv("JAVA_HOME"), "jre").toString() + "/lib/*"));
    }
}
