package com.locationlabs.stuff;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by manjeet.singh on 4/25/19.
 */
public class NestedListWeightSum {
//   public int depthSum(List<NestedInteger> nestedList) {
//      if (nestedList == null || nestedList.isEmpty()) {
//         return 0;
//      }
//      return depthSearch(nestedList, 1);
//   }
//
//   public int depthSumII(List<NestedInteger> nestedList) {
//      if (nestedList == null || nestedList.isEmpty()) {
//         return 0;
//      }
//
//      int sum = 0, depth = 1;
//
//      Queue<NestedList> queue = new LinkedList<NestedList>(nestedList);
//
//      while (queue.size() > 0) {
//         int size = queue.size();
//
//         for (int i=0; i < size; i++) {
//            NestedList nI = queue.poll();
//
//            if (nI.isInteger()) {
//               sum += nI.getInteger() * depth;
//            } else {
//               queue.addAll(nI.getList());
//            }
//         }
//         depth++;
//      }
//
//      return sum;
//   }
//
//   private int depthSearch(List<NestedInteger> nestedList, int depth) {
//      int sum = 0;
//
//      for (NestedImteger nI : nestedList) {
//         if (nI.isInteger()) {
//            sum += nI.getInteger() * depth;
//         } else {
//            sum += depthSearch(nI.getList(), depth + 1);
//         }
//      }
//
//      return sum;
//   }

//   public int depthSumInverse(List<NestedInteger> nestedList) {
//      if (nestedList == null || nestedList.isEmpty()) {
//         return 0;
//      }
//
//      int totalSum = 0, prevSum = 0;
//      final Queue<NestedInteger> queue = new LinkedList<>(nestedList);
//      while (!queue.isEmpty()) {
//         int size = queue.size();
//         int levelSum = 0;
//         for (int i = 0; i < size; i++) {
//            NestedInteger nI = queue.poll();
//            if (nI.isInteger()) {
//               levelSum += nI.getInteger();
//            } else {
//               queue.addAll(nI.getList());
//            }
//         }
//
//         prevSum += levelSum;
//         totalSum += prevSum;
//      }
//
//      return totalSum;
//   }
}
