public class PieceBuzz extends Piece implements Attacker{
    /**
     * Piece based on Buzz Lightyear from Toy Story.
     * @author Jonathan Ma
     * @version 1.0
     */
    //private fields
    private int numAttacks;
    private int numTimesBeenAttacked;
    //PieceBuzz can only attack if workingLaser is true
    private boolean workingLaser;

    //constructors
    public PieceBuzz(char symbol,
                     String teamColor,
                     int numAttacks,
                     int numTimesBeenAttacked,
                     boolean workingLaser,
                     boolean hidden,
                     boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numTimesBeenAttacked = numTimesBeenAttacked;
        this.workingLaser = workingLaser;
    }

    public PieceBuzz(){
        this('B',"- -",
                0,0,
                true, false, true);
    }

    //getters
    public int getNumAttacks() {return numAttacks;}
    public int getNumTimesBeenAttacked() {return numTimesBeenAttacked;}
    public boolean canAttack(){return workingLaser;}

    //setters
    public void setWorkingLaser(boolean workingLaser) {
        this.workingLaser = workingLaser;
    }

    public void setNumAttacks(int numAttacks)  {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int row1, int column1, int row2, int column2) {
        return true;
    }

    //updates numTimesBeenAttacked and sets workingLaser to false
    public void updateNumTimesBeenAttacked(){
        this.numTimesBeenAttacked += 1;
        this.workingLaser = false;
    }

    //see Piece.java for formal definition, PieceBuzz prints "To Infinity and Beyond" to console when speak()
    //is called
    @Override
    public void speak(){
        System.out.println("To Infinity and Beyond!");
    }

    /**
     * see Piece.java for formal definition
     * @param fromSquareRow starting row
     * @param fromSquareCol starting column
     * @param toSquareRow ending row
     * @param toSquareCol ending column
     * @return boolean representing if a move is legal
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    //see Piece.java for formal definition, PieceBuzz cannot spawn
    @Override
    public PieceBuzz spawn(){
        return null;
    }
    //PieceBuzz cannot spawn
    public boolean canSpawn(){
        return false;
    }

}