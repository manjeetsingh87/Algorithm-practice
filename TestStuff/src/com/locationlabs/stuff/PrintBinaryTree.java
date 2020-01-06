package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by manjeet.singh on 6/11/19.
 */
public class PrintBinaryTree {
   private static List<List<String>> printTree(TreeNode root) {
      final List<List<String>> result = new ArrayList<>();
      if (root == null) {
         return result;
      }

      int height = getHeight(root);
      int width = (int) Math.pow(2, height) - 1;

      for (int i = 0 ; i < height; i++) {
         final List<String> currRow = new ArrayList<>();
         for (int j = 0; j < width; j++) {
            currRow.add("");
         }
         result.add(currRow);
      }

      printTree(root, result, 0, 0, width-1);
      return result;
   }

   private static void printTree(TreeNode node, List<List<String>> result, int row, int left, int right) {
      if (node == null) {
         return;
      }

      int center = (left + right) / 2;
      result.get(row).set(center, String.valueOf(node.val));
      printTree(node.left, result, row + 1, left, center);
      printTree(node.right, result, row + 1, center + 1, right);
   }

   private static int getHeight(TreeNode root) {
      if (root == null) {
         return 0;
      }
      return 1 + Math.max(getHeight(root.left), getHeight(root.right));
   }

   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.right = new TreeNode(4);
      List<List<String>> result = printTree(root);

      for (List<String> res : result) {
         System.out.println(res);
      }
   }
}
