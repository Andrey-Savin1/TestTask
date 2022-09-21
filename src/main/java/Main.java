import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Введите выражение типа 1+1 или I+I: ");
        String input = new Scanner(System.in).nextLine().replace(" ", "");

        if (input.isEmpty()) {
            throw new Exception("Вы передали пустое выражение.");
        }
        System.out.println(calc(input));

    }

    public static String calc(String input) throws Exception {

        String[] search = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] in = input.split("");
        String c = in[0];
        boolean foundAll = new HashSet<>(Arrays.asList(search)).contains(c);

        if (foundAll) {
            return romanCalc(input);
        } else return arabianCalc(input);
    }

    public static String arabianCalc(String input) throws Exception {

        String[] arr = input.split("[+-/*]");
        String[] operator = input.split("\\w");
        if (arr.length == 1) {
            throw new Exception();
        }
        int firstElem = Integer.parseInt(arr[0]);
        int secondElem = Integer.parseInt(arr[1]);
        String op = operator[operator.length - 1];
        int result = 0;

        if (input.length() > 5 || firstElem < 1 || firstElem > 10 || secondElem < 1 || secondElem > 10) {
            throw new Exception("Проверьте правильность ввода.");
        }
        result = getResult(firstElem, secondElem, op, result);

        return String.valueOf(result);

    }

    public static String romanCalc(String input) throws Exception {

        String[] arr = input.split("[+-/*]");
        String[] operator = input.split("\\w");
        int firstElem = romeToArabian(arr[0]);
        int secondElem = romeToArabian(arr[1]);
        String op = operator[operator.length - 1];
        int result = 0;

        if (input.length() > 9 || input.length() < 2 || firstElem < 1 || firstElem > 10 || secondElem < 1 || secondElem > 10) {
            throw new Exception("Проверьте правильность ввода.");
        }
        result = getResult(firstElem, secondElem, op, result);
        if (result < 1) {
            throw new Exception();
        }
        String toRoman = convertArabianToRoman(result);

        return String.valueOf(toRoman);

    }
    private static int getResult(int firstElem, int secondElem, String op, int result) {
        if (op.equals("+")) {
            result = firstElem + secondElem;
        }
        if (op.equals("-")) {
            result = firstElem - secondElem;
        }
        if (op.equals("*")) {
            result = firstElem * secondElem;
        }
        if (op.equals("/")) {
            result = firstElem / secondElem;
        }
        return result;
    }

    private static int romeToArabian(String rome) {

        int result = switch (rome) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };

        return result;
    }

    private static String convertArabianToRoman(int res) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[res];
        return s;
    }

}
