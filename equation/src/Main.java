import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("A * B = DEF = GH * I Solver");
        int count = 0;

        for (int a = 1; a <= 9; a++){
            for (int bc = 10; bc <= 98; bc++) {
                int def = a * bc;
                if(def>99 && def < 1000){
                    for (int i = 1; i <= 9; i++){
                        int gh = def / i;
                        if (def % i == 0 && gh <= 98 && gh >= 10) {
                            String combined = "" + a + bc + def + gh + i;
                            if(verification(combined)){
                                String format = a + " * " + bc + " = " + def + " = " + gh + " * " + i;
                                System.out.println(format);
                                count++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static boolean verification(String s){
        if (s.length() != 9) return false;

        // I'm using a HashSet because it can not contain duplicate. So, if the size of my
        // HashSet is 9, it means that all the digits from 1 to 9 had been used only one time
        Set<Character> digits = new HashSet<>();
        for(char c : s.toCharArray()){
            if(c == '0') return false;
            digits.add(c);
        }
        return digits.size() == 9;
    }
}
