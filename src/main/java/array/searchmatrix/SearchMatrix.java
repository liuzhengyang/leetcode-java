package array.searchmatrix;

/**
 * @author liuzhengyang
 * 2020/7/22
 */
public class SearchMatrix {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        // binary search line
        int left = 0;
        int right = matrix.length - 1;
        int line = 0;
        boolean lineFind = false;
        while (left <= right) {
            int midLine = left + (right - left) / 2;
            if (matrix[midLine][0] <= target && target <= matrix[midLine][matrix[0].length - 1]) {
                lineFind = true;
                line = midLine;
                break;
            } else if (target < matrix[midLine][0]) {
                right = midLine - 1;
            } else {
                left = midLine + 1;
            }
        }
        if (!lineFind) {
            return false;
        }
        left = 0;
        right = matrix[line].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[line][mid] == target) {
                return true;
            } else if (matrix[line][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // binary search column
        return false;
    }
}
