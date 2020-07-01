package com.locationlabs.stuff.msft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/3/20.
 */
public class HeightRecostructedQueue {
   private static int[][] reconstructQueue(int[][] people) {
      if (people == null || people.length <= 1) {
         return people;
      }

      Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

      final List<int[]> result = new LinkedList<>();
      for (int[] person : people) {
         result.add(person[1], person);
      }

      for (int[] per : result) {
         System.out.println(Arrays.toString(per));
      }

      return result.toArray(new int[result.size()][2]);
   }

   public static void main(String[] args) {
      reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
   }
}
