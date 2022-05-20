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
        int numTimesSpawned = ((Spawner) game.getBoardSquares()[row1][column1].getPiece()).getNumTimesSpawned();
        ((Spawner) game.getBoardSquares()[row1][column1].getPiece()).setNumTimesSpawned(numTimesSpawned+1);
        //New Action Modification
        //offloads the piece stolen
        if(game.getBoardSquares()[row1][column1].getPiece() instanceof PieceGoblin){
            ((PieceGoblin) game.getBoardSquares()[row1][column1].getPiece()).setPieceStolen(null);
        }
        game.changeTurn();

        //New Objective Modification
        int currRound = game.getRound();
        game.setRound(currRound+1);
    }
}
