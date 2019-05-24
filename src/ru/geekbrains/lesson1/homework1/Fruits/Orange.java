package ru.geekbrains.lesson1.homework1.Fruits;

public class Orange extends Fruit {
    Integer orangeCnt=1;
    Float WEIGHT_ORANGE=1.5f;

    @Override
    public Float getWeightFruits() {
        return WEIGHT_ORANGE;
    }

    @Override
    public Integer getCntFruits() {
        return orangeCnt;
    }

}
