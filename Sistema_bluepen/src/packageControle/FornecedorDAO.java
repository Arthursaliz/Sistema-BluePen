package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageModel.Fornecedor;
import packeageConnection.ConnectionDatabase;

public class FornecedorDAO {

	public void create(Fornecedor fr) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement("INSERT INTO Fornecedor VALUES (?,?,?,?,?)");
			stmt.setString(1, fr.getNome());
			stmt.setString(2, fr.getCNPJ());
			stmt.setString(3, fr.getEmail());
			stmt.setString(4, fr.getTelefone());
			stmt.setString(5, fr.getEndereco());

			stmt.executeUpdate();
			System.out.println("DADOS INSERIDOS - FORNECEDOR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public ArrayList<Fornecedor> read() {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Fornecedor");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setIdFornecedor(rs.getString(1));
				f.setNome(rs.getString(2));
				f.setCNPJ(rs.getString(3));
				f.setEmail(rs.getString(4));
				f.setTelefone(rs.getString(5));
				f.setEndereco(rs.getString(6));

				fornecedor.add(f);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return fornecedor;
	}

	public void update(Fornecedor fr) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement(
					"UPDATE Fornecedor SET nome = ?, CNPJ = ?, Email = ?, Telefone = ?, Endereco = ? WHERE CNPJ = ?");
			stmt.setString(1, fr.getNome());
			stmt.setString(2, fr.getCNPJ());
			stmt.setString(3, fr.getEmail());
			stmt.setString(4, fr.getTelefone());
			stmt.setString(5, fr.getEndereco());
			stmt.setString(6, fr.getCNPJ());

			stmt.executeUpdate();
			System.out.println("DADOS ATUALIZADOS - FORNECEDOR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public void delete(String idFornecedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Fornecedor WHERE CNPJ = ?");
			stmt.setString(1, idFornecedor);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public ArrayList<Fornecedor> search(String search) {
		search = "%" + search + "%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Fornecedor WHERE Nome like ? or CNPJ like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setIdFornecedor(rs.getString(1));
				f.setNome(rs.getString(2));
				f.setCNPJ(rs.getString(3));
				f.setEmail(rs.getString(4));
				f.setTelefone(rs.getString(5));
				f.setEndereco(rs.getString(6));

				fornecedor.add(f);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return fornecedor;
	}

}
