package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/8/20.
 */
public class Search2DMatrix {
   private static boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0) {
         return false;
      }

      int rows = matrix.length;
      int cols = matrix[0].length - 1;

      for (int i = 0 ; i < rows; i++) {
         int[] nums = matrix[i];
         if (nums == null || nums.length == 0) {
            continue;
         }
         if (target >= nums[0] && target <= nums[cols]) {
            return binarySearch(nums, target);
         }
      }

      return false;
   }

   private static boolean binarySearch(int[] nums, int target) {
      int low = 0, high = nums.length - 1;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (nums[mid] == target) {
            return true;
         }

         if (nums[mid] < target) {
            low = mid + 1;
         } else if (nums[mid] > target) {
            high = mid - 1;
         }
      }
      return false;
   }

   private static boolean searchMatrixII(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0) {
         return false;
      }

      int row = 0, column = matrix[0].length - 1;
      while (column >= 0 && row < matrix.length) {
         int val = matrix[row][column];
         if (target == val) {
            return true;
         }

         if (target > val) {
            row++;
         } else if (target < val) {
            column--;
         }
      }
      return false;
   }

   public static void main(String[] args) {
      int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
      System.out.println(searchMatrix(matrix, 3));
      System.out.println(searchMatrix(matrix, 13));
      System.out.println(searchMatrix(new int[][]{{1}}, 1));

      System.out.println("---------------------------------------");

      matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
      System.out.println(searchMatrixII(matrix, 5));
      System.out.println(searchMatrixII(matrix, 20));
   }
}
