import javax.lang.model.util.ElementScanner14;

class AVLNode{
    String data;
    int height;
    AVLNode left,right;
    public AVLNode(String value){
        this.data=value;height=1;
        this.left=this.right=null;
    }   
}

public class Avl{
    private AVLNode root;
    public int getHeight(AVLNode node){
        return (node==null)?0:node.height;
    }
    public int getBalanceFactor(AVLNode node){
        return (node==null)?0:getHeight(node.left)-getHeight(node.right);
    }
    public AVLNode insertInAvl(AVLNode node,String value){
        if (node==null) return new AVLNode(value);
        if (value.compareTo(root.data)<0)
            root.left=insertInAvl(root.left,value);
        else if(value.compareTo(root.data)>0)
            root.right=insertInAvl(root.right,value);
        else
            return node;
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
    }
}
