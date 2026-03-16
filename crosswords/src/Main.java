import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Crosswords generator");
        String solution = (args.length > 0) ? args[0] : "lipa";
        List<String[]> dictionary = new ArrayList<>();
        List<String[]> finalWords = new ArrayList<>();
        Random random = new Random();

        try (Scanner scanner = new Scanner(new FileInputStream("words.txt"))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                if (!line.isEmpty()){
                    dictionary.add(line.split(";"));
                }
            }
            System.out.println("Dictionary loaded successfully...");

            for(char c : solution.toLowerCase().toCharArray()){
                List<String[]> matchingWords = new ArrayList<>();
                for (String[] entry : dictionary){
                    String[] wordAndDescription = new String[2];
                    wordAndDescription[0] = entry[0].toLowerCase();
                    wordAndDescription[1] = entry[1];
                    if (wordAndDescription[0].indexOf(c) != -1){
                        matchingWords.add(wordAndDescription);
                    }
                }
                if(!matchingWords.isEmpty()){
                    String[] chosenWord = matchingWords.get(random.nextInt(matchingWords.size()));
                    String[] pair = new String[3];
                    pair[0] = chosenWord[0];
                    pair[1] = String.valueOf(chosenWord[0].toLowerCase().indexOf(c));
                    pair[2] = chosenWord[1];
                    finalWords.add(pair);
                    System.out.println("Matching word for letter " + c + " : " + pair[0] + ", index = " + pair[1]);
                }
                else {
                    System.out.println("No matching words for letter : " + c);
                }
            }
            int higherIndex = 0;
            for(String[] word : finalWords){
                int i = Integer.parseInt(word[1]);
                if (i > higherIndex) higherIndex = i;
            }

            System.out.println("Final solution :");
            for (String[] word : finalWords){
                int i = Integer.parseInt(word[1]);
                int leftSpace = higherIndex - i;
                for(int j = 0; j < leftSpace; j++){
                    System.out.print(" ");
                }
                for (int k = 0; k < word[0].length(); k++){
                    char c = word[0].charAt(k);
                    if (k == i){
                        System.out.print("|" + c + "|");
                    } else {
                        System.out.print(c);
                    }
                }
                System.out.println();
            }

            System.out.println("Final form with description :");

            for (String[] word : finalWords){
                int i = Integer.parseInt(word[1]);
                int leftSpace = higherIndex - i;
                for(int j = 0; j < leftSpace; j++){
                    System.out.print(" ");
                }
                for (int k = 0; k < word[0].length(); k++){
                    if (k == i){
                        System.out.print("|" + "." + "|");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.print(word[2]);
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error : file 'word.txt' not found");
        }

    }
}
