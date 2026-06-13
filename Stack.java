import java.util.*;

public class Stack {
    public static void main(String[] args){
        class node{
            int d;
            node l,r;
            node(int d){
                this.d = d;
            }
        }

        node root = new node(2);
        root.l = new node(1);
        root.r = new node(3);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"Apple");

        LinkedList<String> list = new LinkedList<>();
        list.add("Task");

        System.out.println(root.l.d + " " + root.r.d

+ " " + root.d


);
        System.out.println(map.get(1));
        System.out.println(list);
    }
}
