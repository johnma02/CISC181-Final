public interface Recruiter {
    /**
     * All recruiters will extend this interface
     * @author Suhas Bolledula
     * @version 1.0
     */
    int getNumRecruits();
    void setNumRecruits(int numRecruits);

    boolean validRecruitPath(int row1, int row2, int column1, int column2);
}
