public abstract class Piece {
    /**
     * Abstract class for all the pieces in our game for CISC-181
     * Written for CISC-181 S22
     * @author Jonathan Ma
     * @version 1.0
     */

    //Abstract fields for all our pieces
    protected char symbol;
    protected String teamColor;
    protected boolean hidden;
    protected boolean original;

    //Constructor
    public Piece(char symbol, String teamColor, boolean hidden, boolean original){
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }
    //Getters
    public char getSymbol() {return symbol;}

    public String getTeamColor(){return teamColor;}

    public boolean isHidden() {return hidden;}

    public boolean isOriginal(){ return original;}

    //Setters
    public void setSymbol(char symbol) {this.symbol = symbol;}
    public void setTeamColor(String teamColor) {this.teamColor = teamColor;}

    public void setHidden(boolean hidden) {this.hidden = hidden;}
    public void setOriginal(boolean original) {this.original = original;}

    //Abstract method, speak will print a string unique to a piece
    public abstract void speak();

    /**
     * "Spawns" a new object of type Piece, inherited classes will spawn an object of the same type as its class.
     * @return Piece, inherited classes will spawn InheritedClass... i.e PieceBuzz
     */
    public abstract Piece spawn();

    /**
     * checks if a move is legal
     * @param fromSquareRow starting row
     * @param fromSquareCol starting column
     * @param toSquareRow ending row
     * @param toSquareCol ending column
     * @return boolean representing whether a move can be performed
     */
    public abstract boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                          int toSquareRow, int toSquareCol);

    /**
     * Overrides toString to return a string representative of a piece
     * @return string representing Piece. Examples: Red U, Blue O, Green P
     */
    @Override
    public String toString(){
        return this.teamColor +" "+this.symbol;
    }
}
