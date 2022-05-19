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
    private int numTimesSpawned = 0;
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
    public boolean canAttack() {
        return true;
    }

    @Override
    public boolean validAttackPath(int row1, int column1, int row2, int column2) {
        if(canFly()){return true;}
        else{
            return Math.abs(column2 - column1) == 1 && row2 == row1;
        }
    }

    public void setNumRecruits(int numRecruits)    {
        this.numRecruits = numRecruits;
    }

    @Override
    public boolean validRecruitPath(int row1, int column1, int row2, int column2) {
        if(canFly()){return true;}
        else{
            return Math.abs(row2 - row1) == 1 && column1 == column2;
        }
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
     * @param row1 starting row
     * @param col1 starting column
     * @param row2 ending row
     * @param col2 ending column
     * @return boolean representing whether move is legal
     */
    @Override
    public boolean validMovePath(int row1, int col1,
                                 int row2, int col2) {
        if(canFly()){return true;}
        else{
            return Math.abs(row2 - row1) <= 1 && Math.abs(col2 - col1) <= 1;
        }
    }

    /**
     * see Piece.java for formal definition, PieceBlueHen makes a new PieceBlueHen named copyHen with lowercased symbol of its
     * original PieceBlueHen, same teamColor, same numAttacks, same numRecruits, and hidden=false, original=false
     * @return
     */
    @Override
    public PieceBlueHen spawn()    {
        return new PieceBlueHen(Character.toLowerCase(this.symbol),
                this.teamColor, this.numAttacks, this.numRecruits,
                false,false);
    }

    //PieceBlueHen can always spawn if it is original
    public boolean canSpawn(){
        return this.original;
    }

    @Override
    public int getNumTimesSpawned() {
        return this.numTimesSpawned;
    }

    @Override
    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    @Override
    public boolean validSpawnPath(int row1, int column1, int row2, int column2) {
        if(canFly()){return true;}
        else {
            return Math.abs(row2 - row1) == 1 && Math.abs(column2 - column1) == 1;
        }
    }
}