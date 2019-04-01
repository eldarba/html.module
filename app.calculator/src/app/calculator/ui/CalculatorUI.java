package app.calculator.ui;

import java.util.Scanner;

import app.calculator.model.CalculatorModel;

public class CalculatorUI {

	// the UI object needs the MODEL object to do application logic
	private CalculatorModel calculatorModel = new CalculatorModel();
	// the UI object needs a way to interact with a user (IO)
	private Scanner sc = new Scanner(System.in);

	/** start interaction with user */
	public void startUp() {
		boolean quit = false;
		String userCommand;
		loop: while (!quit) {
			try {
				showMenu();
				userCommand = sc.nextLine();
				switch (userCommand) {
				case "+":
					System.out.print("enter value to add: ");
					double val = Double.parseDouble(sc.nextLine());
					calculatorModel.add(val); // USING THE MODEL
					System.out.println(val + " added");
					break;
				case "-":
					System.out.print("enter value to subtract: ");
					val = Double.parseDouble(sc.nextLine());
					calculatorModel.sub(val); // USING THE MODEL
					System.out.println(val + " subtracted");
					break;
				case "*":
					System.out.print("enter value to multiply: ");
					val = Double.parseDouble(sc.nextLine());
					calculatorModel.mul(val); // USING THE MODEL
					System.out.println("result multiplied by " + val);
					break;
				case "/":
					System.out.print("enter value to divide: ");
					val = Double.parseDouble(sc.nextLine());
					calculatorModel.div(val); // USING THE MODEL
					System.out.println("result divided by " + val);
					break;
				case "=":
					System.out.println("current result = " + calculatorModel.getResult());
					break;
				case "r":
					calculatorModel.reset(); // USING THE MODEL
					System.out.println("calculator result is reset");
					break;
				case "q":
					break loop;
				default:
					System.out.println(userCommand + " is not a known command");
					break;
				}
			} catch (Exception e) {
				// e.printStackTrace(System.out);
				System.out.println(e);
			}
		}

		shutDown();
	}

	/** close all system resources and do final actions before quit */
	private void shutDown() {
		sc.close();
		System.out.println("\nshutting down the calculator app...");
		System.out.println("scanner is closed");
		System.out.println("Bye!");
	}

	/** display system operations */
	private void showMenu() {
		System.out.println("\n\tcalculator menu");
		System.out.println("\tAdd ......... +");
		System.out.println("\tSubtract .... -");
		System.out.println("\tMultiply .... *");
		System.out.println("\tDivide ...... /");
		System.out.println("\tEquals ...... =");
		System.out.println("\tReset ....... r");
		System.out.println("\tQuit ........ q");
		System.out.print("\nEnter your command choice here: ");
	}

}
