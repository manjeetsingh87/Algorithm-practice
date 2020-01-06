package com.locationlabs.stuff;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by manjeet.singh on 5/22/19.
 */
public class InfiniteStreamMedian {

   private final PriorityQueue<Integer> minHeap;
   private final PriorityQueue<Integer> maxHeap;

   public InfiniteStreamMedian() {
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<>(Collections.reverseOrder());
   }

   public void addNum(int num) {
      maxHeap.offer(num);
      minHeap.offer(maxHeap.poll());

      if (maxHeap.size() < minHeap.size()) {
         maxHeap.offer(minHeap.poll());
      }
   }

   public double findMedian() {
      if (maxHeap.size() == minHeap.size()) {
         return (maxHeap.peek() + minHeap.peek()) / 2.0;
      }

      return maxHeap.peek();
   }

   public static void main(String[] args) {
      InfiniteStreamMedian stream = new InfiniteStreamMedian();
      stream.addNum(41);
      stream.addNum(35);
      System.out.println(stream.findMedian());
      stream.addNum(5);
      System.out.println(stream.findMedian());
      stream.addNum(64);
      System.out.println(stream.findMedian());
   }

}
