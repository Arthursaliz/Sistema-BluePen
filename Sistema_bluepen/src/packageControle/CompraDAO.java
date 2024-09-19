package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageModel.Compra;
import packeageConnection.ConnectionDatabase;

public class CompraDAO {

	public void create(Compra cr) {
		Connection con = ConnectionDatabase.getConnection(); // Abrir conexão com o banco
		PreparedStatement stmt = null; // Realizaa identação indentificando os espaços que seram inseridos os valores
										// desejados.

		try {
			stmt = con.prepareStatement("INSERT INTO Compra VALUES (?,?,?,?,?)");
			stmt.setString(1, cr.getIdCliente());
			stmt.setString(2, cr.getIdVendedor());
			stmt.setString(3, cr.getIdProduto());
			stmt.setString(4, cr.getQuantidade());
			stmt.setString(5, cr.getPrecoTotal());

			stmt.executeUpdate();
			System.out.println("DADOS INSERIDOS - COMPRA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // Comando que indepdente do resultado será sempre execultado
			ConnectionDatabase.closeConnection(con, stmt);

		}

	}

	public ArrayList<Compra> read() {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Compra> compra = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT id_compra , v.nome , cl.nome, p.nome, cp.quantidade, cp.preco_total FROM Compra cp INNER JOIN Cliente cl ON cl.idCliente = cp.id_cliente INNER JOIN Produto p ON cp.id_Produto = p.idProduto INNER JOIN Vendedor v ON cp.id_vendedor = v.idVendedor");
			
			rs = stmt.executeQuery();

			while (rs.next()) {
				Compra c = new Compra();
				c.setIdCompra(rs.getString(1));
				c.setIdCliente(rs.getString(2));
				c.setIdVendedor(rs.getString(3));
				c.setIdProduto(rs.getString(4));
				c.setQuantidade(rs.getString(5));
				c.setPrecoTotal(rs.getString(6));

				compra.add(c);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}

		return compra;

	}

	public void update (Compra cr) {

		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE Compra SET id_cliente = ?, id_vendedor = ?, id_Produto = ?, quantidade = ?, preco_total = ? WHERE id_compra = ?");
			stmt.setString(6, cr.getIdCompra());
			stmt.setString(1, cr.getIdCliente());
			stmt.setString(2, cr.getIdVendedor());
			stmt.setString(3, cr.getIdProduto());
			stmt.setString(4, cr.getQuantidade());
			stmt.setString(5, cr.getPrecoTotal());
			
			stmt.executeUpdate();
			System.out.println("DADOS ATUALIZADOS - COMPRA");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}

	public void delete(String id_compra) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM Compra WHERE id_compra = ?");
			stmt.setString(1, id_compra);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
	}
}
