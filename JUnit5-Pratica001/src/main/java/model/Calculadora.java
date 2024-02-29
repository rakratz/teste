package model;

public class Calculadora {

	public Double somar(double num1, double num2) {
		return num1 + num2;
	}

	public Double subtrair(double num1, double num2) {
		return num1 - num2;
	}

	public Double dividir(double num1, double num2) {
		if (num2 == 0D) {
			throw new ArithmeticException("Não é possível dividir por zero");
		} else {
			return num1 / num2;
		}
	}
	
	public Double multiplicar(double num1, double num2) {
		return num1 * num2;
	}
}
