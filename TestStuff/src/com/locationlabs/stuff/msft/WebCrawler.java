package com.locationlabs.stuff.msft;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by manjeet.singh on 4/3/20.
 */
public class WebCrawler {
   interface HtmlParser {
      List<String> getUrls(String url);
   }

   static class HtmlParserImpl implements HtmlParser {

      @Override
      public List<String> getUrls(String url) {
         return Arrays.asList(
            "http://news.yahoo.com",
            "http://news.yahoo.com/news",
            "http://news.yahoo.com/news/topics/",
            "http://news.google.com",
            "http://news.yahoo.com/us");
      }
   }

   private static List<String> crawl(String startUrl, HtmlParser htmlParser) throws URISyntaxException {
      if (startUrl == null || startUrl.isEmpty()) {
         return new ArrayList<>();
      }

      final Set<String> visited = new HashSet<>();
      final Queue<String> urls = new ArrayDeque<>();
      urls.offer(startUrl);
      visited.add(startUrl);
      while (!urls.isEmpty()) {
         final String url = urls.poll();
         final String hostName = getHostName(url);
         for (String neighbour : htmlParser.getUrls(url)) {
            if (!visited.contains(neighbour) && getHostName(neighbour).equals(hostName)) {
               visited.add(neighbour);
               urls.offer(neighbour);
            }
         }
      }

      return new ArrayList<>(visited);
   }

   private static String getHostName(String url) throws URISyntaxException {
      return new URI(url).getHost();
   }

   public static void main(String[] args) throws URISyntaxException {
      System.out.println(crawl("http://news.yahoo.com/news/topics/", new HtmlParserImpl()));
   }
}
