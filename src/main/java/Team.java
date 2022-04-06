import java.util.ArrayList;

public class Team {
    /**
     * This class represents a team in our game for CISC-181
     * @author Jonathan Ma
     * @version 1.0
     */

    //private fields
    private String teamColor;
    private ArrayList<Piece> teamPieces; //ArrayList holding all the pieces a team owns

    //constructor
    public Team(String teamColor, ArrayList<Piece> pieces){
        this.teamColor = teamColor;
        this.teamPieces = pieces;
    }

    //getters
    public String getTeamColor() {
        return teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }

    /**
     * removes a piece from the teams ArrayList of pieces by value
     * @param piece piece to remove
     */
    public void removePieceFromTeam(Piece piece){
        this.teamPieces.remove(piece);
    }

    /**
     * adds a piece to the end of a teams ArrayList of pieces
     * @param piece piece to add
     */
    public void addPieceToTeam(Piece piece){
        piece.teamColor = this.teamColor;
        this.teamPieces.add(piece);
    }

    /**
     * overrides Object.toString
     * @return team color and team pieces
     */
    @Override
    public String toString(){
        String team = "Team "+this.teamColor+" Pieces\n";
        for (Piece piece : this.teamPieces){
            team = team.concat(piece.toString()+" ");
        }
        return team;
    }
}
