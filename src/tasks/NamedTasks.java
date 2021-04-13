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
        if(!checkIfExists(task1,task2)){
            return false;
        }
        
    }
    
    private boolean checkIfExists(String task1, String task2) {
        boolean found1 = false, found2 = false;
        
        for (int i = 0; i < length; i++) {
            if (names[i].equals(task1)) {
                found1 = true;
            }
            if (names[i].equals(task2)) {
                found2 = true;
            }
        }
        return found1 && found2;
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
