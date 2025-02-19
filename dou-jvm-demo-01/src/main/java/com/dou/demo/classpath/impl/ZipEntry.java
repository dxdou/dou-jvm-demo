package com.dou.demo.classpath.impl;

import com.dou.demo.classpath.Entry;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: dxdou
 * @Date: 2025/02/18/20:59
 * @Description:
 */
public class ZipEntry implements Entry {

    private Path absolutePath;
    public ZipEntry(String path) {
        this.absolutePath = Paths.get(path).toAbsolutePath();
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        try (FileSystem fileSystem = FileSystems.newFileSystem(absolutePath,null)){
            return Files.readAllBytes(fileSystem.getPath(className));
        }
    }

    @Override
    public String toString() {
        return absolutePath.toString();
    }
}
