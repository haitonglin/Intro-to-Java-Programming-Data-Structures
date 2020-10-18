package app;
import edu.princeton.cs.introcs.*; 

public class PasswordChecker {
    public static void main(String[] args) throws Exception {
        while (true) {
            String a = StdIn.readLine();
            a = a.trim();
            boolean empty = a.isEmpty();
            if (empty) break;

            boolean length8 = a.length()>8;
            boolean hasuppercase = !a.equals(a.toLowerCase());
            boolean haslowercase = !a.equals(a.toUpperCase());

            boolean hasdigit = false;
            for (int i = 0; i < a.length(); i++){
                char ch = a.charAt(i);
                if (Character.isDigit(ch)) hasdigit = true;}

            boolean noduplicates = true;
            a = a.toLowerCase();
            for (int j = 0; j < a.length()-1; j++){
                    String b = a.substring(j, j+2);
                    String c = a.replace(b, "");
                    if (a.length()-c.length()!=2) noduplicates = false;}
            
            if (length8 && hasdigit && haslowercase && hasuppercase && noduplicates)
            System.out.println("OK");
            else System.out.println("NOT OK");                   
        }
    }
}