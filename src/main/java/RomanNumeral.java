import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {

    private final String romanString;

    Map<Integer, String> mapping = new LinkedHashMap<Integer, String>() {{
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    Map<String, Integer> mappingRomanToInteger = new LinkedHashMap<String, Integer>() {{
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};

    public RomanNumeral(String numeral) {
        this.romanString = numeral;
    }

    public RomanNumeral(int number) {
        this.romanString = toRomanNumeral(number);
    }

    public String toRomanString() {
        return romanString;
    }

    public int toNumber() {
        return toInteger(this.romanString);
    }

    private String toRomanNumeral(int number) {
        String roman = "";
        for (Map.Entry<Integer, String> map : mapping.entrySet()) {
            while (number >= map.getKey()) {
                roman += map.getValue();
                number -= map.getKey();
            }
        }
        return roman;
    }

    private int toInteger(String romanNumeral) {
        int result = 0;
        int i = 0;
        while (i < romanNumeral.length()) {
            if (i + 1 < romanNumeral.length() &&
                    mappingRomanToInteger.containsKey(romanNumeral.substring(i, i + 2))) {
                result += mappingRomanToInteger.get(romanNumeral.substring(i, i + 2));
                i += 2;
            }
            else {
                result += mappingRomanToInteger.get(romanNumeral.substring(i, i + 1));
                i++;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.romanString.equals(((RomanNumeral) obj).romanString);
    }

    public RomanNumeral add(RomanNumeral other) {
        return new RomanNumeral(toNumber() + other.toNumber());
    }

    public RomanNumeral subtract(RomanNumeral other) {
        return new RomanNumeral(toNumber() - other.toNumber());
    }
}
