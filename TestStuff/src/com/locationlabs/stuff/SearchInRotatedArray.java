package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 4/8/19.
 */
public class SearchInRotatedArray {

   private static int search(int[] nums, int target) {
      if (nums == null || nums.length == 0 ) {
         return -1;
      }

      int start = 0;
      int end = nums.length -1;

      while (start <= end) {
         int mid = (start + end) / 2;

         if (target == nums[mid]) {
            return mid;
         }

         if (nums[start] <= nums[mid]) {
            if (target < nums[mid] && target >= nums[start]) {
               end = mid - 1;
            } else {
               start = mid + 1;
            }
         } else if (nums[mid] <= nums[end]) {
            if (target > nums[mid] && target <= nums[end]) {
               start = mid + 1;
            } else {
               end = mid - 1;
            }
         }
      }

      return -1;
   }

   private static boolean searchII(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
         return false;
      }

      int start = 0, end = nums.length - 1;


      while (start <= end) {
         int mid = (start + end) / 2;

         if (target == nums[mid]) {
            return true;
         }

         if (nums[start] < nums[mid]) {
            if (target < nums[mid] && target >= nums[start]) {
               end = mid;
            } else {
               start = mid + 1;
            }
         } else if (nums[start] > nums[mid]) {
            if (target > nums[mid] && target < nums[start]) {
               start = mid + 1;
            } else {
               end = mid;
            }
         } else {
            start++;
         }
      }

      return false;
   }

   private static int findMin(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int start = 0;
      int end = nums.length - 1;

      while (start < end) {
         int mid = (start + end) / 2;

         if (nums[mid] > nums[end]) {
            start = mid + 1;
         } else {
            end = mid;
         }

      }

      return nums[start];
   }

   public static void main(String[] args) {
      System.out.println(search(new int[]{2,3,4,1}, 1));
//      int[] nums = new int[]{1,3,1,1,1};
      System.out.println(searchII(new int[]{1, 3, 5}, 1));
      System.out.println(searchII(new int[]{4,5,6,7,0, 0, 1, 1, 2}, 0));
//      System.out.println(findMin(new int[]{3,1,2}));
   }
}
