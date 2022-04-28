public class ActionRecruit extends Action{

    public ActionRecruit(GameS22 game, int row1, int column1, int row2, int column2) {
        super(game, row1, column1, row2, column2);
    }

    @Override
    public void performAction() {
        game.getBoardSquares()[row1][column1].getPiece().speak();
        game.getOpponentTeam().removePieceFromTeam(game.getBoardSquares()[row2][column2].getPiece());
        game.getCurrentTeam().addPieceToTeam(game.getBoardSquares()[row2][column2].getPiece());
        game.changeTurn();
    }
}