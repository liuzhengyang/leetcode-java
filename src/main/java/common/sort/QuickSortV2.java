package common.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-14
 */
public class QuickSortV2 {
	public int partition(int[] array, int left, int right) {
		int storeIndex = left;
		int pivotValue = array[right];
		for (int i = left; i < right; i++) {
			if (array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex);
		return storeIndex;
	}

	public void sort(int[] array, int left, int right) {
		if (left > right) {
			return;
		}
		int storeIndex = partition(array, left, right);
		sort(array, left, storeIndex - 1);
		sort(array, storeIndex + 1, right);
	}

	public void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int[] arr = new int[100];
			int[] arrCopied = new int[100];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = new Random().nextInt(100);
			}
			System.arraycopy(arr, 0, arrCopied, 0, arr.length);
			new QuickSortV2().sort(arr);
			Arrays.sort(arrCopied);
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(arrCopied));
			System.out.println(Arrays.equals(arr, arrCopied));
			if (!Arrays.equals(arr, arrCopied)) {
				System.out.println("not");
			}
		}
	}
}
