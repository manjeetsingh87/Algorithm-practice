package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by manjeet.singh on 4/30/19.
 */
public class PathSum {
   private static boolean hasPathSumRec(TreeNode root, int sum) {
      if (root == null) {
         return false;
      }

      sum -= root.val;

      if (root.left == null && root.right == null) {
         return sum == 0;
      }

      return hasPathSumRec(root.left, sum) || hasPathSumRec(root.right, sum);
   }

   private static boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
         return false;
      }

      Stack<TreeNode> nodeStack = new Stack<>();
      Stack<Integer> sumStack = new Stack<>();

      nodeStack.push(root);
      sumStack.push(sum-root.val);

      while (!nodeStack.isEmpty()) {
         TreeNode node = nodeStack.pop();
         int currSum = sumStack.pop();

         if (node.left == null && node.right == null && currSum == 0) {
            return true;
         }

         if (node.left != null) {
            nodeStack.push(node.left);
            sumStack.push(currSum-node.left.val);
         }

         if (node.right != null) {
            nodeStack.push(node.right);
            sumStack.push(currSum-node.right.val);
         }
      }
      return false;
   }

   private static List<List<Integer>> pathSumII(TreeNode root, int sum) {
      List<List<Integer>> result = new ArrayList<>();
      pathSum(root, sum, new ArrayList<>(), result);
      return result;
   }

   private static void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
      if (root == null) {
         return;
      }

      path.add(root.val);
      sum -= root.val;

      if (root.left == null && root.right == null && sum == 0) {
         result.add(path);
         return;
      }

      pathSum(root.left, sum, new ArrayList<>(path), result);
      pathSum(root.right, sum, new ArrayList<>(path), result);
   }

   private static int maxSum = Integer.MIN_VALUE;

   private static int maxPathSum(TreeNode root) {
      findMaxSum(root, 0);
      return maxSum;
   }

   private static void findMaxSum(TreeNode node, int currentSum) {
      if (node == null) {
         return;
      }

      currentSum += node.val;

      if (node.left == null && node.right == null) {
         maxSum = Math.max(maxSum, currentSum);
         return;
      }

      findMaxSum(node.left, currentSum);
      findMaxSum(node.right, currentSum);
   }



   public static void main(String[] args) {
      /*TreeNode root = new TreeNode(5);
      root.left = new TreeNode(4);
      root.right = new TreeNode(8);

      root.left.left = new TreeNode(11);
      root.left.left.left = new TreeNode(7);
      root.left.left.right = new TreeNode(2);

      root.right.left = new TreeNode(13);
      root.right.right = new TreeNode(4);
      root.right.right.left = new TreeNode(5);
      root.right.right.right = new TreeNode(1);*/

//      System.out.println(hasPathSum(root, 22));
//      System.out.println(hasPathSumRec(root, 22));
//      System.out.println(pathSumII(root, 22));

      TreeNode root = new TreeNode(-10);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      System.out.println(maxPathSum(root));
   }
}
