import java.util.Random;
public class RockPaperScissors {
    static String playRound(String playerMove, String computerMove) {
        if (!isValidMove(playerMove) || !isValidMove(computerMove))
            return "Invalid Move";
        if (playerMove.equals(computerMove))
            return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";
        return "Computer Wins";
    }
    private static boolean isValidMove(String move) {
        return "Rock".equals(move) || "Paper".equals(move) || "Scissors".equals(move);
    }
    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[][] summary = new String[5][4];
        Random rand = new Random();
        int wins = 0, losses = 0, draws = 0;
        for (int i = 0; i < 5; i++) {
            String player = playerMoves[i];
            String computer = moves[rand.nextInt(3)];
            String result = playRound(player, computer);
            summary[i][0] = String.valueOf(i + 1);
            summary[i][1] = player;
            summary[i][2] = computer;
            summary[i][3] = result;
            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }
        System.out.println("Round\tPlayer\tComputer\tResult");
        for (int i = 0; i < 5; i++) {
            System.out.println(summary[i][0] + "\t" + summary[i][1] + "\t" +
                               summary[i][2] + "\t\t" + summary[i][3]);
        }
        double winPercentage = (wins * 100.0) / 5;
        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");
    }
}