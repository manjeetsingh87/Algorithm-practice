package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/26/19.
 */
public class LongestSongDuration2Sum {
   private static ArrayList<Integer> IDsOfSongs(int rideDuration,
                                                ArrayList<Integer> songDurations)
   {
      if (rideDuration < 0) {
         return null;
      }

      // since songs need to end 30 seconds before ride ends,
      // total songs duration will be rideDuration-30 .
      int totalSongDuration = rideDuration - 30;
      final Map<Integer, Integer> cache = new HashMap<>();

      int longestSong = Integer.MIN_VALUE;
      int index = 0;
      for (Integer songDuration : songDurations) {
         final int otherSongDuration = totalSongDuration - songDuration;
         if (cache.containsKey(otherSongDuration)) {
            longestSong = Math.max(longestSong, Math.max(songDuration, otherSongDuration));
         }
         cache.put(songDuration, index++);
      }

      if (!cache.containsKey(longestSong)) {
         return null;
      }
      final ArrayList<Integer> result = new ArrayList<>();
      result.add(cache.get(totalSongDuration-longestSong));
      result.add(cache.get(longestSong));

      return result;
   }

   public static void main(String[] args) {
      ArrayList<Integer> songs = new ArrayList<>();
      songs.add(1);
      songs.add(10);
      songs.add(25);
      songs.add(35);
      songs.add(59);
      songs.add(60);
      System.out.println(IDsOfSongs(90, songs));
   }
}
