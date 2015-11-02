package com.gloomyproductions.roller;

import java.util.Random;
import java.util.Scanner; 


public class DiceRoller {
	
	// DIE TYPES
	public static final int D4 = 4;
	public static final int D6 = 6;
	public static final int D8 = 8;
	public static final int D10 = 10;
	public static final int D12 = 12;
	public static final int D20 = 20;
	public static final int D100 = 100;
	
	public static int numDice = 0, dieType = 0, die = 0;
	private static Scanner sc;
	
	
	public static void main(String[] args) {
		// Dice Rolling application
		
		int myRoll = 0;
		Scanner sc = new Scanner(System.in);
		char answer;
		boolean playAgain = false;
				
		do{
			// INPUT
			System.out.println("Dice Roller");
			System.out.println("-----------");
			System.out.println("");
			
			pickDice();
			
			System.out.println("Do you wish to roll " + numDice + "D" + die 
					+ "?");
			answer = sc.next().charAt(0);
			
			//Processing
			if(answer == 'y' || answer == 'Y'){
				myRoll = rollDie(numDice, die);
				
				// Output
				printRoll(myRoll, numDice, die);
				
			}else{
				System.out.println("Thank you!");
				playAgain = true;
			}
			
			System.out.println("Do you wish to roll again?");
			answer = sc.next().charAt(0);
			
			if(answer == 'Y' || answer == 'y'){
				playAgain = false;
				
			}else{
				System.out.println("Goodbye!");
				playAgain = true;
			}
			
		}while(!playAgain);
		
		sc.close();
	
	}
	
	public static int rollDie(int numDice, int die){
		int roll;
		int total = 0;
		Random rand = new Random();
		
		for(int i = 1; i < (numDice) + 1; i++){
			roll = (rand.nextInt((die)) + 1);
			System.out.println("Roll " + i + ": " + roll);
			total += roll;
			
		}
		
		return total;
	}
	
	public static void printRoll(int roll, int numDice, int die){
		System.out.println("\nThe result of rolling " + numDice + "D" + die +
				" is: " + roll);
	}
	
	public static void pickDice(){
		sc = new Scanner(System.in);
		
		System.out.println("Enter the number dice "
				+ "you would like to roll: ");
		numDice = sc.nextInt();
		System.out.println("You chose: " + numDice + " dice.");
		System.out.println("");
		
		System.out.println("Choose the die to roll: ");
		System.out.println("------------------------");
		System.out.println("1.) D4");
		System.out.println("2.) D6");
		System.out.println("3.) D8");
		System.out.println("4.) D10");
		System.out.println("5.) D12");
		System.out.println("6.) D20");
		System.out.println("7.) D100");
		System.out.println("");
		dieType = sc.nextInt();
		
		switch(dieType){
			case 1: die = D4;
			break;
			case 2: die = D6;
			break;
			case 3: die = D8;
			break;
			case 4: die = D10;
			break;
			case 5: die = D12;
			break;
			case 6: die = D20;
			break;
			case 7: die = D100;
			break;
			default: System.out.println("Invalid die type");
			break;
		}
		
		
			
	}
}
