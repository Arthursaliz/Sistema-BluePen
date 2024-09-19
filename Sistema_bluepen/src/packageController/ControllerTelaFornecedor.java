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
import packageControle.FornecedorDAO;
import packageModel.Cliente;
import packageModel.Fornecedor;

public class ControllerTelaFornecedor implements Initializable {

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
	private TableColumn<Fornecedor, String> columnCNPJ;

	@FXML
	private TableColumn<Fornecedor, String> columnEmail;

	@FXML
	private TableColumn<Fornecedor, String> columnEndereco;

	@FXML
	private TableColumn<Fornecedor, String> columnID;

	@FXML
	private TableColumn<Fornecedor, String> columnNome;

	@FXML
	private TableColumn<Fornecedor, String> columnTelefone;

	@FXML
	private TableView<Fornecedor> tblFornecedor;

	@FXML
	private TextField txtPesquisar;

	private ObservableList<Fornecedor> ArrayFornecedor;
	private static FornecedorDAO Fornecedor = new FornecedorDAO();
	public static Fornecedor FornecedorEditar = new Fornecedor();

	@FXML
	void btnCadastrar(ActionEvent event) throws IOException {
		FornecedorEditar = null;
		Main.TelaFornecedor();
		CarregarTabelaFornecedor();
	}

	@FXML
	void btnCliente(ActionEvent event) {
		Main.changeScreen("Cliente");

	}

	@FXML
	void btnEditar(ActionEvent event) throws IOException {
		if (tblFornecedor.getSelectionModel().getFocusedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tblFornecedor.getSelectionModel().getSelectedIndex();
			FornecedorEditar = tblFornecedor.getItems().get(i);
			Main.TelaFornecedor();
		}
		CarregarTabelaFornecedor();
	}

	@FXML
	void btnExcluir(ActionEvent event) {
		int i = tblFornecedor.getSelectionModel().getSelectedIndex();// MUDA
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um fornecedor primeiro!");
			mensagemDeErro.show();
		} else {
			Fornecedor fornecedor = new Fornecedor();// MUDA
			fornecedor = tblFornecedor.getItems().get(i);// MUDA

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o fornecedor : " + fornecedor.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				FornecedorDAO f = new FornecedorDAO();//
				f.delete(fornecedor.getCNPJ());//

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Fornecedor excluido com sucesso");
				mensagemDeExclusao.show();
				CarregarTabelaFornecedor();
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
		ArrayFornecedor = FXCollections.observableArrayList(Fornecedor.search(txtPesquisar.getText()));

		columnID.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		tblFornecedor.setItems(ArrayFornecedor);
		tblFornecedor.refresh();
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
		CarregarTabelaFornecedor();
		FornecedorEditar = null;
	}

	public void CarregarTabelaFornecedor() {
		ArrayFornecedor = FXCollections.observableArrayList(Fornecedor.read());
		
		columnID.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));

		tblFornecedor.setItems(ArrayFornecedor);
	}

}
