package ru.geekbrains.lesson1.homework1;


import ru.geekbrains.lesson1.homework1.Fruits.Apple;
import ru.geekbrains.lesson1.homework1.Fruits.Orange;

public class Main {
    public static void main(String[] args) {
        Orange orange=new Orange();
        Apple apple=new Apple();

        Box<Apple> appleBox=new Box<Apple>();
        Box<Orange> orangeBox=new Box<Orange>();
        apple.setCntFruits(2);
        appleBox.addFruit(apple);
        System.out.println("Вес ящика яблок: "+appleBox.getWeight());
        apple.setCntFruits(15);
        appleBox.addFruit(apple);
        System.out.println("Вес ящика яблок: "+appleBox.getWeight());

        orange.setCntFruits(20);
        orangeBox.addFruit(orange);
        System.out.println("Вес ящика апельсин: "+orangeBox.getWeight());

        System.out.println("Вес ящиков одинаковый - "+appleBox.compare(orangeBox));
    }
}
