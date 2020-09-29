import java.util.Scanner;
import java.util.Random;

public class ProgramFirst{
	public static void main(String[] args) {
		int[] array = new int[10];
		int[] changeArray = new int[array.length];
		int sum;

		addArray(array, true);

		System.out.print("Source array : ");
		display(array);
		sum = sumArray(array);
		System.out.println("Sum elements on array : " + sum);
		System.out.println("****");

		changeArray = reverseArray(array); // reverse Array
		System.out.print("Reverse array : ");
		display(changeArray);
		countAverageForArray(changeArray);

		System.out.print("Change min and max positin: ");
		changeElemOnArray(changeArray);
		display(changeArray);

		System.out.print("Use bubble sort : ");
		bubble_sort(changeArray);
		display(changeArray);
		System.out.println("****");
		System.out.println("Convert array to number : " + convertArrayNumber(changeArray));
		System.out.println("Convert : " + convertArrayNumber2(changeArray));
	}

	// This procedure add on array elements, if isRandom == true, add Random elements
	// from 1 to 12, else User add elemets yourself 
	public static void addArray(int[] a, boolean isRandom){
		if(!isRandom){
			System.out.println("Add elements on array : ");
			Scanner scn = new Scanner(System.in);

			for( int i = 0; i < a.length; i++){
				a[i] = scn.nextInt();
			}

		} else {
			Random rnd = new Random();
			for( int i = 0; i < a.length; i++){
				a[i] = rnd.nextInt(11) + 1;
			}
		}
	}

	// Count the sum of array elements
	public static int sumArray(int[] a){
		int sum = 0;
		for (int i : a) {
			sum += i;
		}

		return sum;
	}

	// This procedure reverse array and return new array
	public static int[] reverseArray(int[] a){
		int[] changeArray = new int[a.length];
		int flag = 0;

		for (int i = a.length - 1; i >= 0; i--){
			changeArray[flag] = a[i];
			flag++;
		}

		return changeArray;
	}

	// Count average in Array
	public static void countAverageForArray(int[] a){
		int sumOfArray = sumArray(a);
		System.out.println("Average is : " + sumOfArray / a.length);
	}

	// This procedure change position elements MIN and MAX
	public static void changeElemOnArray(int[] a){
		int max = a[0];
		int min = a[0];
		int indexMax = 0;
		int indexMin = 0;

		for (int i = 0; i < a.length; i++){
			if (max < a[i]){
				max = a[i];
				indexMax = i;
			}
			if (min > a[i]){
				min = a[i];
				indexMin = i;
			}
		}

		a[indexMin] = max;
		a[indexMax] = min;
	}

	// Bubble sort
	public static void bubble_sort(int[] a){
		int temp = 0;

		for (int i = 0; i < a.length; i++){
			for (int j = 1; j < a.length - i; j++){
				if (a[j] < a[j - 1]){
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	// This procedure determines the number of digits of the number
	// Возвращает количество разрядов в числе
	public static int digitOfNumber(int a){
		int count = 0;

		while (a != 0){
			a /= 10;
			count++;
		}
		return count;
	}

	// Convert array to number 
	// 1. Первое решение с типом возвращаемого значения long
    public static long convertArrayNumber(int[] a){
        long number = a[a.length - 1];
        long flag = 1;
        int count = digitOfNumber(a[a.length - 1]);

        for (int i = a.length - 2; i >= 0; i--){
            while ( count > 0){
                flag *= 10;
                count--;
            }

            number += a[i] * flag;
            count = digitOfNumber(a[i]);
        }

        return number;
    }

    // 2. Второе решение с типом возвращаемого значения String
    public static String convertArrayNumber2(int[] a){
    	String s = "";

    	for( int i = a.length - 1; i >= 0; i--){
    		s = a[i] + s;
    	}

    	return s;
    }

	// Display array elements
	public static void display(int[] a){
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}