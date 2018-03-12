public class SubstringChecker implements Checker
{
    private String string;

    public SubstringChecker(String s)
    {
        string = s;
    }
    
    public boolean accept(String text) {
        return string.indexOf(text) != -1;
    }
}
