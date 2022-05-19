public interface Attacker {
    /**
     * All attackers will extend from this interface
     * @author Suhas Bolledula
     * @version 1.0
     */
    int getNumAttacks();
    void setNumAttacks(int numAttacks);
    boolean canAttack();
    boolean validAttackPath(int row1, int column1, int row2, int column2);
}
