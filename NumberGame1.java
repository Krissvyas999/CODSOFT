import java.util.Scanner;
public class NumberGame1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int maxTries = 7;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
            int numTries = 0;
            boolean guessedCorrectly = false;
            while (!guessedCorrectly && numTries < maxTries) {
                System.out.printf("Guess a number between %d and %d (%d tries left): ", minRange, maxRange, maxTries - numTries);
                int guess = scanner.nextInt();

                if (guess < minRange || guess > maxRange) {
                    System.out.println("Guess is out of range. Please try again.");
                    continue;
                }

                numTries++;
                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + numTries + " tries.");
                } else {
                    int difference = Math.abs(guess - randomNumber);
                    if (guess < randomNumber) {
                        if (difference <= 3) {
                            System.out.println("Your guess is slightly low. Try again.");
                        } else {
                            System.out.println("Your guess is too low. Try again.");
                        }
                    } else {
                        if (difference <= 3) {
                            System.out.println("Your guess is slightly high. Try again.");
                        } else {
                            System.out.println("Your guess is too high. Try again.");
                        }
                    }
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You ran out of tries. The number was " + randomNumber);
            }
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
        }

        scanner.close();
        System.out.println("Thank you for playing.");
    }
}
