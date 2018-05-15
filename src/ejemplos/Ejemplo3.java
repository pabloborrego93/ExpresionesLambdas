package ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejemplo3 {

	private static List<LineaPedido> pedidos = new ArrayList<LineaPedido>(
		// Nombre Producto, Cantidad, Precio
		Arrays.asList(
			new LineaPedido("Galletas", 6, 0.75),
			new LineaPedido("Colacao", 1, 5.35),
			new LineaPedido("Leche", 3, 3.35),
			new LineaPedido("Azucar", 2, 1.24)
		)
	);
	
	public static Double avgExecutionTime(Runnable function) {
		Long TOTAL_EXECUTIONS = 1000000L;
		Double totalTimeExecution = 0D;
		for(int i = 0; i < TOTAL_EXECUTIONS; ++i) {
			Long tiempoInicio = System.nanoTime();
			function.run();
			totalTimeExecution += (System.nanoTime() - tiempoInicio);
		}
		return Double.valueOf(totalTimeExecution/TOTAL_EXECUTIONS)/1000;
	}
	
	public static Double calcularTotal(List<LineaPedido> pedidos) {
		return pedidos.stream().mapToDouble(lineaPedido -> lineaPedido.getPrecio() * lineaPedido.getCantidad()).sum();
	}
	
	public static void main(String[] args) {
		System.out.println(String.format("Total: %s ms", avgExecutionTime(() -> calcularTotal(pedidos))));
	}
	
}
