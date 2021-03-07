package HomeWork6;

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

        print("Reversed number: " + reversNumber.process(4567));
        print("Reversed number: " + reversNumber.process(9876));
        print("+++++++++++++++++++++++++++++++");

        // реализация удаления нулей из числа
        NumbersProcess removerZeroes = number -> {
            StringBuilder builder = new StringBuilder();
            while (number != 0) {
                int remainder = number % 10;
                if (remainder == 0) {
                    number /= 10;
                    continue;
                } else {
                    builder.append(remainder);
                    number /= 10;
                }
            }
            String out = builder.reverse().toString();
            int converted = Integer.valueOf(out);
            return converted;
        };

        print("Without zeroes: " + removerZeroes.process(10203040));
        print("Without zeroes: " + removerZeroes.process(40070099));
        print("+++++++++++++++++++++++++++++++");

        // замена нечетных цифр на ближайшее чётное снизу.
        NumbersProcess changeOddToEven = number -> {
            char[] chars = String.valueOf(number).toCharArray();
            StringBuilder clearedNum = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (isEven(chars[i])) {
                    clearedNum.append(chars[i]);
                } else {
                    clearedNum.append(changeNumber(chars[i]));
                }
            }
            return Integer.parseInt(clearedNum.toString());
        };

        print("Updated num: " + changeOddToEven.process(234567));
        print("Updated num: " + changeOddToEven.process(876543));
        print("+++++++++++++++++++++++++++++++");

        // разворот исходной строки
        StringProcess reversString = string -> {
            StringBuilder reversed = new StringBuilder(string);
            reversed.reverse();
            return reversed.toString();
        };

        print("Reversed string: " + reversString.process("AbCdEfGhI"));
        print("+++++++++++++++++++++++++++++++");

        // убрать все чилсла из строки
        StringProcess onlyLetters = string -> {
            StringBuilder withoutNumbers = new StringBuilder();
            String regexForNumbers = "[0-9]";
            String clear = string.replaceAll(regexForNumbers, "");
            withoutNumbers.append(clear);
            return withoutNumbers.toString();
        };

        print("Deleted numbers: " + onlyLetters.process("w2r4t5 y7q1"));
        print("Deleted numbers: " + onlyLetters.process("w234r4456t565 y78q10"));
        print("+++++++++++++++++++++++++++++++");

        // сделать все маленькие буквы большими
        StringProcess bigLetters = String::toUpperCase;
        print("Only big letters: " + bigLetters.process("If two people get on like a house on fire"));
    }



    public static boolean isEven(char element) {
        return Integer.valueOf(element) % 2 == 0;
    }

    public static int changeNumber(char element) {
        int current = Integer.valueOf(String.valueOf(element));
        int update = current - 1;
        return update;
    }

    public static void print(Object object) {
        System.out.println(object);
    }
}
