package ru.geekbrains.lesson5.HomeWork;

import java.util.concurrent.Phaser;

import static ru.geekbrains.lesson5.HomeWork.MainClass.phaser;
import static ru.geekbrains.lesson5.HomeWork.MainClass.startBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    Phaser phsr;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, Phaser p) {//задаются параметры автомобиля каждого участника
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        phsr=p;
        phsr.register();
        this.name = "Участник #" + CARS_COUNT;
    }


    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));//задержка готовности к гонке
            System.out.println(this.name + " готов");
            startBarrier.await();//ожидаю, пока будут готовы все участники
            phsr.arriveAndAwaitAdvance();//оповещаю, что фаза подготовки к гонки завершена
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        phaser.arriveAndAwaitAdvance();//оповещаю, что фаза гонки завершена
    }
}