package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControle.ClienteDAO;
import packageControle.ProdutoDAO;
import packageModel.Cliente;
import packageModel.Produto;

public class ControllerTelaProduto implements Initializable {

	@FXML
	private Button btnCadastrar;

	@FXML
	private Button btnCliente;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnFornecedor;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnMudarHome;

	@FXML
	private Button btnPaginaInicial;

	@FXML
	private Button btnPesquisar;

	@FXML
	private Button btnProdutos;

	@FXML
	private Button btnRegistrarVenda;

	@FXML
	private Button btnVendedor;

	@FXML
	private TableColumn<Produto, String> columCodigo;

	@FXML
	private TableColumn<Produto, String> columnDataFab;

	@FXML
	private TableColumn<Produto, String> columnDataVal;

	@FXML
	private TableColumn<Produto, String> columnTipo;

	@FXML
	private TableColumn<Produto, String> columnNome;

	@FXML
	private TableColumn<Produto, String> columnPrecoUnitario;

	@FXML
	private TableColumn<Produto, String> columnQuantidade;

	@FXML
	private TableView<Produto> tableProdutos;

	@FXML
	private TextField txtPesquisar;

	public ObservableList<Produto> ArrayProduto;

	public static ProdutoDAO produto = new ProdutoDAO();

	@FXML
	void btnCadastrar(ActionEvent event) throws IOException {
		produtoEditar = null;
		Main.TelaCadastroPro();
		CarregarTableProduto();

	}

	@FXML
	void btnCliente(ActionEvent event) {
		Main.changeScreen("Cliente");

	}

	public static Produto produtoEditar = new Produto();

	@FXML
	void btnEditar(ActionEvent event) throws IOException {
		if (tableProdutos.getSelectionModel().getFocusedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um produto para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableProdutos.getSelectionModel().getSelectedIndex();
			produtoEditar = tableProdutos.getItems().get(i);
			Main.TelaCadastroPro();
		}
		CarregarTableProduto();
	}

	@FXML
	void btnExcluir(ActionEvent event) {
		int i = tableProdutos.getSelectionModel().getSelectedIndex();// MUDA
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Produto  primeiro!");
			mensagemDeErro.show();
		} else {
			Produto produto = new Produto();// MUDA
			produto = tableProdutos.getItems().get(i);// MUDA

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o produto : " + produto.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ProdutoDAO p = new ProdutoDAO();// MUDA
				p.delete(produto.getCodigo());// MUDA

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Produto excluido com sucesso");
				mensagemDeExclusao.show();
				CarregarTableProduto();

			}

		}

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
	void btnPaginaInicial(ActionEvent event) {
		Main.changeScreen("main");

	}

	@FXML
	void btnPesquisar(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produto.search(txtPesquisar.getText()));

		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columnPrecoUnitario.setCellValueFactory(new PropertyValueFactory<>("PrecoUnit"));
		columnTipo.setCellValueFactory(new PropertyValueFactory<>("TipoUnit"));
		columnDataVal.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnDataFab.setCellValueFactory(new PropertyValueFactory<>("dataFab"));

		tableProdutos.setItems(ArrayProduto);
		tableProdutos.refresh();
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
		CarregarTableProduto();
		produtoEditar = null;
	}

	public void CarregarTableProduto() {
		ArrayProduto = FXCollections.observableArrayList(produto.read());

		columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columnPrecoUnitario.setCellValueFactory(new PropertyValueFactory<>("PrecoUnit"));
		columnTipo.setCellValueFactory(new PropertyValueFactory<>("TipoUnit"));
		columnDataVal.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnDataFab.setCellValueFactory(new PropertyValueFactory<>("dataFab"));

		tableProdutos.setItems(ArrayProduto);
	}
}
