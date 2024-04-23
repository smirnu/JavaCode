/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
import java.util.*;

public class FindMinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // list of roots to return
        List<Integer> treesMinHeight = new ArrayList<>();
        if (edges.length == 0 && n == 1) {
            treesMinHeight.add(0);
            return treesMinHeight;
        } else if (n == 0) {
            return treesMinHeight;
        }

        // filling the graph with undirected edges
        ArrayList<Integer>[] edgesInMap = new ArrayList[n];
        for (int i = 0; i < n; i++) edgesInMap[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            edgesInMap[edges[i][0]].add(edges[i][1]);
            edgesInMap[edges[i][1]].add(edges[i][0]);
        }
        int[] indegree = new int[n];
        int cnt = n;
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            indegree[i] = edgesInMap[i].size();
            if (indegree[i] == 1) {
                leaves.add(i);
            }
        }
        while (cnt > 2) {
            int size = leaves.size();
            cnt -= size;
            for (int i = 0; i < size; i++) {
                int v = leaves.poll();
                for (int w : edgesInMap[v]) {
                    indegree[w]--;
                    if (indegree[w] == 1) {
                        leaves.add(w);
                    }
                }
            }
        }
        treesMinHeight.addAll(leaves);
        return treesMinHeight;
    }
}