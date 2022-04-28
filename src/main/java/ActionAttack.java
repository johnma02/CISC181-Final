public class ActionAttack extends Action{
    public ActionAttack(GameS22 game, int row1, int column1, int row2, int column2) {
        super(game, row1, column1, row2, column2);
    }

    @Override
    public void performAction() {
        if(game.getBoardSquares()[row1][column1].getPiece() instanceof PieceEvilMinion
        && game.getBoardSquares()[row2][column2].getPiece().getTeamColor().equals(game.getCurrentTeam().getTeamColor())
        && game.getBoardSquares()[row2][column2].getPiece() instanceof PieceMinion){
            PieceEvilMinion spawnedEvilMinion = new PieceEvilMinion(
                    Character.toLowerCase(game.getBoardSquares()[row1][column1].getPiece().getSymbol()),
                    game.getCurrentTeam().getTeamColor(), 1, 0,
                    0, false, false);
            game.getCurrentTeam().addPieceToTeam(spawnedEvilMinion);
            game.getBoardSquares()[row1][column1].getPiece().speak();
            game.getCurrentTeam().removePieceFromTeam(game.getBoardSquares()[row2][column2].getPiece());
            game.getBoardSquares()[row2][column2].removePiece();
            game.getBoardSquares()[row2][column2].setPiece(spawnedEvilMinion);
            game.changeTurn();
        }
        else{
            game.getBoardSquares()[row1][column1].getPiece().speak();
            game.getOpponentTeam().removePieceFromTeam(game.getBoardSquares()[row2][column2].getPiece());
            game.getBoardSquares()[row2][column2].removePiece();
            game.getBoardSquares()[row2][column2].setPiece(game.getBoardSquares()[row1][column1].getPiece());
            game.getBoardSquares()[row1][column1].removePiece();
            game.changeTurn();
        }
    }
}
