public class Crossword
{
    /** Each element is a  Square  object with a color (black or white) and a number.
     *  puzzle[r][c]  represents the square in row  r, column  c.
     *  There is at least one row in the puzzle.
     */
    private Square[][] puzzle;

    /** Constructs a crossword puzzle grid.
     *  Precondition: There is at least one row in blackSquares.
     *  Postcondition:
     *      - The crossword puzzle grid has the same dimensions as  blackSquares.
     *      - The  Square object at row  r, column  c  in the crossword puzzle is black
     *        if and only if blackSquares[r][c] is  true.
     *      - The squares in the puzzle are labeled according to the crossword labeling rule.
     */
    public Crossword(boolean[][] blackSquares)
    {
        puzzle = new Square[blackSquares.length][blackSquares[0].length];
        int n = 1;
        for (int row = 0; row < puzzle.length; row++) 
        {
            for (int col = 0; col < puzzle[0].length; col++) 
            {
                int label = 0;
                if (toBeLabeled(row, col, blackSquares))
                {
                    label = n;
                    n++;
                } 
                puzzle[row][col] = new Square(blackSquares[row][col], label);
            }
        }
    }

    /** Returns  true  if the square at row  r, column  c should be labeled with a positive number,
     *           false  otherwise.
     *  The square at row  r, column  c is black if and only if blackSquares[r][c] is  true.
     *  Precondition: r  and c  are valid indexes in blackSquares.
     */
    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
    {
        if (blackSquares[r][c] ) return false;
	if (r == 0 || blackSquares[r-1][c]) return true;
	if (c == 0 || blackSquares[r][c-1]) return true;
	return false;
    }
}