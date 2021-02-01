package visao;

import javax.swing.JFrame;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;

import conexaoBD.PessoaDAO;

public class JanelaMenuPrincipal {

	private JFrame frame_MenuPrincipal;
	private JFrame frame_JanelaCadastrar;
	private JFrame frame_JanelaListar;
	private JFrame frame_JanelaConsultar;
	private JFrame frame_JanelaPesquisar;
	private JTable tabelaDados;

	public JanelaMenuPrincipal() {
		initialize();
	}

	private void initialize() {
		frame_MenuPrincipal = new JFrame();
		frame_MenuPrincipal.setBackground(new Color(255, 255, 255));
		frame_MenuPrincipal.getContentPane().setBackground(new Color(255, 255, 255));
		frame_MenuPrincipal.setTitle("COVID-19");
		frame_MenuPrincipal.setVisible(true);
		frame_MenuPrincipal.setBounds(100, 100, 616, 463);
		frame_MenuPrincipal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame_MenuPrincipal.setResizable(false);
		frame_MenuPrincipal.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				VisaoConsole.apresentaQtdCadaTipoPessoa(new PessoaDAO().retornaResultadoCadastros());
				System.exit(0);
			}
		});
		frame_MenuPrincipal.setLocationRelativeTo(null);
		
		JButton button_Cadastrar = new JButton("Cadastrar");
		button_Cadastrar.setBounds(71, 144, 153, 67);
		button_Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_JanelaCadastrar = new JanelaCadastrar();
				frame_JanelaCadastrar.setVisible(true);
				frame_MenuPrincipal.setEnabled(false);
				frame_JanelaCadastrar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame_JanelaCadastrar.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						frame_MenuPrincipal.setEnabled(true);
						frame_JanelaCadastrar.dispose();
					}
				});
			}
		});

		frame_MenuPrincipal.getContentPane().setLayout(null);
		frame_MenuPrincipal.getContentPane().add(button_Cadastrar);
		
		JButton button_Listar = new JButton("Listar");
		button_Listar.setBounds(71, 261, 153, 67);
		button_Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!new PessoaDAO().recuperaGrupoSalvo().getPessoas().isEmpty()) {
					frame_JanelaListar = new JanelaListar(tabelaDados);
					frame_JanelaListar.setVisible(true);
					frame_MenuPrincipal.setEnabled(false);
					frame_JanelaListar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame_JanelaListar.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							frame_MenuPrincipal.setEnabled(true);
							frame_JanelaListar.dispose();							
						}
					});
				}
				else {
					Mensagem.mostraMensagemAtencao("Cadastre uma pessoa primeiro para poder usar esta funcao!", "Nenhuma pessoa cadastrada");
				}
			}
		});
		
		JButton button_Pesquisar = new JButton("Pesquisar");
		button_Pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!new PessoaDAO().recuperaGrupoSalvo().getPessoas().isEmpty()) {
					frame_JanelaPesquisar = new JanelaPesquisar(tabelaDados);
					frame_JanelaPesquisar.setVisible(true);
					frame_MenuPrincipal.setEnabled(false);
					frame_JanelaPesquisar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame_JanelaPesquisar.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							frame_MenuPrincipal.setEnabled(true);
							frame_JanelaPesquisar.dispose();							
						}
					});
				}
				else {
					Mensagem.mostraMensagemAtencao("Cadastre uma pessoa primeiro para poder usar esta funcao!", "Nenhuma pessoa cadastrada");
				}
			}
		});
		button_Pesquisar.setBounds(376, 144, 153, 67);
		frame_MenuPrincipal.getContentPane().add(button_Pesquisar);
		frame_MenuPrincipal.getContentPane().add(button_Listar);
		
		JButton button_Consultar = new JButton("Consultar");
		button_Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!new PessoaDAO().recuperaGrupoSalvo().getPessoas().isEmpty()) {
					frame_JanelaConsultar = new JanelaConsultar();
					frame_JanelaConsultar.setVisible(true);
					frame_MenuPrincipal.setEnabled(false);
					frame_JanelaConsultar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame_JanelaConsultar.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							frame_MenuPrincipal.setEnabled(true);
							frame_JanelaConsultar.dispose();							
						}
					});
				}
				else {
					Mensagem.mostraMensagemAtencao("Cadastre uma pessoa primeiro para poder usar esta funcao!", "Nenhuma pessoa cadastrada");
				}
			}
		});
		button_Consultar.setBounds(376, 261, 153, 67);
		frame_MenuPrincipal.getContentPane().add(button_Consultar);
		
		JButton button_Encerrar = new JButton("Encerrar");
		button_Encerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_Encerrar.setBounds(471, 370, 89, 23);
		button_Encerrar.setForeground(Color.RED);
		button_Encerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VisaoConsole.apresentaQtdCadaTipoPessoa(new PessoaDAO().retornaResultadoCadastros());
				System.exit(0);
			}
		});
		frame_MenuPrincipal.getContentPane().add(button_Encerrar);
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao programa de cadastro de pessoas na pandemia!");
		lblBemVindoAo.setForeground(new Color(0, 0, 153));
		lblBemVindoAo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblBemVindoAo.setBounds(55, 33, 490, 22);
		frame_MenuPrincipal.getContentPane().add(lblBemVindoAo);
		
		JLabel label_SelecioneOpcao = new JLabel("Selecione uma op\u00E7\u00E3o:");
		label_SelecioneOpcao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_SelecioneOpcao.setBounds(36, 99, 177, 14);
		frame_MenuPrincipal.getContentPane().add(label_SelecioneOpcao);
		
	}

}
