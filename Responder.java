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
    private HashMap<String, String> synonymMap;
    private int lastUsedIndex = 0;

    /**
     * Construct a Responder
     */
    public Responder()
    {
        randomGenerator = new Random();
        responses = new ArrayList<>();
        responseMap = new HashMap<>();
        synonymMap = new HashMap<>();
        fillResponses();
        fillSynonymMap();
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
         //will remember last used value
        int index = randomGenerator.nextInt(responses.size());
        // list. The number will be between 0 (inclusive) and the size
        // of the list (exclusive).
        while (lastUsedIndex == index)
        {
            index = randomGenerator.nextInt(responses.size());
            
        }
        lastUsedIndex = index;
        return responses.get(index);
    }
    
    public boolean contains(String input) 
    {
        String[] arrayString = input.split(" ");
        boolean doesContain = false;
        for (int i = 0; i < arrayString.length; i++) 
        {
            if (!doesContain) {
            doesContain = synonymMap.containsKey(arrayString[i]);
            }
        }
        //System.out.println(synonymMap.containsKey());
        return doesContain;
    }
    
    private String pickClueResponse(String input) 
    {
        input = input.toLowerCase();
        String[] words = input.split("\\W+"); // split on non-word characters
    
        for (String word : words) {
            switch (word) {
                case "why":
                    return "Why indeed? Sometimes, there’s just no clear answer.";
                case "how":
                    return "That's a good question. Let's figure out how together.";
                case "who":
                    return "I'm not sure who, but it sounds mysterious.";
                case "what":
                    return "That depends on what you're referring to.";
                case "when":
                    return "Timing is everything. Can you be more specific?";
                case "where":
                    return "That might depend on your setup or location.";
            }
        }
    
        return pickDefaultResponse(); // fallback if no clue word found
    }


        
    public String containsAndOutput(String input) 
    {
        String[] arrayString = input.toLowerCase().split(" ");
        ArrayList<String> matchedResponses = new ArrayList<>();
        
        for (String word : arrayString) 
        {
            if (synonymMap.containsKey(word)) 
            {
                String keyword = synonymMap.get(word);
                String response = responseMap.get(keyword);
                if (response != null && !matchedResponses.contains(response)) {
                    matchedResponses.add("For the issue of " + keyword + ", you can " + response + ".");
                }
            }
        }
    
        if (matchedResponses.isEmpty()) {
            return pickClueResponse(input);
        } 
        else {
            return "It looks like you mentioned a few issues. Here's what I suggest:\n" 
                   + String.join("\n", matchedResponses);
        }
    }

    /**
     * Build up a list of default responses from which we can pick one
     * if we don't know what else to say.
     */
    private void fillResponseMap()
    {
        responseMap.put("screen", "try turning it on and off.");
        responseMap.put("hornet", "git Gud.");
        responseMap.put("robux", "get a job, kiddo.");
        responseMap.put("internet", "restart your PC first. If that doesn't help, restart your modem.");
        responseMap.put("cable", "read the manual.");
        responseMap.put("battery", "try charging it?");
        responseMap.put("keyboard", "Try plugging it into a different USB port.");
        responseMap.put("mouse", "clean the sensor underneath the mouse.");
        responseMap.put("sound", "check if it's muted or your output device is set correctly.");
        responseMap.put("crash", "make sure your drivers are up to date.");
        responseMap.put("blue", "give up cause you cannot escape the Blue Screen of Death. Time for a restart.");
        responseMap.put("slow", "try closing background apps or scanning for malware.");
    }
        
    private void fillSynonymMap()
    {
        synonymMap.put("screen", "screen");
        synonymMap.put("monitor", "screen");
        synonymMap.put("display", "screen");
        synonymMap.put("hornet", "hornet");
        synonymMap.put("hollow", "hornet");
        synonymMap.put("knight", "hornet");
        synonymMap.put("robux", "robux");
        synonymMap.put("internet", "internet");
        synonymMap.put("wifi", "internet");
        synonymMap.put("connection", "internet");
        synonymMap.put("cable", "cable");
        synonymMap.put("cables", "cable");
        synonymMap.put("wire", "cable");
        synonymMap.put("wires", "cable");
        synonymMap.put("battery", "battery");
        synonymMap.put("charge", "battery");
        synonymMap.put("power", "battery");
        synonymMap.put("keyboard", "keyboard");
        synonymMap.put("keys", "keyboard");
        synonymMap.put("mouse", "mouse");
        synonymMap.put("cursor", "mouse");
        synonymMap.put("sound", "sound");
        synonymMap.put("audio", "sound");
        synonymMap.put("volume", "sound");
        synonymMap.put("crash", "crash");
        synonymMap.put("freezes", "crash");
        synonymMap.put("freeze", "crash");
        synonymMap.put("blue", "blue");
        synonymMap.put("bsod", "blue");
        synonymMap.put("slow", "slow");
        synonymMap.put("lag", "slow");
        synonymMap.put("lagging", "slow");
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

