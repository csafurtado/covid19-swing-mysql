package visao;

import javax.swing.JOptionPane;

public class Mensagem {

	public static void mostraMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	public static void mostraMensagemErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void mostraMensagemAtencao(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
	}
	
	public static void mostraMensagemComDados(String dados, String titulo) {
		JOptionPane.showMessageDialog(null, dados, titulo, -1);
	}

}
