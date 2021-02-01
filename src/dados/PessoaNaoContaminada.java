package dados;

public class PessoaNaoContaminada extends Pessoa {

	private Integer idade;
	
	public PessoaNaoContaminada(StringBuilder nomeCompleto, char genero, int id, int idade) {
		super(nomeCompleto, genero, id);
		this.idade = idade;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Object[] devolveDadosPessoa() {
		return new Object[] {getId(), getNomeCompleto().toString().toUpperCase(), colocaPorExtenso(getGenero(), 'G'), getIdade(), "NAO CONTAMINADA"};
	}
	
}
