package ru.geekbrains.lesson5.HomeWork.Stage;

import ru.geekbrains.lesson5.HomeWork.Car;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}