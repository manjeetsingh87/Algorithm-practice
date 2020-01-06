package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 5/25/19.
 */
public class RectangleOverlap {
   private static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
      return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
              && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
   }

   public static void main(String[] args) {
      System.out.println(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1}));
      System.out.println(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
   }
}
