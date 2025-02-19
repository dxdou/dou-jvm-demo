package com.dou.demo.classpath;

import com.dou.demo.classpath.impl.CompositeEntry;
import com.dou.demo.classpath.impl.DirEntry;
import com.dou.demo.classpath.impl.WildcardEntry;
import com.dou.demo.classpath.impl.ZipEntry;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: dxdou
 * @Date: 2025/02/18/20:16
 * @Description:类路径接口
 */
public interface Entry {


    byte[] readClass(String className) throws IOException;

    static Entry create(String path) {
        if (path.contains(File.pathSeparator)) {
            return new CompositeEntry(path);
        }
        if (path.contains("*")) {
            return new WildcardEntry(path);
        }
        if (path.endsWith(".jar") || path.endsWith(".JAR")) {
            return new ZipEntry(path);
        }
        return new DirEntry(path);
    }
}
