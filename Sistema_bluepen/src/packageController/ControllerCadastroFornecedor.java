package packageController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.FornecedorDAO;
import packageModel.Fornecedor;

public class ControllerCadastroFornecedor implements Initializable{

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnFornecedor;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMudarFornecedor;

    @FXML
    private Button btnMudarHome;

    @FXML
    private Button btnPaginaInicial;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnRegistrarVenda;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVendedor;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPesquisarProduto1112;

    @FXML
    private TextField txtTelefone;
    
    private ObservableList<Fornecedor> ArrayFornecedor;
	private static FornecedorDAO Fornecedor = new FornecedorDAO();
	public static Fornecedor FornecedorEditar = new Fornecedor();

    @FXML
    void btnCancelar(ActionEvent event) {
    	txtNome.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		txtCNPJ.setText("");
		txtEmail.setText("");
		ControllerCadastroFornecedor.FornecedorEditar = null;

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
    }

    @FXML
    void btnSalvar(ActionEvent event) {
    	if (ControllerTelaFornecedor.FornecedorEditar == null) {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome(txtNome.getText());
			fornecedor.setEndereco(txtEndereco.getText());
			fornecedor.setTelefone(txtTelefone.getText());
			fornecedor.setCNPJ(txtCNPJ.getText());
			fornecedor.setEmail(txtEmail.getText());
			FornecedorDAO forn = new FornecedorDAO();
			forn.create(fornecedor);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();

		} else {
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome(txtNome.getText());
			fornecedor.setEndereco(txtEndereco.getText());
			fornecedor.setTelefone(txtTelefone.getText());
			fornecedor.setCNPJ(txtCNPJ.getText());
			fornecedor.setEmail(txtEmail.getText());

			FornecedorDAO forn = new FornecedorDAO();
			forn.update(fornecedor);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (ControllerTelaFornecedor.FornecedorEditar != null) {
			txtNome.setText(ControllerTelaFornecedor.FornecedorEditar.getNome());
			txtEndereco.setText(ControllerTelaFornecedor.FornecedorEditar.getEndereco());
			txtTelefone.setText(ControllerTelaFornecedor.FornecedorEditar.getTelefone());
			txtCNPJ.setText(ControllerTelaFornecedor.FornecedorEditar.getCNPJ());
			txtEmail.setText(ControllerTelaFornecedor.FornecedorEditar.getEmail());
		}
		
	}

}
