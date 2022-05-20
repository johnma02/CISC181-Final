public class Rules {
    /**
     * The rules for our game
     * @author Suhas Bolledula
     * @version 1.0
     */
    public static boolean checkValidAction(GameS22 game, int row1, int column1, int row2, int column2, char action){
        Piece initial;
        Piece nextPiece = null;
        boolean nextEmpty;
        boolean isEnemy = false;

        //check if initial is in bounds && if next is in bounds -- Should be handled in TextView, but just makes sure twice
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
            if(!nextEmpty){return false;} //cannot move to filled spot
            return initial.validMovePath(row1,column1,row2,column2);
        }
        else if(action == 'S') {
            boolean validSpawn = false;
            //next cannot be occupied
            if (!nextEmpty) {return false;}
            //down cast
           if (initial instanceof Spawner){
                validSpawn = ((Spawner) initial).canSpawn() && ((Spawner) initial).validSpawnPath(row1, column1,
                        row2, column2);
            }
            return validSpawn;
        }
        else if(action == 'R'){
            boolean validRecruit = false;
            //cannot recruit ally -- also checks if next is empty.
            if(!isEnemy){return false;}
            //down casting -- Only PieceBuzz cannot recruit
            if(initial instanceof Recruiter) {
                validRecruit = ((PieceMinion) initial).validRecruitPath(row1, column1, row2, column2);
            }
            return validRecruit;
        }

        else if(action == 'A'){
            //We DO NOT check for enemy, because certain pieces can attack allies
            boolean validAttack = false;

            //PieceEvilMinion is special so it gets its own control branch
            if (initial instanceof PieceEvilMinion) {
                if(nextEmpty){validAttack = false;}
                //Needed to ensure that ONLY PieceEvilMinion can attack an allied PieceMinion and ONLY PieceMinion
                else if(nextPiece.getTeamColor().equals(game.getCurrentTeam().getTeamColor()) && nextPiece instanceof PieceMinion
                && !(nextPiece instanceof PieceEvilMinion) ){
                    validAttack = ((PieceEvilMinion) initial).canAttack() &&
                            ((PieceEvilMinion) initial).validAttackPath(row1, column1, row2, column2);
                }
                else{
                    validAttack = ((PieceEvilMinion) initial).canAttack() && isEnemy &&
                            ((PieceEvilMinion) initial).validAttackPath(row1, column1, row2, column2);
                }
            }
            //New Rule Modification
            else if(initial instanceof Attacker){
                validAttack = isEnemy && ((Attacker) initial).validAttackPath(row1, column1, row2, column2) &&
                        ((Attacker) initial).canAttack();
            }

            return validAttack;
        }
        //New Action Modification -- basically the same as attacker.
        else if(action == 'H'){
            boolean canDoubleAttack = false;
            if(initial instanceof Rogue){
                canDoubleAttack = ((Rogue) initial).canDoubleAttack() && isEnemy && ((Rogue) initial).validAttackPath(
                        row1, column1, row2, column2);

            }
            return canDoubleAttack;
        }
        else{
            //not a move
            return false;
        }
    }
}
