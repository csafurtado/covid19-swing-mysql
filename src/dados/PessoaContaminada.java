package dados;

public class PessoaContaminada extends Pessoa {

	private Character situacaoSaude;
	
	public PessoaContaminada(StringBuilder nomeCompleto, char genero, int id, char situacaoSaude) {
		super(nomeCompleto, genero, id);
		this.situacaoSaude = situacaoSaude;
	}

	public Character getSituacaoSaude() {
		return situacaoSaude;
	}

	public void setSituacaoSaude(char situacaoSaude) {
		this.situacaoSaude = situacaoSaude;
	}
	
	public Object[] devolveDadosPessoa() {
		return new Object[] {getId(), getNomeCompleto().toString().toUpperCase(), colocaPorExtenso(getGenero(), 'G'), "-", colocaPorExtenso(getSituacaoSaude(), 'S')};
	}
}
