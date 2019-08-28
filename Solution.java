import java.util.*;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {

		int[] A = { 1, 3, 4, 2, 6, 1 };
		int[] B = { 1, 2, 3 };
		int[] C = { -1, -3 };
		int[] D = { -2, 3, 1, -1, 4 };

		System.out.println("Final Result : " + solution(A));
		System.out.println("Final Result : " + solution(B));
		System.out.println("Final Result : " + solution(C));
		System.out.println("Final Result : " + solution(D));

	}

	public static int solution(int[] A) {
		int finalResult = Result(A);
		return finalResult;
	}

	public static int Result(int A[]) {
		int smallest = Arrays.stream(A).min().getAsInt();
		// System.out.println("MIN:->" + smallest);
		int Largest = Arrays.stream(A).max().getAsInt();
		// System.out.println("Max:->" + Largest);
		int result;
		Boolean Flag = false;
		if (Largest < 0) {
			return 1;
		}
		for (int i = smallest; i <= Largest; i++) {
			if (i <= 0) {
				continue;
			}
			Flag = check(A, i);
			if (Flag == false && i != 0) {
				return i;
			}
		}

		return Largest + 1;
	}

	private static Boolean check(int[] arr, int toCheckValue) {
		boolean test = IntStream.of(arr).anyMatch(x -> x == toCheckValue);
		return test;
	}
}
