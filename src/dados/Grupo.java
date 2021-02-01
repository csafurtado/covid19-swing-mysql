package dados;

import java.util.ArrayList;

public class Grupo {

	private ArrayList<Pessoa> pessoas;

	public Grupo() {
		this.pessoas = new ArrayList<Pessoa>();
	}
	
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
