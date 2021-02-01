package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexaoBD.PessoaDAO;
import dados.Pessoa;
import validacao.Validacao;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JanelaConsultar extends JFrame {

	private JPanel contentPane;
	private JTextField campoTexto_ID;

	public JanelaConsultar() {
		setTitle("Consultar Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JLabel label_DigiteIDPessoa = new JLabel("Digite o ID da Pessoa a ser consultada:");
		label_DigiteIDPessoa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_DigiteIDPessoa.setBounds(26, 11, 273, 30);
		contentPane.add(label_DigiteIDPessoa);

		JLabel lblId = new JLabel("ID:  ");
		lblId.setBounds(81, 90, 26, 14);
		contentPane.add(lblId);

		campoTexto_ID = new JTextField();
		campoTexto_ID.setBounds(117, 87, 86, 20);
		contentPane.add(campoTexto_ID);
		campoTexto_ID.setColumns(10);

		JButton botao_Consultar = new JButton("Consultar");
		botao_Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = campoTexto_ID.getText().trim();

				if (Validacao.isIdValido(id)) {
					Pessoa pessoaConsultada = new PessoaDAO().recuperaPessoaPorID(Integer.parseInt(id));
					mostraDadosPessoaConsultada(pessoaConsultada);
				}
			}
		});
		botao_Consultar.setBounds(204, 150, 89, 23);
		contentPane.add(botao_Consultar);
	}
	
	private void mostraDadosPessoaConsultada(Pessoa pessoaConsultada) {
		if(pessoaConsultada == null) {
			Mensagem.mostraMensagemAtencao("Nao foi encontrado uma Pessoa com esse id!", "Cadastro nao encontrado");
		}
		else {						//24%s
			Object[] dadosPessoaCadastrada = pessoaConsultada.devolveDadosPessoa();
			String dadosPessoaPorExtenso = "ID:     " + dadosPessoaCadastrada[0] + "\nNome Completo:     " + dadosPessoaCadastrada[1] + "\nGenero:     " + dadosPessoaCadastrada[2]
					+ "\nIdade:     " + dadosPessoaCadastrada[3] + "\nSituacao de Saude:     " + dadosPessoaCadastrada[4];			
			
			Mensagem.mostraMensagemComDados(dadosPessoaPorExtenso, "Cadastro encontrado");
			
		}
		
		
	}
}
