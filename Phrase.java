public class Phrase
{
    private String currentPhrase;

    /** Constructs a new Phrase object. */
    public Phrase(String p)
    {
        currentPhrase = p;
    }

    /** Returns the index of the nth occurence of str in the current phrase;
     * returns -1 if the nth occurence does not exist.
     * Precondition: str.length() > 0 and n > 0
     * Postcondition: the current phrase is not motified
     */
    public int findNthOccurence(String str, int n)
    {
        int index = currentPhrase.indexOf(str);
        n--;
        while (n > 0 && index != -1) {
            index = currentPhrase.indexOf(str, index + 1); 
            n--;
        }
        
        return index;
    }
    
    /** Modifies the current phrase by replacing the nth occurence of str with repl.
     * If the nth occurence does not exist, the current phrase is unchanged.
     * Precondition: str.length() > 0 and n > 0
     */
    public void replaceNthOccurence (String str, int n, String repl) {
        int loc = findNthOccurence(str, n);
        
        if (loc != -1) {
            currentPhrase = currentPhrase.substring(0,loc) + repl + currentPhrase.substring(loc + str.length());
        }
    }
    
    /** Returns the index of the last occurence of str in the current phrase;
     *  returns -1 if str is not found
     *  Precondition: str.length() > 0
     *  Postcondition: the current prhase is not motified.
     */
    public int findLastOccurence (String str) {
        int n = 1;
        while (findNthOccurence(str, n+1) != -1) {
            n++;
        }
        return findNthOccurence(str, n);
    }
    
    /** Returns a string containing the current phrase. */
    public String toString() {
        return currentPhrase;
    }
}
