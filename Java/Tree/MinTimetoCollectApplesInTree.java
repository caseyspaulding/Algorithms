/*
1443. Minimum Time to Collect All Apples in a Tree
Link: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

Given an undirected tree consisting of n vertices numbered from 0 to n-1, which
has some apples in their vertices. You spend 1 second to walk over one edge of
the tree. Return the minimum time in seconds you have to spend to collect all
apples in the tree, starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi]
means that exists an edge connecting the vertices ai and bi. Additionally, there is
a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple;
otherwise, it does not have any apple.

Example 1:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
hasApple = [false,false,true,false,true,true,false]
Output: 8 
Explanation: The figure above represents the given tree where red vertices have
an apple. One optimal path to collect all apples is shown by the green arrows.  

Example 2:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices
have an apple. One optimal path to collect all apples is shown by the green arrows.  

Example 3:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
hasApple = [false,false,false,false,false,false,false]
Output: 0
*/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        // Create the map with neighbors nodes
        List<Integer>[] tree = new ArrayList[n];
        for (int i=0; i<n; i++) {
            tree[i] = new ArrayList();
        }
        for (int []arr : edges) {
            tree[arr[0]].add(arr[1]);
            tree[arr[1]].add(arr[0]);
        }

        return dfs(tree, hasApple, -1, 0);
    }

	// Count the steps to reach all apples until the current node
    public int dfs(List<Integer> []tree, List<Boolean> hasApple, int parent, int node) {
        int steps = 0;
        for (int c : tree[node]) {
            if (c != parent)
                steps += dfs(tree, hasApple, node, c);
        }
        if ((hasApple.get(node) || steps > 0) && node != 0) {
            steps += 2;
        }
        return steps;
    }
}