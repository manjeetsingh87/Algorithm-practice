package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class CourseScheduleII {
   private static int[] findOrder(int numCourses, int[][] prerequisites) {
      final List<Integer>[] graph = new ArrayList[numCourses];

      for (int i = 0; i < numCourses; i++) {
         graph[i] = new ArrayList<>();
      }

      for (int[] prerequisite : prerequisites) {
         graph[prerequisite[1]].add(prerequisite[0]);
      }

      LinkedList<Integer> courseOrder = new LinkedList<>();
      boolean[] visited = new boolean[numCourses];
      boolean[] finished = new boolean[numCourses];

      for (int i = 0; i < numCourses; i++) {
         if (dfs(graph, visited, finished, courseOrder, i)) {
            return new int[0];
         }
      }

      return courseOrder.stream().mapToInt(i -> i).toArray();
   }

   private static boolean dfs(List<Integer>[] graph,
                              boolean[] visited,
                              boolean[] finished,
                              Deque<Integer> queue,
                              int course) {
      if (visited[course]) {
         return false;
      }

      if (finished[course]) {
         return true;
      }

      finished[course] = true;
      for (int i : graph[course]) {
         if (dfs(graph, visited, finished, queue, i)) {
            return true;
         }
      }

      visited[course] = true;
      queue.addFirst(course);
      return false;
   }

   public static void main(String[] args) {
      System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
      System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
      System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {0, 1}})));
      System.out.println(Arrays.toString(findOrder(1, new int[][]{})));
   }
}
