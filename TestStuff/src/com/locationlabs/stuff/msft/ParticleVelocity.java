package com.locationlabs.stuff.msft;

/**
 * Created by manjeet.singh on 4/18/20.
 */
public class ParticleVelocity {
   private static final int THRESHOLD = 1000000000;

   private static int solution(int[] A) {
      if (A == null || A.length < 3) {
         return 0;
      }

      int velocity = 0;
      int currCount = 0;

      for (int i = 2; i < A.length; i++) {
         if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            currCount += 1;
            velocity += currCount;
         } else {
            currCount = 0;
         }
      }

      return velocity > THRESHOLD ? -1 : velocity;
   }

   public static void main(String[] args) {
      System.out.println(solution(new int[]{1, 3, 5, 7, 9}));
      System.out.println(solution(new int[]{7, 7, 7, 7}));
      System.out.println(solution(new int[]{3, -1, -5, -9}));
      System.out.println(solution(new int[]{1, 1, 2, 5, 7}));
      System.out.println(solution(new int[]{-1, 1, 3, 3, 3, 2, 3, 2, 1, 0}));
      System.out.println(solution(new int[]{1, 2, 4, 5, 6, 7, 3, 4, 5}));
   }
}
