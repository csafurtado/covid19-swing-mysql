package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexaoBD.PessoaDAO;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;
import validacao.Validacao;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

@SuppressWarnings("serial")
public class JanelaCadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NomeCompleto;
	private JTextField textField_Idade;
	private final ButtonGroup grupoBotao_Genero = new ButtonGroup();
	private final ButtonGroup grupoBotao_SituacaoSaude = new ButtonGroup();
	private JCheckBox checkBox_PessoaContamindada;

	public JanelaCadastrar() {
		setTitle("Cadastrar Pessoa");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		textField_NomeCompleto = new JTextField();
		textField_NomeCompleto.setBounds(33, 49, 165, 25);
		textField_NomeCompleto.setDisabledTextColor(Color.BLACK);
		textField_NomeCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		textField_NomeCompleto.setMaximumSize(new Dimension(40, 40));
		textField_NomeCompleto.setBackground(Color.WHITE);
		contentPane.add(textField_NomeCompleto);
		textField_NomeCompleto.setColumns(10);
		
		checkBox_PessoaContamindada = new JCheckBox("Pessoa Contaminada");
		
		JLabel label_NomeCompleto = new JLabel("Nome Completo:");
		label_NomeCompleto.setBounds(33, 24, 106, 14);
		contentPane.add(label_NomeCompleto);
		
		JRadioButton radioB_OpcaoFeminino = new JRadioButton("Feminino");
		grupoBotao_Genero.add(radioB_OpcaoFeminino);
		radioB_OpcaoFeminino.setBounds(33, 179, 89, 23);
		contentPane.add(radioB_OpcaoFeminino);
		
		JRadioButton radioB_OpcaoMasculino = new JRadioButton("Masculino");
		grupoBotao_Genero.add(radioB_OpcaoMasculino);
		radioB_OpcaoMasculino.setBounds(33, 205, 89, 23);
		contentPane.add(radioB_OpcaoMasculino);
		
		JLabel label_Sexo = new JLabel("Sexo:");
		label_Sexo.setBounds(33, 158, 46, 14);
		contentPane.add(label_Sexo);
		
		JLabel label_Idade = new JLabel("Idade:");
		label_Idade.setBounds(268, 24, 46, 14);
		contentPane.add(label_Idade);
		
		textField_Idade = new JTextField();
		textField_Idade.setBounds(268, 48, 86, 26);
		contentPane.add(textField_Idade);
		textField_Idade.setColumns(10);
		
		JRadioButton radioB_OpcaoFalecida = new JRadioButton("Falecida");
		grupoBotao_SituacaoSaude.add(radioB_OpcaoFalecida);
		radioB_OpcaoFalecida.setBounds(268, 205, 109, 23);
		contentPane.add(radioB_OpcaoFalecida);
		
		JRadioButton radioB_OpcaoEmTratamento = new JRadioButton("Em tratamento");
		grupoBotao_SituacaoSaude.add(radioB_OpcaoEmTratamento);
		radioB_OpcaoEmTratamento.setBounds(268, 179, 109, 23);
		contentPane.add(radioB_OpcaoEmTratamento);
		
		JRadioButton radioB_OpcaoCurada = new JRadioButton("Curada");
		grupoBotao_SituacaoSaude.add(radioB_OpcaoCurada);
		radioB_OpcaoCurada.setBounds(268, 154, 109, 23);
		contentPane.add(radioB_OpcaoCurada);
		
		JLabel label_SituacaoSaude = new JLabel("Situa\u00E7\u00E3o de Sa\u00FAde:");
		label_SituacaoSaude.setBounds(268, 133, 119, 14);
		contentPane.add(label_SituacaoSaude);
		
		checkBox_PessoaContamindada.setBounds(33, 108, 165, 23);
		contentPane.add(checkBox_PessoaContamindada);
		
		if(!checkBox_PessoaContamindada.isSelected()) {
				label_SituacaoSaude.setVisible(false);
				radioB_OpcaoFalecida.setVisible(false);
				radioB_OpcaoEmTratamento.setVisible(false);
				radioB_OpcaoCurada.setVisible(false);
				label_Idade.setVisible(true);
				textField_Idade.setVisible(true);
			}
			else {
				label_SituacaoSaude.setVisible(true);
				radioB_OpcaoFalecida.setVisible(true);
				radioB_OpcaoEmTratamento.setVisible(true);
				radioB_OpcaoCurada.setVisible(true);
				label_Idade.setVisible(false);
				textField_Idade.setVisible(false);

		}
		
		checkBox_PessoaContamindada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(label_SituacaoSaude.isVisible() && radioB_OpcaoFalecida.isVisible() && radioB_OpcaoEmTratamento.isVisible() && radioB_OpcaoCurada.isVisible()) {
					label_SituacaoSaude.setVisible(false);
					radioB_OpcaoFalecida.setVisible(false);
					radioB_OpcaoEmTratamento.setVisible(false);
					radioB_OpcaoCurada.setVisible(false);
					label_Idade.setVisible(true);
					textField_Idade.setVisible(true);
				}
				else {
					label_SituacaoSaude.setVisible(true);
					radioB_OpcaoFalecida.setVisible(true);
					radioB_OpcaoEmTratamento.setVisible(true);
					radioB_OpcaoCurada.setVisible(true);
					label_Idade.setVisible(false);
					textField_Idade.setVisible(false);
				}
			}
		});
		
		JButton button_EfetuarCadastro = new JButton("Cadastrar");
		button_EfetuarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int MINIMO = 1;
				
				if(!checkBox_PessoaContamindada.isSelected()) {
					
					if(grupoBotao_Genero.isSelected(null) || textField_NomeCompleto.getText().isEmpty() || textField_Idade.getText().isEmpty()) {
						Mensagem.mostraMensagemAtencao("Todos os campos devem estar preenchidos para completar o cadastro!", "Cadastro incompleto");
						return;
					}

					if(Validacao.isNomeCompletoValido(textField_NomeCompleto.getText().trim(), 0) && Validacao.isIdadeValido(textField_Idade.getText().trim()) && !grupoBotao_Genero.isSelected(null)) {
											
						PessoaDAO pessoaDao = new PessoaDAO();
						StringBuilder nomeCompleto = new StringBuilder(textField_NomeCompleto.getText().trim());
						int idade = Integer.parseInt(textField_Idade.getText().trim());
						int id = new PessoaDAO().recuperaQtdCadastros() + MINIMO;
						
						if(radioB_OpcaoMasculino.isSelected()) {
							pessoaDao.cadastrarPessoaNaoContaminada(new PessoaNaoContaminada(nomeCompleto , 'M', id, idade));
						}
						else {
							pessoaDao.cadastrarPessoaNaoContaminada(new PessoaNaoContaminada(nomeCompleto , 'F', id, idade));
						}
						
						Mensagem.mostraMensagem("Cadastro realizado com sucesso!");
						limpaCampos();
					}
					
					
				}
				else {
					if(grupoBotao_Genero.isSelected(null) || textField_NomeCompleto.getText().isEmpty() || grupoBotao_SituacaoSaude.isSelected(null)) {
						Mensagem.mostraMensagemAtencao("Todos os campos devem estar preenchidos para completar o cadastro!", "Cadastro incompleto");
						return;
					}
					
					
					if(Validacao.isNomeCompletoValido(textField_NomeCompleto.getText().trim(), 0) && !grupoBotao_SituacaoSaude.isSelected(null) && !grupoBotao_Genero.isSelected(null)) { // Validaçao para a entrada de nome em cadastrar
						PessoaDAO pessoaDao = new PessoaDAO();
						StringBuilder nomeCompleto = new StringBuilder(textField_NomeCompleto.getText().trim());
						int id = new PessoaDAO().recuperaQtdCadastros() + MINIMO;

						if(radioB_OpcaoMasculino.isSelected()) {
							if(radioB_OpcaoCurada.isSelected()) {
								pessoaDao.cadastrarPessoaContaminada(new PessoaContaminada(nomeCompleto, 'M', id, radioB_OpcaoCurada.getText().charAt(0)));
							}
							if(radioB_OpcaoEmTratamento.isSelected()) {
								pessoaDao.cadastrarPessoaContaminada(new PessoaContaminada(nomeCompleto, 'M', id, radioB_OpcaoEmTratamento.getText().charAt(0)));
							}
							if(radioB_OpcaoFalecida.isSelected()) {
								pessoaDao.cadastrarPessoaContaminada(new PessoaContaminada(nomeCompleto, 'M', id, radioB_OpcaoFalecida.getText().charAt(0)));
							}
						}
						else {
							if(radioB_OpcaoCurada.isSelected()) {
								pessoaDao.cadastrarPessoaContaminada(new PessoaContaminada(nomeCompleto, 'F', id, radioB_OpcaoCurada.getText().charAt(0)));
							}
							if(radioB_OpcaoEmTratamento.isSelected()) {
								pessoaDao.cadastrarPessoaContaminada(new PessoaContaminada(nomeCompleto, 'F', id, radioB_OpcaoEmTratamento.getText().charAt(0)));
							}
							if(radioB_OpcaoFalecida.isSelected()) {
								pessoaDao.cadastrarPessoaContaminada(new PessoaContaminada(nomeCompleto, 'F', id, radioB_OpcaoFalecida.getText().charAt(0)));
							}
						}

						Mensagem.mostraMensagem("Cadastro realizado com sucesso!");
						limpaCampos();
						
					}
					
				}
			}
		});
		button_EfetuarCadastro.setBounds(288, 247, 99, 23);
		contentPane.add(button_EfetuarCadastro); 		
	}
	
	private void limpaCampos() {
		textField_Idade.setText("");
		textField_NomeCompleto.setText("");
		grupoBotao_Genero.clearSelection();
		grupoBotao_SituacaoSaude.clearSelection();
	}
}
