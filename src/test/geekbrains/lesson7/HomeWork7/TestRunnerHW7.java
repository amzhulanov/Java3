package geekbrains.lesson7.HomeWork7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunnerHW7 {

    public static void start(Class<?> className) {
        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;
        //Создаю Map`у для методов с приоритетами для сортировки по приоритету
        Map<Integer, List<Method>> map = new HashMap<>();  //использую List для случаев, если у методов один приоритет

        //заполняю Мапу методами класса TestClass
        for (Method method : className.getDeclaredMethods()) {

        //    if (method.getAnnotation(BeforeSuite.class) != null) {
            if (method.getName()=="methodBefore"){//
                if (map.get(MIN_PRIORITY - 1) != null) {
                    throw new RuntimeException();//BeforeSuit должен быть один
                } else {//если уже есть метод с таким приоритетом, добавляю в List метод
                    List<Method> list = new ArrayList<>();
                    list.add(method);
                    map.put(MIN_PRIORITY - 1, list);
                }
            }
            //if (method.getAnnotation(AfterSuite.class) != null) {
            if (method.getName()=="methodAfter"){
                if (map.get(MAX_PRIORITY - 1) != null) {
                    throw new RuntimeException();//AfterSuit должен быть один
                } else {
                    List<Method> list = new ArrayList<>();
                    list.add(method);
                    map.put(MAX_PRIORITY + 1, list);
                }
            }
            if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                if (map.get(test.priority()) != null) {
                    map.get(test.priority()).add(method);
                } else {
                    List<Method> list = new ArrayList<>();
                    list.add(method);
                    map.put(test.priority() - 1, list);
                }
            }
        }

        System.out.println("Коллекция методов класса " + className.getSimpleName() + ":");
        for (Integer key : map.keySet()) {
            for (Method nt : map.get(key)) {
                System.out.println("Приоритет:" + key + " " + nt.getName());
            }
        }
        System.out.println("\nВыполняю методы из класса " + className.getSimpleName() + ":");

        try {
            Object testClass = new TestClass();
            List<Method> list = new ArrayList<>();
            for (Integer key : map.keySet()) {
                //   map.get(key).invoke(testClass);
                //System.out.println(map.get(key).size());
                //int ln=map.get(key).size();

                list=map.get(key);
                for (Method nextItem :list){
                    nextItem.invoke(testClass);
                }
                /*for (Method nt : map.get(key)) {

                    nt.invoke(testClass);
                }*/
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start(TestClass.class);
    }
}