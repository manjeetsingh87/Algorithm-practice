package com.locationlabs.stuff.msft;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/3/20.
 */
public class ZigzagIterator {
   private Queue<Iterator> queue;

   public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
      this.queue = new LinkedList<>();
      if (!v1.isEmpty()) {
         this.queue.offer(v1.iterator());
      }

      if (!v2.isEmpty()) {
         this.queue.offer(v2.iterator());
      }
   }

   public int next() {
      Iterator<Integer> current = this.queue.poll();
      int val = current.next();
      if (current.hasNext()) {
         this.queue.offer(current);
      }

      return val;
   }

   public boolean hasNext() {
      return !this.queue.isEmpty() && this.queue.peek() != null;
   }

   public static void main(String[] args) {
      ZigzagIterator iterator = new ZigzagIterator(Arrays.asList(1, 2), Arrays.asList(3, 4, 5, 6));
      System.out.print("[ ");
      while (iterator.hasNext()) {
         System.out.print(iterator.next() + " ,");
      }
      System.out.print("]");
   }
}
