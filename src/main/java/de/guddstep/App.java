package de.guddstep;

import java.util.Scanner;


/**
 * App-Klasse enthaelt nur main-Funktion.
 * @author stephan
 */
public class App 
{
	
    /**
     * main-Funktion, Einstiegspunkt für das Programm.
     * @param args Kommandozeilen-Parameter für das Programm.
     */
    public static void main( String[] args )
    {
	Scanner scan = new Scanner(System.in);
	System.out.print("String eingeben: ");
	String input = scan.nextLine();
        System.out.println(input.toUpperCase());
    }
}
