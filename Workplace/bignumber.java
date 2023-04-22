import java.util.Scanner;
import java.math.BigInteger;

public class bignumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		BigInteger bigint1 = new BigInteger(str1);
		BigInteger bigint2 = new BigInteger(str2);
		System.out.println(bigint1 + "+" + bigint2 + "=" + bigint1.add(bigint2));
		System.out.println(bigint1 + "-" + bigint2 + "=" + bigint1.subtract(bigint2));
		System.out.println(bigint1 + "*" + bigint2 + "=" + bigint1.multiply(bigint2));
		System.out.println(bigint1 + "/" + bigint2 + "=" + bigint1.divide(bigint2));

		BigInteger result[] = bigint1.divideAndRemainder(bigint2);
		System.out.println(bigint1 + "/" + bigint2 + "=" + result[0]);
		System.out.println(bigint1 + "%" + bigint2 + "=" + result[1]);

		System.out.println("max(" + bigint1 + "," + bigint2 + ")=" + bigint1.max(bigint2));
		System.out.println("min(" + bigint1 + "," + bigint2 + ")=" + bigint1.min(bigint2));
	}
}