import org.jetbrains.annotations.NotNull;

public class Rules {
    public static boolean checkValidAction(GameS22 game, int row1, int column1, int row2, int column2, char action){
        Piece initial;
        Piece nextPiece = null;
        boolean nextEmpty;
        boolean isEnemy = false;

        //check if initial is in bounds && if next is in bounds
        if(!game.getGameBoard().inBounds(row1, column1) || !game.getGameBoard().inBounds(row2, column2)){return false;}
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

        if(action == 'M'){
            if(!nextEmpty){return false;}
            boolean validMove = false;
            if(initial instanceof PieceMinion){validMove = ((PieceMinion) initial).validMovePath(row1, column1, row2, column2);}
            else if(initial instanceof PieceBlueHen){validMove = ((PieceBlueHen) initial).validMovePath(row1, column1, row2, column2);}
            else if(initial instanceof PieceBuzz){validMove = ((PieceBuzz) initial).validMovePath(row1, column1, row2, column2);}
            return validMove;
        }
        else if(action == 'S') {
            boolean validSpawn = false;
            //next cannot be occupied
            if (!nextEmpty) {return false;}
            //check for down casting
            if (initial instanceof PieceMinion) { //PieceEvilMinion extends from PieceMinion, thus we do not need to check for PieceEvilMinion
                validSpawn = ((PieceMinion) initial).canSpawn() &&
                        ((PieceMinion) initial).validSpawnPath(row1, column1, row2, column2);
            }
            else if (initial instanceof PieceBlueHen) {
                validSpawn = ((PieceBlueHen) initial).canSpawn() &&
                        ((PieceBlueHen) initial).validSpawnPath(row1, column1, row2, column2);
            }
            return validSpawn;
        }
        else if(action == 'R'){
            boolean validRecruit = false;
            //cannot recruit ally
            if(!isEnemy){return false;}
            //check for down casting -- Only PieceBuzz cannot recruit
            if(initial instanceof PieceMinion){
                validRecruit = ((PieceMinion) initial).validRecruitPath(row1, column1, row2, column2);
            }
            else if (initial instanceof PieceBlueHen){
                validRecruit = ((PieceBlueHen) initial).validRecruitPath(row1, column1, row2, column2);
            }
            return validRecruit;
        }
        else if(action == 'A'){
            boolean validAttack = false;
            if(initial instanceof PieceBuzz){
                validAttack = ((PieceBuzz) initial).canAttack() && isEnemy &&
                        ((PieceBuzz) initial).validAttackPath(row1, column1, row2, column2);
            }
            else if (initial instanceof PieceEvilMinion) {
                validAttack = ((PieceEvilMinion) initial).canAttack() &&
                        ((PieceEvilMinion) initial).validAttackPath(row1, column1, row2, column2) &&
                        nextPiece instanceof PieceMinion;
            }
            else if(initial instanceof PieceBlueHen){
                validAttack = isEnemy && ((PieceBlueHen) initial).validAttackPath(row1, column1, row2, column2);
            }
            return validAttack;
        }
        else{
            //not a move
            return false;
        }
    }
}
