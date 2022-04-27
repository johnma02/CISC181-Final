public interface Attacker {
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int numAttacks);

    public abstract boolean validAttackPath(int row1, int column1, int row2, int column2);
}
