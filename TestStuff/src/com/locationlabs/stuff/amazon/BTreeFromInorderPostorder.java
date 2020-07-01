package com.locationlabs.stuff.amazon;

import com.locationlabs.stuff.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/17/20.
 */
public class BTreeFromInorderPostorder {
   private static TreeNode buildTree(int[] inorder, int[] postorder) {
      if (inorder == null || postorder == null || inorder.length != postorder.length) {
         return null;
      }

      return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
   }

   private static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart) {
      if (posStart < 0 || inStart > inEnd) {
         return null;
      }

      TreeNode root = new TreeNode(postorder[posStart]);
      int target = inStart;
      while (inorder[target] != postorder[posStart]) {
         target++;
      }

      root.left = buildTree(inorder, postorder, inStart, target - 1, posStart - inEnd + target - 1);
      root.right = buildTree(inorder, postorder, target + 1, inEnd, posStart - 1);

      return root;
   }

   public static void main(String[] args) {

   }
}
