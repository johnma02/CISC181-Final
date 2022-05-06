public class ActionSpawn extends Action{
    /**
     * Spawn action
     * @author Suhas Bolledula
     * @version 1.0
     */
    public ActionSpawn(GameS22 game, int row1, int column1, int row2, int column2){
        super(game, row1, column1, row2, column2);
    }

    @Override
    public void performAction() {
        game.getBoardSquares()[row1][column1].getPiece().speak();
        Piece spawnedPiece = game.getBoardSquares()[row1][column1].getPiece().spawn(); //create new spawned piece
        game.getCurrentTeam().addPieceToTeam(spawnedPiece);
        game.getBoardSquares()[row2][column2].setPiece(spawnedPiece);
        game.changeTurn();
    }
}
