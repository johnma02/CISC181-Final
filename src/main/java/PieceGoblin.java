public class PieceGoblin extends Piece implements Spawner, Rogue{
    //New Piece Modification
    private boolean canDoubleAttack;
    private int numAttacks;
    private int numTimesSpawned;
    private Piece PieceStolen;

    public PieceGoblin(char symbol, String teamColor, boolean hidden, boolean original,
                       int numTimesSpawned, int numAttacks, boolean canDoubleAttack) {
        super(symbol, teamColor, hidden, original);
        this.numAttacks = numAttacks;
        this.numTimesSpawned = numTimesSpawned;
        this.canDoubleAttack = canDoubleAttack;
        this.PieceStolen = null;
    }

    public Piece getPieceStolen(){
        return this.PieceStolen;
    }
    public void setPieceStolen(Piece PieceStolen){
        this.PieceStolen = PieceStolen;
    }
    @Override
    public int getNumAttacks() {
        return this.numAttacks;
    }

    @Override
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    @Override
    public boolean canAttack() {
        return this.PieceStolen == null;
    }

    @Override
    public boolean validAttackPath(int row1, int column1, int row2, int column2) {
        return true;
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
    public boolean canSpawn() {
        return this.PieceStolen != null;
    }

    @Override
    public boolean validSpawnPath(int row1, int column1, int row2, int column2) {
        return Math.abs(row2 - row1) <= 1 && Math.abs(column2 - column1) <= 1;
    }

    @Override
    public void speak() {
        System.out.println("Nyeh-he-he-heh!");
    }

    @Override
    public Piece spawn() {
        if(canSpawn()){
            return this.PieceStolen;
        }
        else{
            return null;
        }
    }

    @Override
    public boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol) {
        return true;
    }

    @Override
    public void setDoubleAttack(boolean canDoubleAttack) {
        this.canDoubleAttack = canDoubleAttack;
    }

    @Override
    public boolean canDoubleAttack() {
        return this.canDoubleAttack && canAttack();
    }
}
