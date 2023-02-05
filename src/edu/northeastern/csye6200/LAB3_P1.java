package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P1 {
	public static void main(String[] args) {
		System.out.print(" Enter a credit card number as a long integer: ");
		Scanner input = new Scanner(System.in);
		long number = input.nextLong();
		if(isValid(number)) {
			System.out.println(number+" is valid");
		}else {
			System.out.println(number+" is invalid");
		}
		
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		if(getSize(number)<13 || getSize(number)>16) return false;
		if(prefixMatched(getPrefix(number, 1), 4) || prefixMatched(getPrefix(number, 1), 5) ||
			prefixMatched(getPrefix(number, 1), 6) || prefixMatched(getPrefix(number, 2), 37)) {
			int k = sumOfDoubleEvenPlace(number)+sumOfOddPlace(number);
			if(k%10==0) return true;
		}
		return false;
	}
	
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		long n=number;
		int i=0,sum=0;
		
		while(n>0) {
			if(i%2!=0) {
				sum+=getDigit((int)(n%10));
			}
			i++;
			n=n/10;
		}
		
		return sum;
		
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number) {

		number=number*2;
		if(number<10) return number;
		else return number%10+1;

	}

	/** Return sum of odd place digits in number */
	public static int sumOfOddPlace(long number) {
		long n=number;
		int i=0,sum=0;
		
		while(n>0) {
			if(i%2==0) {
				sum+=n%10;
			}
			i++;
			n=n/10;
		}
		
		return sum;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		if(number==(long)d) return true;
		return false;
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		int l=0; //String.valueOf(d).length();
		while(d>9) {
			d=d/10;
			l++;
		}
		return l;
	}

	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k) {
		// TODO: write your code here
		long n=number;
		while(String.valueOf(n).length()>k) {
			n=n/10;
		}
		return n;
	}
	

}
