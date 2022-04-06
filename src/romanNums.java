import java.util.HashMap;

public class romanNums {
    private int numIntValue;

    public romanNums(String value) {
        this.numIntValue = romanNumsEnum.valueOf(value).getValue();
    }

    public int getNumIntValue() {
        return numIntValue;
    }

    public String parseArabicToRoman (int value) {
        HashMap<Integer, String> nums = new HashMap<>();
        nums.put(1, "I");
        nums.put(2, "II");
        nums.put(3, "III");
        nums.put(4, "IV");
        nums.put(5, "V");
        nums.put(6, "VI");
        nums.put(7, "VII");
        nums.put(8, "VIII");
        nums.put(9, "IX");
        nums.put(10, "X");

        int i = 10;
        String ret = "";

        while (value != 0) {
            if (value - i >= 0) {
                ret += nums.get(i);
                value -= i;
                continue;
            }
            i--;
        }
        return ret;
    }

    public enum romanNumsEnum {
        I(1),
        II(2),
        III(3),
        IV(4),
        V(5),
        VI(6),
        VII(7),
        VIII(8),
        IX(9),
        X(10);
        private int value;
        romanNumsEnum (int value) {
            this.value = value;
        }
        public int getValue(){ return value;}
    }
}
