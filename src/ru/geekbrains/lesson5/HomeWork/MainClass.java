package ru.geekbrains.lesson5.HomeWork;

import ru.geekbrains.lesson5.HomeWork.Stage.Road;
import ru.geekbrains.lesson5.HomeWork.Stage.Tunnel;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CyclicBarrier startBarrier = new CyclicBarrier( CARS_COUNT );
    public static Semaphore semaphore=new Semaphore(CARS_COUNT/2,true);
    public static Phaser phaser=new Phaser((1));

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];//массив машин участников
        for (int i = 0; i < cars.length; i++) {//задаётся скорость каждого участника
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),phaser);
        }

        for (int i = 0; i < cars.length; i++) {//для каждого участника создаётся свой поток
            new Thread(cars[i]).start();
          }
        phaser.arriveAndAwaitAdvance();//ожидаю оповещения о завершении фазы
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        phaser.arriveAndAwaitAdvance();//ожидаю оповещения о завершении фазы
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
