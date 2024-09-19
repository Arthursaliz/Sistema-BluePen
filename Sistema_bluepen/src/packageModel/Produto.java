package packageModel;

public class Produto {

	private String IdProduto;
	private String Nome;
	private String Codigo;
	private String Estoque;
	private String PrecoUnit;
	private String TipoUnit;
	private String DataFab;
	private String DataVal;
	
	public Produto() {
		super();
	}

	public Produto(String idProduto, String nome, String codigo, String estoque, String precoUnitario, String tipoUni,
			String dataFab, String dataVal) {
		super();
		IdProduto = idProduto;
		Nome = nome;
		Codigo = codigo;
		Estoque = estoque;
		PrecoUnit = precoUnitario;
		TipoUnit = tipoUni;
		DataFab = dataFab;
		DataVal = dataVal;
	}

	public String getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(String idProduto) {
		IdProduto = idProduto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getEstoque() {
		return Estoque;
	}

	public void setEstoque(String estoque) {
		Estoque = estoque;
	}

	public String getPrecoUnit() {
		return PrecoUnit;
	}

	public void setPrecoUnit(String precoUnitario) {
		PrecoUnit = precoUnitario;
	}

	public String getTipoUnit() {
		return TipoUnit;
	}

	public void setTipoUnit(String tipoUni) {
		TipoUnit = tipoUni;
	}

	public String getDataFab() {
		return DataFab;
	}

	public void setDataFab(String dataFab) {
		DataFab = dataFab;
	}

	public String getDataVal() {
		return DataVal;
	}

	public void setDataVal(String dataVal) {
		DataVal = dataVal;
	}
	
	
}
