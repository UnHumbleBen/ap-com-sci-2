import java.util.ArrayList;
import java.util.Random;
public class RandomStringChooser
{
    private ArrayList<String> words = new ArrayList<>(); 
    
    public RandomStringChooser(String[] wordArray) {
        for (String singleWord : wordArray ) {
            words.add(singleWord);
        }
    }
    
    public String getNext() {
        if (words.size() > 0) {
            return words.remove((int) (Math.random() * words.size()));
        }
        return "NONE";
    }
}
