public class PieceEvilMinion extends PieceMinion implements Attacker, Recruiter, Spawner{
    /**
     * Piece based on a minion from Despicable Me, this is an evil version of PieceMinion, and as such
     * inherits from PieceMinion
     * @author Jonathan Ma
     * @version 1.0
     */

    //PieceEvilMinion can attack, unlike PieceMinion
    private int numAttacks;
    //A PieceEvilMinion can attack if it is hungry, and a PieceEvilMinion is hungry if it has not attacked MAX_NUM_ATTACKS times.
    private boolean hungry;
    //static int representing max number of times PieceEvilMinion can attack
    public static final int MAX_NUM_ATTACKS = 4;

    //constructors
    public PieceEvilMinion(char symbol, String teamColor, int numRecruits,
                           int numAttacks, int numTimesSpawned,
                           boolean hidden, boolean original){
        super(symbol,teamColor,numRecruits,numTimesSpawned,hidden,original);
        this.numAttacks = numAttacks;
        updateHungry();
    }

    public PieceEvilMinion(){
        this('E',"NON",0,0,0,false,true);
    }

    //getters
    public int getNumAttacks() {
        return numAttacks;
    }
    //setters
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean validAttackPath(int row1, int column1, int row2, int column2) {
        return this.validMovePath(row1, column1, row2, column2);
    }

    public void setNumTimesSpawned(int numTimesSpawned) {
        this.numTimesSpawned = numTimesSpawned;
    }

    /**
     * Checks if this PieceEvilMinion can attack, a PieceEvilMinion can only attack if it is hungry
     * @return boolean representing whether this piece can attack
     */
    public boolean canAttack(){
        return this.hungry;
    }

    /**
     * Updates hungry by checking if numAttacks is equal to or has exceeded MAX_NUM_ATTACKS
     */
    public void updateHungry(){
        this.hungry = this.numAttacks < MAX_NUM_ATTACKS;
    }

    //see Piece.java for formal definition, this PieceEvilMinion will print "Roar!" to the console when speak() is called
    @Override
    public void speak() {
        System.out.println("Roar!");
    }

    /**
     * see Piece.java for formal definition, this PieceEvilMinion will spawn a new PieceEvilMinion instance with
     * the lowercased symbol of its original PieceEvilMinion, the same teamColor as its original PieceEvilMinion,
     * numRecruits=1, numAttacks=0, numTimesSpawned=0,
     * @return new PieceEvilMinion
     */
    @Override
    public PieceEvilMinion spawn() {
        if(canSpawn()) {
            this.numTimesSpawned++;
            return new PieceEvilMinion(Character.toLowerCase(this.symbol),
                    this.teamColor, 1, 0,
                    0, false, false);
        }
        else{
            return null;
        }
    }

    /**
     * see Piece.java for formal definition
     * @param fromSquareRow init row
     * @param fromSquareCol init col
     * @param toSquareRow fin row
     * @param toSquareCol fin col
     * @return boolean representing if move is legal
     */
}
