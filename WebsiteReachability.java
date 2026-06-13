import java.util.*;

public class WebsiteReachability {

    public static void main(String[] args) {

        // Website structure
        Map<String, List<String>> website = new HashMap<>();

        website.put("Home", Arrays.asList("About", "Products"));
        website.put("About", Arrays.asList("Team", "Contact"));
        website.put("Products", Arrays.asList("Services"));
        website.put("Team", new ArrayList<>());
        website.put("Contact", new ArrayList<>());
        website.put("Services", new ArrayList<>());

        String targetPage = "Contact";

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();

        queue.add("Home");
        distance.put("Home", 0);

        boolean found = false;

        while (!queue.isEmpty()) {

            String currentPage = queue.poll();

            if (currentPage.equals(targetPage)) {
                found = true;
                break;
            }

            for (String nextPage : website.get(currentPage)) {

                if (!distance.containsKey(nextPage)) {
                    queue.add(nextPage);
                    distance.put(nextPage,
                            distance.get(currentPage) + 1);
                }
            }
        }

        if (found) {
            System.out.println(targetPage +
                    " is reachable from Home page.");
            System.out.println("Distance = "
                    + distance.get(targetPage)
                    + " clicks");
        } else {
            System.out.println(targetPage +
                    " is NOT reachable from Home page.");
        }
    }
}