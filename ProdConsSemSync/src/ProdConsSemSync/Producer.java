package ProdConsSemSync;

import java.util.Random;

public class Producer implements Runnable {
	private final static Random generator = new Random();
	private final Buffer sharedLocation; // refer�ncia ao objeto compartilhado
	
	public Producer(Buffer shared)
	{
		sharedLocation = shared;
	}
	
	// armazena valores de 1 a 10 no atributo sharedLocation
	public void run()
	{
		int sum = 0;
		
		for(int count = 1; count <= 10; count++)
		{
			// dorme de 0 a 3 segundos e ent�o armazena valor no Buffer
			try
			{
				Thread.sleep(generator.nextInt(3000)); // valor aleat�rio
				sharedLocation.set(count); 			   // armazena valor no buffer
				sum += count; 						   // incrementa soma de valores
				System.out.printf("\t%2d\n", sum);
			}
			catch(InterruptedException exception)
			{
				// se thread for interrompida enquanto estiver dormindo
				exception.printStackTrace();
			}
		}
		
		System.out.println("Produtor encerrou a produ��o\nTerminando thread Producer");
	}
}
