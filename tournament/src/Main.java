import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = null;
        if (args.length > 0){
            System.out.println("args[0]=" + args[0]);
            try {
                FileInputStream fis = new FileInputStream(args[0]);
                scan = new Scanner(fis);
            } catch (FileNotFoundException e) {
                // throw new RuntimeException(e);
                System.err.println("File not found: " + args[0]);
            }
        } else {
            System.out.println("No arguments given, using std input");
            scan = new Scanner(System.in);
        }

        System.out.println("Tournament schedule generator." +
                "Enter names, finished by CMD+D : ");


        String[] names = new String[100];
        int count = 0;
        while(scan.hasNext()){
            String name = scan.nextLine();
            if (count >= names.length){
                System.out.println("No more space, finishing input!");
                break;
            }
            if (name.length()<3) break;
            names[count++] = name;
        }

        int n = count;

        for(int i = 1; i <= n; i++){
            for (int j = i+1; j <= n ; j++) {
               System.out.printf("%d : %s, %d : %s\n", i, names[i-1], j, names[j-1]);
            }
        }
    }
}
