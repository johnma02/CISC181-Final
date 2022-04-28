import java.util.ArrayList;

public class CheckingRules {
    public static void main(String[] arg){
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M',"Blu",
                0,0,false,true));
        piecesTeamA.add(new PieceBuzz('B',"Blu",2,1,
                true,false,true));
        piecesTeamA.add(new PieceBlueHen('H',"Blu",3,
                9,false,true));
        piecesTeamA.add(new PieceEvilMinion('E',"Blu",1,
                1,4,false, true));
        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M',"Red",
                0,0,false,true));
        piecesTeamB.add(new PieceBlueHen('H',"Red",3,
                9,false,true));
        piecesTeamB.add(new PieceBuzz('B',"Red",2,1,
                true,false,true));
        piecesTeamB.add(new PieceEvilMinion('E',"Red",1,
                1,4,false, true));
        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);

        // create a game
        GameS22 game = new GameS22(6,6,teamA,teamB);

        // clear Piece off the board
        for(int row = 0; row < game.getGameBoard().getNumRows();row++){
            for (int col = 0; col < game.getGameBoard().getNumColumns(); col++){
                game.getGameBoard().getSquares()[row][col].removePiece();
            }
        }

        // load your pieces in specific locations of your choice
        game.getGameBoard().getSquares()[0][0].setPiece(piecesTeamA.get(0));
        game.getGameBoard().getSquares()[0][1].setPiece(piecesTeamA.get(1));
        game.getGameBoard().getSquares()[0][2].setPiece(piecesTeamA.get(2));
        game.getGameBoard().getSquares()[0][3].setPiece(piecesTeamA.get(3));
        game.getGameBoard().getSquares()[2][0].setPiece(piecesTeamB.get(0));
        game.getGameBoard().getSquares()[2][1].setPiece(piecesTeamB.get(1));
        game.getGameBoard().getSquares()[2][2].setPiece(piecesTeamB.get(2));
        game.getGameBoard().getSquares()[2][3].setPiece(piecesTeamB.get(3));

        System.out.println(game);

        // Test some moves that should be valid
        System.out.println("VALID");
        System.out.println(Rules.checkValidAction(game,
                0,3,
                2,2,'R'));
        System.out.println(Rules.checkValidAction(game,
                0,3,
                1,4,'M'));

        System.out.println(Rules.checkValidAction(game,
                0,2,
                2,2,'A'));
        System.out.println(Rules.checkValidAction(game,
                0,3,
                0,2,'A'));
        // Test some moves that are invalid
        System.out.println("INVALID");
        System.out.println(Rules.checkValidAction(game,
                0,3,
                1,4,'S'));
        System.out.println(Rules.checkValidAction(game,
                0,1,
                2,1,'R'));
        System.out.println(Rules.checkValidAction(game,
                0,3,
                0,2,'R'));
        System.out.println(Rules.checkValidAction(game,
                0,3,
                2,2,'S'));
        System.out.println(Rules.checkValidAction(game,
                0,3,
                0,2,'M'));
        System.out.println(Rules.checkValidAction(game,
                2,3,
                1,4,'M'));
        System.out.println(Rules.checkValidAction(game,
                0,4,
                2,0,'A'));
        System.out.println(Rules.checkValidAction(game,
                0,0,
                0,2,'A'));
        System.out.println(Rules.checkValidAction(game,
                0,0,
                0,2,'R'));
        System.out.println(Rules.checkValidAction(game,
                0,0,
                0,2,'S'));
        System.out.println(Rules.checkValidAction(game,
                0,0,
                2,0,'A'));

        System.out.println(Rules.checkValidAction(game,
                0,100,
                1,4,'M'));

        System.out.println(Rules.checkValidAction(game,
                -1,3,
                1,4,'M'));

        System.out.println(Rules.checkValidAction(game,
                0,3,
                -1,4,'M'));

        System.out.println(Rules.checkValidAction(game,
                2000,3,
                1,2000,'M'));
        System.out.println("BASE CASES: TFFT");
        // This should be a valid move
        System.out.println(Rules.checkValidAction(game,
                0,0,
                1,4,'M'));

        // To Square isn't empty - should not be a valid move
        System.out.println(Rules.checkValidAction(game,
                0,0,
                0,1,'M'));
        // This isn't current team's piece - should not be valid
        System.out.println(Rules.checkValidAction(game,
                2,0,
                0,5,'M'));


        // You can change the turn to test the other team pieces
        game.changeTurn();

        System.out.println(Rules.checkValidAction(game,
                2,0,
                0,5,'M'));


    }
}
