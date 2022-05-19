public class PieceMinion extends Piece implements Recruiter, Spawner{
    /**
     * Piece based on a minion from Despicable Me
     * @author Jonathan Ma
     * @version 1.0
     */

    //fields unique to minions: number of recruits, and number of times this piece has called spawn()
    protected int numRecruits;
    protected int numTimesSpawned;
    //static, maximum number of times this piece can spawn
    public static final int MAX_NUM_SPAWNED = 3;

    //constructors
    public PieceMinion(char symbol, String teamColor,
                       int numRecruits, int numTimesSpawned,
                       boolean hidden, boolean original) {
        super(symbol, teamColor, hidden, original);
        this.numRecruits = numRecruits;
        this.numTimesSpawned = numTimesSpawned;
    }

    public PieceMinion(){
        this('M',"- -",
                0,0,
                false,true);
    }
    //getters
    public int getNumRecruits() {return numRecruits;}
    public int getNumTimesSpawned() {return numTimesSpawned;}

    @Override
    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    //setters
    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int row1, int col1, int row2, int col2) {
        return this.validMovePath(row1, col1, row2, col2);
    }

    //see Piece.java for formal definition: an instance of PieceMinion will print "Bello!" to console when speak() is called
    @Override
    public void speak(){
        System.out.println("Bello!");
    }

    //see Piece.java for formal definition
    @Override
    public boolean validMovePath(int row1, int col1,
                                 int row2, int col2) {
        boolean validMove = false;
        if(col1 == col2){
            validMove = true;
        }
        else if(Math.abs(col2 - col1) == 2 && row1 == row2){
            validMove = true;
        }
        return validMove;
    }

    /**
     * see Piece.java for formal definition, PieceMinion will spawn a new PieceMinion with the same teamColor as
     * its original PieceMinion, the lowercased symbol of its original PieceMinion numRecruits=1, numTimesSpawned=0,
     * hidden=false, original=false
     * @return New PieceMinion
     */
    @Override
    public PieceMinion spawn(){
        if(canSpawn()) {
            return new PieceMinion(Character.toLowerCase(this.symbol),
                    this.teamColor, 1,
                    0,
                    false,
                    false);
        }
        else{
            return null;
        }
    }

    /**
     * A PieceMinion can spawn if it is the original and if it has not spawned MAX_NUM_SPAWNED of times
     * @return boolean representing if this PieceMinion can spawn more PieceMinions
     */
    public boolean canSpawn(){
        return original && numTimesSpawned < MAX_NUM_SPAWNED;
    }

    @Override
    public boolean validSpawnPath(int row1, int column1, int row2, int column2) {
        return this.validMovePath(row1, column1, row2, column2);
    }
}