public class GameBoard {
    /**
     * This class represents the game board where our game will be played. It holds a 2d array of Board Squares
     * @author Jonathan Ma
     * @version 1.0
     */

    //private fields
    private int numRows; // number of rows in our game board
    private int numColumns; // num columns in our game board
    private BoardSquare[][] squares; // the game board

    //constructor, calls setUpEmptyBoard
    public GameBoard(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    //getters
    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public BoardSquare[][] getSquares() {
        return squares;
    }

    /**
     * checks if a list index is in bounds of the game board
     * @param row given row index
     * @param column given column index
     * @return boolean rep. if this index is in bounds
     */
    public boolean inBounds(int row, int column){
        boolean notNegative = row >= 0 && column >= 0;
        boolean inBounds = row < this.numRows && column < this.numColumns;

        return notNegative && inBounds;
    }

    /**
     * This function sets up the game board.
     * Using two for loops to iterate through the game board 2d array, each BoardSquare is made empty
     * Also sets colors to brown and white alternating, like a chess/checker board
     */
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

    /**
     * Finds a empty space on the game board.
     * @return an empty space on the game board
     */
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
    public void plantMine(){
        BoardSquare mine = findRandomEmptySpace();
        while(mine.isLandMine()){
            mine = findRandomEmptySpace();
        }
        mine.setLandMine();
    }
    public void revealMines(){
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                squares[i][j].setRevealed();
            }
        }
    }
    /**
     * overrides Object.toString
     * @return a string representing the game baord
     */
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
