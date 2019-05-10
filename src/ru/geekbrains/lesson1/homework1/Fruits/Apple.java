package ru.geekbrains.lesson1.homework1.Fruits;

public class Apple extends Fruit {
    Integer appleCnt=1;
    Float WEIGHT_APPLE=1.0f;

    @Override
    public Float getWeightFruits() {
        return WEIGHT_APPLE;
    }

    @Override
    public Integer getCntFruits() {
        return appleCnt;
    }

    @Override
    public void setCntFruits(Integer cnt) {
        appleCnt=cnt;
    }
}
