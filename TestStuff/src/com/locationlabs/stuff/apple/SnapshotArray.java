package com.locationlabs.stuff.apple;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by manjeet.singh on 5/22/20.
 */
public class SnapshotArray {
   private TreeMap<Integer, Integer>[] snapshotArray;
   private int snapId;

   public SnapshotArray(int length) {
      this.snapId = 0;
      this.snapshotArray = new TreeMap[length];
      for (int i = 0; i < length; i++) {
         snapshotArray[i] = new TreeMap<>();
         snapshotArray[i].put(0, 0);
      }
   }

   public void set(int index, int val) {
      snapshotArray[index].put(snapId, val);
   }

   public int snap() {
      return snapId++;
   }

   public int get(int index, int snap_id) {
      return snapshotArray[index].floorEntry(snap_id).getValue();
   }

   public static void main(String[] args) {
      final SnapshotArray snapshotArray = new SnapshotArray(3);
      snapshotArray.set(0, 5);
      System.out.println(snapshotArray.snap());
      snapshotArray.set(0, 6);
      System.out.println(snapshotArray.get(0, 0));
   }
}
