import java.util.ArrayList;
/**
 * This class controls our game flow.
 * @author Jonathan Ma
 * @version 1.0
 */
public class Controller {
    private GameS22 game; //controller has a game and a text view for gui
    private TextView textView;

    public Controller(){
        this.game = setUpGameModel();
        this.textView = new TextView();
        textView.updateView(this.game);
    }

    public void playGame() {
        while(!game.isGameEnded()) {
            textView.getNextPlayersAction(this.game); //get action
            if (!Rules.checkValidAction(game, textView.getRow1(), textView.getColumn1(),
                    textView.getRow2(), textView.getColumn2(), textView.getAction())) { //check validity
                System.out.println("Invalid Move!");
                textView.updateView(this.game); //give player a new view before retrieving another move
            } else {
                carryOutAction(textView.getRow1(), textView.getColumn1(), textView.getRow2(), textView.getColumn2(), textView.getAction());
                textView.updateView(this.game);
                }
            }
        if (game.isAWinner()) {
            textView.printEndOfGameMessage(this.game); //prints winner
        } else {
            System.out.println("It's a tie! The game is over, and there is no winner"); //no winner ? its a tie
        }
    }

    public void carryOutAction(int row1, int column1, int row2, int column2, char action){
        switch(action) {
            case 'M':
                ActionMove actionMove = new ActionMove(this.game, row1, column1, row2, column2);
                actionMove.performAction();
                break;
            case 'A':
                ActionAttack actionAttack = new ActionAttack(this.game, row1, column1, row2, column2);
                actionAttack.performAction();
                break;
            case 'R':
                ActionRecruit actionRecruit = new ActionRecruit(this.game, row1, column1, row2, column2);
                actionRecruit.performAction();
                break;
            case 'S':
                ActionSpawn actionSpawn = new ActionSpawn(this.game, row1, column1, row2, column2);
                actionSpawn.performAction();
                break;
        }
    }
    public GameS22 setUpGameModel(){
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8,teamA, teamB);
    }

    public static void main(String[] args){
        Controller controller = new Controller();
        controller.playGame();
    }
}
