package com.locationlabs.stuff.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CombinationSum {
   /**
    * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
    * find all unique combinations in candidates where the candidate numbers sums to target.
    * The same repeated number may be chosen from candidates unlimited number of times.
    * Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    * Input: candidates = [2,3,6,7], target = 7
    * Solution set is: [[7], [2,2,3]]
    * Input: candidates = [2,3,5], target = 8
    * Solution set is: [[2,2,2,2], [2,3,3], [3,5]]
    */
   public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      backtrack(result, new ArrayList<>(), candidates, target, 0);
      return result;
   }

   private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int target, int start) {
      if (target < 0) {
         return;
      }

      if (target == 0) {
         result.add(new ArrayList<>(current));
         return;
      }

      for (int i = start; i < nums.length; i++) {
         current.add(nums[i]);
         backtrack(result, current, nums, target-nums[i], i);
         current.remove(current.size()-1);
      }
   }

   /**
    * Similar to CombinationSum with constraint that,
    * Each number in candidates may only be used once in the combination
    * candidates = [10,1,2,7,6,1,5], target = 8
    * Solution set is: [[1, 7], [1, 2, 5], [2, 6], [1, 1, 6]]
    *
    * Input: candidates = [2,5,2,1,2], target = 5
    * Solution set is: [[1,2,2], [5]]
    */
   public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      Arrays.sort(candidates);
      backtrackNoDuplicates(result, new ArrayList<>(), candidates, target, 0);
      return result;
   }

   private static void backtrackNoDuplicates(List<List<Integer>> result, List<Integer> current, int[] nums, int target, int start) {
      if (target < 0) {
         return;
      }

      if (target == 0) {
         result.add(new ArrayList<>(current));
         return;
      }

      for (int i = start; i < nums.length; i++) {
         if (i > start && nums[i] == nums[i-1]) {
            continue;
         }
         current.add(nums[i]);
         backtrackNoDuplicates(result, current, nums, target-nums[i], i+1);
         current.remove(current.size()-1);
      }
   }

   private static List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> result = new ArrayList<>();
      backTrackHelper(result, new ArrayList<>(), k, n , 1);
      return result;
   }

   private static void backTrackHelper(List<List<Integer>> result, List<Integer> temp, int k, int n, int curr) {
      if (k < 0 || n < 0) {
         return;
      }

      if (k == 0 && n == 0) {
         result.add(temp);
         return;
      }

      for (int i = curr; i <= Math.min(n , 9); i++) {
         temp.add(i);
         backTrackHelper(result, new ArrayList<>(temp), k-1, n-i, i+1);
         temp.remove(temp.size()-1);
      }
   }

   public static void main(String[] args) {
      System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
      System.out.println(combinationSum(new int[]{2,3,5}, 8));
      System.out.println(combinationSum(new int[]{2,3,5}, 1));

      /*System.out.println(combinationSum(new int[]{1,2,5}, 11));*/

      /*System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));*/

      /*System.out.println(combinationSum3(3, 7));*/
   }
}
