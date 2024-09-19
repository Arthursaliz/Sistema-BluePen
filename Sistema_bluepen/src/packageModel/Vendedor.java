package packageModel;

public class Vendedor {

	private String IdVendedor;
	private String Nome;
	private String CPF;
	private String Email;
	private String Telefone;
	private String DatNasc;
	private String DataCont;
	private String TotalVend;
	private String Endereco;
	private String Password;
	
	public Vendedor() {
		super();
	}

	public Vendedor(String idVendedor, String nome, String cPF, String email, String telefone, String datNasc,
			String dataCont, String totalVend, String endereco, String password) {
		super();
		IdVendedor = idVendedor;
		Nome = nome;
		CPF = cPF;
		Email = email;
		Telefone = telefone;
		DatNasc = datNasc;
		DataCont = dataCont;
		TotalVend = totalVend;
		Endereco = endereco;
		Password = password;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getIdVendedor() {
		return IdVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		IdVendedor = idVendedor;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getDatNasc() {
		return DatNasc;
	}

	public void setDatNasc(String datNasc) {
		DatNasc = datNasc;
	}

	public String getDataCont() {
		return DataCont;
	}

	public void setDataCont(String dataCont) {
		DataCont = dataCont;
	}

	public String getTotalVend() {
		return TotalVend;
	}

	public void setTotalVend(String totalVend) {
		TotalVend = totalVend;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	
	
	
}
