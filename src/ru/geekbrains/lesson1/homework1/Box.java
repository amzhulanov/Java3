package ru.geekbrains.lesson1.homework1;

import ru.geekbrains.lesson1.homework1.Fruits.Apple;
import ru.geekbrains.lesson1.homework1.Fruits.Fruit;
import ru.geekbrains.lesson1.homework1.Fruits.Orange;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    public List<T> fruits = new ArrayList<>();

    public static void main(String[] args) {
        Orange orange=new Orange();
        Apple apple=new Apple();

        Box<Apple> appleBoxFirst=new Box<>();
        Box<Apple> appleBoxSecond=new Box<>();
        Box<Orange> orangeBoxFirst=new Box<>();


        appleBoxFirst.addFruit(apple);
        appleBoxFirst.addFruit(apple);
        appleBoxFirst.addFruit(apple);
        appleBoxFirst.addFruit(apple);
        appleBoxSecond.addFruit(apple);
        appleBoxSecond.addFruit(apple);
        orangeBoxFirst.addFruit(orange);
        orangeBoxFirst.addFruit(orange);
        orangeBoxFirst.addFruit(orange);
        orangeBoxFirst.addFruit(orange);
        System.out.println("Вес первого ящика с яблоками = " +appleBoxFirst.getWeight());
        System.out.println("Вес второго ящика с яблоками = " +appleBoxSecond.getWeight());
        System.out.println("Вес ящика с апельсинами = " + orangeBoxFirst.getWeight());
        appleBoxFirst.intersperseFruit(appleBoxSecond);
        System.out.println("Яблоки пересыпали в один ящик, вес = " +appleBoxFirst.getWeight());

        System.out.println("Вес первого ящика с аблоками и  первого ящика апельсинами равен - "+appleBoxFirst.compare(orangeBoxFirst));
    }


    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public Float getWeight() {
        Float weightBox = 0.0f;
        for (Fruit item : fruits) {
            weightBox += item.getWeightFruits() * item.getCntFruits();
        }
        return weightBox;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public void intersperseFruit(Box<T> source) {
        fruits.addAll(source.fruits);

    }

}

