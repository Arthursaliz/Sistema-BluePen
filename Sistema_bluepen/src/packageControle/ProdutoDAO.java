package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageModel.Produto;
import packeageConnection.ConnectionDatabase;

public class ProdutoDAO {

	public void create(Produto pr) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement("INSERT INTO Produto VALUES (?,?,?,?,?,?,?)");
			stmt.setString(1, pr.getNome());
			stmt.setString(2, pr.getCodigo());
			stmt.setString(3, pr.getEstoque());
			stmt.setString(4, pr.getPrecoUnit());
			stmt.setString(5, pr.getTipoUnit());
			stmt.setString(6, pr.getDataFab());
			stmt.setString(7, pr.getDataVal());

			stmt.executeUpdate();
			System.out.println("DADOS INSERIDOS - FORNECEDOR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public ArrayList<Produto> read() {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> produto = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Produto");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setIdProduto(rs.getString(1));
				p.setNome(rs.getString(2));
				p.setCodigo(rs.getString(3));
				p.setEstoque(rs.getString(4));
				p.setPrecoUnit(rs.getString(5));
				p.setTipoUnit(rs.getString(6));
				p.setDataFab(rs.getString(7));
				p.setDataVal(rs.getString(8));

				produto.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return produto;
	}

	public void update(Produto pr) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement(
					"UPDATE Produto SET nome = ?, codigo = ?, estoque = ?, precoUnit = ?, tipoUnit = ?, dataFab = ?, dataVal = ? WHERE codigo = ?");
			stmt.setString(1, pr.getNome());
			stmt.setString(2, pr.getCodigo());
			stmt.setString(3, pr.getEstoque());
			stmt.setString(4, pr.getPrecoUnit());
			stmt.setString(5, pr.getTipoUnit());
			stmt.setString(6, pr.getDataFab());
			stmt.setString(7, pr.getDataVal());
			stmt.setString(8, pr.getCodigo());

			stmt.executeUpdate();
			System.out.println("DADOS ATUALIZADOS - FORNECEDOR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public void delete(String codigo) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Produto WHERE codigo = ?");
			stmt.setString(1, codigo);
			stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public ArrayList<Produto> search(String search) {
		search = "%" + search + "%";
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> produto = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM Produto WHERE Nome like ? or codigo like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setIdProduto(rs.getString(1));
				p.setNome(rs.getString(2));
				p.setCodigo(rs.getString(3));
				p.setEstoque(rs.getString(4));
				p.setPrecoUnit(rs.getString(5));
				p.setTipoUnit(rs.getString(6));
				p.setDataFab(rs.getString(7));
				p.setDataVal(rs.getString(8));

				produto.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return produto;
	}

}
