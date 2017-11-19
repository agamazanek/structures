import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println(encode("abcSSSSSED", 100));
        System.out.println(decode("pabBBBBBNM", 100));
        System.out.println();
        Stack stack = new LinkedStack();
        stack.





        String[] tab = new String[]{"Ala"};

        String result = concat(tab, " ");

        if ("Ala".equals(result)) {
            System.out.println("OK");
        } else {
            System.out.println("Error");
            System.out.println("Ala ma kota");
            System.out.println(result);
        }

        Random random = new Random();

        int size = 10000;

        int[] tab0 = new int[size];
        int[] tab1 = new int[size];

        for (int i = 0; i < tab0.length; ++i) {
            tab0[i] = random.nextInt(100);
        }

        long now = System.nanoTime();
        for (int i = 0; i < tab0.length; ++i) {
            tab1[i] = tab0[i];
        }
        System.out.println(System.nanoTime() - now);

        for (int i = 0; i < tab0.length; ++i) {
            tab0[i] = random.nextInt(100);
        }

        now = System.nanoTime();
        System.arraycopy(tab0, 0, tab1, 0, tab0.length);
        System.out.println(System.nanoTime() - now);


        //Random random = new Random();

        List numbers = new ArrayList();

        for (int i = 0; i < 10; ++i) {
            numbers.add(random.nextInt(100) / 10.0);
        }

        numbers.remove(9);
        System.out.println(numbers);
    }

    public static String concat(String[] tab, String delimiter) {
        if (tab == null || tab.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder(tab[0]);
        for (int i = 1; i < tab.length; ++i) {
            result.append(delimiter).append(tab[i]);
        }

        return result.toString();
    }

    //////////////////////////szyfrowanie///////////////////////////
    private static int ALPHATHET_SIZE = 'z' - 'a' + 1;

    public static String encode(String text, int number) {
        if(number < 0) {
            throw new IllegalArgumentException("number < 0");
        }
        char[] chars = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            char c = chars[i];
            char a;

            // if( c >= 'a' && c <= 'z')
            if (Character.isLowerCase(c)) {
                a = 'a';
            } else if (Character.isUpperCase(c)) {
                a = 'A';
            } else {
                continue;
            }

            c -= 'a';
            c -= number;

            c %= ALPHATHET_SIZE;
            //System.out.println((int)c);

            c += a;


            chars[i] = c;
        }

        return String.valueOf(chars);
    }

///////////////////////odszyfrowanie///////////////////////



    public static String decode(String text, int number) {
        if(number < 0) {
            throw new IllegalArgumentException("number < 0");
        }
        char[] chars = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            char c = chars[i];
            char a;

            // if( c >= 'a' && c <= 'z')
            if (Character.isLowerCase(c)) {
                a = 'a';
            } else if (Character.isUpperCase(c)) {
                a = 'A';
            } else {
                continue;
            }

            c -= 'a';

//            c+= ALPHATHET_SIZE;
//            c-= number % ALPHATHET_SIZE;
            c += ALPHATHET_SIZE * (number / ALPHATHET_SIZE +1);
            c += number;

            c %= ALPHATHET_SIZE;

            //System.out.println((int)c);

            c += a;


            chars[i] = c;
        }

        return String.valueOf(chars);
    }

//maven - narzedzie do budowania programow, okresla liste zaleznosci
    // https://mvnrepository.com/
}
