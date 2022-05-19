public class ActionMove extends Action{
    /**
     * Move action
     * @author Suhas Bolledula
     * @version 1.0
     */
    public ActionMove(GameS22 game, int row1, int column1, int row2, int column2){
        super(game, row1, column1, row2, column2);
    }

    @Override
    public void performAction(){
        game.getBoardSquares()[row1][column1].getPiece().speak();
        game.getBoardSquares()[row2][column2].setPiece(game.getBoardSquares()[row1][column1].getPiece());
        game.getBoardSquares()[row1][column1].removePiece(); //move
        game.changeTurn();


        //New Objective Modification
        int currRound = game.getRound();
        game.setRound(currRound+1);
    }
}
