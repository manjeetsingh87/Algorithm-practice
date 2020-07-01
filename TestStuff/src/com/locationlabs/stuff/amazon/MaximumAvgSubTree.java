package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.TreeNode;

/**
 * Created by manjeet.singh on 5/11/20.
 */
public class MaximumAvgSubTree {
   private static double maximumAverageSubtree(TreeNode root) {
      if (root == null) {
         return 0.0;
      }

      return helper(root)[2];
   }

   /**
    * @param node The current subtree under consideration
    * @return double array of {currSumSoFar, countOfNodesInSubTree, maxAvg}
    */
   private static double[] helper(TreeNode node) {
      if (node == null) {
         return new double[]{0, 0, 0};
      }


      double[] left = helper(node.left);
      double[] right = helper(node.right);

      double currSum = node.val + left[0] + right[0];
      double count = 1 + left[1] + right[1];

      double currMaxAvg = Math.max(left[2], right[2]);
      return new double[]{currSum, count, Math.max(currMaxAvg, currSum / count)};
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(6);
      root.left = new TreeNode(5);
      root.right = new TreeNode(1);

      System.out.println(maximumAverageSubtree(root));
   }
}
