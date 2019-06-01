package math;

public class DigitCountInRange {
    public static void main(String[] args) {
        DigitCountInRange digitCountInRange = new DigitCountInRange();

        System.out.println(digitCountInRange.digitsCount(1, 1, 13));
        System.out.println(digitCountInRange.digitsCount(3, 100, 250));
        System.out.println(digitCountInRange.digitsCount(3, 100, 20000_0000));
        System.out.println(digitCountInRange.digitsCount(1, 100, 20000_0000));
    }

    public int digitsCount(int d, int low, int high) {
        if (low > high) {
            return 0;
        }

        int count = 0;
        for (int i = low; i <= high; i++) {
            count += containsDigits(i, d);
        }
        return count;
    }

    private int containsDigits(int num, int digit) {
        int count = 0;
        while (num != 0) {
            int thisDigit = num % 10;
            num /= 10;
            if (thisDigit == digit){
                count ++;
            }
        }
        return count;
    }
}
