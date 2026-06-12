

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
public class DetectCycleUndirected {
    public Map<Integer,List<Integer>> adjacency;
    int size;
    public DetectCycleUndirected(int vertsize){
        size=vertsize;
        adjacency=new Hashtable<>();
    }
    public void buildEdges(int vertex1 ,int vertex2){
        adjacency.putIfAbsent(vertex1,new ArrayList<>());
        adjacency.putIfAbsent(vertex2,new ArrayList<>());
        adjacency.get(vertex1).add(vertex2);
        adjacency.get(vertex1).add(vertex2);
    }
    public boolean cycleDetector(int vertex,
        boolean visited,int parent){
            visited[vertex]=true;
            if(adjacency.containsKey(vertex)){
                for(int neighrbour:adjacency.get(vertex)){
                    if(!visited [neighbour]){
                        if(cycleDetector(neighrbour,visited,vertex))
                            return true;
                    
                    }else if(neighrbour!=parent)
                        return true;
                }
            }
        }
        return ;
}
