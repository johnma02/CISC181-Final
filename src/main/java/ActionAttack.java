public class ActionAttack extends Action{
    /**
     * Attack action
     * @author Jonathan Ma
     * @version 1.0
     */
    public ActionAttack(GameS22 game, int row1, int column1, int row2, int column2) {
        super(game, row1, column1, row2, column2);
    }

    @Override
    public void performAction() {
        //First implementation will allow PieceEvilMinion to turn allied PieceMinions into PieceEvilMinions
        if(game.getBoardSquares()[row1][column1].getPiece() instanceof PieceEvilMinion //Attacker is PieceEvilMinion
        && game.getBoardSquares()[row2][column2].getPiece().getTeamColor().equals(game.getCurrentTeam().getTeamColor()) //same team
        && game.getBoardSquares()[row2][column2].getPiece() instanceof PieceMinion
        && !(game.getBoardSquares()[row2][column2].getPiece() instanceof PieceEvilMinion)){ //Attacked piece is PieceMinion

            PieceEvilMinion spawnedEvilMinion = new PieceEvilMinion( //Create a new PieceEvilMinion
                    Character.toLowerCase(game.getBoardSquares()[row1][column1].getPiece().getSymbol()),
                    game.getCurrentTeam().getTeamColor(), 1, 0,
                    0, false, false);

            game.getCurrentTeam().addPieceToTeam(spawnedEvilMinion); //add to curr team
            game.getBoardSquares()[row1][column1].getPiece().speak();
            game.getCurrentTeam().removePieceFromTeam(game.getBoardSquares()[row2][column2].getPiece());
            game.getBoardSquares()[row2][column2].removePiece();
            game.getBoardSquares()[row2][column2].setPiece(spawnedEvilMinion);
            game.changeTurn();
        }
        else{
            //Encompasses every other piece in game.
            game.getBoardSquares()[row1][column1].getPiece().speak();
            game.getOpponentTeam().removePieceFromTeam(game.getBoardSquares()[row2][column2].getPiece());
            game.getBoardSquares()[row2][column2].removePiece();
            game.getBoardSquares()[row2][column2].setPiece(game.getBoardSquares()[row1][column1].getPiece());
            game.getBoardSquares()[row1][column1].removePiece();
            game.changeTurn();
        }
    }
}
