package com.yjc.test;

import java.util.Scanner;

public class SunruiTest {
    public static void main(String[] args) {
        System.out.println("请输入你的名字:");
        Scanner name = new Scanner(System.in);
        if (name.hasNext()) {
            System.out.println("你想干嘛：");
            Scanner sb = new Scanner(System.in);
            System.out.println(a() + "在" + sb.next() + "，然后到处拉屎");
        }

        name();

    }

    public static void name() {
        System.out.println("△");
    }


    public static String a() {
        return "易家成";
    }
}


