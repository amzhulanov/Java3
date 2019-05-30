package ru.geekbrains.lesson5.HomeWork.Stage;

import ru.geekbrains.lesson5.HomeWork.Car;

import static ru.geekbrains.lesson5.HomeWork.MainClass.semaphore;


public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {//второй этап Туннел
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire(); //в туннель может заехать одновременно не более половины участников
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();//машина покинула тунель, освобождаю очередь
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}