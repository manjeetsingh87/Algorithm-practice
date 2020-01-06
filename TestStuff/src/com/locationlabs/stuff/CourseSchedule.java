package com.locationlabs.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by manjeet.singh on 6/3/19.
 */
public class CourseSchedule {
   private static boolean canFinish(int numCourses, int[][] prerequisites) {
      if (prerequisites == null || prerequisites.length == 0) {
         return true;
      }

      final List<Integer>[] graph = new ArrayList[numCourses];

      for (int i = 0; i < numCourses; i++) {
         graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < prerequisites.length; i++) {
         graph[prerequisites[i][1]].add(prerequisites[i][0]);
      }

      boolean[] visited = new boolean[numCourses];
      boolean[] finished = new boolean[numCourses];

      for (int i = 0; i < numCourses; i++) {
         if (!dfs(graph, visited, finished, i)) {
            return false;
         }
      }

      return true;
   }

   private static boolean dfs(List<Integer>[] graph,
                              boolean[] visited,
                              boolean[] finished,
                              int course) {
      if (finished[course]) {
         return true;
      }

      if (visited[course]) {
         return false;
      }

      visited[course] = true;
      for (int i : graph[course]) {
         if (!dfs(graph, visited, finished, i)) {
            return false;
         }
      }

      finished[course] = true;
      return true;
   }


   public static void main(String[] args) {
      /*System.out.println(canFinish(2, new int[][]{{1, 0}}));
      System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));*/
      System.out.println(canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
   }
}
