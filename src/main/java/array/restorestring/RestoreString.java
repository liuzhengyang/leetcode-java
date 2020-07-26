package array.restorestring;

/**
 * @author liuzhengyang
 */
public class RestoreString {
    public static void main(String[] args) {
        RestoreString restoreString = new RestoreString();
        System.out.println(restoreString.restoreString("codeleet", new int[] {4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(restoreString.restoreString("abc", new int[] {0, 1, 2}));
        System.out.println(restoreString.restoreString("aiohn", new int[] {3, 1, 4, 2, 0}));
    }

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] == i) {
                continue;
            } else {
                move(chars, indices, indices[i], chars[i]);
            }
        }
        return new String(chars);
    }

    private void move(char[] move, int[] indices, int toIndex, char c) {
        int toIndexValue = indices[toIndex];
        if (toIndex == toIndexValue) {
            return;
        }
        char toIndexChar = move[toIndex];
        move[toIndex] = c;
        indices[toIndex] = toIndex;
        move(move, indices, toIndexValue, toIndexChar);
    }
}
