public class LogMessage
{
    private String machineId;
    private String description;
    
    /** Precondition: message is a valid log message. */
    public LogMessage(String message)
    {
        machineId = message.substring(0, message.indexOf(":"));
        description = message.substring(message.indexOf(":") + 1);
    }
    
    /** Returns  true  if the description in this log message contains  keyword;
     *           false  otherwise.
     */
    public boolean containWord(String keyword)
    {
        int a = description.lastIndexOf(keyword);
        return ((a != -1) 
        && (a == 0 || description.charAt(a-1) == ' ')
        && (a + keyword.length() == description.length() || description.charAt(a + keyword.length()) == ' '));
    }
    
    public String getMachineID()
    { return machineId; }
    public String getDescription()
    { return description; }
}