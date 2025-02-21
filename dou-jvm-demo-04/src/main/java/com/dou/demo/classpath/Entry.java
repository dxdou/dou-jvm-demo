package com.dou.demo.classpath;

import com.dou.demo.classpath.impl.CompositeEntry;
import com.dou.demo.classpath.impl.DirEntry;
import com.dou.demo.classpath.impl.WildcardEntry;
import com.dou.demo.classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOException;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 * 类路径接口
 */
public interface Entry {

    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {

        //File.pathSeparator；路径分隔符(win\linux)
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }

        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }

        if (path.endsWith(".jar") || path.endsWith(".JAR") ||
                path.endsWith(".zip") || path.endsWith(".ZIP")) {
            return new ZipEntry(path);
        }

        return new DirEntry(path);
    }

}
