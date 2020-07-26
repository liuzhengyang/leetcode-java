package array.shufflestring;

/**
 * @author liuzhengyang
 */
public class ShuffleString {
    public static void main(String[] args) {
        ShuffleString shuffleString = new ShuffleString();
        System.out.println(shuffleString.restoreString("codeleet", new int[] {4, 5, 6, 7, 0, 2, 1, 3}));
    }

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            newChars[indices[i]] = chars[i];
        }
        return new String(newChars);
    }
}
