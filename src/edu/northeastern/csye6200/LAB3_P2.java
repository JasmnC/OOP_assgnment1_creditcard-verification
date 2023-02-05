package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of values: ");
		int length = input.nextInt();
		int[] array = new int[length];
		System.out.print("Enter the number: ");
		for(int i=0; i<length; i++) {
			array[i]=input.nextInt();
		}
		
		if(isConsecutiveFour(array)) {
			System.out.println("The list has consecutive fours.");
		}else {
			System.out.println("The list does not have consecutive fours.");
		}
	}

	public static boolean isConsecutiveFour(int[] values) {
		int count=0;
		for(int i=0; i<values.length-1; i++) {
			if(values[i]==values[i+1]) {
				count++;
				if(count>=3) return true;
			}else {
				count=0;
			}
			
		}
		return false;
	}

}

