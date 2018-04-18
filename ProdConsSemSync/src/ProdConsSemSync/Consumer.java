package ProdConsSemSync;

import java.util.Random;

public class Consumer implements Runnable {
	private final static Random generator = new Random();
	private final Buffer sharedLocation; // refer�ncia ao objeto compartilhado
	
	public Consumer(Buffer shared)
	{
		sharedLocation = shared;
	}
	
	// l� os valores armazenados em sharedLocation 10 vezes e soma os valores
	public void run()
	{
		int sum = 0;
		
		for(int count = 1; count <= 10; count++)
		{
			// dorme de 0 a 3 segundos e ent�o l� um valor do Buffer
			try
			{
				Thread.sleep(generator.nextInt(3000)); // valor aleat�rio
				sum += sharedLocation.get(); 		// l� e soma valor do buffer
				System.out.printf("\t\t\t\t%2d\n", sum);
			}
			catch(InterruptedException exception)
			{
				// se thread for interrompida enquanto estiver dormindo
				exception.printStackTrace();
			}
		}
		
		System.out.printf("\n%s %d\n%s\n",
				"Consumidor leu os valores totalizando", sum, "Terminando thread Consumer");
	}
}
