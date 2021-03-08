package HomeWork6;

import static HomeWork6.UtilsForHW6.*;

public class MainTestDrive {

    public static void main(String[] args) {

        // реализация разворота числа
        NumbersProcess reversNumber = number -> {
            int reversed = 0;
            while (number != 0) {
                int remainder = number % 10;
                number /= 10;
                reversed = reversed * 10 + remainder;
            }
            return reversed;
        };

        println("Reversed number: " + reversNumber.process(4567));
        println("Reversed number: " + reversNumber.process(9876));
        println("+++++++++++++++++++++++++++++++");

        // реализация удаления нулей из числа
        NumbersProcess removerZeroes = number -> {
            int clearedNum = 0;
            while (number != 0) {
                int remainder = number % 10;
                if (remainder == 0) {
                    number /= 10;
                    continue;
                } else {
                    clearedNum = clearedNum * 10 + remainder;
                    number /= 10;
                }
            }
            return revers(clearedNum);
        };

        println("Without zeroes: " + removerZeroes.process(10203040));
        println("Without zeroes: " + removerZeroes.process(40070099));
        println("+++++++++++++++++++++++++++++++");

        // замена нечетных цифр на ближайшее чётное снизу.
        NumbersProcess changeOddToEven = number -> {
            int changedNum = 0;
            while (number != 0) {
                int remainder = number % 10;
                if (isEven(remainder)) {
                    changedNum = changedNum * 10 + remainder;
                    number /= 10;
                } else {
                    remainder -= 1;
                    changedNum = changedNum * 10 + remainder;
                    number /= 10;
                }
            }

            return revers(changedNum);
        };

        println("Updated num: " + changeOddToEven.process(234567));
        println("Updated num: " + changeOddToEven.process(876543));
        println("+++++++++++++++++++++++++++++++");

        // разворот исходной строки
        StringProcess reversString = string -> {
            StringBuilder reversed = new StringBuilder(string);
            reversed.reverse();
            return reversed.toString();
        };

        println("Reversed string: " + reversString.process("AbCdEfGhI"));
        println("+++++++++++++++++++++++++++++++");

        // убрать все чилсла из строки
        StringProcess onlyLetters = string -> {
            StringBuilder withoutNumbers = new StringBuilder();
            String regexForNumbers = "[0-9]";
            String clear = string.replaceAll(regexForNumbers, "");
            withoutNumbers.append(clear);
            return withoutNumbers.toString();
        };

        println("Deleted numbers: " + onlyLetters.process("w2r4t5 y7q1"));
        println("Deleted numbers: " + onlyLetters.process("w234r4456t565 y78q10"));
        println("+++++++++++++++++++++++++++++++");

        // сделать все маленькие буквы большими
        StringProcess bigLetters = String::toUpperCase;
        println("Only big letters: " + bigLetters.process("If two people get on like a house on fire"));
    }
}
