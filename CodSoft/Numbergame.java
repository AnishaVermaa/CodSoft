import java.util.Random;
import java.util.Scanner;

public class Numbergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        System.out.println();
        System.out.println("******* Number Game! *******");
        System.out.println(
                "You have " + maxAttempts + " attempts to guess the number between " + minRange + " and " + maxRange);

        while (true) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Your guess is out of the valid range.");
                } else if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Attempts remaining: " + (maxAttempts - attempts));
                } else {
                    System.out.println("Your guess is too high. Attempts remaining: " + (maxAttempts - attempts));
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("You have used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Your total score is: " + score);
                break;
            }
        }

        sc.close();
    }
}
