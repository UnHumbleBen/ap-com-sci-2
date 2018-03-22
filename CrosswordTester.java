import java.util.*;
public class CrosswordTester
{
    public static void main(String[] args) 
    {
        Random r = new Random();
        boolean[][] blackSquares = new boolean[10][10];
        for (int row = 0; row < blackSquares.length; row++) 
        {
            for (int column = 0; column < blackSquares[0].length; column++) 
            {
                int n = r.nextInt(100);
                blackSquares[row][column] = (n % 2 == 0);
            }
        }
        for (boolean[] m : blackSquares) 
        {
            for (boolean n : m) 
            {
                System.out.println(n);
            }
        }
        //Crossword a = new Crossword;
    }
}