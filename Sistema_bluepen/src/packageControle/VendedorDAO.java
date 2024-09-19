package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageModel.Fornecedor;
import packageModel.Vendedor;
import packeageConnection.ConnectionDatabase;

public class VendedorDAO {

	public void create(Vendedor vd) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement(
					"INSERT INTO Vendedor(nome, CPF, Email, Telefone, DataNasc, DataCont, Endereco) VALUES (?,?,?,?,?,?,?)");
			stmt.setString(1, vd.getNome());
			stmt.setString(2, vd.getCPF());
			stmt.setString(3, vd.getEmail());
			stmt.setString(4, vd.getTelefone());
			stmt.setString(5, vd.getDatNasc());
			stmt.setString(6, vd.getDataCont());
			stmt.setString(7, vd.getEndereco());

			stmt.executeUpdate();
			System.out.println("DADOS INSERIDOS - VENDEDOR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public ArrayList<Vendedor> read() {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vendedor> vendedor = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDatNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));

				vendedor.add(v);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return vendedor;
	}

	public void update(Vendedor vd) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement(
					"UPDATE Vendedor SET nome = ?, CPF = ?, Email = ?, Telefone = ?, DataNasc = ?, DataCont = ?, Endereco = ? WHERE idVendedor = ?");
			stmt.setString(1, vd.getNome());
			stmt.setString(2, vd.getCPF());
			stmt.setString(3, vd.getEmail());
			stmt.setString(4, vd.getTelefone());
			stmt.setString(5, vd.getDatNasc());
			stmt.setString(6, vd.getDataCont());
			stmt.setString(7, vd.getEndereco());
			stmt.setString(8, vd.getIdVendedor());

			stmt.executeUpdate();
			System.out.println("DADOS ATUALIZADOS - VENDEDOR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public void delete(String idVendedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Vendedor WHERE CPF = ?");
			stmt.setString(1, idVendedor);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public Vendedor autenticarUser(String user, String password) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Vendedor vendedor = new Vendedor();

		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor WHERE Password = ? and CPF = ?");
			stmt.setString(1, password);
			stmt.setString(2, user);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDatNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				v.setPassword(rs.getString(10));

				vendedor = v;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return vendedor;

	}

	public ArrayList<Vendedor> search(String search) {
		search = "%" + search + "%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vendedor> vendedor = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Vendedor WHERE Nome like ? or CPF like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Vendedor v = new Vendedor();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDatNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				v.setPassword(rs.getString(10));

				vendedor.add(v);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return vendedor;
	}

}
