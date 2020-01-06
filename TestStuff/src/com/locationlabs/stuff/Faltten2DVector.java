package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/11/19.
 */
public class Faltten2DVector {
   int[][] grid;
   int row = 0, column = 0;

   public Faltten2DVector(int[][] v) {
      grid = v;
      while (row < grid.length && grid[row].length == 0) {
         row++;
      }
   }

   private void nextIndex() {
      if (row < grid.length && column < grid[row].length-1) {
         column++;
         return;
      }

      row++;
      column = 0;
      while (row < grid.length && grid[row].length == 0) {
         row++;
      }
   }

   public int next() {
      int result = grid[row][column];
      nextIndex();
      return result;
   }

   public boolean hasNext() {
      return (row < grid.length-1) || (row == grid.length-1 && column < grid[row].length);
   }

   public static void main(String[] args) {
      int[][] vector = {{1,2}, {3}, {4}};
      Faltten2DVector faltten2DVector = new Faltten2DVector(vector);
      System.out.println(faltten2DVector.next());
      System.out.println(faltten2DVector.next());
      System.out.println(faltten2DVector.next());
      System.out.println(faltten2DVector.hasNext());
      System.out.println(faltten2DVector.hasNext());
      System.out.println(faltten2DVector.next());
      System.out.println(faltten2DVector.hasNext());
   }
}
