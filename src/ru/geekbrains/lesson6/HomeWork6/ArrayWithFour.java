package geekbrains.lesson6.HomeWork6;


public class ArrayWithFour {


    public int[] afterFour(int mas[]) {

        int n = 0;
        for (int nextItem : mas) {
            n++;
            if (nextItem == 4) {
                int[] result = new int[mas.length - n];
                System.arraycopy(mas, n, result, 0, mas.length - n);
                return result;
            }
        }
        throw new RuntimeException();
    }

}
