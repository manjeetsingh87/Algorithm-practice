package com.locationlabs.stuff.msft;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 4/11/20.
 */
public class UniqueBST {
   private static int numTrees(int n) {
      if (n <= 0) {
         return 0;
      }

      int[] uniqueBST = new int[n + 1];
      uniqueBST[0] = 1;
      uniqueBST[1] = 1;

      for (int i = 2; i <= n; i++) {
         for (int j = 1; j <= i; j++) {
            uniqueBST[i] += uniqueBST[j - 1] * uniqueBST[i - j];
         }
      }

      return uniqueBST[n];
   }

   private static List<TreeNode> generateTrees(int n) {
      if (n <= 0) {
         return new ArrayList<>();
      }

      return generate(1, n);
   }

   private static List<TreeNode> generate(int start, int end) {
      List<TreeNode> result = new ArrayList<>();

      if (start > end) {
         result.add(null);
         return result;
      }

      for (int i = start; i <= end; i++) {
         final List<TreeNode> leftSubTrees = generate(start, i - 1);
         final List<TreeNode> rightSubTrees = generate(i + 1, end);

         for (TreeNode leftSubTree : leftSubTrees) {
            for (TreeNode rightSubTree : rightSubTrees) {
               TreeNode tree = new TreeNode(i);
               tree.left = leftSubTree;
               tree.right = rightSubTree;
               result.add(tree);
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      System.out.println(numTrees(3));
      System.out.println(numTrees(4));
   }
}
