import java.util.*;

class Main {
    public static void main(String[] args) {
        int T;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int n;
        while (T-- > 0) {
            n = sc.nextInt();
            double res = 0.0;
            for (int i = 1; i <= n; i++) {
                res += 1.0 / i;
            }
            System.out.printf("%.4f\n", res);
        }
    }
}