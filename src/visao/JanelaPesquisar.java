package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexaoBD.PessoaDAO;
import dados.Pessoa;
import validacao.Validacao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class JanelaPesquisar extends JFrame {

	private JPanel contentPane;
	private JTextField campoTexto_NomePesquisa;
	private JLabel label_QtdPessoasEncontradas;
	private JLabel label_ResultadoQtdPessoasEncontradas ;

	public JanelaPesquisar(JTable tabelaDados) {
		setTitle("Pesquisa de Pessoas Cadastradas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 788, 434);
		contentPane.add(scrollPane);
		
		campoTexto_NomePesquisa = new JTextField();
		campoTexto_NomePesquisa.setBounds(181, 22, 146, 20);
		contentPane.add(campoTexto_NomePesquisa);
		campoTexto_NomePesquisa.setColumns(10);
		
		JLabel label_PesquisarNome = new JLabel("Nome para Pesquisa:");
		label_PesquisarNome.setBounds(30, 25, 141, 14);
		contentPane.add(label_PesquisarNome);
		
		label_QtdPessoasEncontradas = new JLabel("Quantidade de pessoas encontradas:");
		label_QtdPessoasEncontradas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_QtdPessoasEncontradas.setBounds(488, 513, 234, 14);
		contentPane.add(label_QtdPessoasEncontradas);
		label_QtdPessoasEncontradas.setVisible(false);
		
		label_ResultadoQtdPessoasEncontradas = new JLabel("New label");
		label_ResultadoQtdPessoasEncontradas.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_ResultadoQtdPessoasEncontradas.setBounds(732, 513, 46, 14);
		contentPane.add(label_ResultadoQtdPessoasEncontradas);
		label_ResultadoQtdPessoasEncontradas.setVisible(false);

		tabelaDados = new JTable();
		scrollPane.setViewportView(tabelaDados);
		
		DefaultTableModel modelo = (DefaultTableModel) tabelaDados.getModel();
		construirTabela(modelo,tabelaDados);
		
		
		JButton botao_Pesquisar = new JButton("Pesquisar");
		botao_Pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				preencheTabela(modelo);				
			}
		});
		botao_Pesquisar.setBounds(562, 21, 97, 23);
		contentPane.add(botao_Pesquisar);
		
		JButton botao_LimparTabela = new JButton("Limpar");
		botao_LimparTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.setNumRows(0);
				label_QtdPessoasEncontradas.setVisible(false);
				label_ResultadoQtdPessoasEncontradas.setVisible(false);
				campoTexto_NomePesquisa.setText("");
			}
		});
		botao_LimparTabela.setBounds(681, 21, 97, 23);
		contentPane.add(botao_LimparTabela);
		
	}
	
	
	private void construirTabela(DefaultTableModel modelo, JTable tabelaDados) {
		modelo.addColumn("ID");
		modelo.addColumn("Nome Completo");
		modelo.addColumn("Genero");
		modelo.addColumn("Idade");
		modelo.addColumn("Situacao de Saude");
		tabelaDados.getColumnModel().getColumn(0).setPreferredWidth(20);
		tabelaDados.getColumnModel().getColumn(1).setWidth(100);
	}
	
	@SuppressWarnings("unchecked")
	private void preencheTabela(DefaultTableModel modelo) {
		String nomePesquisa = campoTexto_NomePesquisa.getText().trim().toUpperCase();

		modelo.setNumRows(0);
		
		if(Validacao.isNomeCompletoValido(nomePesquisa, 1)) {	// Validaçao para a entrada de nome em pesquisa
			ArrayList<Pessoa> pessoasEncontradas = new ArrayList<Pessoa>();
			
			for(Pessoa pessoa : new PessoaDAO().recuperaGrupoSalvo().getPessoas()) {
				if(pessoa.getNomeCompleto().toString().toUpperCase().contains(nomePesquisa))
					pessoasEncontradas.add(pessoa);
			}
			
			Collections.sort(pessoasEncontradas);
			
			for(Pessoa pessoa1 : pessoasEncontradas) 
				modelo.addRow(pessoa1.devolveDadosPessoa());			
				
				label_QtdPessoasEncontradas.setVisible(true);
				label_ResultadoQtdPessoasEncontradas.setVisible(true);
				label_ResultadoQtdPessoasEncontradas.setText(Integer.toString(pessoasEncontradas.size()));

				if(modelo.getRowCount() == 0) {
					Mensagem.mostraMensagemAtencao("Nao foram encontrados cadastros com esse nome!", "Cadastro nao encontrado");
				}
			}
		
		}
		
	
}
