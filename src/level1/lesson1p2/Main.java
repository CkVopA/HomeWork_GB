package level1.lesson1p2;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

//    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//    С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int [] b = {1,0,1,1,0,0,1};
        invertBinaryArray(b);

// 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] emptyArray = new int[8];
        for (int i = 0; i < emptyArray.length; i++) {
            emptyArray[i] = 3*i;
            System.out.print(emptyArray[i]+ " ");
        }
        System.out.println();

// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arrayNum = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        multiplyBy2IfLessThan6(arrayNum);

// 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//                и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int [][] square  = new int[7][7];
        fillDiagonalsOnes(square);

// 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int [] array5 = {2,10, -6, 4, 21, 11, 10, -4, 8, 5, -9, 1 };
        findMinAndMaxValue(array5);
        System.out.println(sumOfArray(array5));

//  6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//   если в массиве есть место, в котором сумма левой и правой части массива равны.
//   Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//    граница показана символами ||, эти символы в массив не входят.
        int [] equalArr = {2, 1, 3, 4, 2};
        int [] array6 = {1,1,2,0,0,0,1,1,0,-1,0,0,1,1,0,};
        System.out.println(checkBalance(array5));
        System.out.println(checkBalance(equalArr));
        System.out.println(checkBalance(array6));

/*
  7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
          или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
          Для усложнения задачи нельзя пользоваться вспомогательными массивами.
*/
        int[] sevenArr = {2,4,6,8,9,10};
        shiftArray(sevenArr, -2);

    }

    private static void fillDiagonalsOnes(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (i==j || i+j== square.length-1) {
                    square[i][j]=1;
                }
                System.out.print(square[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void shiftArray (int [] ar, int n){
        int stepShift = n;
        int xSafety;
        while (stepShift != 0) {
            if (n%ar.length == 0) {
                System.out.println("Массив остался такого же вида");
                break;
            }
            if (n>0) {
                xSafety = ar[ar.length - 1];
                for (int i = ar.length - 1; i >= 0; i--) {
                    if (i > 0) {
                        ar[i] = ar[i - 1];
                    } else {
                        ar[0] = xSafety;
                        xSafety = ar[ar.length - 1];
                        stepShift--;
                    }
                }
            }
            if (n<0) {
                xSafety = ar[0];
                for (int i = 0; i < ar.length; i++) {
                    if (i < ar.length-1){
                        ar[i] = ar[i+1];
                    }
                    else if (i == ar.length-1) {
                        ar[i] = xSafety;
                        xSafety = ar[0];
                        stepShift++;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(ar));
    }

    public static boolean checkBalance (int [] arr) {
        int sumOfMembers = 0;
        for (int j : arr) {
            if (sumOfMembers == sumOfArray(arr) - sumOfMembers) {
                return true;
            } else sumOfMembers += j;
        }
        return false;
    }

    public static int sumOfArray (int[] arr){
        int sum=0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    public static void findMinAndMaxValue(int[] array5) {
        int minValueOfArray5 = 0;
        int maxValueOfArray5 = 0;
        for (int j : array5) {
            if (minValueOfArray5 < j) {
                minValueOfArray5 = j;
            } else if (maxValueOfArray5 > j) {
                maxValueOfArray5 = j;
            }
        }
        System.out.println("Минимальное значение массива: "+ minValueOfArray5);
        System.out.println("Максимальное значение массива: "+ maxValueOfArray5);
    }

    public static void multiplyBy2IfLessThan6(int[] arrayNum) {
        for (int i = 0; i < arrayNum.length; i++) {
            if (arrayNum[i]<6){
                arrayNum[i]*=2;
            }
            System.out.print(arrayNum[i]+" ");
        }
        System.out.println();
    }

    public static void invertBinaryArray(int[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i]==1) b[i]=0;
            else if (b[i]==0) b[i]=1;
            System.out.print(b[i]);
        }
        System.out.println();
    }

}
