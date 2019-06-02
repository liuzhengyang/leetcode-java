package strings;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("LEET", "CODE"));
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM", "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
            return "";
        }
        for (int i = str1.length(); i > 0; i--) {
            String subStr = str1.substring(0, i);
            if (isDivisor(subStr, str1) && isDivisor(subStr, str2)) {
                return subStr;
            }
        }

        return "";
    }

    private boolean isDivisor(String subStr, String str) {
        int fromIndex = 0;
        int findIndex = 0;
        while ((findIndex = str.indexOf(subStr, fromIndex)) != -1) {
            fromIndex = findIndex + subStr.length();
            if (fromIndex == str.length()) {
                return true;
            }
        }
        return false;
    }
}
