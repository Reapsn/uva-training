import java.util.Scanner;

/**
 * Created by Reapsn on 2017/2/21.
 */
public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int case_count = scanner.nextInt();

		for (int i = 0; i < case_count; ) {

			int linear_element_count = scanner.nextInt();

			int max_sub_sum_linear = Integer.MIN_VALUE;

			int thisSum = 0;

			int begin = 0;
			int end = 0;
			int temp_begin = 0;

			for (int j = 1; j < linear_element_count; j++) {

				thisSum = thisSum + scanner.nextInt();

				if (thisSum < 0) {
					temp_begin = j;

					thisSum = 0;
				} else if (thisSum > max_sub_sum_linear
						|| (thisSum == max_sub_sum_linear && j - temp_begin > end - begin)) {
					begin = temp_begin;
					end = j;

					max_sub_sum_linear = thisSum;
				}
			}

			if (max_sub_sum_linear > 0) {
				System.out.println(String.format("The nicest part of route %d is between stops %d and %d", ++i, begin + 1, end + 1));
			} else {
				System.out.println(String.format("Route %d has no nice parts", ++i));
			}

		}
	}

}
