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
        try {
            int ret = Integer.parseInt(num);
            return 1;
        } catch (Exception ignored) {}
        try {
            romanNums.romanNumsEnum.valueOf(num);
            return 2;
        } catch (Exception ignored) {}
        return 0;
    }

    public static void main(String[] args) {
        if (args.length != 3)
            throw new IllegalStateException("Error! At least 3 args need to proceed :(");
        Operation op;
        switch (args[1]) {
            case "-" -> op = Operation.SUBTRACT;
            case "+" -> op = Operation.SUM;
            case "*" -> op = Operation.MULTIPLY;
            case "/" -> op = Operation.DIVIDE;
            default -> throw new IllegalStateException("Error! Unexpected value: " + args[1]);
        }
        System.out.println("First num: " + args[0]);
        System.out.println("Operation: " + op.name());
        System.out.println("Second num: " + args[0]);

        if (isArabicOrRoman(args[0]) == 1 && isArabicOrRoman(args[2]) == 1) {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[2]);
            System.out.println("Result: " + op.action(num1, num2));
        }
        else if (isArabicOrRoman(args[0]) == 2 && isArabicOrRoman(args[2]) == 2) {
            int res;
            romanNums first = new romanNums(args[0]);
            romanNums second = new romanNums(args[2]);
            if ((res = op.action(first.getNumIntValue(), second.getNumIntValue())) < 1)
                throw new IllegalStateException("Error! In Roman there is no nums less than I :(");
            System.out.println("Result: " + first.parseArabicToRoman(res));
        }
        else
            throw new IllegalStateException("Error! Args should be all roman or arabic :(");
    }
}