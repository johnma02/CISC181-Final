public class BoardSquare {
    /**
     * This class represents a square on our board. BoardSquares hold instances of Piece
     * @author Jonathan Ma
     * @version 1.0
     */
    //private fields
    private boolean isEmpty; // represents if this BoardSquare is not holding a Piece
    private Piece piece; // Piece this BoardSquare holds
    private String squareColor; // Color of this BoardSquare
    //Board Square Modification
    private boolean landMine;
    private boolean revealed;
    //constructors
    public BoardSquare(String squareColor){
        this.squareColor = squareColor;
        this.isEmpty = true;
        this.piece = null;
        this.landMine = false;
        this.revealed = false;
    }

    //getters
    //Board Square Modification
    public boolean isLandMine(){return this.landMine;}
    public void setLandMine(){this.landMine = true;}
    public boolean isRevealed(){return this.revealed;}
    public void setRevealed(){this.revealed = true;}

    public boolean isEmpty() {
        return isEmpty;
    }

    public Piece getPiece() {
        return piece;
    }

    public String getSquareColor() {
        return squareColor;
    }

    //setters -- also sets isEmpty to false
    public void setPiece(Piece piece) {
        this.piece = piece;
        this.isEmpty = false;
    }

    /**
     * Returns the Piece in this BoardSquare, also removes it from this BoardSquare, and sets isEmpty to true
     * @return Piece in this BoardSquare
     */
    public Piece removePiece(){
        Piece temp = this.piece;
        this.piece = null;
        this.isEmpty = true;
        return temp;
    }

    /**
     * Overrides Object.toString()
     * @return string representing this BoardSquare's piece's toString value.
     */
    @Override
    public String toString(){
        return !isEmpty() && !isLandMine() ? "-"+this.piece.toString()+"-" :
                isRevealed() && isLandMine() ? "XXXXXXX" : "-------";
    }
}
