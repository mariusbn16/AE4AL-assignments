import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class wordinfo {
    String word;
    int count;
    public wordinfo(String word, int count){
        this.word = word;
        this.count = count;
    }
    public String toString(){
        return word + " : " + count + "\n";
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.err.println("Usage: java Main <file>");
            System.exit(1);
        }
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream(new File(args[0])));
            input.useDelimiter("\\W");
            MyArrayList<wordinfo> words = new MyArrayList<wordinfo>();
            long startTime = System.currentTimeMillis();
            while (input.hasNext()){
                String word = input.next().toLowerCase();
                boolean found = false;
                for (int i = 0; i < words.size(); i++){
                    wordinfo w = words.get(i);
                    if (w.word.equals(word)){
                        w.count++;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    words.add(new wordinfo(word, 1));
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
