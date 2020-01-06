package com.locationlabs.stuff;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by manjeet.singh on 5/28/19.
 */
public class PeekingIterator implements Iterator<Integer> {
   private Integer peekNext = null;
   private Iterator<Integer> itr;

   public PeekingIterator(Iterator<Integer> iterator) {
      itr = iterator;
      if (itr.hasNext()) {
         peekNext = itr.next();
      }
   }

   // Returns the next element in the iteration without advancing the iterator.
   public Integer peek() {
      return peekNext;
   }

   @Override
   public boolean hasNext() {
      return peekNext != null;
   }

   @Override
   public Integer next() {
      int next = peekNext;
      peekNext = itr.hasNext() ? itr.next() : null;
      return next;
   }

   public static void main(String[] args) {
      PeekingIterator pk = new PeekingIterator(Arrays.asList(1,2,3,4).listIterator());
      System.out.println(pk.hasNext());
      System.out.println(pk.peek());
      System.out.println(pk.peek());
      System.out.println(pk.next());
      System.out.println(pk.next());
      System.out.println(pk.peek());
      System.out.println(pk.peek());
      System.out.println(pk.next());
      System.out.println(pk.hasNext());
      System.out.println(pk.peek());
      System.out.println(pk.hasNext());
      System.out.println(pk.next());
      System.out.println(pk.hasNext());
   }
}
