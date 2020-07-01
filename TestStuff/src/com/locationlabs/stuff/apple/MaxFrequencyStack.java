package com.locationlabs.stuff.apple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manjeet.singh on 5/26/20.
 */
public class MaxFrequencyStack {
   private Map<Integer, Integer> freqMap;
   private Map<Integer, Deque<Integer>> freqNumGroup;
   private int maxFrequency;

   public MaxFrequencyStack() {
      freqMap = new HashMap<>();
      freqNumGroup = new HashMap<>();
      maxFrequency = 0;
   }

   public void push(int x) {
      final int freq = freqMap.getOrDefault(x, 0) + 1;
      freqMap.put(x, freq);

      maxFrequency = Math.max(maxFrequency, freq);

      freqNumGroup.computeIfAbsent(freq, s -> new ArrayDeque<>()).push(x);
   }

   public int pop() {
      int x = freqNumGroup.get(maxFrequency).pop();
      freqMap.put(x, freqMap.get(x) - 1);

      if (freqNumGroup.get(maxFrequency).isEmpty()) {
         maxFrequency--;
      }

      return x;
   }

   public static void main(String[] args) {
      final MaxFrequencyStack stack = new MaxFrequencyStack();
      stack.push(5);
      stack.push(7);
      stack.push(5);
      stack.push(7);
      stack.push(4);
      stack.push(5);

      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
   }
}
