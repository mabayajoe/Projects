package week01;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Lab1i {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean userInputComplete = false;
		String input;

		ArrayList<Integer> numbers = new ArrayList<>();
		int num;
		int largest;

		System.out.println("In this program, you will enter a list of numbers.\n");

		while (!userInputComplete) {
			System.out.print("Please enter a number (or press 'Enter' key to stop): ");
			input = in.nextLine();

			try {
				if (input.equals("")) {
					userInputComplete = true;
				} else {
					num = Integer.parseInt(input);
					numbers.add(num);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid response. '" + input + "' is not a number");
				System.out.println();
			}
		}

		in.close(); // Close the Scanner object

		// Sorting Array
		Collections.sort(numbers);

		int total = addNumbers(numbers);
		System.out.println("The sum of the list of numbers you entered is: " + total);

		largest = largestNumber(numbers);
		System.out.println("The largest number in the list is: " + largest);
	}

	// Create a method to sum up
	public static int addNumbers(ArrayList<Integer> numList) {
		int sum = 0;
		System.out.println("numList size is: " + numList.size());

		int i = 0;
		while (i < numList.size()) {
			int number = numList.get(i);
			sum += number;
			i++;
		}
		return sum;
	}

	// Largest number method
	public static int largestNumber(ArrayList<Integer> numList) {
		int largestNum = Integer.MIN_VALUE;

		int i = 0;
		while (i < numList.size()) {
			if (numList.get(i) > largestNum) {
				largestNum = numList.get(i);
			}
			i++;
		}
		return largestNum;
	}
}
