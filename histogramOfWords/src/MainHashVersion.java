import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class wordinfoHash {
    String word;
    int count;
    public wordinfoHash(String word, int count){
        this.word = word;
        this.count = count;
    }
    public String toString(){
        return word + " : " + count + "\n";
    }
    int hashCode(String word){
        return word.hashCode();
    }
    boolean equals(String word){
        return word.equals(this.word);
    }
}

public class MainHashVersion {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Usage: java Main <file>");
            System.exit(1);
        }
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream(new File(args[0])));
            input.useDelimiter("\\W");

            //HashMap<String, Integer> words = new HashMap<>();
            MyHashTable words = new MyHashTable(10000);

            long startTime = System.currentTimeMillis();
            while (input.hasNext()){
                String word = input.next().toLowerCase();
                Integer occurences = words.get(word);

                if(occurences == null){
                    words.put(word, 1);
                } else {
                    words.put(word, 0);
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println(words);
            System.out.println("Time taken: " + (endTime-startTime)/1000.0 + " seconds");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + args[0]);
        }

    }
}
