package org.example;

import java.lang.reflect.Field;
import java.util.*;

public class CompanyResolver {
    private List<Company> companies;
    private Map<Integer, Set<Integer>> graph = new HashMap<>();

    public CompanyResolver(List<Company> companies) {
        this.companies = companies;
    }

    public Map<Integer, Integer> resolveDuplicates() {
        int n = companies.size();

        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new HashSet<>());
            for (int j = i + 1; j < n; j++) {
                if (areSimilar(companies.get(i), companies.get(j))) {
                    graph.get(i).add(j);
                    graph.putIfAbsent(j, new HashSet<>());
                    graph.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        Map<Integer, Integer> groupMap = new HashMap<>();
        int groupId = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, groupId, visited, groupMap);
                groupId++;
            }
        }

        return groupMap;
    }

    private void dfs(int node, int groupId, boolean[] visited, Map<Integer, Integer> groupMap) {
        visited[node] = true;
        groupMap.put(node, groupId);
        for (int neighbor : graph.getOrDefault(node, Collections.emptySet())) {
            if (!visited[neighbor]) {
                dfs(neighbor, groupId, visited, groupMap);
            }
        }
    }

    private boolean areSimilar(Company c1, Company c2) {
        try {
            Field[] fields = Company.class.getDeclaredFields();
            double totalScore = 0;
            int comparisons = 0;

            for (Field field : fields) {
                field.setAccessible(true);
                Object v1 = field.get(c1);
                Object v2 = field.get(c2);

                if (v1 instanceof String && v2 instanceof String) {
                    String s1 = (String) v1;
                    String s2 = (String) v2;

                    if (!Utils.isEmpty(s1) && !Utils.isEmpty(s2)) {
                        totalScore += Utils.similarity(s1, s2);
                        comparisons++;
                    }
                }
            }

            if (comparisons == 0) return false;
            double averageScore = totalScore / comparisons;
            return averageScore >= 0.85;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
