package com.locationlabs.stuff.facebook;

import com.locationlabs.stuff.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 8/5/19.
 */
public class BinaryTreePaths {
   private static List<String> binaryTreePaths(TreeNode root) {
      final List<String> paths = new ArrayList<>();
      if (root == null) {
         return paths;
      }
      getTreePath(root, new StringBuilder(), paths);
      return paths;
   }

   private static void getTreePath(TreeNode node, StringBuilder path, List<String> paths) {
      if (node == null) {
         return;
      }

      int tmp = path.length();
      if (node.left == null && node.right == null) {
         path.append(node.val);
         paths.add(path.toString());
         path.delete(tmp, path.length());
         return;
      }

      path.append(node.val).append("->");
      getTreePath(node.left, path, paths);
      getTreePath(node.right, path, paths);
      path.delete(tmp, path.length());
      return;
   }

   public static void main(String[] args) {
      final TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.right = new TreeNode(5);
      root.right = new TreeNode(3);
      System.out.println(binaryTreePaths(root));
   }
}
