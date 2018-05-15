package ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Ejemplo2 {

	private static List<LineaPedido> pedidos = new ArrayList<LineaPedido>(
		// Nombre Producto, Cantidad, Precio
		Arrays.asList(
			new LineaPedido("Galletas", 6, 0.75),
			new LineaPedido("Colacao", 1, 5.35),
			new LineaPedido("Leche", 3, 3.35),
			new LineaPedido("Azucar", 2, 1.24)
		)
	);
	
	private static List<LineaPedido> pedidosUltimosTresDias = new ArrayList<LineaPedido>(
		// Nombre Producto, Cantidad, Precio
		Arrays.asList(
			new LineaPedido("Galletas", 6, 0.75),
			new LineaPedido("Galletas", 3, 0.75),
			new LineaPedido("Galletas", 10, 0.75),
			new LineaPedido("Colacao", 1, 5.35),
			new LineaPedido("Colacao", 3, 5.35),
			new LineaPedido("Colacao", 6, 5.35),
			new LineaPedido("Leche", 0, 3.35),
			new LineaPedido("Leche", 3, 3.35),
			new LineaPedido("Leche", 4, 3.35),
			new LineaPedido("Azucar", 7, 1.24),
			new LineaPedido("Azucar", 8, 1.24),
			new LineaPedido("Azucar", 2, 1.24)
		)
	);

	public static DoubleStream calcularTotal(List<LineaPedido> pedidos) {
		return pedidos.stream().mapToDouble(lp -> lp.getPrecio() * lp.getCantidad());
	}
	
	public static void main(String[] args) {

		System.out.println(String.format("Total: %s", calcularTotal(pedidos).sum()));
		System.out.println(String.format("Maximo: %s", calcularTotal(pedidos).max().getAsDouble()));
		System.out.println(String.format("Minimo: %s", calcularTotal(pedidos).min().getAsDouble()));
		System.out.println(String.format("Media: %s", calcularTotal(pedidos).average().getAsDouble()));
		
		
		List<LineaPedido> filtrado1 = pedidos
			.stream()
			.filter(p -> p.getPrecio() > 1)
			.sorted()
			.collect(Collectors.toList());
		System.out.println("Filtrado1: " +filtrado1);
		
		List<LineaPedido> filtrado2 = pedidos
			.stream()
			.distinct()
			.collect(Collectors.toList());
		System.out.println("Filtrado2: " +filtrado2);
		
		Map<String, Integer> filtrado3 = pedidosUltimosTresDias
			.stream()
			.collect(
				Collectors.groupingBy(
					LineaPedido::getProducto, 
					Collectors.summingInt(LineaPedido::getCantidad)
				)
			);
		System.out.println("Filtrado3: " +filtrado3);
		
	}
	
}
