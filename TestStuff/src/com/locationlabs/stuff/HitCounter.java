package com.locationlabs.stuff;

/**
 * Created by manjeet.singh on 6/20/19.
 */
public class HitCounter {
   volatile int[] hits;
   volatile int[] times;

   /** Initialize your data structure here. */
   public HitCounter() {
      this.hits = new int[300];
      this.times = new int[300];
   }

   /** Record a hit.
    @param timestamp - The current timestamp (in seconds granularity). */
   public void hit(int timestamp) {
      synchronized (this) {
         int index = timestamp % 300;
         if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
         } else {
            hits[index]++;
         }
      }
   }

   /** Return the number of hits in the past 5 minutes.
    @param timestamp - The current timestamp (in seconds granularity). */
   public int getHits(int timestamp) {
      synchronized (this) {
         int total = 0;
         for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
               total += hits[i];
            }
         }
         return total;
      }
   }

   public static void main(String[] args) {
      final HitCounter counter = new HitCounter();
      counter.hit(1);
      counter.hit(2);
      counter.hit(3);
      System.out.println(counter.getHits(4));
      counter.hit(300);
      System.out.println(counter.getHits(300));
      System.out.println(counter.getHits(301));
   }
}
