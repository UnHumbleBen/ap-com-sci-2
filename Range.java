import java.util.List;
import java.util.ArrayList;
public class Range implements NumberGroup
{
    private List<Integer> group = new ArrayList<>();
    public Range(int min, int max) 
    {
        int n = min;
        while (n <= max) 
        {
            group.add(n);
            n++;
        }
    }
    
    public boolean contains(int num)
    {
        for (int n : group)
        {
            if (n == num) return true;
        }
        return false;
    }
}