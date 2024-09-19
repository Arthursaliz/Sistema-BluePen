package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControle.CompraDAO;
import packageModel.Compra;

public class ControllerRelatorios implements Initializable {

	@FXML
	private TableColumn<Compra, String> ColumPrecoTotal;

	@FXML
	private TableColumn<Compra, String> ColumID;

	@FXML
	private TableColumn<Compra, String> ColumProduto;

	@FXML
	private TableColumn<Compra, String> ColumQuantidade;

	@FXML
	private TableColumn<Compra, String> ColumVendedor;

	@FXML
	private TableColumn<Compra, String> ColumCliente;

	@FXML
	private TableView<Compra> tableViewRelatorioVenda;

	@FXML
	private Button btnCancelarRelatorio;

	@FXML
	private Button btnCliente;

	@FXML
	private Button btnFornecedor;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnMudarHome;

	@FXML
	private Button btnPaginaHome;

	@FXML
	private Button btnPesquisarRelatorio;

	@FXML
	private Button btnProdutos;

	@FXML
	private Button btnRegistrarVenda;

	@FXML
	private Button btnVendedor;

	private ObservableList<Compra> ArrayCompra;
	private static CompraDAO compra = new CompraDAO();

	@FXML
	private TextField txtPesquisarRelatorio;

	@FXML
	void btnCancelarRelatorio(ActionEvent event) {

	}

	@FXML
	void btnCliente(ActionEvent event) {
		Main.changeScreen("Cliente");
	}

	@FXML
	void btnFornecedor(ActionEvent event) {
		Main.changeScreen("Fornecedor");
	}

	@FXML
	void btnHome(ActionEvent event) {
		Main.changeScreen("main");
	}

	@FXML
	void btnMudarHome(ActionEvent event) {
		Main.changeScreen("main");

	}

	@FXML
	void btnPaginaHome(ActionEvent event) {
		Main.changeScreen("main");

	}

	@FXML
	void btnPesquisarRelatorio(ActionEvent event) {
		CarregarTableCompra();
	}

	@FXML
	void btnProdutos(ActionEvent event) {
		Main.changeScreen("Produto");

	}

	 @FXML
	    void btRegistrarVenda(ActionEvent event) throws IOException {
		Main.TelaRegistroVenda();
	}

	@FXML
	void btnVendedor(ActionEvent event) {
		Main.changeScreen("Vendedor");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CarregarTableCompra();
	}

	public void CarregarTableCompra() {
		ArrayCompra = FXCollections.observableArrayList(compra.read());

		ColumID.setCellValueFactory(new PropertyValueFactory<>("idCompra"));
		ColumVendedor.setCellValueFactory(new PropertyValueFactory<>("IdVendedor"));
		ColumCliente.setCellValueFactory(new PropertyValueFactory<>("IdCliente"));
		ColumProduto.setCellValueFactory(new PropertyValueFactory<>("IdProduto"));
		ColumQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		ColumPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("PrecoTotal"));

		tableViewRelatorioVenda.setItems(ArrayCompra);

	}

}
