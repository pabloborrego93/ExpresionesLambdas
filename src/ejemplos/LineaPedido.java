package ejemplos;

import java.io.Serializable;

public class LineaPedido implements Serializable, Comparable<LineaPedido> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6191880816334889373L;

	private String producto;
	
	private Integer cantidad;
	
	private Double precio;

	public LineaPedido() {
		super();
	}

	public LineaPedido(String producto, Integer cantidad, Double precio) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return String.format("(Nombre: %s, Cantidad: %s, Precio: %s)", producto, cantidad, precio);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		LineaPedido other = (LineaPedido) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

	@Override
	public int compareTo(LineaPedido lp) {
		return this.precio.compareTo(lp.getPrecio());
	}
	
}
