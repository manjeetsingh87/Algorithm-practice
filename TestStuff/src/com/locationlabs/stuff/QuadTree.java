package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 9/26/19.
 */
public class QuadTree {
   private Node construct(int[][] grid) {
      return helper(grid, 0, 0, grid.length);
   }

   private Node helper(int[][] grid, int row, int col, int length) {
      if (length == 1) {
         return new Node(grid[row][col] != 0, true, null, null, null, null);
      }

      Node result = new Node();
      Node topLeft = helper(grid, row, col, length / 2);
      Node topRight = helper(grid, row, col + length / 2, length / 2);
      Node bottomLeft = helper(grid, row + length / 2, col, length / 2);
      Node bottomRight = helper(grid, row + length / 2, col + length / 2, length / 2);

      if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
              && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
         result.isLeaf = true;
         result.val = topLeft.val;
      } else {
         result.topLeft = topLeft;
         result.topRight = topRight;
         result.bottomLeft = bottomLeft;
         result.bottomRight = bottomRight;
      }
      return result;
   }

   private class Node {
      public boolean val;
      public boolean isLeaf;
      public Node topLeft;
      public Node topRight;
      public Node bottomLeft;
      public Node bottomRight;

      public Node() {}

      public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
         val = _val;
         isLeaf = _isLeaf;
         topLeft = _topLeft;
         topRight = _topRight;
         bottomLeft = _bottomLeft;
         bottomRight = _bottomRight;
      }
   };
}
