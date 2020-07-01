package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by manjeet.singh on 5/20/19.
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

   class NestedInteger {
      int val ;
      boolean isInteger() {
         return true;
      }

      List<NestedInteger> getList() {
         return new ArrayList<>();
      }
      int getInteger() {
         return 0;
      }
   }

   private List<Integer> flattenedList;
   private Iterator<Integer> itr;

   public FlattenNestedListIterator(List<NestedInteger> nestedList) {
      flattenedList = new LinkedList<>();
      flattenNestedList(nestedList);
      itr = flattenedList.iterator();
   }

   private void flattenNestedList(List<NestedInteger> nestedList) {
      for (NestedInteger nInt : nestedList) {
         if (nInt.isInteger()) {
            flattenedList.add(nInt.getInteger());
         } else {
            flattenNestedList(nInt.getList());
         }
      }
   }

   @Override
   public Integer next() {
      if (!itr.hasNext()) {
         throw new NullPointerException();
      }
      return itr.next();
   }

   @Override
   public boolean hasNext() {
      return itr.hasNext();
   }
}
