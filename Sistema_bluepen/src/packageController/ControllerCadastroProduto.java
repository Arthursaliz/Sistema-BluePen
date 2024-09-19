   package packageController;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import packageControle.ProdutoDAO;
import packageModel.Produto;

public class ControllerCadastroProduto implements Initializable {

	@FXML
	private DatePicker DtDataValidade;

	@FXML
	private DatePicker DtFabricacao;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnCliente;

	@FXML
	private Button btnFornecedor;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnMudarHome;

	@FXML
	private Button btnMudarProdutos;

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
	private TextField txtTipo;

	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtFornecedor;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtPrecoUnitario;

	@FXML
	private TextField txtEstoque;

	@FXML
	void btnCancelar(ActionEvent event) {
		txtNome.setText("");
		txtCodigo.setText("");
		DtDataValidade.setValue(null);
		DtFabricacao.setValue(null);
		txtEstoque.setText("");
		txtPrecoUnitario.setText("");
		txtTipo.setText("");
		ControllerTelaProduto.produtoEditar = null;

		Stage stage = (Stage) btnCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnSalvar(ActionEvent event) {

		if (ControllerTelaProduto.produtoEditar == null) {
			Produto produto = new Produto();
			produto.setNome(txtNome.getText());
			produto.setCodigo(txtCodigo.getText());
			produto.setTipoUnit(txtTipo.getText());
			produto.setDataFab(DtFabricacao.getValue().toString());
			produto.setDataVal(DtDataValidade.getValue().toString());
			produto.setPrecoUnit(txtPrecoUnitario.getText());
			produto.setEstoque(txtEstoque.getText());
			ProdutoDAO prod = new ProdutoDAO();
			prod.create(produto);

			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();

		} else {

			Produto produto = new Produto();
			produto.setNome(txtNome.getText());
			produto.setCodigo(txtCodigo.getText());
			produto.setTipoUnit(txtTipo.getText());
			produto.setDataFab(DtFabricacao.getValue().toString());
			produto.setDataVal(DtDataValidade.getValue().toString());
			produto.setPrecoUnit(txtPrecoUnitario.getText());
			produto.setEstoque(txtEstoque.getText());
			ProdutoDAO prod = new ProdutoDAO();
			prod.update(produto);
			Stage stage = (Stage) btnCancelar.getScene().getWindow();
			stage.close();
		}
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		if (ControllerTelaProduto.produtoEditar != null) {
			txtNome.setText(ControllerTelaProduto.produtoEditar.getNome());
			txtCodigo.setText(ControllerTelaProduto.produtoEditar.getCodigo());
			txtEstoque.setText(ControllerTelaProduto.produtoEditar.getEstoque());
			txtPrecoUnitario.setText(ControllerTelaProduto.produtoEditar.getPrecoUnit());
			txtTipo.setText(ControllerTelaProduto.produtoEditar.getTipoUnit());
			LocalDate localdateFab = LocalDate.parse(ControllerTelaProduto.produtoEditar.getDataVal());
			LocalDate localdateVal = LocalDate.parse(ControllerTelaProduto.produtoEditar.getDataFab());
			DtDataValidade.setValue(localdateVal);
			DtFabricacao.setValue(localdateFab);
			
		}else {
			
		}

	}

}
