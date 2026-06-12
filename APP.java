// INTERFACE with TWO abstract methods
interface ShortList {
    void findAll();      // Abstract Method 1: Print ALL costs
    int findMax();       // Abstract Method 2: Find MAX cost
}

// PRODUCTS class implements interface
class PRODUCTS implements ShortList {

    int[] costs = {900, 4500, 200, 1600};

    // NON-ABSTRACT METHOD:
    // Find existing cost within user given MIN & MAX
    void findCostsInRange(int min, int max) {
        System.out.println("Costs between " + min + " and " + max + ":");

        boolean found = false;
        for (int c : costs) {
            if (c >= min && c <= max) {
                System.out.println(c);
        

        if (!found) {
            System.out.println("No matching costs found.");
        }
    }

    // ABSTRACT METHOD IMPLEMENTATION 1:
    // Print ALL costs
    public void findAll() {
        System.out.println("All product costs:");
        for (int c : costs) {
            System.out.println(c);
        }
    }

    // ABSTRACT METHOD IMPLEMENTATION 2:
    // Find MAX cost
    public int findMax() {
        int max = costs[0];
        for (int c : costs) {
            if (c > max) {
                max = c;
            }
        }
        return max;
    }
}

// MAIN CLASS APP (inherits everything)
public class APP {
    public static void main(String[] args) {

        PRODUCTS p = new PRODUCTS();

        // Call NON-ABSTRACT METHOD
        p.findCostsInRange(500, 2000);

        // Call ABSTRACT METHODS via implementation
        p.findAll();
        System.out.println("Maximum Cost: " + p.findMax());
    }
}