package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class MinAdjSwapsToPalindrome {
   private static int minSwaps(String S) {
      if (S == null || S.length() <= 1) {
         return 0;
      }

      char[] arr = S.toCharArray();

      if (!isPalindromePossible(arr)) {
         return -1;
      }

      int left = 0, right = arr.length - 1;
      int swaps = 0;

      while (right > left) {
         if (arr[right] != arr[left]) {
            int curr = right;
            while (curr > left && arr[curr] != arr[left]) {
               curr--;
            }

            if (curr == left) { //When no matching character found
               swap(arr, left, left + 1);
               swaps++;
            } else { //When Matching character found swap until K reaches p2 position
               while (curr < right) {
                  swap(arr, curr, curr + 1);
                  swaps++;
                  curr++;
               }
               left++;
               right--;
            }
         } else { //When the characters are equal move on
            left++;
            right--;
         }
      }

      return swaps;
   }

   private static boolean isPalindromePossible(char[] arr) {
      int[] occurances = new int[26];
      int oddCount = 0;

      for (char ch : arr) {
         occurances[ch - 'a']++;
      }

      for (int count : occurances) {
         if (count % 2 != 0) {
            oddCount++;
         }
      }

      return oddCount <= 1;
   }

   private static void swap(char[] arr, int i, int j) {
      char tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
   }

   public static void main(String[] args) {
      System.out.println(minSwaps("mamad"));
      System.out.println(minSwaps("asflkj"));
      System.out.println(minSwaps("aabb"));
      System.out.println(minSwaps("ntiin"));
   }
}
