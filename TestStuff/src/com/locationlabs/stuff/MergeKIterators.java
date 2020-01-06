package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 9/11/19.
 */
public class MergeKIterators {
   private static Iterable<Integer> mergeKIterators(List<Iterator<Integer>> iterators) {
      final List<Integer> result = new ArrayList<>();
      if (iterators == null || iterators.isEmpty()) {
         return result;
      }

      final PriorityQueue<CustomIterator> pq = new PriorityQueue<>(iterators.size());
      for (Iterator<Integer> itr : iterators) {
         if (itr.hasNext()) {
            pq.offer(new CustomIterator(itr.next(), itr));
         }
      }

      while (!pq.isEmpty()) {
         final CustomIterator currentItr = pq.poll();
         result.add(currentItr.value);
         if (currentItr.hasNext()) {
            pq.offer(currentItr);
         }
      }

      return result;
   }

   private static class CustomIterator implements Comparable<CustomIterator> {
      private int value;
      private Iterator<Integer> itr;

      private CustomIterator(int value, Iterator<Integer> itr) {
         this.value = value;
         this.itr = itr;
      }

      private boolean hasNext() {
         if (itr.hasNext()) {
            this.value = itr.next();
            return true;
         }
         return false;
      }

      @Override
      public int compareTo(CustomIterator other) {
         return this.value - other.value;
      }
   }

   public static void main(String[] args) {
      List<Integer> list1 = Arrays.asList(1, 3, 5, 6);
      List<Integer> list2 = Arrays.asList(2, 4, 10, 12);
      List<Integer> list3 = Arrays.asList(7, 8, 9, 11);
      List<Iterator<Integer>> iterators = Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator());
      System.out.println(mergeKIterators(iterators));
   }
}
