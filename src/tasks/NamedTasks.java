package tasks;

//import java.util.HashMap;

public class NamedTasks extends Tasks {
    
    private String[] names;

    public NamedTasks(String[] names) {
        super(names.length);
        this.names = names;

    }
    
    //checks whether task1 depends on task2
    public boolean dependsOn(String task1, String task2) {
        int task1Index=-1, task2Index=-1;

        //finds the indices of the corresponding tasks in the names array
        for (int i = 0; i < names.length; i++) {
            if(names[i].equals(task1)) {
                task1Index=i;
            }if(names[i].equals(task2)) {
                task2Index=i;
            }
        }
        if(task1Index<0 || task2Index<0)
            return false;
        
        super.dependsOn(task1Index,task2Index);
        return true;
    }
    
    //fills the names tasks array in an order following the given dependencies
    public String[] nameOrder() {
        int[] numberedOrder = new int[names.length];
        String[] orderedArray = new String[names.length];

        numberedOrder = super.order();

        if(numberedOrder==null) {
            return null;
        }
        //matches the tasks name to the corresponding order provided by the order method
        for (int i = 0; i < names.length; i++) {
            orderedArray[i] = names[numberedOrder[i]];
        }
        return orderedArray;
    }
}
