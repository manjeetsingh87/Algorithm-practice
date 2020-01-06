package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjeet.singh on 7/10/19.
 */
public class Flatten2DVectorII {
   private List<Integer> list;
   private int next;

   public Flatten2DVectorII(int[][] v) {
      list = new ArrayList<>();

      for (int i = 0; i < v.length; i++) {
         for (int j = 0; j < v[i].length; j++) {
            list.add(v[i][j]);
         }
      }

      next = 0;
   }

   public int next() {
      return list.get(next++);
   }

   public boolean hasNext() {
      return next != list.size();
   }

   public static void main(String[] args) {
      int[][] v = {{1, 2}, {3}, {4}};
      Flatten2DVectorII vector = new Flatten2DVectorII(v);
      System.out.println(vector.next());
      System.out.println(vector.next());
      System.out.println(vector.next());
      System.out.println(vector.hasNext());
      System.out.println(vector.hasNext());
      System.out.println(vector.next());
      System.out.println(vector.hasNext());
   }
}
