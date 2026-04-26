package fitconnect;

public class Cliente {
	
	private String id;
	private String cpf;
	private String sexo;
	private 	String nome;
	private int idade;
	private String email;
	private String senha;
	private Double altura;
	private Double peso;


	public void cadastrar (){
		System.out.println("Usuario cadastrado com sucesso");
	}
	
	public void login (){
		System.out.println("Login realizado");
	}
	
	public void alterarInformacoes (){
		System.out.println("informação alterada com sucesso");
	}
	
}