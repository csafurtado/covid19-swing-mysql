package dados;

@SuppressWarnings("rawtypes")
public abstract class Pessoa implements Comparable {

	private StringBuilder nomeCompleto;
	private Character genero;
	private Integer id;
	
	public Pessoa(StringBuilder nomeCompleto, char genero, int id) {
		this.nomeCompleto = nomeCompleto;
		this.genero = genero;
		this.id = id;
	}

	public StringBuilder getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(StringBuilder nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Object[] devolveDadosPessoa() {
		return null;
	}
	
	protected String colocaPorExtenso(char letra, char tipo) {
		switch(letra) {
		case 'F':
			if(tipo == 'S')
				return "FALECIDA";
			else
				return "FEMININO";
		case 'M':
			return "MASCULINO";
		case 'C':
			return "CURADA";
		case 'E':
			return "EM TRATAMENTO";
		}
		
		return null;
	}
	
	public int compareTo(Object obj) {
		Pessoa pessoaParametro = (Pessoa) obj;
		return getNomeCompleto().toString().compareTo(pessoaParametro.getNomeCompleto().toString());
	}
	
}
