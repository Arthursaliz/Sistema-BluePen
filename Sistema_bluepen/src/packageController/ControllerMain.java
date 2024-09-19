package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerMain implements Initializable {

	@FXML
	private Button btCliente;

	@FXML
	private Button btFornecedor;

	@FXML
	private Button btHome;

	@FXML
	private Button btPageCliente;

	@FXML
	private Button btPageFornecedor;

	@FXML
	private Button btPageProdutos;

	@FXML
	private Button btPageRegistrar;

	@FXML
	private Button btPageRelatorio;

	@FXML
	private Button btPageVendedor;

	@FXML
	private Button btProdutos;

	@FXML
	private Button btRegistrarVenda;

	@FXML
	private Button btVendedor;

	@FXML
	private Button btnsair;

	@FXML
	private Label txtNomeUsuario;

	@FXML
	void btCliente(ActionEvent event) {
		Main.changeScreen("Cliente");
	}

	@FXML
	void btFornecedor(ActionEvent event) {
		Main.changeScreen("Fornecedor");
	}

	@FXML
	void btHome(ActionEvent event) {
		Main.changeScreen("Home");
	}

	@FXML
	void btPageCliente(ActionEvent event) {
		Main.changeScreen("Cliente");
	}

	@FXML
	void btPageFornecedor(ActionEvent event) {
		Main.changeScreen("Fornecedor");

	}

	@FXML
	void btPageProdutos(ActionEvent event) {
		Main.changeScreen("Produto");
	}

	@FXML
	void btPageRegistrar(ActionEvent event) throws IOException {
		Main.TelaRegistroVenda();
	}

	@FXML
	void btPageRelatorio(ActionEvent event) {
		Main.changeScreen("Relátorio de vendas");
	}

	@FXML
	void btPageVendedor(ActionEvent event) {
		Main.changeScreen("Vendedor");
	}

	@FXML
	void btProdutos(ActionEvent event) {
		Main.changeScreen("Produto");
	}

	@FXML
	void btRegistrarVenda(ActionEvent event) throws IOException {
		Main.TelaRegistroVenda();
	}

	@FXML
	void btVendedor(ActionEvent event) {
		Main.changeScreen("Vendedor");
	}

	@FXML
	void btnSair(ActionEvent event) {
		Main.changeScreen("Login");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			txtNomeUsuario.setText(ControllerLogin.vendedor.getNome());
		}

	}

