public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public BoardSquare[][] getSquares() {
        return squares;
    }

    public boolean inBounds(int row, int column){
        boolean notNegative = row >= 0 && column >= 0;
        boolean inBounds = row < this.numRows && column < this.numColumns;

        return notNegative && inBounds;
    }

    public void setUpEmptyBoard(){
        int colorSwitch = 0;
        for (int i = 0; i < this.numRows; i++){
            for (int j = 0; j < this.numColumns; j++){
                this.squares[i][j] = colorSwitch % 2 == 0 ?
                        new BoardSquare("Brown"):
                        new BoardSquare("White");
                colorSwitch++;
            }
        }
    }

    public BoardSquare findRandomEmptySpace(){
        boolean empty = false;
        int row = 0;
        int column = 0;
        while (!empty){
            row = (int)(Math.random() * (this.numRows-1));
            column = (int)(Math.random() * (this.numColumns-1));
            empty = this.squares[row][column].isEmpty();
        }
        return this.squares[row][column];
    }

    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }


}
