import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanTest {

    @Test
    @DisplayName("should convert a number to a Roman string")
    public void turnOneToI() {
        assertEquals("I", new RomanNumeral(1).toRomanString());
        assertEquals("II", new RomanNumeral(2).toRomanString());
        assertEquals("III", new RomanNumeral(3).toRomanString());
        assertEquals("IV", new RomanNumeral(4).toRomanString());
        assertEquals("V", new RomanNumeral(5).toRomanString());
        assertEquals("VI", new RomanNumeral(6).toRomanString());
        assertEquals("IX", new RomanNumeral(9).toRomanString());
        assertEquals("X", new RomanNumeral(10).toRomanString());
        assertEquals("XL", new RomanNumeral(40).toRomanString());
        assertEquals("XLIX", new RomanNumeral(49).toRomanString());
        assertEquals("L", new RomanNumeral(50).toRomanString());
        assertEquals("XC", new RomanNumeral(90).toRomanString());
        assertEquals("XCIX", new RomanNumeral(99).toRomanString());
        assertEquals("C", new RomanNumeral(100).toRomanString());
    }

    @Test
    @DisplayName("should convert a Roman string to a number")
    public void turnIToOne() {
        assertEquals(1, new RomanNumeral("I").toNumber());
        assertEquals(2, new RomanNumeral("II").toNumber());
        assertEquals(3, new RomanNumeral("III").toNumber());
        assertEquals(4, new RomanNumeral("IV").toNumber());
        assertEquals(5, new RomanNumeral("V").toNumber());
        assertEquals(6, new RomanNumeral("VI").toNumber());
        assertEquals(9, new RomanNumeral("IX").toNumber());
        assertEquals(10, new RomanNumeral("X").toNumber());
        assertEquals(40, new RomanNumeral("XL").toNumber());
        assertEquals(50, new RomanNumeral("L").toNumber());
        assertEquals(90, new RomanNumeral("XC").toNumber());
        assertEquals(100, new RomanNumeral("C").toNumber());
    }

    @Test
    @DisplayName("should create an object from a Roman string")
    public void romanObjectStoresII() {
        RomanNumeral roman = new RomanNumeral("II");
        assertEquals("II", roman.toRomanString());
    }

    @Test
    @DisplayName("create a object from a number")
    public void romanObjectReturnNumberOrString() {
        RomanNumeral roman = new RomanNumeral(2);
        assertEquals("II", roman.toRomanString());
    }

    @Test
    @DisplayName("should create an object from a number")
    public void romanObjectStores2() {
        RomanNumeral roman = new RomanNumeral(2);
        assertEquals(2, roman.toNumber());
    }

    @Test
    @DisplayName("compare two objects to see if they are equal")
    public void compareRomanObjects() {
        RomanNumeral roman = new RomanNumeral("II");
        RomanNumeral roman_2 = new RomanNumeral("II");
        assertEquals(roman, roman_2);
    }

    @Test
    @DisplayName("addition with roman numerals")
    public void testNumeralAddition() {
        RomanNumeral roman = new RomanNumeral("II");
        RomanNumeral toAdd = new RomanNumeral("II");
        RomanNumeral sum = new RomanNumeral("IV");
        assertEquals(sum, roman.add(toAdd));
    }

    @Test
    @DisplayName("subtraction with roman numerals")
    public void testNumeralSubtraction() {
        RomanNumeral roman = new RomanNumeral("III");
        RomanNumeral toSubtract = new RomanNumeral("II");
        RomanNumeral sum = new RomanNumeral("I");
        assertEquals(sum, roman.subtract(toSubtract));
    }
}
