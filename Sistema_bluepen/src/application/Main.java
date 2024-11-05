package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stage;
	private static Scene Login;
	private static Scene Home;
	private static Scene RegistrarVenda;

	private static Scene Vendedor;
	private static Scene Cliente;
	private static Scene Fornecedor;
	private static Scene Produto;
	private static Scene RelatorioVenda;

	private static Scene CadastroVendedor;
	private static Scene CadastroCliente;
	private static Scene CadastroFornecedor;
	private static Scene CadastroProduto;

	private static Stage CadProduto;
	private static Stage RegistroVenda;
	private static Stage RegistroFornecedor;
	private static Stage CadVendedor;

	@Override
	public void start(Stage primaryStage) {
		try {

			stage = primaryStage;
			primaryStage.setTitle("Bluen Pen");

			// INICIAL
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/packageView/ViewLogin.fxml"));
			Login = new Scene(fxmlLogin);

			// HOME
//			Parent fxmlHome = FXMLLoader.load(getClass().getResource("/packageView/ViewMain.fxml"));
//			Home = new Scene(fxmlHome);

			Parent fxmlRelatorioVenda = FXMLLoader.load(getClass().getResource("/packageView/ViewRelatorio.fxml"));
			RelatorioVenda = new Scene(fxmlRelatorioVenda);

			// CLIENTE
			Parent fxmlCliente = FXMLLoader.load(getClass().getResource("/packageView/ViewTelaCliente.fxml"));
			Cliente = new Scene(fxmlCliente);

			Parent fxmlCadastroCliente = FXMLLoader
					.load(getClass().getResource("/packageView/ViewCadastroCliente.fxml"));
			CadastroCliente = new Scene(fxmlCadastroCliente);

			// VENDEDOR
			Parent fxmVendedor = FXMLLoader.load(getClass().getResource("/packageView/ViewTelaVendedor.fxml"));
			Vendedor = new Scene(fxmVendedor);

			Parent fxmCadastroVendedor = FXMLLoader
					.load(getClass().getResource("/packageView/ViewCadastroVendedor.fxml"));
			CadastroVendedor = new Scene(fxmCadastroVendedor);

			// PRODUTO
			Parent fxmlProduto = FXMLLoader.load(getClass().getResource("/packageView/ViewTelaProduto.fxml"));
			Produto = new Scene(fxmlProduto);

			Parent fxmlCadastroProduto = FXMLLoader
					.load(getClass().getResource("/packageView/ViewCadastroProduto.fxml"));
			CadastroProduto = new Scene(fxmlCadastroProduto);

			// FORNECEDOR
			Parent fxmFornecedor = FXMLLoader.load(getClass().getResource("/packageView/ViewTelaFornecedor.fxml"));
			Fornecedor = new Scene(fxmFornecedor);

			Parent fxmlCadastroFornecedor = FXMLLoader
					.load(getClass().getResource("/packageView/ViewCadastroFornecedor.fxml"));
			CadastroFornecedor = new Scene(fxmlCadastroFornecedor);

			// REGISTRAR VENDA
			Parent fxmlRegistrarVenda = FXMLLoader.load(getClass().getResource("/packageView/ViewRegistrarVenda.fxml"));
			RegistrarVenda = new Scene(fxmlRegistrarVenda);

			stage.getIcons().add(new Image(getClass().getResourceAsStream("/packageMedias/ICONE.png")));		
			primaryStage.setScene(Login);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void changeScreen(String tela) {

		if (tela.equals("Login")) {
			stage.setScene(Login);
			stage.centerOnScreen();
		} else if (tela.equals("main")) {
			stage.setScene(Home);
			stage.centerOnScreen();
		} else if (tela.equals("Cliente")) {
			stage.setScene(Cliente);
			stage.centerOnScreen();
		} else if (tela.equals("Cadastro cliente")) {
			stage.setScene(CadastroCliente);
			stage.centerOnScreen();
		} else if (tela.equals("Vendedor")) {
			stage.setScene(Vendedor);
			stage.centerOnScreen();
		} else if (tela.equals("Cadastro vendedor")) {
			stage.setScene(CadastroVendedor);
			stage.centerOnScreen();
		} else if (tela.equals("Produto")) {
			stage.setScene(Produto);
			stage.centerOnScreen();
		} else if (tela.equals("Cadastro de produto")) {
			stage.setScene(CadastroProduto);
			stage.centerOnScreen();
		} else if (tela.equals("Fornecedor")) {
			stage.setScene(Fornecedor);
			stage.centerOnScreen();
		} else if (tela.equals("Cadastro de fornecedor")) {
			stage.setScene(CadastroFornecedor);
			stage.centerOnScreen();
		} else if (tela.equals("Registrar venda")) {
			stage.setScene(RegistrarVenda);
			stage.centerOnScreen();
		} else if (tela.equals("Relátorio de vendas")) {
			stage.setScene(RelatorioVenda);
			stage.centerOnScreen();
		}
	}

	public static void TelaHome() throws IOException {
		
		FXMLLoader fxmlHome = new FXMLLoader();
		fxmlHome.setLocation(Main.class.getResource("/packageView/ViewMain.fxml"));
		Parent TelaHOme = fxmlHome.load();
		Home = new Scene(TelaHOme);
		stage.setScene(Home);
		stage.setResizable(false);
		stage.show();
		
	}
	public static void TelaCadastroPro() throws IOException {
		FXMLLoader ProdutoCadastro = new FXMLLoader();
		ProdutoCadastro.setLocation(Main.class.getResource("/packageView/ViewCadastroProduto.fxml"));
		Parent cadastroProd = ProdutoCadastro.load();
		Scene scene1 = new Scene(cadastroProd);

		CadProduto = new Stage();
		CadProduto.setTitle("Cadastro / Edição de produtos - BLUE PEN");
		CadProduto.initModality(Modality.WINDOW_MODAL);
		CadProduto.setScene(scene1);
		CadProduto.centerOnScreen();
		CadProduto.setResizable(false);
		CadProduto.showAndWait();

	}
	
	public static void TelaCadastroVendedor() throws IOException {
		FXMLLoader VendedorCadastrado = new FXMLLoader();
		VendedorCadastrado.setLocation(Main.class.getResource("/packageView/ViewCadastroVendedor.fxml"));
		Parent cadastroVend = VendedorCadastrado.load();
		Scene scene6 = new Scene(cadastroVend);

		CadVendedor = new Stage();
		CadVendedor.setTitle("Cadastro / Edição de vendedor - BLUE PEN");
		CadVendedor.initModality(Modality.WINDOW_MODAL);
		CadVendedor.setScene(scene6);
		CadVendedor.centerOnScreen();
		CadVendedor.setResizable(false);
		CadVendedor.showAndWait();
		

	}

	public static void TelaCadastroCliente() throws IOException {
		FXMLLoader CadastroCliente = new FXMLLoader();
		CadastroCliente.setLocation(Main.class.getResource("/packageView/ViewCadastroCliente.fxml"));
		Parent cadastroCli = CadastroCliente.load();
		Scene scene2 = new Scene(cadastroCli);

		CadProduto = new Stage();
		CadProduto.setTitle("Cadastro / Edição de clientes - BLUE PEN");
		CadProduto.initModality(Modality.WINDOW_MODAL);
		CadProduto.setScene(scene2);
		CadProduto.centerOnScreen();
		CadProduto.setResizable(false);
		CadProduto.showAndWait();

	}

	public static void TelaRegistroVenda() throws IOException {
		FXMLLoader RegistrarVenda = new FXMLLoader();
		RegistrarVenda.setLocation(Main.class.getResource("/packageView/ViewRegistrarVenda.fxml"));
		Parent registrarVenda = RegistrarVenda.load();
		Scene scene3 = new Scene(registrarVenda);

		RegistroVenda = new Stage();
		RegistroVenda.setTitle("Registro de venda - BLUE PEN");
		RegistroVenda.initModality(Modality.WINDOW_MODAL);
		RegistroVenda.setScene(scene3);
		RegistroVenda.centerOnScreen();
		RegistroVenda.setResizable(false);
		RegistroVenda.showAndWait();

	}
	
	public static void TelaFornecedor() throws IOException {
		FXMLLoader RegistrarFornecedor = new FXMLLoader();
		RegistrarFornecedor.setLocation(Main.class.getResource("/packageView/ViewCadastroFornecedor.fxml"));
		Parent registrarFornecedor = RegistrarFornecedor.load();
		Scene scene4 = new Scene(registrarFornecedor);

		RegistroFornecedor = new Stage();
		RegistroFornecedor.setTitle("Registro de Fornecedor - BLUE PEN");
		RegistroFornecedor.initModality(Modality.WINDOW_MODAL);
		RegistroFornecedor.setScene(scene4);
		RegistroFornecedor.centerOnScreen();
		RegistroFornecedor.setResizable(false);
		RegistroFornecedor.showAndWait();

	}
	

	public static void main(String[] args) {
		launch(args);

	}
}




//---------------------------------------------------------------------

//Connection con = ConnectionDatabase.getConnection();
//ConnectionDatabase.closeConnection(con);
//
////-------------------------------------------
////TESTES: 	
//
//ArrayList<Vendedor> Vendedor = new ArrayList<>();
//VendedorDAO v = new VendedorDAO();
//Vendedor ven = new Vendedor();
//
//////INSERIDO 
//ven.setNome("Railson");
//ven.setCPF("123456789");
//ven.setEmail("railson@email.com");
//ven.setTelefone("63991111111");
//ven.setDatNasc("2004-01-01");
//ven.setDataCont("2024-05-01");
//ven.setTotalVend("1000");		
//ven.setEndereco("Ipês II");
//
//v.create(ven);
//////UPDATE
//ven.setIdVendedor("1000");
//ven.setNome("Tayla Lima");
//ven.setCPF("987654321");
//ven.setEmail("tayla@email.com");
//ven.setTelefone("63991195874");
//ven.setDatNasc("2007-06-04");
//ven.setDataCont("2024-01-1");
//ven.setTotalVend("50");		
//ven.setEndereco("Ipês II");
//
//v.update(ven);
//
//////DELETE
//
//
////RESULTADO 
//Vendedor = v.read();
//for (int i = 0; i < Vendedor.size(); i++) {
//	Vendedor vende = Vendedor.get(i);
//	System.out.println();
//	System.out.print(vende.getIdVendedor()+ "| ");
//	System.out.print(vende.getNome() + "| ");
//	System.out.print(vende.getCPF() + "| ");
//	System.out.print(vende.getEmail() + "| ");
//	System.out.print(vende.getTelefone() + "| ");
//	System.out.print(vende.getDatNasc() + "| ");
//	System.out.print(vende.getDataCont() + "| ");
//	System.out.print(vende.getTotalVend() + "| ");
//	System.out.print(vende.getEndereco() + "| ");
//
//}

//-------------- COMPRA ----------------
//INSERINDO VALORES NA TABELA COMPRA ↓↓		

//ArrayList<Compra> Compra = new ArrayList<>();
//CompraDAO c = new CompraDAO();
//Compra cra = new Compra();
//
////INSERINDO INFORMAÇÕES NA TABELA
//cra.setIdCliente("5");
//cra.setIdVendendor("1000");
//cra.setIdProduto("112");
//cra.setQuantidade("10");
//cra.setPrecoTotal("149.99");
//
//c.create(cra); // INSERIR INFORMA
//
//Compra = c.read();
//for (int i=0;i < Compra.size(); i++) {
//	Compra com = Compra.get(i);
//	System.out.println();
//	System.out.print(com.getIdCompra()+ "| ");
//	System.out.print(com.getIdCliente()+ "| ");
//	System.out.print(com.getIdVendendor()+ "| ");
//	System.out.print(com.getIdProduto()+ "| ");
//	System.out.print(com.getQuantidade()+ "| ");
//	System.out.print(com.getPrecoTotal()+ "| ");
//	
//}

//UPDATE
//ArrayList<Compra> Compra = new ArrayList<>();
//CompraDAO c = new CompraDAO();
//Compra cra = new Compra();
//
//cra.setIdCompra("1342");
//cra.setIdCliente("5");
//cra.setIdVendendor("1000");
//cra.setIdProduto("112");
//cra.setQuantidade("1");
//cra.setPrecoTotal("14.99");
//
//c.update(cra); // ATUALIZAR INFORMAÇÃO
//
//Compra = c.read();
//for (int i = 0; i < Compra.size(); i++) {
//	Compra com = Compra.get(i);
//	System.out.println();
//	System.out.print(com.getIdCompra() + "| ");
//	System.out.print(com.getIdCliente() + "| ");
//	System.out.print(com.getIdVendendor() + "| ");
//	System.out.print(com.getIdProduto() + "| ");
//	System.out.print(com.getQuantidade() + "| ");
//	System.out.print(com.getPrecoTotal() + "| ");
//
//}

//DELETE ↓
//c.delete("1342"); // ATUALIZAR INFORMAÇÃO

//--------------- FORNECEDOR -------------------

//ArrayList<Fornecedor> Fornecedor = new ArrayList<>();
//FornecedorDAO f = new FornecedorDAO();
//Fornecedor fra = new Fornecedor();

////INSERIDO 
//fra.setNome("Google");
//fra.setCNPJ("198468468");
//fra.setEmail("contacte@google.com");
//fra.setTelefone("63999888888");
//fra.setEndereco("345S BL 44 - CAROLINA DO NORTE ");
//
//f.create(fra);
//UPDATE
//fra.setIdFornecedor("1");
//fra.setNome("Apple USA");
//fra.setCNPJ("1547785694");
//fra.setEmail("apple.com");
//fra.setTelefone("63999999999");
//fra.setEndereco("405S BL 21 - CAROLINA DO NORTE ");
//
//f.update(fra);

//DELETE
//f.delete("2");
//
////RESULTADO 
//Fornecedor = f.read();
//for (int i = 0; i < Fornecedor.size(); i++) {
//	Fornecedor forn = Fornecedor.get(i);
//	System.out.println();
//	System.out.print(forn.getIdFornecedor() + "| ");
//	System.out.print(forn.getNome() + "| ");
//	System.out.print(forn.getCNPJ() + "| ");
//	System.out.print(forn.getEmail() + "| ");
//	System.out.print(forn.getTelefone() + "| ");
//	System.out.print(forn.getEndereco() + "| ");
//
//}

//---------------- CLIENTE -------------------

//		ArrayList<Cliente> cliente = new ArrayList<>();
//		ClienteDAO c = new ClienteDAO();
//		c.delete("18411478912");
//		
//		Cliente cl = new Cliente();
//		cl.setNome("Luiz Morcovix");
//		cl.setCPF_CNPJ("18411478912");
//		cl.setEmail("pedro@email.com");
//		cl.setTelefone("63 999999999");
//		cl.setDataNasc("1970-04-11");
//		cl.setDataPriCom("2024-08-08");
//		cl.setEndereco("rua tal, numero tal");
//		cl.setTipoJur("PF");
//		c.update(cl);
//		cliente = c.read();
//		for (int i=0;i < cliente.size(); i++) {
//			Cliente clt = cliente.get(i);
//			System.out.println();
//			System.out.print(clt.getIdCliente()+ "| ");
//			System.out.print(clt.getNome()+ "| ");
//			System.out.print(clt.getCPF_CNPJ()+ "| ");
//			System.out.print(clt.getEmail()+ "| ");
//			System.out.print(clt.getTelefone()+ "| ");
//			System.out.print(clt.getDataNasc()+ "| ");
//			System.out.print(clt.getDataPriCom()+ "| ");
//			System.out.print(clt.getEndereco()+ "| ");
//			System.out.print(clt.getTipoJur()+ "| ");
//			
//		}
//		
//		System.out.println(cliente);