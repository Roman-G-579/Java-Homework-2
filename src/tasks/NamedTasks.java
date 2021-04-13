package tasks;

import java.util.HashMap;

public class NamedTasks extends Tasks {
    
    private String[] names;
    private HashMap<String, Integer> stringToInteger = new HashMap<String, Integer>();
    private HashMap<Integer, String> integerToString = new HashMap<Integer, String>();
    
    public NamedTasks(String[] names) {
        super(names.length);
        this.names = names;
        
        // "builds" the HashMaps
        {
            integerToString.put(0, "zero");
            integerToString.put(1, "one");
            integerToString.put(2, "two");
            integerToString.put(3, "three");
            integerToString.put(4, "four");
            integerToString.put(5, "five");
            integerToString.put(6, "six");
            integerToString.put(7, "seven");
            integerToString.put(8, "eight");
            integerToString.put(9, "nine");
            
            stringToInteger.put("zero", 0);
            stringToInteger.put("one", 1);
            stringToInteger.put("two", 2);
            stringToInteger.put("three", 3);
            stringToInteger.put("four", 4);
            stringToInteger.put("five", 5);
            stringToInteger.put("six", 6);
            stringToInteger.put("seven", 7);
            stringToInteger.put("eight", 8);
            stringToInteger.put("nine", 9);
        }
    }
    
    public boolean dependsOn(String task1, String task2) {
        if (!stringToInteger.containsKey(task1) || !stringToInteger.containsKey(task2)) {
            return false;
        }
        
        dependsOn(stringToInteger.get(task1), stringToInteger.get(task2));
        return true;
    }
    
    public String[] nameOrder() {
        int[] numberedOrder = new int[names.length];
        String[] stringOrder = new String[names.length];
        
        //converts the names array to a numbers array
        for (int i = 0; i < names.length; i++) {
            numberedOrder[i] = stringToInteger.get(names[i]);
        }
        
        numberedOrder = order();
        
        // converts the ordered int array into an ordered string array
        for (int i = 0; i < names.length; i++) {
            stringOrder[i] = integerToString.get(numberedOrder[i]);
        }
        return stringOrder;
    }
    
}