package visao;

import java.text.DecimalFormat;

public class VisaoConsole {
	
	public static void apresentaQtdCadaTipoPessoa(int[] qtdETipoDePessoas) {		
			DecimalFormat formato = new DecimalFormat("00");
			String espaco = "                    ";			
			
			System.out.println(espaco + formato.format(qtdETipoDePessoas[0]) + " = NAO CONTAMINADAS\n" +
					espaco + formato.format(qtdETipoDePessoas[1]) + " = CONTAMINADAS EM TRATAMENTO\n" +
					espaco + formato.format(qtdETipoDePessoas[2]) + " = CONTAMINADAS CURADAS\n" +
					espaco + formato.format(qtdETipoDePessoas[3]) + " = MULHERES CONTAMINADAS FALECIDAS\n" +
					espaco + formato.format(qtdETipoDePessoas[4]) + " = HOMENS CONTAMINADOS FALECIDOS");
					System.err.println(espaco + formato.format(qtdETipoDePessoas[5]) + " = TOTAL DE PESSOAS CADASTRADAS\n");
	}

}
