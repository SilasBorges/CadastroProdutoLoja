package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

	private Date dataProducao;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ProdutoUsado() {
		super();
	}


	public ProdutoUsado(String nome, Double preco, Date dataProducao) {
		super(nome, preco);
		this.dataProducao = dataProducao;
	}

	public Date getDataProducao() {
		return dataProducao;
	}

	public void setDataProducao(Date dataProducao) {
		this.dataProducao = dataProducao;
	}
	
	@Override
	public String etiquetaPreco() {
		
		return getNome() + "(usado) $ " + String.format("%.2f", getPreco()) + " (Data de fabricação: " + sdf.format(dataProducao) + ")";
		
	}
	
}