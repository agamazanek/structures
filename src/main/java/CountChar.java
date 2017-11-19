import java.util.Scanner;

public class CountChar {




//    public static void main(String[] args) {
//        System.out.println("Enter text:");
//        Scanner input = new Scanner (System.in);
//        String line = input.nextLine();
//
//        int counter = 0;
//        public static int countSmallA(String line){
//
//
//        for (int i = 0; i < line.length(); i++) {
//            char c = line.charAt(i);
//            if(line.charAt(i)== line.toCharArray(a)){
//                counter++;
//            }
//            return counter;
//        }
//
//    }

//    }

    public static String encode(String text, int number) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            char c = chars[i];

            c+= number;

            chars [c] = c;
        }

        return String.valueOf(chars);
    }


}
