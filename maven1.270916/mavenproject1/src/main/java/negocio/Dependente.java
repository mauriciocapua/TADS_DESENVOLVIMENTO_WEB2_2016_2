package negocio;

public class Dependente {

	private int id;
	private String nome;
	private int id_cliente;
	
	public Dependente (){
		
	}

	public Dependente(int id, String nome, int id_cliente) {
		this.id = id;
		this.nome = nome;
		this.id_cliente = id_cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

}
