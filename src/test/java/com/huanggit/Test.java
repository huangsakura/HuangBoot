package com.huanggit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2017-12-15-0015.
 */
public class Test {

    public static void main(String[] a) {
        List<String> stringArray = new ArrayList<>();
        stringArray.add("a");
        stringArray.add("b");
        stringArray.add("c");
        stringArray.add("d");
        stringArray.forEach((s) -> System.out.println(s));
        new Thread(() -> System.out.println("aaa")).start();
    }
}
