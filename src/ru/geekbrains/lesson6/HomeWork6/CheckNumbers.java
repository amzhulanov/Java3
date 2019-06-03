package geekbrains.lesson6.HomeWork6;

import java.util.*;

public class CheckNumbers {

    public static boolean checkNum(int [] mass){
        TreeSet<Integer> arr=new TreeSet<>();

        for(int next:mass){arr.add(next);}
        if (arr.size()==2&&arr.first()==1&&arr.last()==4){
            return true;
        }
        return false;

    }
}
