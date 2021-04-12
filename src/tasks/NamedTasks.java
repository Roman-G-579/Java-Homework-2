package tasks;

public class NamedTasks extends Tasks {
    
    private String[] names;
    private int length = names.length;
    private boolean[][] dependencies;
    
    public NamedTasks(String[] names) {
        super(names.length);
        names = new String[length];
    }
    
    public boolean dependsOn(String task1, String task2) {
        for (int i = 0; i < length; i++) {
        
        }
        for (int i = 0; i < length; i++) {
        
        }
        return false;
    }
    
    public String[] nameOrder() {
        
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
