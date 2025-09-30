package tests;

import org.testng.annotations.Test;

public class C10_ParallelTesting {

    @Test
    void test01() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    void test02() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    void test03() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    void test04() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }

    @Test
    void test05() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }


}