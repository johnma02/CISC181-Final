public interface Recruiter {
    /**
     * All recruiters will extend this interface
     * @author Suhas Bolledula
     * @version 1.0
     */
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int numRecruits);

    public abstract boolean validRecruitPath(int row1, int row2, int column1, int column2);
}
