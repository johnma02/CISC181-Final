public class PieceBlueHen extends Piece implements Attacker, Recruiter, Spawner{
    /**
     * PieceBlueHen is based on the University of Delaware's mascot.
     * @author Jonathan Ma
     * @version 1.0
     */

    //private fields
    private int numAttacks;
    private int numRecruits;
    private boolean flies;

    //static variable representing the number of times PieceBlueHen can attack
    public static final int MAX_NUM_ATTACKS = 3;

    //constructors
    public PieceBlueHen(char symbol,
                         String teamColor,
                         int numAttacks, int numRecruits,
                         boolean hidden, boolean original){
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen ()  {
        this('H',"NON",
                0,0,
                false,true);
    }

    //getters
    public int getNumAttacks()    {
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }

    public boolean canFly()    {
        return this.flies;
    }

    //setters
    public void setNumAttacks(int numAttacks)    {
        this.numAttacks = numAttacks;
        updateFly();
    }

    @Override
    public boolean validAttackPath(int row1, int column1, int row2, int column2) {
        return true;
    }

    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int row1, int row2, int column1, int column2) {
        return true;
    }


    // checks if PieceBlueHen has attacked MAX_NUM_ATTACKS times, and updates flies accordingly
    //PieceBlueHen can only fly if it hasn't exceeded MAX_NUM_ATTACKS
    private void updateFly()    {
        this.flies = this.numAttacks < MAX_NUM_ATTACKS;
    }

    //see Piece.java for formal definition, PieceBlueHen prints "Go UD!" to console when speak() is called.
    @Override
    public void speak(){
        System.out.println("Go UD!");
    }

    /**
     * see piece.java for formal definition
     * @param fromSquareRow starting row
     * @param fromSquareCol starting column
     * @param toSquareRow ending row
     * @param toSquareCol ending column
     * @return boolean representing whether move is legal
     */
    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }

    /**
     * see Piece.java for formal definition, PieceBlueHen makes a new PieceBlueHen named copyHen with lowercased symbol of its
     * original PieceBlueHen, same teamColor, same numAttacks, same numRecruits, and hidden=false, original=false
     * @return
     */
    @Override
    public PieceBlueHen spawn()    {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor,this.numAttacks,this.numRecruits,
                        false,false);
        return copyHen;
    }

    //PieceBlueHen can always spawn
    public boolean canSpawn(){
        return true;
    }

    @Override
    public boolean validSpawnPath(int row1, int column1, int row2, int column2) {
        return true;
    }
}