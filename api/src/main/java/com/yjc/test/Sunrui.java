package com.yjc.test;


import java.lang.ref.WeakReference;

public class Sunrui {


    private static int a = 0;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("1");
        super.finalize();
    }

    public static void main(String[] args) throws InterruptedException {
        Sunrui a = new Sunrui();
        WeakReference<Sunrui> reference = new WeakReference(a);
        Sunrui b = reference.get();
        System.runFinalization();
        System.out.println();
    }
}
