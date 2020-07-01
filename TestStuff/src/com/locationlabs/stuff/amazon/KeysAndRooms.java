package com.locationlabs.stuff.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by manjeet.singh on 5/8/20.
 */
public class KeysAndRooms {
   private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
      if (rooms == null || rooms.isEmpty()) {
         return true;
      }

      final Set<Integer> visitedRooms = new HashSet<>();
      visitRooms(0, rooms, visitedRooms);
      return visitedRooms.size() == rooms.size();
   }

   private static void visitRooms(final int roomId,
                                  final List<List<Integer>> rooms,
                                  final Set<Integer> visitedRooms) {
      visitedRooms.add(roomId);
      List<Integer> nextRooms = rooms.get(roomId);

      for (int room : nextRooms) {
         if (!visitedRooms.contains(room)) {
            visitRooms(room, rooms, visitedRooms);
         }
      }
   }

   public static void main(String[] args) {
      List<List<Integer>> rooms = new ArrayList<>();
      rooms.add(Arrays.asList(1, 3));
      rooms.add(Arrays.asList(3, 0 ,1));
      rooms.add(Arrays.asList(2));
      rooms.add(Arrays.asList(0));

      System.out.println(canVisitAllRooms(rooms));
   }
}
