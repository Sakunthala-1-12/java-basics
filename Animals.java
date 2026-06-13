import java.util.*;

interface AnimalInfo {
    void displayInfo();
}

// ===== EXISTING ANIMALS (UNCHANGED) =====

class Panda implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Panda");
        System.out.println("Food          : Bamboo");
        System.out.println("Lifespan      : 20-30 years");
    }
}

class Bison implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Bison");
        System.out.println("Food          : Grass");
        System.out.println("Lifespan      : 15-25 years");
    }
}

class Fox implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Fox");
        System.out.println("Food          : Small animals");
        System.out.println("Lifespan      : 3-10 years");
    }
}

class Octopus implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Octopus");
        System.out.println("Food          : Crabs, Fish");
        System.out.println("Lifespan      : 1-5 years");
    }
}

class Anaconda implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Anaconda");
        System.out.println("Food          : Mammals, Birds");
        System.out.println("Lifespan      : 10-30 years");
    }
}

class Rhino implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Rhino");
        System.out.println("Food          : Grass");
        System.out.println("Lifespan      : 35-50 years");
    }
}

class Demogorgon implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Demogorgon");
        System.out.println("Food          : Meat");
        System.out.println("Fictional Monster");
    }
}

// ===== NEW ANIMALS FOR HUNTING SYSTEM =====

class Tiger implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Tiger");
        System.out.println("Role          : Apex Predator");
    }
}

class Wolf implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Wolf");
        System.out.println("Role          : Pack Hunter");
    }
}

class Deer implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Deer");
        System.out.println("Role          : Prey");
    }
}

class WildBoar implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Wild Boar");
        System.out.println("Role          : Prey/Omnivore");
    }
}

class Snake implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Snake");
        System.out.println("Role          : Small Predator");
    }
}

class Eagle implements AnimalInfo {
    public void displayInfo() {
        System.out.println("Animal Name   : Eagle");
        System.out.println("Role          : Sky Predator");
    }
}

// ===== FACTORY UPDATED =====

class AnimalFactory {

    public AnimalInfo getAnimal(String name) {

        if (name.equalsIgnoreCase("Panda"))
            return new Panda();
        else if (name.equalsIgnoreCase("Bison"))
            return new Bison();
        else if (name.equalsIgnoreCase("Fox"))
            return new Fox();
        else if (name.equalsIgnoreCase("Octopus"))
            return new Octopus();
        else if (name.equalsIgnoreCase("Anaconda"))
            return new Anaconda();
        else if (name.equalsIgnoreCase("Rhino"))
            return new Rhino();
        else if (name.equalsIgnoreCase("Demogorgon"))
            return new Demogorgon();

        else if (name.equalsIgnoreCase("Tiger"))
            return new Tiger();
        else if (name.equalsIgnoreCase("Wolf"))
            return new Wolf();
        else if (name.equalsIgnoreCase("Deer"))
            return new Deer();
        else if (name.equalsIgnoreCase("WildBoar"))
            return new WildBoar();
        else if (name.equalsIgnoreCase("Snake"))
            return new Snake();
        else if (name.equalsIgnoreCase("Eagle"))
            return new Eagle();

        return null;
    }
}

// ===== MAIN APPLICATION =====

public class Animals {

    static ArrayList<String> favorites = new ArrayList<>();
    static int viewCount = 0;
    static int huntCount = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AnimalFactory factory = new AnimalFactory();

        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. View Animal");
            System.out.println("2. Compare Animals");
            System.out.println("3. Add Favorite");
            System.out.println("4. View Favorites");
            System.out.println("5. View All Animals");
            System.out.println("6. Hunting Cycle Simulation 🐅");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Animal Name: ");
                    AnimalInfo animal = factory.getAnimal(sc.nextLine());

                    System.out.println("\n--- ANIMAL DETAILS ---");
                    if (animal != null) {
                        animal.displayInfo();
                        viewCount++;
                    } else {
                        System.out.println("Animal Not Found!");
                    }
                    break;

                case 2:
                    System.out.print("Enter First Animal: ");
                    AnimalInfo a1 = factory.getAnimal(sc.nextLine());

                    System.out.print("Enter Second Animal: ");
                    AnimalInfo a2 = factory.getAnimal(sc.nextLine());

                    System.out.println("\n--- COMPARISON ---");
                    if (a1 != null && a2 != null) {
                        a1.displayInfo();
                        System.out.println();
                        a2.displayInfo();
                    } else {
                        System.out.println("Invalid animals!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Favorite Animal: ");
                    favorites.add(sc.nextLine());
                    System.out.println("Added!");
                    break;

                case 4:
                    System.out.println("\nFavorites:");
                    for (String f : favorites)
                        System.out.println("- " + f);
                    break;

                case 5:
                    System.out.println("Animals Available:");
                    System.out.println("Panda, Bison, Fox, Octopus, Anaconda, Rhino, Demogorgon");
                    System.out.println("Tiger, Wolf, Deer, WildBoar, Snake, Eagle");
                    break;

                case 6:
                    System.out.println("\n===== HUNTING CYCLE =====");
                    System.out.println("Tiger → Deer / Wild Boar");
                    System.out.println("Wolf → Deer");
                    System.out.println("Eagle → Snake / small animals");
                    System.out.println("Snake → Frogs / rats");
                    System.out.println("Fox → small animals");

                    huntCount++;
                    System.out.println("Hunting simulation runs: " + huntCount);
                    break;

                case 7:
                    System.out.println("Total Views: " + viewCount);
                    System.out.println("Total Hunts Simulated: " + huntCount);
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}