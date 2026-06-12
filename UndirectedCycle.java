import java.util.*;

public class UndirectedCycle {
    private int V;
    private List<List<Integer>> adj;

    public UndirectedCycle(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);  // undirected
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, visited, node)) return true;
            }
            else if (neigh != parent) {
                return true;  // cycle found
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedCycle g = new UndirectedCycle(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3); 
        g.addEdge(3, 1);// cycle exists

        System.out.println(g.isCyclic()); // true
    }
}
