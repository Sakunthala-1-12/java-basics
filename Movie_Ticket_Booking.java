import java.util.Scanner;
import java.util.Random;

public class Movie_Ticket_Booking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] movies = { "Coolie", "Leo", "Jailer", "Lover" };
        String[] theatres = { "PVR", "INOX", "AGS" };
        String[] timings = { "10:00 AM", "2:00 PM", "6:00 PM", "10:00 PM" };

        System.out.println("====================================");
        System.out.println("     MOVIE TICKET BOOKING SYSTEM");
        System.out.println("====================================");

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        // Movie Selection
        System.out.println("\nAvailable Movies");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i]);
        }

        System.out.print("Choose Movie (1-4): ");
        int movieChoice = sc.nextInt();

        if (movieChoice < 1 || movieChoice > 4) {
            System.out.println("Invalid Movie Choice!");
            return;
        }

        String selectedMovie = movies[movieChoice - 1];

        // Theatre Selection
        System.out.println("\nAvailable Theatres");
        for (int i = 0; i < theatres.length; i++) {
            System.out.println((i + 1) + ". " + theatres[i]);
        }

        System.out.print("Choose Theatre (1-3): ");
        int theatreChoice = sc.nextInt();

        if (theatreChoice < 1 || theatreChoice > 3) {
            System.out.println("Invalid Theatre Choice!");
            return;
        }

        String selectedTheatre = theatres[theatreChoice - 1];

        // Timing Selection
        System.out.println("\nAvailable Timings");
        for (int i = 0; i < timings.length; i++) {
            System.out.println((i + 1) + ". " + timings[i]);
        }

        System.out.print("Choose Timing (1-4): ");
        int timeChoice = sc.nextInt();

        if (timeChoice < 1 || timeChoice > 4) {
            System.out.println("Invalid Timing Choice!");
            return;
        }

        String selectedTime = timings[timeChoice - 1];

        // Seat Category
        System.out.println("\nSeat Categories");
        System.out.println("1. Platinum - Rs.500");
        System.out.println("2. Gold     - Rs.350");
        System.out.println("3. Silver   - Rs.200");

        System.out.print("Choose Category: ");
        int category = sc.nextInt();

        int seatPrice = 0;
        String seatType = "";

        switch (category) {
            case 1:
                seatPrice = 500;
                seatType = "Platinum";
                break;
            case 2:
                seatPrice = 350;
                seatType = "Gold";
                break;
            case 3:
                seatPrice = 200;
                seatType = "Silver";
                break;
            default:
                System.out.println("Invalid Category!");
                return;
        }

        // Persons
        System.out.print("\nHow Many Persons?: ");
        int persons = sc.nextInt();

        String[] availableSeats = {
                "A4", "A5", "A6", "A7", "A8",
                "B1", "B2", "B3", "B4", "B5",
                "C1", "C2", "C3", "C4", "C5"
        };

        String[] bookedSeats = { "A1", "A2", "A3" };

        System.out.println("\nAvailable Seats:");
        for (String seat : availableSeats) {
            System.out.print(seat + " ");
        }
        System.out.println();

        String[] selectedSeats = new String[persons];

        for (int i = 0; i < persons; i++) {

            while (true) {

                System.out.print("Enter Seat For Person " + (i + 1) + ": ");
                String seatNumber = sc.next();

                boolean validSeat = false;
                boolean unavailable = false;

                for (String seat : availableSeats) {
                    if (seat.equalsIgnoreCase(seatNumber)) {
                        validSeat = true;
                        break;
                    }
                }

                if (!validSeat) {
                    System.out.println("Invalid Seat Number!");
                    continue;
                }

                for (String seat : bookedSeats) {
                    if (seat.equalsIgnoreCase(seatNumber)) {
                        unavailable = true;
                        break;
                    }
                }

                for (int j = 0; j < i; j++) {
                    if (selectedSeats[j] != null &&
                            selectedSeats[j].equalsIgnoreCase(seatNumber)) {
                        unavailable = true;
                        break;
                    }
                }

                if (unavailable) {
                    System.out.println("Seat Not Available! Choose Another.");
                } else {
                    selectedSeats[i] = seatNumber;
                    break;
                }
            }
        }

        // Snacks
        System.out.println("\nAvailable Snacks");
        System.out.println("1. Popcorn - Rs.150");
        System.out.println("2. Coke - Rs.80");
        System.out.println("3. Nachos - Rs.120");
        System.out.println("4. Burger - Rs.180");

        int snackTotal = 0;
        String snacks = "";

        System.out.print("\nHow Many Different Snacks?: ");
        int snackCount = sc.nextInt();

        for (int i = 1; i <= snackCount; i++) {

            System.out.print("\nChoose Snack " + i + ": ");
            int snackChoice = sc.nextInt();

            int snackPrice = 0;
            String snackName = "";

            switch (snackChoice) {
                case 1:
                    snackName = "Popcorn";
                    snackPrice = 150;
                    break;
                case 2:
                    snackName = "Coke";
                    snackPrice = 80;
                    break;
                case 3:
                    snackName = "Nachos";
                    snackPrice = 120;
                    break;
                case 4:
                    snackName = "Burger";
                    snackPrice = 180;
                    break;
                default:
                    System.out.println("Invalid Snack!");
                    i--;
                    continue;
            }

            System.out.print("Quantity: ");
            int qty = sc.nextInt();

            snackTotal += snackPrice * qty;
            snacks += snackName + "(" + qty + ") ";
        }

        // Snack Delivery
        System.out.println("\nSnack Delivery Time");
        System.out.println("1. Before Movie");
        System.out.println("2. Interval");
        System.out.println("3. After Movie");

        System.out.print("Choose Option: ");
        int snackTimeChoice = sc.nextInt();

        String snackTime = "";

        switch (snackTimeChoice) {
            case 1:
                snackTime = "Before Movie";
                break;
            case 2:
                snackTime = "During Interval";
                break;
            case 3:
                snackTime = "After Movie";
                break;
            default:
                snackTime = "Not Selected";
        }

        // Offer
        System.out.println("\nOffers");
        System.out.println("1. MOVIE50");
        System.out.println("2. No Offer");

        System.out.print("Choose Option: ");
        int offerChoice = sc.nextInt();

        int discount = 0;

        if (offerChoice == 1) {
            discount = 50;
        }

        // Voucher
        System.out.println("\nVouchers");
        System.out.println("1. Rs.100 Voucher");
        System.out.println("2. No Voucher");

        System.out.print("Choose Option: ");
        int voucherChoice = sc.nextInt();

        int voucherDiscount = 0;

        if (voucherChoice == 1) {
            voucherDiscount = 100;
        }

        int ticketTotal = seatPrice * persons;

        int totalAmount = ticketTotal +
                snackTotal -
                discount -
                voucherDiscount;

        if (totalAmount < 0) {
            totalAmount = 0;
        }

        System.out.println("\n========== BILL ==========");
        System.out.println("Ticket Price : Rs." + ticketTotal);
        System.out.println("Snack Price  : Rs." + snackTotal);
        System.out.println("Discount     : Rs." + discount);
        System.out.println("Voucher      : Rs." + voucherDiscount);
        System.out.println("--------------------------");
        System.out.println("Total Amount : Rs." + totalAmount);

        double gst = totalAmount * 0.18;
        double finalAmount = totalAmount + gst;

        System.out.printf("GST (18%%)    : Rs.%.2f%n", gst);
        System.out.printf("Final Amount : Rs.%.2f%n", finalAmount);

        // Payment
        System.out.println("\nPayment Method");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.println("3. Wallet");

        System.out.print("Choose Payment Method: ");
        int paymentChoice = sc.nextInt();
        sc.nextLine();

        String paymentMethod = "";
        boolean paymentSuccess = false;

        switch (paymentChoice) {

            case 1:
                paymentMethod = "UPI";

                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();

                if (upiId.contains("@")) {
                    paymentSuccess = true;
                }
                break;

            case 2:
                paymentMethod = "Card";

                System.out.print("Enter 16 Digit Card Number: ");
                String cardNumber = sc.nextLine();

                System.out.print("Enter 3 Digit CVV: ");
                String cvv = sc.nextLine();

                if (cardNumber.matches("\\d{16}") &&
                        cvv.matches("\\d{3}")) {
                    paymentSuccess = true;
                }
                break;

            case 3:
                paymentMethod = "Wallet";

                System.out.print("Enter Mobile Number: ");
                String mobile = sc.nextLine();

                if (mobile.matches("\\d{10}")) {
                    paymentSuccess = true;
                }
                break;
        }

        if (paymentSuccess) {

            String bookingId = "BK" + (10000 + random.nextInt(90000));

            System.out.println("\n================================");
            System.out.println("            E-TICKET");
            System.out.println("================================");
            System.out.println("Booking ID : " + bookingId);
            System.out.println("Customer   : " + name);
            System.out.println("Movie      : " + selectedMovie);
            System.out.println("Theatre    : " + selectedTheatre);
            System.out.println("Time       : " + selectedTime);
            System.out.println("Seat Type  : " + seatType);
            System.out.println("Persons    : " + persons);

            System.out.print("Seats      : ");
            for (String seat : selectedSeats) {
                System.out.print(seat + " ");
            }

            System.out.println();
            System.out.println("Snacks     : " + snacks);
            System.out.println("Snack Time : " + snackTime);
            System.out.println("Payment    : " + paymentMethod);
            System.out.printf("Amount     : Rs.%.2f%n", finalAmount);
            System.out.println("Status     : CONFIRMED");
            System.out.println("================================");

        } else {

            System.out.println("\nPayment Failed!");
            System.out.println("Booking Not Successful");
        }

        int rating;

        do {
            System.out.print("\nRate Movie (1-5): ");
            rating = sc.nextInt();
        } while (rating < 1 || rating > 5);

        System.out.println("Thanks For Rating : " + rating + "/5");

        System.out.println("\n====================================");
        System.out.println("Thank You For Visiting!");
        System.out.println("We Hope You Enjoy The Movie!");
        System.out.println("Visit Again!");
        System.out.println("====================================");

        System.out.println("\n1. Book Another Ticket");
        System.out.println("2. Exit");

        System.out.print("Choose Option: ");
        int option = sc.nextInt();

        if (option == 1) {
            System.out.println("Please Restart Program To Book Again.");
        } else {
            System.out.println("Exiting Application...");
            System.out.println("Thank You!");
        }

        sc.close();
    }
}