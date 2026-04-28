package fitconnect;

public class validadorCpf {
	
	public static boolean validarCpf(String cpf) {
	    if(cpf.length() != 11) {
	        return false;
	    }
	    
	    int soma = 0;
	    
	    for(int i = 0; i < 9; i++) {
	        int numero = cpf.charAt(i) - '0';
	        int peso = 10 - i;
	        soma += numero * peso;
	    }
	    
	    int resto = soma % 11;
	    int primeiroDigito = 11 - resto;
	    
	    if (primeiroDigito >= 10) {
	        primeiroDigito = 0;
	    }
	    
	    String cpf2 = cpf.substring(0, 9) + primeiroDigito;
	    
	    soma = 0;
	    
	    for(int i = 0; i < 10; i++) {
	    		int numero = cpf.charAt(i) - 0;
	    		int peso = 10 - i;
	    		soma += numero * peso;
	    }
	    
	    resto = soma % 11;
	    int segundoDigito = 11 - resto;
	    
	    if (segundoDigito >= 10) {
	    		segundoDigito = 0;
	    }
	    
	    /*Vai pegar os dois últimos dígitos do CPF e transforma-los em String. Caso o cálculo seja igual aos dígitos digitados, o CPF é válido(True), senão for, será inválido(False)!*/
	    String digitosOriginais = cpf.substring(9, 11);
	    String digitosCalculados = "" + primeiroDigito + segundoDigito;

	    return digitosOriginais.equals(digitosCalculados);
	}
}
