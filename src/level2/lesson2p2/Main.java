package level2.lesson2p2;
/*
Java. Уровень 2
Урок 2. Исключения
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
   при подаче массива другого размера необходимо бросить исключение MyArraySizeException.

2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
   Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
   должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.

3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException
   и вывести результат расчета.
*/

/*
Дополнительное задание для практики:
Требуется написать метод, принимающий на вход размеры двумерного массива и выводящий массив в виде
инкременированной цепочки чисел, идущих по спирали против часовой стрелки.
Примеры:
2х3
1 6
2 5
3 4

3х1
1 2 3
4х4
01 12 11 10
02 13 16 09
03 14 15 08
04 05 06 07

0х7
Ошибка!
 */
public class Main {

    public static void main(String[] args) {
        String[][] array = {{"1","F","3","6"},
                            {"A","1","2","4"},
                            {"4","3","N","1"},
                            {"4","3","N","1"}
        };
//        String[][] t = new String[3][5];
        print2Array(array);
        try {
            checkSizeArray(array);
        } catch (MyArraySizeException e){
            System.out.println("Ошибка размерности массива! "+e);
        }
        catch (MyArrayDataException e) {
            System.out.println("Ошибка преобразования в число!"+e);
        }
    }

    public static void checkSizeArray(String[][] arr)  {
        String[][] ref = new String[4][4];
        if (!(arr.length == ref.length)) throw new MyArraySizeException("Размер массива должен быть 4*4");
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++) {
                try {
                    sum += getArrInt(arr[i][j], i, j);
                } catch (MyArrayDataException e) {
                    System.out.println(e);
                }
            }
        }        System.out.println("Сумма числовых элементов массива = "+sum);
    }

    public  static int getArrInt (String str, int i, int j)
    {
        int val;
        if (isDigital(str)) val = Integer.parseInt(str);
        else
            throw new MyArrayDataException("Элемент " + str + " по индексу " + "(" + i + ")" + "(" + j + ") не приведён к числовому формату");
        return val;
    }

    public static boolean isDigital (String p) {
        try {
            Integer.parseInt(p);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void print2Array (String [][] arr2){
        for (String[] strings : arr2) {
            System.out.println(" ");
            for (String string : strings) {
                System.out.print("  "+string+"  ");
            }
        }
        System.out.println(" ");
    }
}