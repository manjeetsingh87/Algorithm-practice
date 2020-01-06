package com.locationlabs.stuff.dropbox;

import com.locationlabs.stuff.HitCounter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by manjeet.singh on 7/20/19.
 */
public class DesignHitCounter {
   private Map<Integer, Integer> hitCounterStore;

   public DesignHitCounter() {
      this.hitCounterStore = new ConcurrentHashMap<>();
   }

   public void hit(int timestamp) {
      int hits = hitCounterStore.getOrDefault(timestamp, 0);
      hitCounterStore.put(timestamp, hits + 1);
   }

   public int getHits(int timestamp) {
      int hits = 0;
      int lowerBound = Math.max(1, timestamp - 300 + 1);
      for (int i = timestamp; i >= lowerBound; i--) {
         if (hitCounterStore.containsKey(i)) {
            hits += hitCounterStore.get(i);
         }
      }
      return hits;
   }

   public static void main(String[] args) {
      final DesignHitCounter hitCounter = new DesignHitCounter();
      hitCounter.hit(1);
      hitCounter.hit(2);
      hitCounter.hit(3);
      System.out.println(hitCounter.getHits(4));
      hitCounter.hit(300);
      System.out.println(hitCounter.getHits(300));
      System.out.println(hitCounter.getHits(301));
   }
}
