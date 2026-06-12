import java.util.ArrayList;
import java.util.List; 

//Directed and unweighted
public class Adjacencylist {
    private List<List<Integer>> adjUnweighted;
    public Adjacencylist(int i) {
        //TODO Auto-generated constructor stub
    }
    public Adjacencylist(int size){
        adjUnweighted = new ArrayList<>();
        for (int index =0 ; index<size; index++)
            adjUnweighted.add(new ArrayList<>());
    }
    public void buildEdge(int row,int col){
        adjUnweighted.get(row).add(col);
    }
    public void viewList(){
        for (List<Integer> row : adjUnweighted){
            for(Integer temp:row)
                System.out.print(temp+" ");
            System.err.println();
        }
    }
    public static void main(String[]args){
        Adjacencylist adj = new Adjacencylist(5);;
        adj.buildEdge(0,1);
        adj.buildEdge(0,3);
        adj.buildEdge(1,3);
        adj.buildEdge(2,4);
        adj.buildEdge(1,4);
        adj.buildEdge(4,3);
        adj.viewList();
    }
    
}




