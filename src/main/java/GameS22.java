public class GameS22 extends Game{
    public GameS22(int rows, int columns, Team team1, Team team2){
        super(rows, columns, team1, team2);
    }

    @Override
    public boolean isAWinner() {
        return team1.getTeamPieces().isEmpty() ^ team2.getTeamPieces().isEmpty();
    }

    @Override
    public Team getWinner() {
        if(!isAWinner()){return null;}
        else{
            return team1.getTeamPieces().isEmpty() ? team2 : team1;
        }
    }

    @Override
    public boolean isGameEnded() {
        return team1.getTeamPieces().isEmpty() || team2.getTeamPieces().isEmpty();
    }
}
