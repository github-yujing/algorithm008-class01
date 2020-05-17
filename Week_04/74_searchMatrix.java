//因为该题目给定的二维矩阵符合二分查找的使用条件，所以使用二分查找来完成。
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (matrix[mid / col][mid % col] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (matrix[left / col][left % col] != target) return false;
        return true;
    }
}
