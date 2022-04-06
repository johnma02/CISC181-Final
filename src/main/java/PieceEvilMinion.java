public class PieceEvilMinion extends PieceMinion{
    private int numAttacks;
    private boolean hungry;

    public static int MAX_NUM_ATTACKS = 4;

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

    public int getNumAttacks() {
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public boolean canAttack(){
        return this.hungry;
    }

    public void updateHungry(){
        this.hungry = this.numAttacks < MAX_NUM_ATTACKS;
    }
    @Override
    public void speak() {
        System.out.println("Roar!");
    }

    @Override
    public PieceEvilMinion spawn() {
        this.numTimesSpawned++;
        return new PieceEvilMinion(Character.toLowerCase(this.symbol),
                this.teamColor, 1, 0,
                0, false, false);
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }
}
