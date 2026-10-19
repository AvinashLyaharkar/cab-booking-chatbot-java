import java.util.Scanner;

public class CabBookingChatbot {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // predefined routes (route 1, 2, 3)
        String[] sources = {"Pune Station", "Swargate", "Hinjawadi"};
        String[] destinations = {"Shivajinagar", "Kothrud", "Wakad"};
        int[] distances = {5, 8, 10};

        System.out.println("=================================");
        System.out.println("   Welcome to Cab Booking Chatbot");
        System.out.println("=================================");

        while (true) {
            System.out.println();
            System.out.println("----- MAIN MENU -----");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine().trim();

            if (choice.equals("1")) {

                // Step 2: choose cab type
                System.out.println();
                System.out.println("Choose your cab type:");
                System.out.println("1. Auto  (Rs.12/km)");
                System.out.println("2. Sedan (Rs.18/km)");
                System.out.println("3. SUV   (Rs.25/km)");
                System.out.print("Enter cab choice: ");
                String cabChoice = sc.nextLine().trim();

                String cabType;
                int rate;

                if (cabChoice.equals("1")) {
                    cabType = "Auto";
                    rate = 12;
                } else if (cabChoice.equals("2")) {
                    cabType = "Sedan";
                    rate = 18;
                } else if (cabChoice.equals("3")) {
                    cabType = "SUV";
                    rate = 25;
                } else {
                    System.out.println("Invalid cab choice! Going back to main menu.");
                    continue;
                }

                // Step 3: choose route
                System.out.println();
                System.out.println("Available routes:");
                System.out.println("1. Pune Station -> Shivajinagar (5 km)");
                System.out.println("2. Swargate -> Kothrud (8 km)");
                System.out.println("3. Hinjawadi -> Wakad (10 km)");
                System.out.print("Enter route number: ");
                String routeChoice = sc.nextLine().trim();

                int index;
                if (routeChoice.equals("1")) {
                    index = 0;
                } else if (routeChoice.equals("2")) {
                    index = 1;
                } else if (routeChoice.equals("3")) {
                    index = 2;
                } else {
                    System.out.println("Invalid route choice! Going back to main menu.");
                    continue;
                }

                String source = sources[index];
                String destination = destinations[index];
                int distance = distances[index];

                // Step 4: calculate fare
                int fare = rate * distance;

                System.out.println();
                System.out.println("------ Booking Details ------");
                System.out.println("Cab Type    : " + cabType);
                System.out.println("From        : " + source);
                System.out.println("To          : " + destination);
                System.out.println("Distance    : " + distance + " km");
                System.out.println("Rate per km : Rs." + rate);
                System.out.println("Total Fare  : Rs." + fare);
                System.out.println("-----------------------------");

                // Step 5: cancel or confirm (before OTP)
                System.out.println();
                System.out.println("1. Confirm & Share OTP");
                System.out.println("2. Cancel Ride");
                System.out.print("Enter your choice: ");
                String confirm = sc.nextLine().trim();

                if (confirm.equals("2")) {
                    System.out.println("Your ride has been cancelled. No OTP was shared.");
                    continue;
                } else if (confirm.equals("1")) {
                    // Step 6: generate 4-digit OTP
                    int otp = 1000 + (int) (Math.random() * 9000);

                    System.out.println();
                    System.out.println("OTP shared with you: " + otp);
                    System.out.println("Note: Ride cannot be cancelled after the OTP is shared.");
                    System.out.println("Booking confirmed! Your " + cabType + " is on the way.");
                } else {
                    System.out.println("Invalid choice! Going back to main menu.");
                    continue;
                }

            } else if (choice.equals("2")) {
                // Step 7: exit
                System.out.println();
                System.out.println("Thank you for using Cab Booking Chatbot. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please enter 1 or 2.");
            }
        }

        sc.close();
    }
}