package p46;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MainTest {
    Main main = new Main();

    @Test
    public void permute() throws Exception {
        List<List<Integer>> result = new ArrayList<>();
        result.add(listOf(1, 2, 3));
        result.add(listOf(1, 3, 2));
        result.add(listOf(2, 1, 3));
        result.add(listOf(2, 3, 1));
        result.add(listOf(3, 1, 2));
        result.add(listOf(3, 2, 1));
        assertEquals(result, main.permute(new int[]{1, 2, 3}));
    }

    private List<Integer> listOf(int... args) {
        List<Integer> result = new ArrayList<>();
        for (int arg : args) {
            result.add(arg);
        }
        return result;
    }

}