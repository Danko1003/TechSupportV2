import java.util.HashMap;
/**
 * Write a description of class MapTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapTester
{
    // instance variables - replace the example below with your own
    HashMap<String, String> mapTest = new HashMap<>();

    /**
     * Constructor for objects of class MapTester
     */
    public MapTester()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void enterNumber(String name, String number)
    {
        // put your code here
        mapTest.put(name, number);
    }
    
    public String lookUpNumber(String name) 
    {
        String returning = mapTest.get(name);
        return returning;
    }
}
