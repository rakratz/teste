package br.edu.ipog;

public class Calculadora {
	
    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		// Testes Manuais do Método Somar   
		System.out.println("2 + 3 = 5  Teste " + (calc.somar(2, 3) == 5));
		System.out.println("4 + 3 = 7  Teste " + (calc.somar(4, 3) == 7));
		System.out.println("5 + 5 = 10 Teste " + (calc.somar(5, 5) == 10));
		
		// Testes Manuais do Método Subtrair  
		System.out.println("2 - 3 = -1 Teste " + (calc.subtrair(2, 3) == -1));
		System.out.println("4 - 3 = 1  Teste " +(calc.subtrair(4, 3) == 1));
		System.out.println("5 - 5 = 0  Teste " +(calc.subtrair(5, 5) == 0));
	}

}


