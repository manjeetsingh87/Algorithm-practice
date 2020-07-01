package com.locationlabs.stuff.msft;

import java.util.Arrays;

/**
 * Created by manjeet.singh on 3/31/20.
 */
public class FloodFill {
   private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
      if (image == null || image.length == 0) {
         return image;
      }

      if (image[sr][sc] == newColor) {
         return image;
      }

      fill(image, sr, sc, image[sr][sc], newColor);
      return image;
   }

   private static void fill(int[][] image, int sr, int sc, int currColour, int newColour) {
      if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != currColour) {
         return;
      }

      image[sr][sc] = newColour;
      fill(image, sr + 1, sc, currColour, newColour);
      fill(image, sr - 1, sc, currColour, newColour);
      fill(image, sr, sc + 1, currColour, newColour);
      fill(image, sr, sc - 1, currColour, newColour);
   }

   public static void main(String[] args) {
      int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
      floodFill(image, 1, 1, 2);
      for (int[] row : image) {
         System.out.println(Arrays.toString(row));
      }
   }
}
