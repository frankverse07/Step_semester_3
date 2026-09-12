package core_java.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    private static final String[] CHOICES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the outcome of a single round of Rock-Paper-Scissors.
     *
     * @param playerMove   Move chosen by the player ("Rock", "Paper", or "Scissors")
     * @param computerMove Move chosen by the computer ("Rock", "Paper", or "Scissors")
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        int totalRounds = 5;
        String[] playerMoves = new String[totalRounds];
        String[] computerMoves = new String[totalRounds];
        String[] results = new String[totalRounds];

        // Demo moves covering win, loss, and draw cases matching sample output
        String[] demoPlayerMoves = {"Rock", "Paper", "Scissors", "Scissors", "Paper"};
        String[] demoComputerMoves = {"Scissors", "Paper", "Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=== Rock-Paper-Scissors Match (5 Rounds) ===");

        for (int i = 0; i < totalRounds; i++) {
            playerMoves[i] = demoPlayerMoves[i];
            computerMoves[i] = demoComputerMoves[i];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("Round %d - Player: %s, Computer: %s -> %s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        System.out.println("\n--- Summary Table ---");
        System.out.printf("%-7s | %-12s | %-14s | %-13s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-7d | %-12s | %-14s | %-13s%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = ((double) wins / totalRounds) * 100.0;
        System.out.printf("%nFinal Summary (after %d rounds)%n", totalRounds);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}
