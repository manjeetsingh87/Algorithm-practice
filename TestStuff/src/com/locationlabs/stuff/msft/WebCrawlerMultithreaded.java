package com.locationlabs.stuff.msft;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import com.locationlabs.stuff.msft.WebCrawler.HtmlParser;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by manjeet.singh on 4/22/20.
 */
public class WebCrawlerMultithreaded {
   public List<String> crawl(String startUrl, HtmlParser htmlParser) {
      if (startUrl == null || startUrl.isEmpty()) {
         return new ArrayList<>();
      }

      final Set<String> visited = ConcurrentHashMap.newKeySet();
      visited.add(startUrl);
      final String hostName = getHostName(startUrl);

      return crawl(startUrl, htmlParser, visited, hostName).collect(Collectors.toList());
   }

   private Stream<String> crawl(String url, HtmlParser htmlParser, Set<String> visited, String hostName) {
      Stream<String> stream = htmlParser.getUrls(url)
                                        .parallelStream()
                                        .filter(nextUrl -> isSameHost(hostName, nextUrl))
                                        .filter(nextUrl -> visited.add(nextUrl))
                                        .flatMap(nextUrl -> crawl(nextUrl, htmlParser, visited, hostName));

      return Stream.concat(Stream.of(url), stream);
   }

   private String getHostName(String url) {
      try {
         return new URI(url).getHost();
      } catch (URISyntaxException e) {
         e.printStackTrace();
         return "";
      }
   }

   private boolean isSameHost(String host, String url) {
      return getHostName(url).equals(host);
   }
}
