package ejemplos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Ejemplo1 {
	
	public static ExecutorService newFixedThreadPool(int nThreads) {
		return new ThreadPoolExecutor(
			nThreads, nThreads,
			0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>()
		);
	}
	
	public static Integer random(Integer limiteSuperior) {
		return (int) (Math.random()*limiteSuperior);
	}
	
	public static final Integer NUM_HILOS = 4;
	public static final Integer NUM_TAREAS = NUM_HILOS*4;
	
	public static void main(String[] args) {
		
		ExecutorService executor = newFixedThreadPool(NUM_HILOS);
		
		for(int i = 1; i <= NUM_TAREAS; ++i) {
			
			// Ejemplo sin lambdas
//			executor.submit(new Runnable() {
//				@Override
//				public void run() {
//					try { Thread.sleep(random(2000)); } catch (InterruptedException e) {}
//					System.out.println(String.format("Ejecutandome en el hilo [%s]", Thread.currentThread().getName()));
//				}
//			});
			
			// Ejemplo con lambdas
			executor.submit(() -> {
				try { Thread.sleep(random(2000)); } catch (InterruptedException e) {}
				System.out.println(String.format("Ejecutandome en el hilo [%s]", Thread.currentThread().getName()));
			});
			
		}
		
		executor.shutdown();
		
		while(!executor.isTerminated()) {};
		
		System.out.println("Fin");
	}

}
