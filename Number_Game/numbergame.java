import java.util.*;

public class numbergame {

    // Method to play one round
    public static void playGame(Scanner sc) {
        Random rdRandom = new Random();
        int number = rdRandom.nextInt(100) + 1; // 1 to 100
        int maxAttempts = 5;
        int attempts = 0;
        boolean Correctguess = false;

        System.out.println("\n Guess the number between 1 and 100");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            
            // Input validation
            if (!sc.hasNextInt()) {
                System.out.println(" Please enter a valid number!");
                sc.next(); // discard invalid input
                continue;
            }

            int guess = sc.nextInt();
            attempts++;

            if (guess == number) {
                System.out.println(" Correct! You guessed it in " + attempts + " attempts.");
                Correctguess = true;
                break;
            } 
            else if (guess > number) {
                System.out.println(" Too High!");
            } 
            else {
                System.out.println(" Too Low!");
            }

            System.out.println("Attempts left: " + (maxAttempts - attempts));
        }

        if (!Correctguess) {
            System.out.println(" Game Over! The correct number was: " + number);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;

        System.out.println(" Welcome to Number Guessing Game!");

        do {
            playGame(sc);

            System.out.print("\nDo you want to play again? (yes/no): ");
            choice = sc.next();

        } while (choice.equalsIgnoreCase("yes"));

        System.out.println(" Thanks for playing!");
        sc.close();
    }
}