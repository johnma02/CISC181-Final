public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int numRecruits);

    public abstract boolean validRecruitPath(int row1, int row2, int column1, int column2);
}
