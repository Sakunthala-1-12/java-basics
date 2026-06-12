import java.util.ArrayList;
import java.util.List;

public class Degree {
        adjList=new ArrayList<>();
        versize=size;
        for(int index=1;index<=size;index++){\
            adjList.add(new ArrayList<>());
        }
    }
    public void buildEdge(int row,int col){
        adj.List.get(row).add(col);
    }
    public void findDegree(){
        int[] inDegree=new int[versize];
        int[] outDegree=new int[versize]; 
        for(int row=0;row<versize;row++){
            for(int col:Adjacencylist.get(row)){
                inDegree[row]++;
                inDegree[col]++;
            }
        }
        for(int index=0;index<versize;index++){
            System.out.println("Vertex "+index
                +"In Degree"+inDegree[index]
                +"Out degree"+OutDegree[index]);
        }
    }
    public static void main(String[] args) {
        DirectDegree object=new DirectedDegree(size:5)
        object.buildEdge(row:0,col:1);
        object.buildEdge(row:0,col:1);
        object.buildEdge(row:0,col:1);
        object.buildEdge(row:0,col:1);
        object.buildEdge(row:0,col:1);
        object.findDegree();
}