import java.util.Random;
import java.util.Scanner;

class GuessingGame {
    private final int low;
    private final int high;
    private final int secret;
    private final int attempts;

    public GuessingGame(int low, int high) {
        if (low > high) { int t = low; low = high; high = t; }
        this.low = low;
        this.high = high;

        int rangeSize = Math.max(1, high - low + 1);
        this.attempts = computeAttempts(rangeSize);

        this.secret = new Random().nextInt(rangeSize) + low;
    }

    private int computeAttempts(int rangeSize) {
        double log2 = Math.log(rangeSize) / Math.log(2.0);
        int a = (int) Math.ceil(log2) + 1;
        return Math.max(1, a);
    }

    public void play(Scanner sc) {
        System.out.println();
        System.out.println("You have " + attempts + " attempts to guess the number between " + low + " and " + high + ".");
        System.out.println("Let's start!");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + " of " + attempts + " - Enter your guess: ");
            int guess = sc.nextInt();

            if (guess == secret) {
                System.out.println("Correct! The number is " + secret + ". You guessed it in " + i + " attempt(s).");
                return;
            } else if (guess > secret) {
                if (i < attempts) System.out.println("Too high. Try a lower number.");
            } else {
                if (i < attempts) System.out.println("Too low. Try a higher number.");
            }

            if (i == attempts) {
                System.out.println("Out of attempts. The number was " + secret + ".");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi! Welcome to the Number Guessing Game.");
        System.out.println();
        System.out.print("Enter the Lower Bound: ");
        int low = sc.nextInt();

        System.out.print("Enter the Upper Bound: ");
        int high = sc.nextInt();

        GuessingGame game = new GuessingGame(low, high);
        game.play(sc);

        sc.close();
    }
}
