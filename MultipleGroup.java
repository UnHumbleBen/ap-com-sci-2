import java.util.List;
public class MultipleGroup implements NumberGroup
{
    private List<NumberGroup> groupList;
    
    public boolean contains(int num)
    {
        for (NumberGroup g : groupList)
        {
            if (g.contains(num)) return true;
        }
        return false;
    }
}
