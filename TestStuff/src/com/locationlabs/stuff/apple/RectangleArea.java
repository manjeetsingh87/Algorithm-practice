package com.locationlabs.stuff.apple;

/**
 * Created by manjeet.singh on 5/27/20.
 */
public class RectangleArea {
   private static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
      final int areaRectA = (C - A) * (D - B);
      final int areaRectB = (G - E) * (H - F);

      final int left = Math.max(A, E);
      final int right = Math.min(C, G);
      final int bottom = Math.max(B, F);
      final int top = Math.min(D, H);

      int overlap = 0;

      if (left < right && bottom < top) {
         overlap = (right - left) * (top - bottom);
      }

      return areaRectA + areaRectB - overlap;
   }
}
