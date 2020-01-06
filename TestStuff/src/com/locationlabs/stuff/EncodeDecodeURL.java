package com.locationlabs.stuff;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by manjeet.singh on 4/30/19.
 */
public class EncodeDecodeURL {
   private static final Map<Long, String> map = new ConcurrentHashMap<>();
   private static final String URL_PREFIX = "http://tinyurl.com/";

   private static Random rand = new SecureRandom();
   private volatile long key = rand.nextLong();

   // Encodes a URL to a shortened URL.
   public String encode(String longUrl) {
      if (map.containsValue(longUrl)) {
         for (Map.Entry<Long, String> entry : map.entrySet()) {
            if (entry.getValue().equals(longUrl)) {
               return URL_PREFIX + entry.getKey();
            }
         }
      }

      while (map.containsKey(key)) {
         key = rand.nextLong();
      }
      map.put(key, longUrl);
      return URL_PREFIX + key;
   }

   // Decodes a shortened URL to its original URL.
   public String decode(String shortUrl) {
      return map.get(Long.parseLong(shortUrl.replace(URL_PREFIX,"")));
   }

   public static void main(String[] args) {
      EncodeDecodeURL urlShortner = new EncodeDecodeURL();
      String tinyUrl = urlShortner.encode("https://leetcode.com/problems/design-tinyurl");
      System.out.println(tinyUrl);
      System.out.println(urlShortner.decode(tinyUrl));
   }
}
