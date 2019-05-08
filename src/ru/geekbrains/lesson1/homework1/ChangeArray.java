package ru.geekbrains.lesson1.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChangeArray {

    public static void main(String[] args) {
        Number[] numArr = new Number[100];

        Integer[] intArr = {1, 2, 3, 4};
        Long[] longArr = {1L, 2L, 3L, 4L};
        Double[] doubleArr = {1.1, 1.2, 2.5, 3.7};
        Float[] floatArr = {1.1f, 1.5f, 100.99f, 99.9999f};
        String[] stringArr={"abc","def","ghi","ikf"};
        System.out.println(changeItem(intArr,2,3));
        System.out.println(changeItem(floatArr,2,3));
        System.out.println(changeItem(stringArr,1,2));


    }

    public static <T> List<T> changeItem(T[] numListOut,int xPos, int yPos) {
        T item;
        item=numListOut[xPos];
        numListOut[xPos]=numListOut[yPos];
        numListOut[yPos]=item;
        List<T> numListIn=new ArrayList<>();
        Collections.addAll(numListIn,numListOut);
        return numListIn;


    }
}
