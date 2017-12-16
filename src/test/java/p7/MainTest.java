package p7;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    Main main = new Main();
    @Test
    public void reverse() throws Exception {
        assertEquals(0, main.reverse(1534236469));
    }

}