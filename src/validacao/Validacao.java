package validacao;

import visao.Mensagem;

public class Validacao {	
	
	public static boolean isNomeCompletoValido(String nomeCompleto, int tipoValidacao) {
		if(tipoValidacao == 0) {
			if(nomeCompleto.length() <= 3) {
				Mensagem.mostraMensagemAtencao("Nome precisa ter mais que 3 caracteres", "Atencao");
				return false;
			}
		}
		else {
			if(nomeCompleto.length() == 0) {
				Mensagem.mostraMensagemAtencao("Campo está vazio!", "Atencao");
				return false;
			}
		}
		
		if(nomeCompleto.length() > 65) {
			Mensagem.mostraMensagemAtencao("Nome não pode ter mais que 65 caracteres", "Atencao");
			return false;
		}
		
		if(isNumeros(nomeCompleto)) {
			Mensagem.mostraMensagemErro("O campo de nome não pode possuir numeros", "Erro");
			return false;
		}
		
		
		return true;
	}
	
	public static boolean isIdadeValido(String idadeDigitada) {
		final int MAXIMO = 130;
		
		if(idadeDigitada.isEmpty()) {
			Mensagem.mostraMensagemErro("Campo da idade está vazio", "Erro");
			return false;
		}
		
		try {
			int idade = Integer.parseInt(idadeDigitada);
			
			if(idade > MAXIMO || idade < 0) {
				Mensagem.mostraMensagemAtencao("Numero nao pode ser maior que " + MAXIMO + " ou menor que 0", "Atencao");
				return false;
			}
			
			
		} catch (NumberFormatException e) {
			Mensagem.mostraMensagemErro("Idade nao pode possuir letras ou outros caracteres", "Erro");
			return false;
		}

		return true;
	}
	
	
	private static boolean isNumeros(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			if (Character.isDigit(texto.charAt(i)))
				return true;
		}
		return false;
	}

	public static boolean isIdValido(String id) {
		int idNumero; 
		final int MININO = 1;
		
		try {
			idNumero = Integer.parseInt(id);
			
			if(idNumero < MININO) {
				Mensagem.mostraMensagemAtencao("ID nao pode estar abaixo de " + MININO, "ID invalido");
				return false;
			}
			
		}
		catch(NumberFormatException e) {
			Mensagem.mostraMensagemErro("ID nao pode possuir letras", "ID invalido");
			return false;
		}
		
		return true;
	}
	
}
