package ru.geekbrains.lesson1.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChangeArray {

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4};
        Float[] floatArr = {1.1f, 1.5f, 100.99f, 99.9999f};
        String[] stringArr={"abc","def","ghi","ikf"};
        System.out.println(changeItem(intArr,2,3));
        System.out.println(changeItem(floatArr,2,3));
        System.out.println(changeItem(stringArr,1,2));


    }

    public static <T> List<T> changeItem(T[] numListOut,int xPos, int yPos) {
    //на вход метода подаётся массив и номера позиций элементов, которые необходимо поменять друг с другом
        T item;
        item=numListOut[xPos]; //во временную переменную копирую значение с позиции xPos
        numListOut[xPos]=numListOut[yPos];//в позицию xPos копирую значение с позиции yPos
        numListOut[yPos]=item;//в позицию yPos вставляю значение из временной переменной
        List<T> numListIn=new ArrayList<>();//создаю пустой список
        Collections.addAll(numListIn,numListOut);//преобразую массив в список ArrayList
        return numListIn; //возвращаю список


    }
}
