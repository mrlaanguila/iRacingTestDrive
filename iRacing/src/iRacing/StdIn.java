package iRacing;

import java.util.Locale;
import java.util.Scanner;

public class StdIn {

	public static final Scanner in = new Scanner(System.in);
	{
		in.useLocale(Locale.US);
	}

	public static char readChar(String prompt) {
		System.out.println(prompt);
		String tmp = in.nextLine();
		char ch = tmp.charAt(0);
		return ch;
	}

	public static String readString(String prompt) {
		System.out.println(prompt);
		String tmp = in.nextLine();
		return tmp;
	}

	public static int readInt(String prompt) {
		System.out.println(prompt);
		int tmp = in.nextInt();
		in.nextLine();
		return tmp;
	}
}
