package com.locationlabs.stuff.msft;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by manjeet.singh on 3/30/20.
 */
public class MovingAverageOfDataStream {
   private Queue<Integer> queue;
   private int size;
   private double total;
   public MovingAverageOfDataStream(int size) {
      this.size = size;
      this.queue = new ArrayDeque<>();
   }

   public double next(int val) {
      queue.offer(val);
      total += val;

      if (queue.size() < size) {
         return total / (double)queue.size();
      }

      if (queue.size() > size) {
         total -= queue.poll();
      }

      return total / (double) size;
   }

   public static void main(String[] args) {
      MovingAverageOfDataStream dataStream = new MovingAverageOfDataStream(3);
      System.out.println(dataStream.next(1));
      System.out.println(dataStream.next(10));
      System.out.println(dataStream.next(3));
      System.out.println(dataStream.next(5));
   }
}
