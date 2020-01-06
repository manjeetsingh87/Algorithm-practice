package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 9/26/19.
 */
public class TopVotedCandidate {
   private Map<Integer, Integer> map;
   private int[] times;

   public TopVotedCandidate(int[] persons, int[] times) {
      this.times = times;
      this.map = new HashMap<>();
      int[] count = new int[persons.length + 1]; // count[i]: count of votes for persons[i].
      for (int i = 0, winner = -1; i < persons.length; i++) {
         final int person = persons[i];
         count[person]++;
         if (map.isEmpty() || count[winner] <= count[person]) {
            winner = person;
         }
         map.put(times[i], person);
      }
   }

   public int q(int t) {
      int idx = Arrays.binarySearch(times, t);
      return map.get(times[idx < 0 ? -idx - 2 : idx]);
   }

   public static void main(String[] args) {
      TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0},
                                                                  new int[]{0,5,10,15,20,25,30});
      System.out.println(topVotedCandidate.q(3));
      System.out.println(topVotedCandidate.q(12));
      System.out.println(topVotedCandidate.q(25));
      System.out.println(topVotedCandidate.q(15));
      System.out.println(topVotedCandidate.q(24));
      System.out.println(topVotedCandidate.q(8));
   }
}
