package packageController;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import packageControle.VendedorDAO;
import packageModel.Vendedor;

public class ControllerLogin {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;
    
    @FXML
    private ToggleButton VerSenha;
    
    @FXML
    private TextField txtSenha;

    VendedorDAO v = new VendedorDAO();
    static Vendedor vendedor = new Vendedor();
    @FXML
    void btnButtonLogin(ActionEvent event) throws IOException {
    	txtPassword.setVisible(true);
    	
    	vendedor = v.autenticarUser(txtUser.getText(), txtPassword.getText());
    	
    	if(vendedor.getPassword()!=null && vendedor.getCPF()!=null ) {
    		Alert saudacao = new Alert(AlertType.CONFIRMATION);
    		saudacao.setHeaderText("Saudações");
    		saudacao.setTitle("Bem vindo!");
    		saudacao.setContentText("Seja bem vindo de volta " + vendedor.getNome()+"!");
    		saudacao.show();
    		txtUser.setText("");
    		txtPassword.setText("");
			//Main.changeScreen("main");
			
//			Stage stage = (Stage) btnLogin.getScene().getWindow();
//			stage.close();
			Main.TelaHome();

			
    	}else {
    		Alert erro = new Alert(Alert.AlertType.ERROR);
    		erro.setTitle("Falha ao realizar o login!");
    		erro.setHeaderText("Erro!");
    		erro.setContentText("Usuario ou senha incorretos! Verifique as informações e tente novamente.");
    		erro.show();
    	}
    	
    }
  
    @FXML
    void visualizarSenha(ActionEvent event) {
    	if(VerSenha.isSelected()) {
    		txtSenha.setText(txtPassword.getText());
    		txtPassword.setVisible(false);
    		txtSenha.setVisible(true);
    		txtSenha.setEditable(true);
    	}else {
    		txtPassword.setText(txtSenha.getText());
    		txtPassword.setVisible(true);
    		txtSenha.setVisible(false);
    	}
    }
    
}
