package ProdConsSemSync;

// Mantém o número inteiro compartilhado que é acessado por
// um thread produtor e um thread consumidor via métodos set e get
public class UnsynchronizedBuffer implements Buffer {
	// valor compartilhado entre os threads produtor e consumidor. Valor
	// inicializado com –1, que será usado quando o consumidor tentar
	// consumir um valor antes dele ser produzido pelo produtor
	private int buffer = -1;
	private boolean occupied = false;
	// coloca o valor no buffer
	public synchronized void set(int value) throws InterruptedException
	{
		//enquanto buffer estiver com um valor, a thread do produtor irá dormir.
		while(occupied){
			System.out.println("Produtor tentou escrever...");
			System.out.println("Produtor indo dormir...");
			wait();
		}
		
		
		
		buffer = value;
		System.out.printf("Produtor escreveu\t%2d", value);
		//buffer ocupado pelo valor produzido
		occupied = true;
		notifyAll();
		
	}
	
	// retorna valor do buffer
	public synchronized int get() throws InterruptedException
	{
		
		//enquanto não houver um valor na thread, não há nada para ser consumido, logo a thread do consumidor vai para a espera.
		while(!occupied) {
			System.out.println("Consumidor tentou ler...");
			System.out.println("Consumidor indo dormir...");
			wait();
		}
		occupied = false;
		System.out.printf("Consumidor leu\t\t%2d", buffer);
		notifyAll();
		return buffer;
		
	}
}
