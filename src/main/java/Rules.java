public class Rules {
    public static boolean checkValidAction(GameS22 game, int row1, int column1, int row2, int column2, char action){
        Piece initial;
        Piece nextPiece = null;
        boolean nextEmpty;
        boolean isEnemy = false;
        //check if initial is empty
        if(!game.getBoardSquares()[row1][column1].isEmpty()){
            initial = game.getBoardSquares()[row1][column1].getPiece();
        }
        //initial is empty! can't do anything
        else{return false;}

        //check if initial is same team as current, if not, return, we can't use enemy pieces
        if(!(initial.getTeamColor().equals(game.getCurrentTeam().getTeamColor()))){return false;}
        //check if next is empty
        nextEmpty = game.getBoardSquares()[row2][column2].isEmpty();
        if(!nextEmpty){
            nextPiece = game.getBoardSquares()[row2][column2].getPiece();
        }
        //check if next position is enemy owned if next is not empty
        if(!nextEmpty){
            isEnemy = nextPiece.getTeamColor().equals(game.getOpponentTeam().getTeamColor());
        }

        //only needs empty next, by now, we have returned other conditions are unsatisfied
        if(action == 'M'){
            return nextEmpty;
        }
        else if(action == 'S') {
            boolean validSpawn = false;
            //next cannot be occupied
            if (!nextEmpty) {return false;}
            //check for down casting
            if (initial instanceof PieceMinion) { //PieceEvilMinion extends from PieceMinion, thus we do not need to check for PieceEvilMinion
                validSpawn = ((PieceMinion) initial).canSpawn();
            }
            else if (initial instanceof PieceBlueHen) {
                validSpawn = ((PieceBlueHen) initial).canSpawn();
            }
            return validSpawn;
        }
        else if(action == 'R'){
            boolean validRecruit = false;
            //cannot recruit ally
            if(!isEnemy){return false;}
            //check for down casting -- Only PieceBuzz cannot recruit
            if(!(initial instanceof PieceBuzz)){
                validRecruit = true;
            }
            return validRecruit;
        }
        else if(action == 'A'){
            boolean validAttack = false;
            if(initial instanceof PieceBuzz){
                validAttack = ((PieceBuzz) initial).canAttack() && isEnemy;
            }
            else if (initial instanceof PieceEvilMinion) {
                validAttack = ((PieceEvilMinion) initial).canAttack();
            }
            else if(initial instanceof PieceBlueHen){
                validAttack = isEnemy;
            }
            return validAttack;
        }
        else{
            //not a move
            return false;
        }
    }
}
