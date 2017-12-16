package p8;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {
    Main main = new Main();
    @Test
    public void myAtoi() throws Exception {
        assertEquals(2, main.myAtoi("2"));
        assertEquals(200, main.myAtoi("200"));
        assertEquals(1024, main.myAtoi("1024"));
        assertEquals(20, main.myAtoi("20"));
        assertEquals(2, main.myAtoi("02"));
        assertEquals(2, main.myAtoi("002"));
        assertEquals(0, main.myAtoi(""));
        assertEquals(2, main.myAtoi("+2"));
        assertEquals(-2, main.myAtoi("-2"));
        assertEquals(0, main.myAtoi("+"));
//        assertEquals(0, main.myAtoi("+-2"));
        assertEquals(12, main.myAtoi("  -0012a42"));
    }

}