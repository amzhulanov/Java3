package ru.geekbrains.lesson5.HomeWork.Stage;

import ru.geekbrains.lesson5.HomeWork.Car;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);//первый этап Дорога
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}