public class GameS22 extends Game{
    /**
     * Game template for this class
     * @author Jonathan Ma
     * @version 1.0
     */
    //New Objective Modification
    private int roundCounter;
    public GameS22(int rows, int columns, Team team1, Team team2){
        super(rows, columns, team1, team2);
        this.roundCounter = 1;
    }

    public int getRound(){return this.roundCounter;}
    public void setRound(int round){this.roundCounter = round;}

    @Override
    public boolean isAWinner() {
        return team1.getTeamPieces().isEmpty() ^ team2.getTeamPieces().isEmpty(); //cannot currently be a tie, but checks for winner
    }

    @Override
    public Team getWinner() {
        if(!isAWinner()){return null;}
        else{
            return team1.getTeamPieces().isEmpty() ? team2 : team1; //checks which team is empty
        }
    }

    @Override //called every turn
    public boolean isGameEnded() {
        return team1.getTeamPieces().isEmpty() || team2.getTeamPieces().isEmpty();
    }
}
