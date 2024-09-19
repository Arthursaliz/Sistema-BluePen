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
import packageModel.Cliente;
import packageModel.Produto;

public class ControllerCliente implements Initializable {

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
	private TableColumn<Cliente, String> columnCPFCNPJ;

	@FXML
	private TableColumn<Cliente, String> columnCodigo;

	@FXML
	private TableColumn<Cliente, String> columnDataNascimeto;

	@FXML
	private TableColumn<Cliente, String> columnDataPrimCompr;

	@FXML
	private TableColumn<Cliente, String> columnEmail;

	@FXML
	private TableColumn<Cliente, String> columnEndereco;

	@FXML
	private TableColumn<Cliente, String> columnNome;

	@FXML
	private TableColumn<Cliente, String> columnTipoJuridico;

	@FXML
	private TableColumn<Cliente, String> columnTelefone;

	@FXML
	private TableView<Cliente> tableCliente;

	private ObservableList<Cliente> ArrayCliente;

	private static ClienteDAO cliente = new ClienteDAO();

	public static Cliente clienteEditar = new Cliente();
	@FXML
	private TextField txtPesquisarRelatorio;

	@FXML
	void btnCadastrar(ActionEvent event) throws IOException {
		clienteEditar = null;
		Main.TelaCadastroCliente();
		CarregarTableCliente();

	}

	@FXML
	void btnCliente(ActionEvent event) {
		Main.changeScreen("Cliente");

	}

	@FXML
	void btnEditar(ActionEvent event) throws IOException {
		if (tableCliente.getSelectionModel().getFocusedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tableCliente.getSelectionModel().getSelectedIndex();
			clienteEditar = tableCliente.getItems().get(i);
			Main.TelaCadastroCliente();
		}
		CarregarTableCliente();
	}

	@FXML
	void btnExcluir(ActionEvent event) {
		int i = tableCliente.getSelectionModel().getSelectedIndex();// MUDA
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um cliente primeiro!");
			mensagemDeErro.show();
		} else {
			Cliente cliente = new Cliente();// MUDA
			cliente = tableCliente.getItems().get(i);// MUDA

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o cliente : " + cliente.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ClienteDAO c = new ClienteDAO();//
				c.delete(cliente.getCPF_CNPJ());//

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Cliente excluido com sucesso");
				mensagemDeExclusao.show();
				CarregarTableCliente();
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

		ArrayCliente = FXCollections.observableArrayList(cliente.search(txtPesquisarRelatorio.getText()));

		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("IdCliente"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPFCNPJ.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNascimeto.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnDataPrimCompr.setCellValueFactory(new PropertyValueFactory<>("DataPriCom"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnTipoJuridico.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));

		tableCliente.setItems(ArrayCliente);
		tableCliente.refresh();
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
		// TODO Auto-generated method stub
		CarregarTableCliente();
		clienteEditar = null;
	}

	public void CarregarTableCliente() {
		ArrayCliente = FXCollections.observableArrayList(cliente.read());

		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("IdCliente"));
		columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columnCPFCNPJ.setCellValueFactory(new PropertyValueFactory<>("CPF_CNPJ"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		columnTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
		columnDataNascimeto.setCellValueFactory(new PropertyValueFactory<>("DataNasc"));
		columnDataPrimCompr.setCellValueFactory(new PropertyValueFactory<>("DataPriCom"));
		columnEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		columnTipoJuridico.setCellValueFactory(new PropertyValueFactory<>("TipoJur"));

		tableCliente.setItems(ArrayCliente);

	}

}
