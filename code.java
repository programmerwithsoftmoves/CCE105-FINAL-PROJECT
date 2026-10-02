package code;

import java.util.Scanner;

public class code {

	public static int migratoryBirds(int[] arr) {

		int maxCount = 0;
		int result = 1;

		for (int type = 1; type <= 5; type++) {

			int count = 0;

			for (int i = 0; i < arr.length; i++) {

				if (arr[i] == type) {
					count++;
				}

			}

			if (count > maxCount) {

				maxCount = count;
				result = type;

			}
		}

		return result;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of bird sightings: ");
		int n = scanner.nextInt();

		if (n <= 0) {
			System.out.println("Please enter a number greater than 0.");
			scanner.close();
			return;
		}

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {

			while (true) {

				System.out.print("Enter Bird #" + (i + 1) + " (1-5): ");
				int bird = scanner.nextInt();

				if (bird >= 1 && bird <= 5) {

					arr[i] = bird;
					break;

				} 
				
				else {

					System.out.println("Invalid bird ID. Please enter a number from 1 to 5.");

				}
			}
		}

		long startTime = System.nanoTime();

		int answer = migratoryBirds(arr);

		long endTime = System.nanoTime();

		long runtime = endTime - startTime;

		System.out.println();
		System.out.println("===== RESULT =====");
		System.out.println("Most Frequent Bird Type: " + answer);
		System.out.println("Execution Time: " + runtime + " ns");

		scanner.close();
	}
}
