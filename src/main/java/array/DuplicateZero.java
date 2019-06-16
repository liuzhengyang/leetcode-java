package array;

import java.util.Arrays;

public class DuplicateZero {

    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] newArray = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j >= newArray.length) {
                break;
            }
            newArray[j++] = arr[i];
            if (arr[i] == 0) {
                if (j >= newArray.length) {
                    break;
                }
                newArray[j++] = arr[i];
            }
        }
        System.arraycopy(newArray, 0, arr, 0, newArray.length);
    }

    public static void main(String[] args) {
        DuplicateZero duplicateZero = new DuplicateZero();
        int[] arr = new int[] {1,0,2,3,0,4,5,0};
        duplicateZero.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
