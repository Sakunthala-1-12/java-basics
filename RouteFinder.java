import java.util.*;

public class RouteFinder {

    public static int minRoads(Map<String, List<String>> graph,
                               String start, String end) {

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();

        queue.add(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            String city = queue.poll();

            if (city.equals(end))
                return distance.get(city);

            for (String neighbor : graph.get(city)) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(city) + 1);
                    queue.add(neighbor);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Map<String, List<String>> graph = new HashMap<>();

        graph.put("Chennai", Arrays.asList("Vellore", "Salem"));
        graph.put("Vellore", Arrays.asList("Chennai", "Coimbatore"));
        graph.put("Salem", Arrays.asList("Chennai", "Coimbatore"));
        graph.put("Coimbatore", Arrays.asList("Vellore", "Salem"));

        System.out.println("Minimum roads required: "
                + minRoads(graph, "Chennai", "Coimbatore"));
    }
}