
public class AdjacencyMatrix {
    private int[][] AdjacencyWeighted;
    private int vertexSize;
    public AdjacencyMatrix(int vertsize){
        this.vertexSize=vertsize;
        AdjacencyWeighted=new int [vertsize][vertsize];    
    }
    public void buildEdge(int ver1,int ver2,int weight){
        AdjacencyWeighted[ver1][ver2]=weight;
        AdjacencyWeighted[ver2][ver1]=weight;
    }
    public void viewMatrix(){
        for(int[]row:AdjacencyWeighted){
            for (int col:row)System.out.print(col+" ");
            System.out.println();        }
    }
}
public static void main (String[] args){
    AdjacencyMatrix adjacent = new AdjacencyMatrix(7);
    adjacent.buildEdge(0,1,80); 
    adjacent.buildEdge( 0,2,70);
    adjacent.buildEdge(1,1,90);
    adjacent.buildEdge(0,0,99);
    adjacent.buildEdge(1,1,100);
    adjacent.buildEdge(0,1,1);
    adjacent.buildEdge(2,1,10);
    adjacent.viewMatrix();
}