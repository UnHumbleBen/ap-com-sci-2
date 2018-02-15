
public class HorseA implements Horse
{
    // instance variables - replace the example below with your own
    private String name;
    private int wieght;

    public HorseA(String newName, int newWeight)
    {
        name = newName;
        wieght = newWeight;
    }

    /** @return the horse's name */
    public String getName() {
        return name;
    }

    /** @return the horse's weight */
    public int getWeight() {
        return wieght;
    }
    // There may be methods that are not shown.

}
