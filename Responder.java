import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
/**
 * The responder class represents a response generator object. It is used
 * to generate an automatic response. This is the second version of this 
 * class. This time, we generate some random behavior by randomly selecting 
 * a phrase from a predefined list of responses.
 * 
 * @author   Michael Kölling and David J. Barnes
 * @version 7.2
 */
public class Responder
{
    private Random randomGenerator;
    private ArrayList<String> responses;
    private HashMap<String, String> responseMap;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        randomGenerator = new Random();
        responses = new ArrayList<>();
        responseMap = new HashMap<>();
        fillResponses();
        fillResponseMap();
    }

    /**
     * Generate a response.
     * 
     * @return  A string that should be displayed as the response
     */
    public String pickDefaultResponse()
    {
        // Pick a random number for the index in the default response 
        // list. The number will be between 0 (inclusive) and the size
        // of the list (exclusive).
        int index = randomGenerator.nextInt(responses.size());
        return responses.get(index);
    }
    
    public boolean contains(String input) 
    {
        String[] arrayString = input.split(" ");
        boolean doesContain = false;
        for (int i = 0; i < arrayString.length; i++) 
        {
            if (!doesContain) {
            doesContain = responseMap.containsKey(arrayString[i]);
        }
        }
        System.out.println(doesContain);
        return doesContain;
    }
    
    public String containsAndOutput(String input) 
    {
        String[] arrayString = input.split(" ");
        boolean doesContain = false;
        String word = "";
        for (int i = 0; i < arrayString.length; i++) 
        {
            
            doesContain = responseMap.containsKey(arrayString[i]);
            
            if (doesContain) 
            {
                word = responseMap.get(arrayString[i]);
            }
        }
        return word;
    }
    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillResponseMap()
    {
        responseMap.put("screen", "try turning it on and off");
        responseMap.put("hornet", "Git Gud");
        responseMap.put("robux", "get a job Kiddo");
    }
    
    private void fillResponses()
    {
        responses.add("That sounds odd. Could you describe this in more detail?");
        responses.add("""
                      No other customer has ever complained about this before.
                      What is your system configuration?
                      """);
        responses.add("I need a bit more information on that.");
        responses.add("Have you checked that you do not have a dll conflict?");
        responses.add("That is covered in the manual. Have you read the manual?");
        responses.add("""
                      Your description is a bit wishy-washy. Have you got an expert
                      there with you who could describe this more precisely?
                      """);
        responses.add("That's not a bug, it's a feature!");
        responses.add("Could you elaborate on that?");
        responses.add("Have you tried running the app on your phone?");
        responses.add("I just checked StackOverflow - they don't know either.");
    }
}

