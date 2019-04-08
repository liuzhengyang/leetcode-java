package implementrand10usingrand7;

/**
 * @author liuzhengyang
 */
public class Solution {
    public static void main(String[] args) {

    }

    int result = rand7();

    public int rand10() {
        result = (result + rand7()) % 10;
        return result;
    }

    private int rand7() {
        return 0;
    }
}
