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
import packageControle.VendedorDAO;
import packageModel.Vendedor;

public class ControllerTelaVendedor implements Initializable {

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
	private TableColumn<Vendedor, String> columnCPF;

	@FXML
	private TableColumn<Vendedor, String> columnDataContracao;

	@FXML
	private TableColumn<Vendedor, String> columnDataNascimento;

	@FXML
	private TableColumn<Vendedor, String> columnEmail;

	@FXML
	private TableColumn<Vendedor, String> columnEndereco;

	@FXML
	private TableColumn<Vendedor, String> columnID;

	@FXML
	private TableColumn<Vendedor, String> columnNome;

	@FXML
	private TableColumn<Vendedor, String> columnTelefone;

	@FXML
	private TableColumn<Vendedor, String> columnTotalVendido;

	@FXML
	private TableView<Vendedor> tableViewVendedor;

	private ObservableList<Vendedor> ArrayVendedor;
	public static Vendedor vendedorEditar = new Vendedor();
	private VendedorDAO vendedor = new VendedorDAO();

	@FXML
	private TextField txtPesquisar;

	@FXML
	void btnCadastrar(ActionEvent event) throws IOException {
		vendedorEditar = null;
		Main.TelaCadastroVendedor();
		CarregarTableVendedor();
	}

	@FXML
	void btnCliente(ActionEvent event) {
		Main.changeScreen("Cliente");
	}

	@FXML
	void btnEditar(ActionEvent event) throws IOException {
		if (tableViewVendedor.getSelectionModel().getFocusedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableViewVendedor.getSelectionModel().getSelectedIndex();
			vendedorEditar = tableViewVendedor.getItems().get(i);
			Main.TelaCadastroVendedor();
		}
		CarregarTableVendedor();
	}

	@FXML
	void btnExcluir(ActionEvent event) {
		int i = tableViewVendedor.getSelectionModel().getSelectedIndex();// MUDA
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro!");
			mensagemDeErro.show();
		} else {
			Vendedor vendedor = new Vendedor();// MUDA
			vendedor = tableViewVendedor.getItems().get(i);// MUDA

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o fornecedor : " + vendedor.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				VendedorDAO v = new VendedorDAO();//
				v.delete(vendedor.getCPF());//

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Vendedor excluido com sucesso");
				mensagemDeExclusao.show();
				CarregarTableVendedor();
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

	@FXML
	void txtPesquisar(ActionEvent event) {
		ArrayVendedor = FXCollections.observableArrayList(vendedor.search(txtPesquisar.getText()));

		columnID.setCellValueFactory(new PropertyValueFactory<>("IdVendedor"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("DatNasc"));
		columnDataContracao.setCellValueFactory(new PropertyValueFactory<>("DataCont"));
		columnTotalVendido.setCellValueFactory(new PropertyValueFactory<>("TotalVend"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		tableViewVendedor.setItems(ArrayVendedor);
		tableViewVendedor.refresh();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CarregarTableVendedor();
		vendedorEditar = null;
	}

	public void CarregarTableVendedor() {
		ArrayVendedor = FXCollections.observableArrayList(vendedor.read());

		columnID.setCellValueFactory(new PropertyValueFactory<>("IdVendedor"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNascimento.setCellValueFactory(new PropertyValueFactory<>("DatNasc"));
		columnDataContracao.setCellValueFactory(new PropertyValueFactory<>("DataCont"));
		columnTotalVendido.setCellValueFactory(new PropertyValueFactory<>("TotalVend"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		tableViewVendedor.setItems(ArrayVendedor);

	}

}
