package packageController;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import packageControle.ClienteDAO;
import packageControle.CompraDAO;
import packageControle.ProdutoDAO;
import packageModel.Cliente;
import packageModel.Compra;
import packageModel.Produto;

public class ControllerRegistrarVenda implements Initializable {

	@FXML
	private TableColumn<Produto, String> ColumnCodigo;

	@FXML
	private TableColumn<Produto, String> ColumnNome;

	@FXML
	private TableColumn<Produto, String> ColumnPrecoUnitario;

	@FXML
	private TableColumn<Produto, String> ColumnQuantidade;

	@FXML
	private Button btnCancelarVenda;

	@FXML
	private Button btnPesquisarProduto;

	@FXML
	private Button btnSalvarVenda;

	@FXML
	private TableView<Produto> tblPesquisarProduto;

	@FXML
	private TextField txtCPFCliente;

	@FXML
	private TextField txtCPFVendedor;

	@FXML
	private TextField txtCodigoProduto;

	@FXML
	private TextField txtDesconto;

	@FXML
	private TextField txtIDCliente;

	@FXML
	private TextField txtIDVendedor;

	@FXML
	private TextField txtNomeCliente;

	@FXML
	private TextField txtNomeVendedor;

	@FXML
	private TextField txtPesquisarProduto;

	@FXML
	private TextField txtPrecoTotal;

	@FXML
	private TextField txtPrecoUnitario;

	@FXML
	private TextField txtQuantidadeProduto;

	Produto produto = new Produto();
	ArrayList<Cliente> cliente1 = new ArrayList<>();
	Cliente cliente2 = new Cliente();
	private ObservableList<Produto> ArrayProduto;
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private ClienteDAO clienteDAO = new ClienteDAO();

	@FXML
	void btnCancelarRegistroVenda(ActionEvent event) {
		Stage stage = (Stage) btnCancelarVenda.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnPesquisarProduto(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtPesquisarProduto.getText()));

		ColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		ColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		ColumnPrecoUnitario.setCellValueFactory(new PropertyValueFactory<>("PrecoUnit"));

		tblPesquisarProduto.setItems(ArrayProduto);
		tblPesquisarProduto.refresh();

	}

	@FXML
	void btnSalvarRegistroVenda(ActionEvent event) {
		if (cliente2 != null && produto != null && txtIDVendedor != null) {
			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso
					.setContentText("Deseja realmente Salvar a venda para o vendedor : " + txtNomeVendedor.getText());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Venda realizada com sucesso!");
				mensagemDeExclusao.show();
				CompraDAO compraDAO = new CompraDAO();
				Compra compra = new Compra();
				compra.setIdCliente(cliente2.getIdCliente());
				compra.setIdVendedor(txtIDVendedor.getText());
				compra.setIdProduto(produto.getIdProduto());
				compra.setQuantidade(txtQuantidadeProduto.getText());
				compra.setPrecoTotal(txtPrecoTotal.getText());
				compraDAO.create(compra);
				txtIDCliente.setText("");
				txtNomeCliente.setText("");
				txtCPFCliente.setText("");
				txtCodigoProduto.setText("");
				txtPesquisarProduto.setText("");
				txtQuantidadeProduto.setText("");
				txtPrecoTotal.setText("");
				txtPrecoUnitario.setText("");
				txtDesconto.setText("");
				cliente2 = null;
			}
		} else {
			Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
			mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
			mensagemDeExclusao.show();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CarregarTabelaProduto();
		cliente2 = null;

		txtCPFVendedor.setText(ControllerLogin.vendedor.getCPF());
		txtNomeVendedor.setText(ControllerLogin.vendedor.getNome());
		txtIDVendedor.setText(ControllerLogin.vendedor.getIdVendedor());
		txtQuantidadeProduto.setText("0");

		tblPesquisarProduto.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = tblPesquisarProduto.getSelectionModel().getSelectedIndex();
				produto = tblPesquisarProduto.getItems().get(i);
				txtCodigoProduto.setText(produto.getCodigo());
				txtPrecoUnitario.setText(produto.getPrecoUnit());
				txtPesquisarProduto.setText(produto.getNome());
			}
		});
	}

	private void CarregarTabelaProduto() {

		ArrayProduto = FXCollections.observableArrayList(produtoDAO.read());

		ColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		ColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		ColumnPrecoUnitario.setCellValueFactory(new PropertyValueFactory<>("PrecoUnit"));
		ColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Estoque"));

		tblPesquisarProduto.setItems(ArrayProduto);
	}

	@FXML
	void definirPrecoTotal(KeyEvent event) {
		if (txtQuantidadeProduto.getText() != "" && txtQuantidadeProduto.getText() != null) {

			double quantidade = Double.parseDouble(txtQuantidadeProduto.getText());

			if (quantidade < 30) {
				txtDesconto.setText("");
				double precoTotal = Double.parseDouble(txtPrecoUnitario.getText())
						* Double.parseDouble(txtQuantidadeProduto.getText());
				txtPrecoTotal.setText(Double.toString(precoTotal));

			} else {

				double precoTotal = (Double.parseDouble(txtPrecoUnitario.getText())
						* Double.parseDouble(txtQuantidadeProduto.getText()));
				precoTotal = precoTotal * 0.85;
				txtPrecoTotal.setText(Double.toString(precoTotal));
				Double desconto = precoTotal * 0.15;
				txtDesconto.setText(Double.toString(desconto));

			}
		}
	}

	@FXML
	void definirCliente(KeyEvent evente) {
		if (clienteDAO.search(txtCPFCliente.getText()) != null) {
			cliente1 = clienteDAO.search(txtCPFCliente.getText());
			cliente2 = cliente1.get(0);
			txtIDCliente.setText(cliente2.getIdCliente());
			txtNomeCliente.setText(cliente2.getNome());
		}

	}

}
