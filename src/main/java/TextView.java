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
    public static int getValidInt(int a, int b,Scanner scnr){
        int userInput = a-1;
        int count = 0;
        while(userInput < a || userInput > b){
           if(scnr.hasNextInt()) {
                userInput = scnr.nextInt();
            }
            else {
                scnr.next();
            }
            if(userInput < a || userInput > b){
                count++;
                if(count == 2){
                    System.out.print("Please enter an integer between "+a+" and "+b+": ");
                    count = 0;
                }
            }
        }
        return userInput;
    }

    public void getNextPlayersAction(GameS22 game){
        Scanner scnr = new Scanner(System.in);
        this.action = getUsersNextActionType(scnr);
        System.out.print("\nEnter two values between "+0+" and "+game.getGameBoard().getNumColumns()+
                " (Rows, Columns): ");
        this.row1 = getValidInt(0,game.getGameBoard().getNumRows() , scnr);
        this.column1 = getValidInt(0, game.getGameBoard().getNumRows(), scnr);

        System.out.print("\nEnter two values between "+0+" and "+game.getGameBoard().getNumColumns()+
                " (Rows, Columns): ");
        this.row2 = getValidInt(0, game.getGameBoard().getNumRows(), scnr);
        this.column2 = getValidInt(0, game.getGameBoard().getNumRows(), scnr);
    }
    public void updateView(GameS22 game){
        System.out.println(game);
    }

    public void printEndOfGameMessage(GameS22 game){
        System.out.println("The game is over: "+game.getWinner().getTeamColor()+" is the winner.");
    }
}
