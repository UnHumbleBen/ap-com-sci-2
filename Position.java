public class Position
{
    private int row;
    private int column;
    /** Constructs a Position object with row r and column c. */
    public Position(int r, int c)
    {
        row = r;
        column = c;
    }
    
    /** returns the a string containing the position */
    public String toString() {
        return "(" + row + "," + column + ")";
    }
}