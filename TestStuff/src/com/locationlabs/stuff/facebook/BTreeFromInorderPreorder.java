package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 8/13/19.
 */
public class BTreeFromInorderPreorder {
   private static TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder == null || inorder == null) {
         return null;
      }

      int inLen = inorder.length, preLen = preorder.length;
      if (inLen == 0 || preLen == 0) {
         return null;
      }

      final Map<Integer, Integer> inorderMap = new HashMap<>();
      for (int i = 0; i < inLen; i++) {
         inorderMap.put(inorder[i], i);
      }

      return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1, inorderMap);
   }

   private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder,
                                     int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
      if (preStart > preEnd || inStart > inEnd) {
         return null;
      }

      final TreeNode root = new TreeNode(preorder[preStart]);
      int inRootIdx = inorderMap.get(root.val);
      int numsLeft = inRootIdx - inStart;

      root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRootIdx - 1, inorderMap);
      root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRootIdx + 1, inEnd, inorderMap);
      return root;
   }

   public static void main(String[] args) {
      TreeNode node = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
      System.out.println(node);
   }
}
