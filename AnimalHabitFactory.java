import java.util.Scanner;

interface Animal {
    void displayInfo();
    void showStory();
}

class AnimalData implements Animal {

    private String name, sound, group, food, habitat;
    private String lifespan, weight, bio, story;

    public AnimalData(String name, String sound, String group,
                      String food, String habitat,
                      String lifespan, String weight,
                      String bio, String story) {

        this.name = name;
        this.sound = sound;
        this.group = group;
        this.food = food;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.weight = weight;
        this.bio = bio;
        this.story = story;
    }

    public void displayInfo() {
        System.out.println("\n========== ANIMAL DETAILS ==========");
        System.out.println("Name      : " + name);
        System.out.println("Sound     : " + sound);
        System.out.println("Group     : " + group);
        System.out.println("Food      : " + food);
        System.out.println("Habitat   : " + habitat);
        System.out.println("Life Span : " + lifespan);
        System.out.println("Weight    : " + weight);
        System.out.println("Bio       : " + bio);
    }

    public void showStory() {
        System.out.println("\n====================================");
        System.out.println("        " + name.toUpperCase() + " STORY");
        System.out.println("====================================\n");
        System.out.println(story);
        System.out.println("\n====================================");
    }
}

class AnimalFactory {

    public Animal getAnimal(String name) {

        switch (name.toLowerCase()) {

            case "panda":
                return new AnimalData(
                        "Panda", "Bleat, Honk", "Embarrassment",
                        "Bamboo", "China Bamboo Forest",
                        "20 Years", "100-150 Kg",
                        "Black and white bear native to China.",
                        "Bao the panda loved exploring bamboo forests..."
                );

            case "octopus":
                return new AnimalData(
                        "Octopus", "Clicking Sounds", "Solitary",
                        "Fish, Crabs, Shrimp", "Ocean",
                        "3-5 Years", "15 Kg",
                        "Intelligent marine animal with eight arms.",
                        "Ollie the octopus explored coral reefs and found his lost shell..."
                );

            case "bison":
                return new AnimalData(
                        "Bison", "Grunt", "Herd",
                        "Grass", "Plains",
                        "15-20 Years", "900 Kg",
                        "Large grazing mammal.",
                        "Bruno the bison protected his herd during a snowstorm..."
                );

            case "fox":
                return new AnimalData(
                        "Fox", "Bark, Scream", "Skulk",
                        "Fruits and Small Animals", "Forest",
                        "3-10 Years", "10 Kg",
                        "Clever omnivorous mammal.",
                        "Fiona the fox saved animals from hunters using her intelligence..."
                );

            case "anaconda":
                return new AnimalData(
                        "Anaconda", "Hiss", "Solitary",
                        "Fish, Birds, Mammals", "Swamps and Rivers",
                        "10-30 Years", "250 Kg",
                        "One of the world's largest snakes.",
                        "Ana the anaconda found a hidden lake and saved animals from drought..."
                );

            case "rhino":
                return new AnimalData(
                        "Rhino", "Snort, Grunt", "Crash",
                        "Grass and Plants", "Grasslands",
                        "35-50 Years", "2300 Kg",
                        "Large herbivore with horns.",
                        "Rocky the rhino rescued a zebra stuck in mud..."
                );

            case "demogorgon":
                return new AnimalData(
                        "Demogorgon", "Roar", "Pack",
                        "Living Creatures", "Upside Down",
                        "Unknown", "Unknown",
                        "Fictional creature from Stranger Things.",
                        "Drax the Demogorgon discovered friendship instead of fear..."
                );

            default:
                return new AnimalData(
                        "Unknown", "-", "-", "-", "-",
                        "-", "-",
                        "Animal not found in system.",
                        "No story available."
                );
        }
    }
}

public class AnimalHabitFactory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AnimalFactory factory = new AnimalFactory();

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" SMART ANIMAL INFORMATION SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. View Animal Details");
            System.out.println("2. Read Animal Story");
            System.out.println("3. Animal Quiz");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 4) {
                System.out.println("Thank You!");
                break;
            }

            if (choice == 3) {

                int score = 0;

                System.out.println("\n========== ANIMAL QUIZ ==========");

                System.out.println("\nQ1. Which animal mainly eats Bamboo?");
                System.out.println("1. Panda\n2. Rhino\n3. Fox");
                if (sc.nextInt() == 1) {
                    System.out.println("Correct!");
                    score++;
                } else System.out.println("Wrong! Answer: Panda");

                System.out.println("\nQ2. Which animal lives in the Ocean?");
                System.out.println("1. Octopus\n2. Rhino\n3. Bison");
                if (sc.nextInt() == 1) {
                    System.out.println("Correct!");
                    score++;
                } else System.out.println("Wrong! Answer: Octopus");

                System.out.println("\nQ3. Which is a large snake?");
                System.out.println("1. Panda\n2. Anaconda\n3. Fox");
                if (sc.nextInt() == 2) {
                    System.out.println("Correct!");
                    score++;
                } else System.out.println("Wrong! Answer: Anaconda");

                System.out.println("\nYour Score: " + score + "/3");
                sc.nextLine();
                continue;
            }

            System.out.print("\nEnter Animal Name: ");
            String animalName = sc.nextLine();

            Animal animal = factory.getAnimal(animalName);

            if (choice == 1)
                animal.displayInfo();
            else if (choice == 2)
                animal.showStory();
        }

        sc.close();
    }
}