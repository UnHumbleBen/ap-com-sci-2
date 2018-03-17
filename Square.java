public class Square
{
    private boolean black;
    private int n;
    
    /** Constructs one square of a crossword puzzle grid.
     *  Postcondition:
     *      - The square is black if and only if  isBlack  is true.
     *      - The square has number  num.
     */
    public Square(boolean isBlack, int num)
    {
        black = isBlack;
        n = num;
    }
}