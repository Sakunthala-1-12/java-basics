import java.util.*;
public class Collection_framework{
    public static void main(String[] args){
        List<String> cart= new ArrayList<>();
        cart.add("Laptop");
        cart.add("mouse");
        cart.add("keyboard");
        cart.add("keyboard");

        Set<String> categories= new HashSet<>();
        categories.add("electronics");
        categories.add("fashion");
        categories.add("electronics");

        Map<Integer,String> orders = new HashMap<>();
            orders.put(101,"laptop");
            orders.put(102,"mouse");
        
        System.out.println("cart:"+cart);
        System.out.println("categories:"+categories);
        System.out.println("orders:"+orders);
    }
}
