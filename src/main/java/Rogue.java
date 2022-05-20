public interface Rogue extends Attacker{
    /**
     * Hasty Strike Action -- hasty strike allows two moves in one turn
     * @author Suhas Bolledula
     * @version 1.0
     */

    //New Action Modification
    //only rogues can double attack, rogues are attackers.
    void setDoubleAttack(boolean canDoubleAttack);
    boolean canDoubleAttack();
}
