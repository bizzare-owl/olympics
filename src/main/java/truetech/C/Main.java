package truetech.C;

public class Main {
    public static void main(String[] args) {
        System.out.println("X1 X2 X3 | Y");

        for (int x1 = 0; x1 <= 1; x1++) {
            for (int x2 = 0; x2 <= 1; x2++) {
                for (int x3 = 0; x3 <= 1; x3++) {
                    int y = (1 - x2) | (x1 & x3);

                    System.out.printf(
                            "%d  %d  %d  | %d%n",
                            x1, x2, x3, y
                    );
                }
            }
        }
    }
}
