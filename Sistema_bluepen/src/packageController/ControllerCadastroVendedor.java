package packageController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.ClienteDAO;
import packageControle.VendedorDAO;
import packageModel.Cliente;
import packageModel.Vendedor;

public class ControllerCadastroVendedor implements Initializable {

	@FXML
	private DatePicker DtDataContratacao;

	@FXML
	private DatePicker DtDataNascimento;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnVendedor;

	@FXML
	private TextField txtTotalVendido;

	@FXML
	private TextField txtCPF;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtEndereco;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTelefone;

	@FXML
	void btnCancelar(ActionEvent event) {
		txtNome.setText("");
		txtEndereco.setText("");
		DtDataNascimento.setValue(null);
		DtDataContratacao.setValue(null);
		txtTelefone.setText("");
		txtCPF.setText("");
		txtEmail.setText("");
		ControllerTelaVendedor.vendedorEditar = null;

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
	}
	Vendedor vendedorE = new Vendedor();

	@FXML
	void btnSalvar(ActionEvent event) {
		if (ControllerTelaVendedor.vendedorEditar == null) {
			Vendedor vendedorS = new Vendedor();

			vendedorS.setNome(txtNome.getText());
			vendedorS.setEndereco(txtEndereco.getText());
			vendedorS.setTelefone(txtTelefone.getText());
			vendedorS.setCPF(txtCPF.getText());
			vendedorS.setDatNasc(DtDataNascimento.getValue().toString());
			vendedorS.setDataCont(DtDataContratacao.getValue().toString());
			vendedorS.setEmail(txtEmail.getText());
			VendedorDAO vend = new VendedorDAO();
			vend.create(vendedorS);
			
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();

		} else {
			vendedorE.setNome(txtNome.getText());
			vendedorE.setEndereco(txtEndereco.getText());
			vendedorE.setTelefone(txtTelefone.getText());
			vendedorE.setCPF(txtCPF.getText());
			vendedorE.setDatNasc(DtDataNascimento.getValue().toString());
			vendedorE.setDataCont(DtDataContratacao.getValue().toString());
			vendedorE.setEmail(txtEmail.getText());
			VendedorDAO vend = new VendedorDAO();
			vend.update(vendedorE);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if (ControllerTelaVendedor.vendedorEditar != null) {
			vendedorE.setIdVendedor(ControllerTelaVendedor.vendedorEditar.getIdVendedor());
			txtNome.setText(ControllerTelaVendedor.vendedorEditar.getNome());
			txtEndereco.setText(ControllerTelaVendedor.vendedorEditar.getEndereco());
			txtTelefone.setText(ControllerTelaVendedor.vendedorEditar.getTelefone());
			txtEmail.setText(ControllerTelaVendedor.vendedorEditar.getEmail());
			txtCPF.setText(ControllerTelaVendedor.vendedorEditar.getCPF());
			LocalDate localdateNas = LocalDate.parse(ControllerTelaVendedor.vendedorEditar.getDatNasc());
			DtDataNascimento.setValue(localdateNas);
			LocalDate localdateContratacao = LocalDate.parse(ControllerTelaVendedor.vendedorEditar.getDataCont());
			DtDataContratacao.setValue(localdateContratacao);

		}
	}

}
