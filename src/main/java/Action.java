public abstract class Action {
    protected GameS22 game;
    protected int row1;
    protected int column1;
    protected int row2;
    protected int column2;

    public Action(GameS22 game, int row1, int column1, int row2, int column2){
        this.game = game;
        this.row1 = row1;
        this.column1 = column1;
        this.row2 = row2;
        this.column2 = column2;
    }

    public abstract void performAction();
}
