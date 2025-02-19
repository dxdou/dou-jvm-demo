package com.dou.demo.classpath.impl;

import com.dou.demo.classpath.Entry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: dxdou
 * @Date: 2025/02/18/20:53
 * @Description:
 */
public class CompositeEntry implements Entry {

    private final List<Entry> entryList = new ArrayList<>();

    public CompositeEntry(String pathList) {
        String[] paths = pathList.split(File.pathSeparator);
        for (String path : paths) {
            entryList.add(Entry.create(path));
        }
    }

    @Override
    public byte[] readClass(String className) throws IOException {
        for (Entry entry : entryList) {
            return entry.readClass(className);
        }
        throw new IOException("class not found " + className);
    }

    @Override
    public String toString() {
        String[] strings = new String[entryList.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = entryList.get(i).toString();
        }
        return String.join(File.pathSeparator, strings);
    }
}
