package de.guddstep;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
	Scanner scan = new Scanner(System.in);
	System.out.print("String eingeben: ");
	String input = scan.nextLine();
        System.out.println(input.toUpperCase());
    }
}
