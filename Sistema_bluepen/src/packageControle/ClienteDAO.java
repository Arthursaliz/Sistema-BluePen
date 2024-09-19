package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageModel.Cliente;
import packageModel.Produto;
import packeageConnection.ConnectionDatabase;

public class ClienteDAO {

	public void create(Cliente cl) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?)");
			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getCPF_CNPJ());
			stmt.setString(3, cl.getEmail());
			stmt.setString(4, cl.getTelefone());
			stmt.setString(5, cl.getDataNasc());
			stmt.setString(6, cl.getDataPriCom());
			stmt.setString(7, cl.getEndereco());
			stmt.setString(8, cl.getTipoJur());

			stmt.executeUpdate();
			System.out.println("DADOS INSERIDOS - CLIENTE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public ArrayList<Cliente> read() {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPriCom(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJur(rs.getString(9));

				cliente.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return cliente;
	}

	public void update(Cliente cl) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement(
					"UPDATE Cliente SET nome = ?, CPF_CNPJ = ?, Email = ?, Telefone = ?, DataNasc = ?, DataPrimCompra = ?, Endereco = ?, TipoJuridico = ? WHERE CPF_CNPJ = ?");
			stmt.setString(1, cl.getNome());
			stmt.setString(2, cl.getCPF_CNPJ());
			stmt.setString(3, cl.getEmail());
			stmt.setString(4, cl.getTelefone());
			stmt.setString(5, cl.getDataNasc());
			stmt.setString(6, cl.getDataPriCom());
			stmt.setString(7, cl.getEndereco());
			stmt.setString(8, cl.getTipoJur());
			stmt.setString(9, cl.getCPF_CNPJ());

			stmt.executeUpdate();
			System.out.println("DADOS ATUALIZADOS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public void delete(String cpf_cnpj) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Cliente WHERE CPF_CNPJ = ?");
			stmt.setString(1, cpf_cnpj);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao Apagar! O cliente possui compras registradas!");
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}
	
	public ArrayList<Cliente> search(String search) {
		search = "%" + search + "%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> cliente = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Cliente WHERE Nome like ? or CPF_CNPJ like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getString(1));
				c.setNome(rs.getString(2));
				c.setCPF_CNPJ(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setTelefone(rs.getString(5));
				c.setDataNasc(rs.getString(6));
				c.setDataPriCom(rs.getString(7));
				c.setEndereco(rs.getString(8));
				c.setTipoJur(rs.getString(9));

				cliente.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return cliente;
	}
	

}
