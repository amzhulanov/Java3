package geekbrains.lesson7.HomeWork7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunnerHW7 {

    public static void start(Class<?> className) {
        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;
        Method beforeSuit=null;
        Method afterSuite=null;
        //Создаю Map`у для методов с приоритетами для сортировки по приоритету
        //Map<Integer, List<Method>> map = new HashMap<>();  //использую List для случаев, если у методов один приоритет
        List<Method> map=new ArrayList<>();

        //заполняю Мапу методами класса TestClass
        for (Method method : className.getMethods()) {

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuit==null) {
                    beforeSuit=method;
                } else {//если уже есть метод с таким приоритетом, добавляю в List метод
                    throw new IllegalStateException("Method BeforeSuite duplicated");
                }
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuite==null) {
                    afterSuite=method;
                } else {//если уже есть метод с таким приоритетом, добавляю в List метод
                    throw new IllegalStateException("Method AfterSuite duplicated");//BeforeSuit должен быть один
                }
            }
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                map.add(method);

            }
        }

        System.out.println("Коллекция методов класса " + className.getSimpleName() + ":");
        for (Method mth : map) {
            System.out.println("Приоритет: " + mth.getName());
        }
        map.sort(Comparator.comparingInt(method ->method.getAnnotation(Test.class).priority()));

        System.out.println("\nВыполняю методы из класса " + className.getSimpleName() + ":");

        try {
            Object testClass = className.newInstance();
            if (beforeSuit!=null){
                beforeSuit.invoke(testClass);
            }
            for (Method mth : map) {
                mth.invoke(testClass);
            }
            if (afterSuite!=null){
                afterSuite.invoke(testClass);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start(TestClass.class);
    }
}