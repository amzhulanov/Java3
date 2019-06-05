package geekbrains.lesson7.HomeWork7;

import java.lang.reflect.Method;

public class TestClass {
    @BeforeSuite
    public void methodBefore() {
        System.out.println(getClass().getName()+" выполняю BeforeSuit");
    }

    @AfterSuite
    public void methodAfter() {
        System.out.println(getClass().getName()+" выполняю AfterSuit");
    }

    @Test(priority = 1)
    public void methodTest1() {
        System.out.println("Приоритет 1");
    }

    @Test(priority = 2)
    public void methodTest2() {
        System.out.println("Приоритет 2");
    }

    @Test(priority = 2)
    public void methodTest22() {
        System.out.println("Приоритет 2");
    }

    @Test(priority = 3)
    public void methodTest3() {
        System.out.println("Приоритет 3");
    }

    @Test(priority = 4)
    public void methodTest4() {
        System.out.println("Приоритет 4");
    }

    @Test(priority = 5)
    public void methodTest5() {
        System.out.println("Приоритет 5");
    }

    @Test(priority = 6)
    public void methodTest6() {
        System.out.println("Приоритет 6");


    }

    @Test(priority = 6)
    public void methodTest66() {
        System.out.println("Приоритет 6");
    }

    @Test(priority = 7)
    public void methodTest7() {
        System.out.println("Приоритет 7");
    }

    @Test(priority = 8)
    public void methodTest8() {
        System.out.println("Приоритет 8");
    }
}