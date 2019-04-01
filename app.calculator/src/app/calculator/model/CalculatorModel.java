package app.calculator.model;

public class CalculatorModel {

	private double result;

	public void add(double value) {
		result += value;
	}

	public void sub(double value) {
		result -= value;
	}

	public void mul(double value) {
		result *= value;
	}

	public void div(double value) {
		result /= value;
	}

	public double getResult() {
		return result;
	}

	public void reset() {
		result = 0;
	}

}
