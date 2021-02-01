package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexaoBD.PessoaDAO;
import dados.Pessoa;

import javax.swing.JTable;


@SuppressWarnings("serial")
public class JanelaListar extends JFrame {

	private JPanel contentPane;

	public JanelaListar(JTable tabelaDados) {
		setTitle("Lista de Pessoas Cadastradas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 788, 517);
		contentPane.add(scrollPane);

		tabelaDados = new JTable();
		scrollPane.setViewportView(tabelaDados);

		DefaultTableModel modelo = (DefaultTableModel) tabelaDados.getModel();
		formataTabela(modelo);
		populaTabela(modelo);
	}
	
	private void formataTabela(DefaultTableModel modelo) {
		modelo.addColumn("ID");
		modelo.addColumn("Nome Completo");
		modelo.addColumn("Genero");
		modelo.addColumn("Idade");
		modelo.addColumn("Situacao de Saude");
	}
	
	private void populaTabela(DefaultTableModel modelo) {
		for(Pessoa pessoa : new PessoaDAO().recuperaGrupoSalvo().getPessoas()) {
			modelo.addRow(pessoa.devolveDadosPessoa());
		}
	}
	
}
