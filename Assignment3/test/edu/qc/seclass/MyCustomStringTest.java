package edu.qc.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    // Test when there is no digits in the string
    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("There is no digits in this string");
        assertEquals(0, mycustomstring.countNumbers());
    }

    // Test separate digits in the strings
    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("The digit 123 is different digit from 34 and 498");
        assertEquals(3, mycustomstring.countNumbers());
    }

    // Test if space is count as digit or not
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("Determine if space is count as a digit: eg. 1 2 3");
        assertEquals(3, mycustomstring.countNumbers());
    }

    // Test for empty string
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    // Test for null string
    @Test (expected = NullPointerException.class)
    public void testCountNumbers6() {
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    // Test when n=2 and true, it retrieves the spaces and only prints the digits
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("1 2 3 4 5 6 ");
        assertEquals("123456", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    // Test when n=2 and false, it retrieves the digits and only prints the spaces
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString("1 2 3 4 5 6 ");
        assertEquals("      ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    // Test if the current string is empty or has less than n characters, the method returns an
    // empty string.
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("string < n");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(15, true));
    }

    // Test if "n" less than or equal to zero
    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("when n is less than or equal to zero");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    // Test when n=2 and startFromEnd=true, it prints the string in order
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString(" h e l l o ");
        assertEquals("hello", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    // Test when n=1 and startFromEnd=false, it prints the string in order
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("hello world");
        assertEquals("hello world", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    // Test when n=3 and startFromEnd=false, yields diff output from startFromEnd=true
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("hello num 1 a");
        assertEquals("eou1", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    // Test when n=3 and startFromEnd=false, yields diff output from startFromEnd=true
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("hello num 1 a");
        assertEquals("l m ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    // Test when n=2 and startFromEnd=true gives same result as startFromEnd=false
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("hi queens");
        assertEquals("iqen", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    // Test when n=2 and startFromEnd=true gives same result as startFromEnd=false
    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("hi queens");
        assertEquals("iqen", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    // Test when n = 0 or -1, it throws illegalArgumentException 
    @Test (expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("Let's test this exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    // Test when string is null, it throws NullPointerException
    @Test (expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    // Test non-digit characters up to index 12 of string length
    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("hi 12 & 13 @ 14 $ 15");
        mycustomstring.convertDigitsToNamesInSubstring(1, 12);
        assertEquals("hi OneTwo & OneThree @ 14 $ 15", mycustomstring.getString());
    }

    // Test non-digit characters of the whole string
    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("hi 12 & 13 @ 14 $ 15");
        mycustomstring.convertDigitsToNamesInSubstring(1, mycustomstring.getString().length());
        assertEquals("hi OneTwo & OneThree @ OneFour $ OneFive", mycustomstring.getString());
    }

    // Testing spaces
    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString(" ");
        mycustomstring.convertDigitsToNamesInSubstring(1,1);
    }

    // Test when string is null, it throws NullPointerException
    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1,2);
    }

    // Test when the string startpoint begins at zero, it throws 
    // IndexOutOfBoundsException
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("hello world");
        mycustomstring.convertDigitsToNamesInSubstring(0,9);
    }

    // Test when the string endpoint is greater than string length, it throws 
    // IndexOutOfBoundsException
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("hello world");
        mycustomstring.convertDigitsToNamesInSubstring(1,mycustomstring.getString().length() + 1);
        
    }

    // Test when starting point is greater than end point, it throws
    // IllegalArgumentException
    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("hello world");
        mycustomstring.convertDigitsToNamesInSubstring(10,5);
    }

}
