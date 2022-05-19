public class ActionHastyStrike extends Action{
    //New Action Modification
    public ActionHastyStrike(GameS22 game, int row1, int column1, int row2, int column2) {
        super(game, row1, column1, row2, column2);
    }

    //A Rogue can double attack ONCE PER GAME!
    @Override
    public void performAction() {
        if(game.getBoardSquares()[row1][column1].getPiece() instanceof PieceGoblin){
            ((PieceGoblin) game.getBoardSquares()[row1][column1].getPiece()).setPieceStolen(
                    game.getBoardSquares()[row2][column2].getPiece());
            ((PieceGoblin) game.getBoardSquares()[row1][column1].getPiece()).getPieceStolen().setTeamColor(
                    game.getCurrentTeam().getTeamColor());
        }
        game.getBoardSquares()[row1][column1].getPiece().speak();
        game.getOpponentTeam().removePieceFromTeam(game.getBoardSquares()[row2][column2].getPiece());
        game.getBoardSquares()[row2][column2].removePiece();
        game.getBoardSquares()[row2][column2].setPiece(game.getBoardSquares()[row1][column1].getPiece());
        game.getBoardSquares()[row1][column1].removePiece();
        int numAttacks = ((Rogue) game.getBoardSquares()[row2][column2].getPiece()).getNumAttacks();
        ((Rogue) game.getBoardSquares()[row2][column2].getPiece()).setNumAttacks(numAttacks+1);
        ((Rogue) game.getBoardSquares()[row2][column2].getPiece()).setDoubleAttack(false);
        //New Objective Modification -- Hasty Strike does not change the turn, so round is not incremented
    }
}
