public class PieceGoblin extends Piece implements Spawner, Rogue{
    /**
     * Hasty Strike Action -- hasty strike allows two moves in one turn
     * @author Jonathan Ma
     * @version 1.0
     */

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

    //PieceGoblin steals pieces to spawn later.
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

    //can only attack if PieceGoblin does not currently have a piece stolen.
    @Override
    public boolean canAttack() {
        return this.PieceStolen == null;
    }

    //move anywhere, attack anywhere
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

    //can only spawn if it has a stolen piece.
    @Override
    public boolean canSpawn() {
        return this.PieceStolen != null;
    }

    //spawn within radius one
    @Override
    public boolean validSpawnPath(int row1, int column1, int row2, int column2) {
        return Math.abs(row2 - row1) <= 1 && Math.abs(column2 - column1) <= 1;
    }

    @Override
    public void speak() {
        System.out.println("Nyeh-he-he-heh!");
    }

    //spawns the piece stolen
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

    //can only double attack once per game.
    @Override
    public boolean canDoubleAttack() {
        return this.canDoubleAttack && canAttack();
    }
}
