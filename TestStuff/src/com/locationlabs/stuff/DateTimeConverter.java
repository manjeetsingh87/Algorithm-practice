package com.locationlabs.stuff;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * Created by manjeet.singh on 2/15/18.
 */
public class DateTimeConverter {

   private static final String timeZone = "EST";

   public static void main(String[] args) {
      OffsetDateTime eventTimestamp = OffsetDateTime.now();
      System.out.println(convertOffsetToLocaDateTime(eventTimestamp));
      System.out.println(LocalDateTime.now(ZoneOffset.UTC));
   }

   private static LocalDateTime convertOffsetToLocaDateTime(final OffsetDateTime eventTimestamp) {
      if (null == eventTimestamp)
         return null;

      return LocalDateTime.from(eventTimestamp.atZoneSameInstant(ZoneOffset.UTC));
   }
}
