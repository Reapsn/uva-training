import java.util.Scanner;

/**
 * Created by Reapsn on 2017/2/19.
 */
public class Main {

	public static final int MAX_N = 100;

	public static final int MIN_C = -127;

	public static final int MAX_C = 127;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		// 矩阵的元数据
		int[][] c_data = new int[n + 1][n + 1];

		// 矩阵中每一行中每一项的前序和
		int[][] matrix_x_c_data = new int[n + 1][n + 1];

		int max_matric = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				c_data[i][j] = scanner.nextInt();

				matrix_x_c_data[i][j] = matrix_x_c_data[i][j - 1] + c_data[i][j];
			}
		}

		for (int i = 1; i <= n; i++) {

			for (int j = i; j <= n; j++) {

				// i，i+1，...，j-1，j 列当中，每一行的各项和
				int[] matric_xx_c_data = new int[n + 1];

				for (int k = 1; k <= n; k++) {
					matric_xx_c_data[k] = matrix_x_c_data[k][j] - matrix_x_c_data[k][i - 1];
				}

				int maxSubSumLinear = maxSubSumLinear(matric_xx_c_data);
				max_matric = Math.max(max_matric, maxSubSumLinear);
			}
		}
		System.out.println(max_matric);
	}

	public static int maxSubSumLinear(int[] array) {

		int maxSum = 0, thisSum = 0;

		// 排除第 0 项。 此处的 第 0 项 仅是边界，不是实际数据
		for (int j = 1; j < array.length; j++) {

			thisSum += array[j];

			if (thisSum < 0) {
				thisSum = 0;
			} else if (thisSum > maxSum) {
				maxSum = thisSum;
			}

		}

		return maxSum;

	}
}

