import java.util.Collections;

public class Game {
    private GameBoard board;
    private Team team1;
    private Team team2;
    private String turn;

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

    public Game(int numRows, int numColumns, Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;

        this.turn = team1.getTeamColor();

        initializeGameBoard(numRows,numColumns);
    }

    public GameBoard getGameBoard() {
        return this.board;
    }

    public Team getCurrentTeam() {
        return team1.getTeamColor().equals(this.turn) ?
                team1:
                team2;
    }

    public Team getOpponentTeam() {
        return team2.getTeamColor().equals(this.turn) ?
                team1:
                team2;
    }

    public boolean isTurn(Team team){
        return team.getTeamColor().equals(this.turn);
    }

    public BoardSquare[][] getBoardSquares(){
        return board.getSquares();
    }

    public void changeTurn(){
        this.turn = isTurn(team1) ? team2.getTeamColor() : team1.getTeamColor();
    }

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
