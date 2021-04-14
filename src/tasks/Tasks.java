package tasks;

import java.util.Arrays;

public class Tasks {
    
    private boolean[][] dependencies;
    private int[] tasks;
    private int num;
    
    public Tasks(int num) {
        this.num = num;
        tasks = new int[num];
        Arrays.fill(tasks, -1);
        dependencies = new boolean[num][num];
    }
    
    //checks whether task1 depends on task2
    public boolean dependsOn(int task1, int task2) {
        if (task1 < 0 || task1 >= num || task2 < 0 || task2 >= num) {
            return false;
        }
        dependencies[task1][task2] = true;
        return true;
    }
    
    //fills the tasks array in an order following the given dependencies
    public int[] order() {
        int index = 0;
        
        for (int row = 0; row < num; row++) {
            for (int column = 0; column < num; column++) {
                while (existsInArray(row)) {
                    row++;
                    column = 0;
                }
                if (dependencies[row][column]) {
                    row++;
                    column = -1;
                }
                //checks if the current row is out of the matrix's bounds
                // , which means there's a dependency loop
                if (row == num) {
                    return null;
                }
            }
            tasks[index++] = row;
            clearRow(row);
            row = -1; // restarts the loop from the first row
            
            //checks whether the tasks array is full
            if (index == num) {
                return tasks;
            }
        }
        throw new IndexOutOfBoundsException("Out of bounds error");
    }
    
    // this method clears all of the chosen column dependencies
    private void clearRow(int column) {
        for (int i = 0; i < num; i++) {
            dependencies[i][column] = false;
        }
    }
    
    //checks whether the task already exists in the current array
    private boolean existsInArray(int task) {
        for (int i : tasks) {
            if (task == i) {
                return true;
            }
        }
        return false;
    }
}