package tasks;

import java.util.HashMap;

public class NamedTasks extends Tasks {
    
    private String[] names;
    private int length = names.length;
    private HashMap numbers = new HashMap(names.length);
    
    public NamedTasks(String[] names) {
        super(names.length);
        names = new String[length];
        
        // assigns the values to the HashMaps keys
        for (int i = 0; i < names.length; i++) {
            numbers.put(i, names[i]);
        }
    }
    
    public boolean dependsOn(String task1, String task2) {
        return true;
    }
    
    public String[] nameOrder() {
        boolean[][] dependencies = new boolean[length][length];
        int[] reservedTasks = new int[length];
        int k = 0;
        
        //fills the matrix with the dependency values
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                dependencies[i][j] = dependsOn(names[i], names[j]);
            }
        }
        return null;
    }
}
