package com.locationlabs.stuff;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
/**
 * Created by manjeet.singh on 6/2/19.
 */
public class Yelp {

   class TimeRange {
      /*
      Represents a time range (the time between a start time and an end time)

      Example usage:
          time_range = TimeRange('3-5')
          System.out.println(time_range.start)
          3.0
       */
      float start;
      float end;

      TimeRange(String rangeString){
         String[] rangeSplit = rangeString.split("-");
         this.start = Float.valueOf(rangeSplit[0]);
         this.end = Float.valueOf(rangeSplit[1]);
      }
   }

   /*
   Inputs:
   A time range to query for (as a TimeRange object)
   A business's open hours (as a List of TimeRanges)

   Output:
   The fraction OF THE QUERY TIME RANGE that the business is open.
   (In other words, the percentage of the query time range in which the business is open.)
   Return this number as a float. This function should NOT do any rounding.

   Examples of time ranges:
       (0, 24)        the whole day
       (9, 17)        9 AM to 5 PM
       (18, 23.75)    6 PM to 11:45 PM

   Examples of open hours:
       []                       closed the entire day
       [(0, 24)]                open the entire day
       [(9.5, 17)]              open from 9:30 AM to 5 PM
       [(11, 14), (18, 22)]     open from 11 AM to 2 PM, and from 6 PM to 10 PM

   Assume that the open hours time ranges are in order and non-overlapping.

   Furthermore, all time ranges (start, end) have the property 0 <= start < end <= 24.

   Examples:
   Query Time Range    Open Hours            Answer
   (4, 10)             [(0, 24)]             1.0
   (7, 11)             [(9, 17)]             0.5
   (0, 24)             [(0, 2), (20, 24)]    0.25
   (5, 22)             []                    0.0
   */
   public float openHoursRatio(TimeRange queryTimeRange, List<TimeRange> openHours) {
      if (openHours == null || openHours.isEmpty() || queryTimeRange.start >= queryTimeRange.end) {
         return 0.0F;
      }

      float overlappingHours = 0.0F;
      for (TimeRange openHour : openHours) {
         float endTime = Math.min(openHour.end, queryTimeRange.end);
         float startTime = Math.max(queryTimeRange.start, openHour.start);

         if (endTime >= startTime) {
            overlappingHours += (endTime - startTime);
         }
      }
      return overlappingHours / (queryTimeRange.end - queryTimeRange.start);
   }
}
