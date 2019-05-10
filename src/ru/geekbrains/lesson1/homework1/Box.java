package ru.geekbrains.lesson1.homework1;

import ru.geekbrains.lesson1.homework1.Fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private  final List<T> box = new ArrayList<>();



    public   void addFruit(T fruit) {
        box.add(fruit);
    }

    public  Float getWeight() {
       Float weightBox=0.0f;
        for (Fruit item:box) {
           weightBox+=item.getWeightFruits()*item.getCntFruits();
        }
        return weightBox;
    }

    public boolean compare(Box<?> box){
        return Math.abs(this.getWeight()-box.getWeight())<0.0001;
    }

}

