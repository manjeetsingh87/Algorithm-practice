package com.locationlabs.stuff.apple;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Created by manjeet.singh on 5/28/20.
 */
public class CompositeKey {
   private List<Object> objectList;
   private static int diff = 0;

   public CompositeKey(Object... keyValues) {
      this.objectList = new ArrayList<>();
      Collections.addAll(objectList, keyValues);
   }

   @Override
   public boolean equals(Object other) {
      if (!(other instanceof CompositeKey)) {
         return false;
      }

      return this.objectList.equals(((CompositeKey) other).objectList);
   }

   @Override
   public int hashCode() {
      int hash = this.objectList.hashCode();
      diff++;
      System.out.println(hash + diff);
      System.out.println(hash + (diff % 2));
      return hash + (diff % 2);
   }

   @Override
   public String toString() {
      return this.objectList.toString();
   }

   public static void main(String[] args) {
      Map<CompositeKey, String> map = new HashMap<>();
      CompositeKey key1 = new CompositeKey("1", 2, new Date(3000000));
      CompositeKey dupkey1 = new CompositeKey("1", 2, new Date(3000000));

      map.put(key1, "value1");
      map.put(dupkey1, "value2");

      System.out.println(map);

      if ("value1".equals(map.get(new CompositeKey("1", 2, new Date(3000000))))) {
         System.out.println("matches");
      } else {
         System.out.println("not matches");
      }
   }
}
