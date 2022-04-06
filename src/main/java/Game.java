import java.util.Collections;
public class Game {
    /**
     * This class represents our game for CISC-181
     * @author Jonathan Ma
     * @version 1.0
     */

    //private fields
    private GameBoard board; //game board
    private Team team1; // teams
    private Team team2;
    private String turn; //Represents which teams' turn it is

    /**
     * initializes the game board for our game. Finds random empty spaces on the game board and inserts each teams' pieces
     * @param numRows
     * @param numColumns
     */
    private void initializeGameBoard(int numRows, int numColumns){
        this.board = new GameBoard(numRows, numColumns);
        for (Piece piece : team1.getTeamPieces()){
            BoardSquare randomEmptySpace = this.board.findRandomEmptySpace();
            randomEmptySpace.setPiece(piece);
        }
        for (Piece piece : team2.getTeamPieces()){
            BoardSquare randomEmptySpace = this.board.findRandomEmptySpace();
            randomEmptySpace.setPiece(piece);
        }
    }

    //constructor, calls initializeGameBoard()
    public Game(int numRows, int numColumns, Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;

        this.turn = team1.getTeamColor();

        initializeGameBoard(numRows,numColumns);
    }

    //getters
    public GameBoard getGameBoard() {
        return this.board;
    }

    //returns whose turn it is
    public Team getCurrentTeam() {
        return team1.getTeamColor().equals(this.turn) ?
                team1:
                team2;
    }

    //returns whose turn it is not
    public Team getOpponentTeam() {
        return team2.getTeamColor().equals(this.turn) ?
                team1:
                team2;
    }

    //checks if it is the given teams' turn
    public boolean isTurn(Team team){
        return team.getTeamColor().equals(this.turn);
    }

    // gets our game board
    public BoardSquare[][] getBoardSquares(){
        return board.getSquares();
    }

    //changes turn to whose turn it isn't
    public void changeTurn(){
        this.turn = isTurn(team1) ? team2.getTeamColor() : team1.getTeamColor();
    }

    // overrides Object.toString, returns a string representing the game
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }

}
