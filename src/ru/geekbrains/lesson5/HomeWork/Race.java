package ru.geekbrains.lesson5.HomeWork;

import ru.geekbrains.lesson5.HomeWork.Stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {//заполняется массив этапов гонки
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}