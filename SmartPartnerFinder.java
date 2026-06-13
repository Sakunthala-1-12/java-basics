import java.util.Scanner;

class Partner {
    String name;
    int age;
    String city;
    String education;
    double salary;
    String interest;
    String profession;
    String lifestyle;
    String familyType;
    String personality;

    Partner(String name, int age, String city,
            String education, double salary,
            String interest, String profession,
            String lifestyle, String familyType,
            String personality) {

        this.name = name;
        this.age = age;
        this.city = city;
        this.education = education;
        this.salary = salary;
        this.interest = interest;
        this.profession = profession;
        this.lifestyle = lifestyle;
        this.familyType = familyType;
        this.personality = personality;
    }
}

public class SmartPartnerFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Partner[] candidates = {
            new Partner("Arjun", 26, "Chennai", "BE", 50000,
                    "Music", "Engineer", "Non-Smoker",
                    "Nuclear", "Extrovert"),

            new Partner("Rahul", 28, "Chennai", "MBA", 70000,
                    "Travel", "Manager", "Non-Smoker",
                    "Joint", "Ambivert"),

            new Partner("Vijay", 27, "Coimbatore", "BE", 60000,
                    "Music", "Engineer", "Non-Smoker",
                    "Nuclear", "Introvert"),

            new Partner("Karthik", 29, "Chennai", "BE", 85000,
                    "Sports", "Software Developer", "Non-Smoker",
                    "Joint", "Extrovert"),

            new Partner("Ajay", 25, "Madurai", "BSc", 40000,
                    "Reading", "Teacher", "Smoker",
                    "Nuclear", "Introvert")
        };

        System.out.println("======================================");
        System.out.println(" SMART PARTNER RECOMMENDATION SYSTEM ");
        System.out.println("======================================");

        System.out.print("Enter Your Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter Education: ");
        String education = sc.nextLine();

        System.out.print("Enter Interest: ");
        String interest = sc.nextLine();

        System.out.print("Enter Salary Expectation: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Preferred Profession: ");
        String profession = sc.nextLine();

        System.out.print("Enter Lifestyle (Smoker/Non-Smoker): ");
        String lifestyle = sc.nextLine();

        System.out.print("Enter Family Type (Joint/Nuclear): ");
        String familyType = sc.nextLine();

        System.out.print("Enter Personality (Introvert/Extrovert/Ambivert): ");
        String personality = sc.nextLine();

        int bestScore = 0;
        Partner bestMatch = null;

        System.out.println("\n===== MATCH RESULTS =====");

        for (Partner p : candidates) {

            int score = 0;

            // Age Match (15)
            if (Math.abs(age - p.age) <= 5)
                score += 15;

            // Education Match (15)
            if (education.equalsIgnoreCase(p.education))
                score += 15;

            // Salary Match (10)
            if (p.salary >= salary)
                score += 10;

            // City Match (10)
            if (city.equalsIgnoreCase(p.city))
                score += 10;

            // Interest Match (20)
            if (interest.equalsIgnoreCase(p.interest))
                score += 20;

            // Profession Match (10)
            if (profession.equalsIgnoreCase(p.profession))
                score += 10;

            // Lifestyle Match (10)
            if (lifestyle.equalsIgnoreCase(p.lifestyle))
                score += 10;

            // Family Type Match (5)
            if (familyType.equalsIgnoreCase(p.familyType))
                score += 5;

            // Personality Match (5)
            if (personality.equalsIgnoreCase(p.personality))
                score += 5;

            System.out.println("----------------------------------");
            System.out.println("Candidate : " + p.name);
            System.out.println("Compatibility Score : " + score + "%");

            if (score >= 80)
                System.out.println("Match Status : Excellent Match");
            else if (score >= 60)
                System.out.println("Match Status : Good Match");
            else if (score >= 40)
                System.out.println("Match Status : Average Match");
            else
                System.out.println("Match Status : Not Recommended");

            if (score > bestScore) {
                bestScore = score;
                bestMatch = p;
            }
        }

        System.out.println("\n======================================");
        System.out.println("          BEST MATCH FOUND");
        System.out.println("======================================");

        if (bestMatch != null) {

            System.out.println("Name          : " + bestMatch.name);
            System.out.println("Age           : " + bestMatch.age);
            System.out.println("City          : " + bestMatch.city);
            System.out.println("Education     : " + bestMatch.education);
            System.out.println("Profession    : " + bestMatch.profession);
            System.out.println("Salary        : ₹" + bestMatch.salary);
            System.out.println("Interest      : " + bestMatch.interest);
            System.out.println("Lifestyle     : " + bestMatch.lifestyle);
            System.out.println("Family Type   : " + bestMatch.familyType);
            System.out.println("Personality   : " + bestMatch.personality);
            System.out.println("Match Score   : " + bestScore + "%");
        }

        sc.close();
    }
}