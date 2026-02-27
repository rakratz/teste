package model;

public class Calculadora {
	
	public Calculadora() {
	}
	
	public double somar(double a, double b) {
		return a + b;
	}
	
	public double subtrair(double a, double b) {
		return a - b;
	}
	
	public double multiplicar(double a, double b) {
		return a * b;
	}
	
	public double dividir(double a, double b) {
		if (b == 0 ) {
			throw new ArithmeticException("Divisão por Zero");
		}
		return a / b;
	}
}
