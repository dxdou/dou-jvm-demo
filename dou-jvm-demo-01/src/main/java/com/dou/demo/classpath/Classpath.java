package com.dou.demo.classpath;

import com.dou.demo.classpath.impl.WildcardEntry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: dxdou
 * @Date: 2025/02/18/20:43
 * @Description:类路径
 */
public class Classpath {

    private Entry bootstrapClasspath; //启动类路径
    private Entry extensionClasspath; // 扩展类路径
    private Entry userClasspath; //用户类路径

    public Classpath(String jreOption, String cpOption) {
        bootstrapAndExtensionClasspath(jreOption);
        parseUserClasspath(cpOption);
    }

    public void bootstrapAndExtensionClasspath(String jreOption) {
        String jrdDir = getJreDir(jreOption);
        String jrelibDir = Paths.get(jrdDir, "lib") + File.separator + "*";
        bootstrapClasspath = new WildcardEntry(jrelibDir);

        String jreextDir = Paths.get(jrdDir, "lib", "ext") + File.separator + "*";
        extensionClasspath = new WildcardEntry(jreextDir);
    }

    private void parseUserClasspath(String cpOption) {
        userClasspath = Entry.create(cpOption);
    }

    public String getJreDir(String jreOption) {
        if (jreOption != null && Files.exists(Paths.get(jreOption))) {
            return jreOption;
        }
        String jreDir = System.getenv("JAVA_HOME"); //获取JAVA_HOME
        if (jreDir != null && Files.exists(Paths.get(jreDir))) {
            return Paths.get(jreDir, "jre").toString(); //获取JAVA_HOME目录
        }
        throw new RuntimeException("java home is not found");
    }


    public byte[] readClass(String className) throws IOException {
        className = className + ".class";
        try {
            return bootstrapClasspath.readClass(className);
        } catch (IOException e) {

        }
        try {
            return extensionClasspath.readClass(className);
        } catch (IOException e) {

        }
        return userClasspath.readClass(className);
    }

}
