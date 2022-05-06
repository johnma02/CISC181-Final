public interface Attacker {
    /**
     * All attackers will extend from this interface
     * @author Suhas Bolledula
     * @version 1.0
     */
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int numAttacks);

    public abstract boolean validAttackPath(int row1, int column1, int row2, int column2);
}
