package weekly.contest.biweeek33;

/**
 * @author liuzhengyang
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.thousandSeparator(987));
        System.out.println(problem1.thousandSeparator(1234));
        System.out.println(problem1.thousandSeparator(123456));
        System.out.println(problem1.thousandSeparator(123456789));
        System.out.println(problem1.thousandSeparator(0));
    }

    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        int count = 0;
        while (n != 0) {
            if (count != 0 && (count % 3 == 0)) {
                sb.append(".");
            }
            count ++;
            sb.append(n % 10);
            n /= 10;

        }
        return sb.reverse().toString();
    }
}
