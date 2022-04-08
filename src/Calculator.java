import java.util.Scanner;

public class Calculator {


    enum Operation{
        SUM {
            public int action(int x, int y){ return x + y;}
        },
        SUBTRACT {
            public int action(int x, int y){ return x - y;}
        },
        MULTIPLY {
            public int action(int x, int y){ return x * y;}
        },
        DIVIDE {
            public int action(int x, int y){ return x / y;}
        };
        public abstract int action(int x, int y);
    }

    public static int isArabicOrRoman (String num) {
        int ret = 0;
        try {
            int tmp = Integer.parseInt(num);
            if (tmp <= 10)
                ret = 1;
        } catch (Exception ignored) {}
        try {
            romanNums.romanNumsEnum tmp = romanNums.romanNumsEnum.valueOf(num);
            if (tmp.getValue() <= 10)
                ret = 2;
        } catch (Exception ignored) {}
//        System.out.println(num + ": " + ret);
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");

        if (line.length != 3)
            throw new IllegalStateException("Error! At least 3 args need to proceed :(");


        Operation op;
        switch (line[1]) {
            case "-" -> op = Operation.SUBTRACT;
            case "+" -> op = Operation.SUM;
            case "*" -> op = Operation.MULTIPLY;
            case "/" -> op = Operation.DIVIDE;
            default -> throw new IllegalStateException("Error! Unexpected value: " + line[1]);
        }
        System.out.println("First num: " + line[0]);
        System.out.println("Operation: " + op.name());
        System.out.println("Second num: " + line[2]);

        if (isArabicOrRoman(line[0]) == 1 && isArabicOrRoman(line[2]) == 1) {
            int num1 = Integer.parseInt(line[0]);
            int num2 = Integer.parseInt(line[2]);
            System.out.println("Result: " + op.action(num1, num2));
        }
        else if (isArabicOrRoman(line[0]) == 2 && isArabicOrRoman(line[2]) == 2) {
            int res;
            romanNums first = new romanNums(line[0]);
            romanNums second = new romanNums(line[2]);
            if ((res = op.action(first.getNumIntValue(), second.getNumIntValue())) < 1)
                throw new IllegalStateException("Error! In Roman there is no nums less than I :(");
            System.out.println("Result: " + first.parseArabicToRoman(res));
        }
        else
            throw new IllegalStateException("Error! Args should be all roman or arabic and less than 11:(");
    }
}