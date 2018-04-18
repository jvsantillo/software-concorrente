package ProdConsSemSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest {

	public static void main( String[] args )
	{
		// cria novo pool de thread pool com dois threads
		ExecutorService application = Executors.newCachedThreadPool();
		
		// cria UnsynchronizedBuffer para armazenar inteiros
		Buffer sharedLocation = new UnsynchronizedBuffer();
		
		System.out.println(
					"A��o\t\t\tValor\tSoma dos Produzidos\tSoma dos Consumidos");
		System.out.println(
					"------\t\t\t-----\t-------------------\t-------------------");
		
		// executa o produtor e consumidor, dando a cada um deles
		// acesso � vari�vel sharedLocation
		application.execute(new Producer(sharedLocation));
		application.execute(new Consumer(sharedLocation));
		
		application.shutdown(); // termina a aplica��o quando as tarefas completarem
	}
}
