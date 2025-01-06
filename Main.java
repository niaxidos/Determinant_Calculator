import java.util.Scanner;

/**
 * Main class that calculates the determinant of a square matrix by first
 * putting it into its upper triangular form and then calculating the product of
 * its diagonal entries.
 */

public class Main {

	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);
		int numRows;
		int numCols;

		System.out.println("Hello, welcome to my Determinant calculator.\n");
		System.out.print("Please enter the number of rows in your matrix as a positive integer: ");

		while (true) {
			numRows = key.nextInt();
			if (numRows <= 0) {
				System.out.println();
				System.out.print("ERROR: Please enter a positive integer. Try again: ");

			}

			else {
				break;
			}
		}

		System.out.print(
				"\nPlease enter the number of columns in your matrix as a positive integer. \nTo have a determinant, the number of rows and columns must be equal (a square matrix): ");

		while (true) {
			numCols = key.nextInt();

			if (numCols <= 0 || numCols != numRows) {
				System.out.println();
				System.out.print("ERROR: Please enter a positive integer equal to the number of rows. Try again: ");

			}

			else {
				break;
			}

		}

		double[][] matrix = new double[numRows][numCols];

		System.out.println();
		System.out.println("Enter matrix elements in row-major order.");

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {

				matrix[i][j] = key.nextDouble();

			}

		}

		System.out.println("\nThis is your matrix:");
		for (double[] row : matrix) {
			for (double element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}

		System.out.println();

		double[][] result = upperTriangular(matrix);

		System.out.println("Upper Triangular Form:");
		for (double[] row : result) {
			for (double element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("The determinant is " + calculateDet(result) + ".");

		key.close();
	}

	/**
	 * Converts a square matrix into its upper triangular form and returns it
	 * 
	 * @param arr The matrix to be transformed.
	 * @return The upper triangular form of the matrix.
	 */
	public static double[][] upperTriangular(double[][] arr) {

		double[][] result = arr;
		double factor;

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				// Calculate the factor
				factor = result[j][i] / result[i][i];

				for (int k = 0; k < arr.length; k++) {

					// Eliminate elements below the pivot element
					result[j][k] -= (result[i][k] * factor);

				}

			}
		}

		return result;
	}

	/**
	 * Calculates the determinant of a given matrix when its in upper triangular
	 * form.
	 * 
	 * @param The given matrix.
	 * @return The determinant of that matrix.
	 */
	public static double calculateDet(double[][] arr) {

		double result = 1;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {

				if (i == j) {
					// multiply the diagonal elements
					result *= arr[i][j];
				}
			}

		}

		return Math.round(result);

	}

}
