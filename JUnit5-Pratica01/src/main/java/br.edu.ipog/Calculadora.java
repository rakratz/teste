package br.edu.ipog;

public class Calculadora {
	
	public int soma(int n1, int n2) {
		return n1 + n2;
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		System.out.println(calc.soma(2, 3) == 5);
		System.out.println(calc.soma(4, 3) == 7);
		System.out.println(calc.soma(5, 5) == 8);
	}

}
