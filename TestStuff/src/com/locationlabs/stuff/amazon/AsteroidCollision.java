package com.locationlabs.stuff.amazon;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by manjeet.singh on 5/16/20.
 */
public class AsteroidCollision {
   private static int[] asteroidCollision(int[] asteroids) {
      if (asteroids == null || asteroids.length <= 1) {
         return asteroids;
      }

      final LinkedList<Integer> stack = new LinkedList<>();
      for (int asteroid : asteroids) {
         if (asteroid > 0) { // CASE 1: moving in same positive direction
            stack.add(asteroid);
         } else {
            // CASE 2 a: found asteroid in opposite dir,
            // find all asteroids smaller than this one and destroy them
            while (!stack.isEmpty() && stack.getLast() > 0 && stack.getLast() < Math.abs(asteroid)) {
               stack.pollLast();
            }

            // CASE 2 b: found first asteroid in same dir as the current one, push this to the stack
            if (stack.isEmpty() || stack.getLast() < 0) {
               stack.add(asteroid);
            } else if (asteroid + stack.getLast() == 0) {
               // CASE 2 b: found asteroid in opposite dir as the current one with same weight, both get destroyed
               stack.pollLast();
            }
         }
      }

      if (stack.isEmpty()) {
         return new int[0];
      }

      return stack.stream().mapToInt(i -> i).toArray();
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
      System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
      System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
      System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, 1, 1, 2})));
   }
}
