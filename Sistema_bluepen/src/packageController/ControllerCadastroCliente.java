package packageController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.ClienteDAO;
import packageModel.Cliente;

public class ControllerCadastroCliente implements Initializable {

	@FXML
	private DatePicker DtDataNascimento;

	@FXML
	private DatePicker DtDataPrim;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

	@FXML
	private ChoiceBox<String> cbTipo;

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
		DtDataPrim.setValue(null);
		txtTelefone.setText("");
		txtCPF.setText("");
		txtEmail.setText("");
		ControllerCliente.clienteEditar = null;

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnSalvar(ActionEvent event) {
		if (ControllerCliente.clienteEditar == null) {
			Cliente cliente = new Cliente();
			cliente.setNome(txtNome.getText());
			cliente.setEndereco(txtEndereco.getText());
			cliente.setTelefone(txtTelefone.getText());
			cliente.setCPF_CNPJ(txtCPF.getText());
			cliente.setDataNasc(DtDataNascimento.getValue().toString());
			cliente.setDataPriCom(DtDataPrim.getValue().toString());
			cliente.setEmail(txtEmail.getText());
			cliente.setTipoJur(cbTipo.getValue().toString());
			cliente.setDataNasc(DtDataNascimento.getValue().toString());
			ClienteDAO clin = new ClienteDAO();
			clin.create(cliente);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();

		} else {
			Cliente cliente = new Cliente();
			cliente.setNome(txtNome.getText());
			cliente.setEndereco(txtEndereco.getText());
			cliente.setTelefone(txtTelefone.getText());
			cliente.setCPF_CNPJ(txtCPF.getText());
			cliente.setDataNasc(DtDataNascimento.getValue().toString());
			cliente.setDataPriCom(DtDataPrim.getValue().toString());
			cliente.setEmail(txtEmail.getText());
			cliente.setTipoJur(cbTipo.getValue().toString());

			ClienteDAO clin = new ClienteDAO();
			clin.update(cliente);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbTipo.getItems().add("PJ");
		cbTipo.getItems().add("PF");

		if (ControllerCliente.clienteEditar != null) {
			txtNome.setText(ControllerCliente.clienteEditar.getNome());
			txtEndereco.setText(ControllerCliente.clienteEditar.getEndereco());
			txtTelefone.setText(ControllerCliente.clienteEditar.getTelefone());
			txtCPF.setText(ControllerCliente.clienteEditar.getCPF_CNPJ());
			txtEmail.setText(ControllerCliente.clienteEditar.getEmail());
			cbTipo.setValue(ControllerCliente.clienteEditar.getTipoJur());
			LocalDate localdateNas = LocalDate.parse(ControllerCliente.clienteEditar.getDataNasc());
			DtDataNascimento.setValue(localdateNas);
			LocalDate localdatePrimCompr = LocalDate.parse(ControllerCliente.clienteEditar.getDataPriCom());
			DtDataPrim.setValue(localdatePrimCompr);

		}
	}

}
