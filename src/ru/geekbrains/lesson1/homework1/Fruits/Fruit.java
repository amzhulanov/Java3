package ru.geekbrains.lesson1.homework1.Fruits;

public abstract class Fruit {
    Float weight;
    Integer cnt;

    public Float getWeightFruits() {
        return weight;
    }

    public Integer getCntFruits() {
        return cnt;
    }

    public void setCntFruits(Integer cnt) {
        this.cnt = cnt;
    }
}
