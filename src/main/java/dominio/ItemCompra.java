package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_itemcompra")
public class ItemCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codItemCompra;
	private Double desconto;
	private Double preco;
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name="compra")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="produto")
	private Produto produto;
	
	

	public ItemCompra() {

	}

	public ItemCompra(Integer codItemCompra, Double desconto, Double preco, Integer quantidade, Compra compra,
			Produto produto) {
		super();
		this.codItemCompra = codItemCompra;
		this.desconto = desconto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.compra = compra;
		this.produto = produto;
	}

	public Integer getCodItemCompra() {
		return codItemCompra;
	}

	public void setCodItemCompra(Integer codItemCompra) {
		this.codItemCompra = codItemCompra;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItemCompra [codItemCompra=" + codItemCompra + ", desconto=" + desconto + ", preco=" + preco
				+ ", quantidade=" + quantidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItemCompra == null) ? 0 : codItemCompra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompra other = (ItemCompra) obj;
		if (codItemCompra == null) {
			if (other.codItemCompra != null)
				return false;
		} else if (!codItemCompra.equals(other.codItemCompra))
			return false;
		return true;
	}

	public double getSubTotal() {
		return (preco - desconto) * quantidade;
	}

}
