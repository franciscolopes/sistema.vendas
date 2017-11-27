package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_compra")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCompra;
	private Date horarioCompra;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy="compra")
	private List<ItemCompra> itensCompra;

	public Compra() {
		this.itensCompra = new ArrayList<ItemCompra>();
	}

	public Compra(Integer codCompra, Date horarioCompra, Usuario usuario) {
		super();
		this.codCompra = codCompra;
		this.horarioCompra = horarioCompra;
		this.usuario = usuario;
		this.itensCompra = new ArrayList<ItemCompra>();
	}

	public Integer getCodCompra() {
		return codCompra;
	}

	public void setCodCompra(Integer codCompra) {
		this.codCompra = codCompra;
	}

	public Date getHorarioCompra() {
		return horarioCompra;
	}

	public void setHorarioCompra(Date horarioCompra) {
		this.horarioCompra = horarioCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItemCompra> getItensCompra() {
		return itensCompra;
	}

	public void setItensCompra(List<ItemCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}

	public void addItemCompra(ItemCompra x) {
		this.itensCompra.add(x);
		x.setCompra(this);
	}

	public void removeItemCompra(ItemCompra x) {
		this.itensCompra.remove(x);
	}

	@Override
	public String toString() {
		return "Compra [codCompra=" + codCompra + ", horarioCompra=" + horarioCompra + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCompra == null) ? 0 : codCompra.hashCode());
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
		Compra other = (Compra) obj;
		if (codCompra == null) {
			if (other.codCompra != null)
				return false;
		} else if (!codCompra.equals(other.codCompra))
			return false;
		return true;
	}

	public double getPreçoTotal() {
		double soma = 0.0;
		for (ItemCompra iC : itensCompra) {
			soma = soma + iC.getSubTotal();
		}
		return soma;
	}

}
