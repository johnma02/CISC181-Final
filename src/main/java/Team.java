import java.util.ArrayList;

public class Team {
    private String teamColor;
    private ArrayList<Piece> teamPieces;

    public Team(String teamColor, ArrayList<Piece> pieces){
        this.teamColor = teamColor;
        this.teamPieces = pieces;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }

    public void removePieceFromTeam(Piece piece){
        this.teamPieces.remove(piece);
    }

    public void addPieceToTeam(Piece piece){
        piece.teamColor = this.teamColor;
        this.teamPieces.add(piece);
    }

    @Override
    public String toString(){
        String team = "Team "+this.teamColor+" Pieces\n";
        for (Piece piece : this.teamPieces){
            team = team.concat(piece.toString()+" ");
        }
        return team;
    }
}
