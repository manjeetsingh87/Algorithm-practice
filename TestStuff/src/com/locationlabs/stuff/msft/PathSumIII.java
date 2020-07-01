package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 4/2/20.
 */
public class PathSumIII {
   private static int pathSum(TreeNode root, int sum) {
      final Map<Integer, Integer> preSum = new HashMap<>();
      preSum.put(0, 1);
      return helper(root, 0, sum, preSum);
   }

   private static int helper(TreeNode node, int currSum, int targetSum, Map<Integer, Integer> preSum) {
      if (node == null) {
         return 0;
      }

      currSum += node.val;
      // number of ways to get to target sum so far
      int res = preSum.getOrDefault(currSum - targetSum, 0);
      // update map to increment count of number of ways to get to current sum
      preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

      // let's recurse all possible paths from here
      res += helper(node.left, currSum, targetSum, preSum) + helper(node.right, currSum, targetSum, preSum);

      // pruning the already explored path
      preSum.put(currSum, preSum.get(currSum) - 1);
      return res;
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(10);
      root.left = new TreeNode(5);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(2);
      root.left.left.left = new TreeNode(3);
      root.left.left.right = new TreeNode(-2);
      root.left.right.right = new TreeNode(1);

      root.right = new TreeNode(-3);
      root.right.right = new TreeNode(11);

      System.out.println(pathSum(root, 8));
   }
}
