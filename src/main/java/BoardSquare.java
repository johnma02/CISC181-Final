public class BoardSquare {
    private boolean isEmpty;
    private Piece piece;
    private String squareColor;
    
    public BoardSquare(String squareColor){
        this.squareColor = squareColor;
        this.isEmpty = true;
        this.piece = null;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Piece getPiece() {
        return piece;
    }

    public String getSquareColor() {
        return squareColor;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        this.isEmpty = false;
    }

    public Piece removePiece(){
        Piece temp = this.piece;
        this.piece = null;
        this.isEmpty = true;
        return temp;
    }

    @Override
    public String toString(){
        return !isEmpty() ? "-"+this.piece.toString()+"-" : "-------";
    }
}
