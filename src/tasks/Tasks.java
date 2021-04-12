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
    
    public boolean dependsOn(int task1, int task2) {
        if (task1 < 0 || task1 >= num || task2 < 0 || task2 >= num) {
            return false;
        }
        dependencies[task1][task2] = true;
        return true;
    }
    
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
                    column = 0;
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
        throw new IndexOutOfBoundsException("Dummy return");
    }
    
    // this method clears all of the chosen column dependencies
    private void clearRow(int column) {
        for (int i = 0; i < num - 1; i++) {
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

//int[] reservedTasks = new int[num];
//        Arrays.fill(reservedTasks, -1);
//        int k = 0;
//
//        for (int i = 0; i < num; i++) {
//
//            for (int j = 0; j < num; j++) {
//                //checks if the task has already been sorted
//                while (existsInArray(reservedTasks, i)) {
//                    i++;
//                }
//                //checks whether the current cell is dependant
//                //if it is, skips to the next row
//                if (i < num && dependencies[i][j]) {
//                    i++;
//                    if(i == num){
//
//                    }
//                    j = 0;
//                } else if (j == num - 1 && k < num) {
//                    reservedTasks[k] = tasks[i];
//                    k++;
//                    clearRow(dependencies, i);
//
//                    i = -1; // resets the dependencies check for the updated matrix
//                }
//            }
//        }
//        if (k == num) {
//            return reservedTasks;
//        }
//        return null;