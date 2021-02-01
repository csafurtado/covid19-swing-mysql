package conexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Grupo;
import dados.Pessoa;
import dados.PessoaContaminada;
import dados.PessoaNaoContaminada;

public class PessoaDAO {
	private Connection con = Conexao.getConnection();

	public void cadastrarPessoaContaminada(PessoaContaminada pessoaContaminada) {
		String sql = "INSERT INTO pessoa (nomeCompleto, genero, situacaoSaude, idade) VALUES (?, ?, ?, ?)";  // ? é como se fosse um %d ou %s em C, um parâmetro que deverá ser colocado posteriormente.
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, pessoaContaminada.getNomeCompleto().toString());
			preparador.setString(2, pessoaContaminada.getGenero().toString());
			preparador.setString(3, pessoaContaminada.getSituacaoSaude().toString());
			preparador.setString(4, null);
			
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro no envio de dados");
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão.");
					System.out.println("Causa: " + e.getMessage());
				}
		}

	}
	
	public void cadastrarPessoaNaoContaminada(PessoaNaoContaminada pessoaNaoContaminada) {
		String sql = "INSERT INTO pessoa (nomeCompleto, genero, situacaoSaude, idade) VALUES (?, ?, ?, ?)";  // ? é como se fosse um %d ou %s em C, um parâmetro que deverá ser colocado posteriormente.
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, pessoaNaoContaminada.getNomeCompleto().toString());
			preparador.setString(2, pessoaNaoContaminada.getGenero().toString());
			preparador.setString(3, null);
			preparador.setString(4, pessoaNaoContaminada.getIdade().toString());
			
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro no envio de dados");
		} finally {
			if (con != null)
				
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão.");
					System.out.println("Causa: " + e.getMessage());
				}
		}

	}
	
	public Grupo recuperaGrupoSalvo() {
		String sql = "SELECT * FROM PESSOA";
		Grupo grupoPessoas = new Grupo();
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet listaResultado = preparador.executeQuery();

			while(listaResultado.next()) {
				String nomeCompleto = listaResultado.getString("nomeCompleto");
				String situacaoSaude = listaResultado.getString("situacaoSaude");
				int idade = listaResultado.getInt("idade");
				int id = listaResultado.getInt("idPessoa");
				String genero = listaResultado.getString("genero");
				
				if (listaResultado.getString("situacaoSaude") == null)
					grupoPessoas.getPessoas().add(new PessoaNaoContaminada(new StringBuilder(nomeCompleto), genero.charAt(0), id, idade));
				else
					grupoPessoas.getPessoas().add(new PessoaContaminada(new StringBuilder(nomeCompleto), genero.charAt(0), id, situacaoSaude.charAt(0)));				
			}

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();				
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão.");
					System.out.println("Causa: " + e.getMessage());
				}
		}
		
		return grupoPessoas;
	}
	
	public Pessoa recuperaPessoaPorID(int idConsulta) {
		String sql = "SELECT * FROM PESSOA WHERE idPessoa = " + idConsulta; 
		Pessoa pessoaConsultada = null;
		
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet listaResultado = preparador.executeQuery();

			while(listaResultado.next()) {
				String nomeCompleto = listaResultado.getString("nomeCompleto");
				String situacaoSaude = listaResultado.getString("situacaoSaude");
				int idade = listaResultado.getInt("idade");
				int id = listaResultado.getInt("idPessoa");
				String genero = listaResultado.getString("genero");
				
				
				if(id == idConsulta) {
					if (listaResultado.getString("situacaoSaude") == null)
						pessoaConsultada =  new PessoaNaoContaminada(new StringBuilder(nomeCompleto), genero.charAt(0), id, idade);
					else
						pessoaConsultada =  new PessoaContaminada(new StringBuilder(nomeCompleto), genero.charAt(0), id, situacaoSaude.charAt(0));
				}
			}

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();				
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão.");
					System.out.println("Causa: " + e.getMessage());
				}
		}
		
		return pessoaConsultada;
	}	
	
	public int recuperaQtdCadastros() {
		String sql = "select count(*) from pessoa as contado;";
		int qtdCadastros = 0;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet listaResultado = preparador.executeQuery();

			while(listaResultado.next()) {
				qtdCadastros++;
			}

		preparador.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (con != null)
			try {
				con.close();				
			} catch (SQLException e) {
				System.out.print("Falha ao fechar a conexão.");
				System.out.println("Causa: " + e.getMessage());
			}
		}
		
		return qtdCadastros;
	}
	
	public int[] retornaResultadoCadastros() {
		String sql = "select * from pessoa;";
		
		int qtdCadastros = 0;
		int naoContaminados = 0;
		int contaminadosEmTratamento = 0;
		int contaminadosCurados = 0;
		int mulheresFalecidas = 0;
		int homensFalecidos = 0;
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet listaResultado = preparador.executeQuery();

			while(listaResultado.next()) {
				qtdCadastros++;
				
				if(listaResultado.getString("situacaoSaude") != null) {
					if(listaResultado.getString("situacaoSaude").charAt(0) == 'F') {
						if(listaResultado.getString("genero").charAt(0) == 'F')
							mulheresFalecidas++;
						else
							homensFalecidos++;
					}
					else if(listaResultado.getString("situacaoSaude").charAt(0) == 'C')
						contaminadosCurados++;
					else 
						contaminadosEmTratamento++;					
				}
				else
					naoContaminados++;
			}

		preparador.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (con != null)
			try {
				con.close();				
			} catch (SQLException e) {
				System.out.print("Falha ao fechar a conexão.");
				System.out.println("Causa: " + e.getMessage());
			}
		}
		
		return new int[] {naoContaminados, contaminadosEmTratamento, contaminadosCurados, mulheresFalecidas, homensFalecidos, qtdCadastros};
	}
}
