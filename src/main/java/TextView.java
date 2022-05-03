import java.util.ArrayList;
import java.util.Scanner;

public class TextView {
    private int row1;
    private int column1;
    private int row2;
    private int column2;

    public int getColumn2() {
        return column2;
    }

    public int getRow2() {
        return row2;
    }

    public int getColumn1() {
        return column1;
    }

    private char action;

    public int getRow1() {
        return row1;
    }

    public char getAction() {
        return action;
    }

    /**
     *prompts the user to enter a character correlating to a certain action (a: Attack, m: Move,
     * r: Recruit, s: Spawn)
     * @param scnr Scanner object
     * @return the user inputted action
     */
    public static char getUsersNextActionType(Scanner scnr) {
        String pMove = "C";
        String moveList = "AMRSamrs";
        char tempMove = 0;
        while (!moveList.contains(pMove)) {
            System.out.print("Enter your next move: \nA[Attack]\nM[Move]\nR[Recruit]\nS[Spawn]\n");
            tempMove = scnr.next().toUpperCase().charAt(0);
            pMove = "" + tempMove;
        }
        return Character.toUpperCase(tempMove);
    }

    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
    public static ArrayList<Integer> getValidInt(int a, int b, Scanner scnr) {
        ArrayList<Integer> outputs = new ArrayList<Integer>();
        boolean invalid = true;
        while (invalid) {
            boolean notNumeric = false;
            String input = null;
            outputs.clear();
            if(scnr.hasNext()) {
                input = scnr.nextLine();
            }
            String[] inputs = input.split(" ");
            if (inputs.length != 2) {
                System.out.print("Invalid entries -- LessPlease enter two integers within range "+a+"-"+b);
                continue;
            }
            for (String i : inputs) {
                if (isNumeric(i)) {
                    outputs.add(Integer.parseInt(i));
                } else {
                    System.out.print("Invalid entries -- Negative or Non numeric input -- Please enter two integers within range "+a+"-"+b);
                    notNumeric = true;
                    break;
                }
            }
            if(notNumeric){ notNumeric = false; continue;}
            int count = 0;
            for (Integer in : outputs) {
                if (in >= a && in <= b) {
                    count++;
                }
            }
            if(count == outputs.size()){invalid = false;}
            else{System.out.print("Invalid entries: Please enter two integers within range "+a+"-"+b);}
        }
        return outputs;
    }

    public void getNextPlayersAction(GameS22 game) {
        Scanner scnr = new Scanner(System.in);
        this.action = getUsersNextActionType(scnr);
        System.out.print("\nEnter two integers between " + 0 + " and " + game.getGameBoard().getNumColumns() +
                " (Rows, Columns): ");

        ArrayList<Integer> position1 = getValidInt(0, game.board.getNumColumns(), scnr);
        this.row1 = position1.get(0);
        this.column1 = position1.get(1);

        System.out.print("\nEnter two integers between " + 0 + " and " + game.getGameBoard().getNumColumns() +
                " (Rows, Columns): ");

        ArrayList<Integer> position2 = getValidInt(0, game.board.getNumColumns(), scnr);
        this.row2 = position2.get(0);
        this.column2 = position2.get(1);

    }
    public void updateView(GameS22 game){
        System.out.println(game);
    }

    public void printEndOfGameMessage(GameS22 game){
        System.out.println("The game is over: "+game.getWinner().getTeamColor()+" is the winner.");
    }
}
