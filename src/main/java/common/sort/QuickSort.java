//package common.sort;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Arrays;
//import java.util.Random;
//
///**
// * Description: Fast sort algorithm
// * device and conquer and recursive
// * if left part is ordered and righted is ordered and largest number in left is small than smallest number
// * in the right, the whole array is ordered too.
// *
// * @author liuzhengyang
// * @version 1.0
// * @since 2017-02-12
// */
//public class QuickSort {
//	private static final Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);
//
//	public void sort(int[] array) {
//
//		if (array == null || array.length == 0) {
//			LOGGER.info("Array is Null");
//			return;
//		}
//		sort(array, 0, array.length - 1);
//
//	}
//
//	public void sort(int[] array, int start, int end) {
//		if (start >= end) {
//			return;
//		}
//
//		int mid = array[end];
//		int left = start;
//		int right = end - 1;
//
//		while (left < right) {
//			while (array[left] < mid && left < right) {
//				left++;
//			}
//			while (array[right] >= mid && left < right) {
//				right--;
//			}
//			swap(array, left, right);
//		}
//		if (array[left] >= array[end]) {
//			swap(array, left, end);
//		} else {
//			left++;
//		}
//		sort(array, start, left - 1);
//		sort(array, left + 1, end);
//	}
//
//	public void swap(int[] array, int from, int to) {
//		int temp = array[from];
//		array[from] = array[to];
//		array[to] = temp;
//	}
//
//	public static void main(String[] args) {
//		for (int i = 0; i < 1000; i++) {
//			int[] arr = new int[100];
//			int[] arrCopied = new int[100];
//			for (int j = 0; j < arr.length; j++) {
//				arr[j] = new Random().nextInt(100);
//			}
//			System.arraycopy(arr, 0, arrCopied, 0, arr.length);
//			new QuickSort().sort(arr);
//			Arrays.sort(arrCopied);
////			System.out.println(Arrays.toString(arr));
////			System.out.println(Arrays.toString(arrCopied));
////			System.out.println(Arrays.equals(arr, arrCopied));
//			if (!Arrays.equals(arr, arrCopied)) {
//				System.out.println("not");
//			}
//		}
//	}
//}
