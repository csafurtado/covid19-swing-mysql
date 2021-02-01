package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid19?useTimezone=true&serverTimezone=UTC", "root", "root");

		} catch (SQLException e) {
			System.out.println("Sem conectar!\n" + e.getMessage());
			e.printStackTrace();
		}

		return con;
	}
}
