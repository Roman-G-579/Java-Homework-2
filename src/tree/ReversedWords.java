package tree;

import java.util.Scanner;

public class ReversedWords {
    
    //returns the amount of word pairs which match their reversed counterparts
    public static int checkReversed() {
        Scanner s = new Scanner(System.in);
        Node newNode = new Node();
        int counter = 0;
        
        // splits the text into seperate items in an array
        String[] helpStr = s.nextLine().split(" ");
        String currentWord = helpStr[0];
        
        int i = 1;
        
        while (!currentWord.equals("X")) {
            newNode.add(currentWord);
            currentWord = helpStr[++i];
        }
        //if the amount of reversed words of the current word is greater than 0, adds 1 to the counter
        for (i = 0; i < helpStr.length - 1; i++) {
            String mainReversedWord = buildReversedWord((helpStr[i]));
            //checks wether the reversed word appeares in the tree
            if (!helpStr[i].equals(" ") && newNode.num(mainReversedWord) > 0) {
                //goes over the rest of the array
                for (int j = i + 1; j < helpStr.length - 1; j++) {
                    String currentReversedWord = buildReversedWord(helpStr[j]);
                    // if another instance of the reversed word is found,
                    // deletes it to prevent duplicate counting
                    // adds 1 to the counter
                    if (helpStr[i].equals(currentReversedWord)) {
                        helpStr[j] = " ";
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
    
    // builds a reversed word using the parameter
    private static String buildReversedWord(String str) {
        char[] reversedWord = new char[str.length()];
        for (int i = 0; i <= str.length() - 1; i++) {
            reversedWord[i] = str.charAt(str.length() - i - 1);
        }
        return new String(reversedWord); // converts the reveresed word to a string
    }
}