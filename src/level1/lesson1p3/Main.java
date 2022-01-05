package level1.lesson1p3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

/*        1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю
        дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
        указанное пользователем число чем загаданное, или меньше. После победы или проигрыша
        выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
*/

/*        2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana",
        "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
        "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
            При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
            Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы */

        menuMain();

    }

    private static void menuMain() {
        System.out.println("Выбери игру...");
        System.out.println("0. Завершить программу.\n" +
                "1. Угадай число.\n" +
                "2. Угадай слово.");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: gameStartGuessTheNumber();
            case 2: startGuessTheWord();
            case 0: System.exit(0);
        }
    }

    private static void startGuessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.println("Отгадайте загаданное компьютером слово.");
        Random random = new Random();
        String hiddenWord = words[random.nextInt(words.length)];
        System.out.println(hiddenWord);
        gameGuessTheWord (hiddenWord);
    }

    private static void gameGuessTheWord (String hiddenWord) {
        char sharp = '#';
        String attemptWord = scanner.nextLine();

        try {
            for (int i = 0; i < hiddenWord.length() + attemptWord.length(); i++) {
                char simbolHidden = hiddenWord.charAt(i);
                char simbolAttempt = attemptWord.charAt(i);
                if (hiddenWord.equals(attemptWord)){
                    System.out.println("Вы отгадали слово!");
                    askToContinuation();
                }
                if (simbolHidden == simbolAttempt){
                    System.out.print(simbolHidden);
                }
                else {
                    System.out.print(sharp);
                }
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.print(sharp);
            for (int i = 0; i < 14-attemptWord.length(); i++) {
                System.out.print(sharp);
            }
            System.out.println();
        }
        gameGuessTheWord(hiddenWord);
    }

    public static void gameStartGuessTheNumber() {
        int numGuess = (int) (Math.random() * 9);
        System.out.println("Попробуйте отгадать загаданное компьютером число от 0 до 9");
        int sumTry = 0;
        while (sumTry<3) {
            int x = scanner.nextInt();
            sumTry++;
            if (sumTry == 3){
                System.out.println("К сожалению у Вас кончиллись попытки =( Вы проиграли.");
                break;
            }
            if (x < numGuess) {
                System.out.println("Загаданное число Больше!");
            }
            if (x > numGuess) {
                System.out.println("Загаданное число Меньше!");
            }
            if (x==numGuess) {
                System.out.println("Вы угадали!");
                break;
            }
        }
        askToContinuation();
    }

    public static void askToContinuation() {
        System.out.println("Хотите сыграть ещё раз?");
        menuMain();
    }
}

