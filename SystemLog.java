import java.util.*;
public class SystemLog
{
    /** Contains all the entries in this system log.
     *  Guaranteed not to be  null  and to contain only non-null  entries.
     */
    private List<LogMessage> messageList;
    
    /** Removes from the system log all entries whose descriptions properly contain  keyword,
     *  and returns a list (possibily empty) containing the removed entries.
     *  Postcondition:
     *      - Entries in the returned list properly contain  keyword  and
     *        are in the order in which they appeared in the system log.
     *      - The remaining entries in the system log do not properly contain  keyword and
     *        are in their eoriginal order.
     *      - The returned list is empty if no messages preoperly contain keyword.
     */
    public List<LogMessage> removeMessages(String keyword)
    {
        List<LogMessage> removed = new ArrayList<>();
        for (int i = 0; i < messageList.size(); i++) 
        {
            if (messageList.get(i).containWord(keyword))
            {
                removed.add(messageList.get(i));
                messageList.remove(messageList.get(i));
                i--;
            }
        }
        return removed;
    }
    
}