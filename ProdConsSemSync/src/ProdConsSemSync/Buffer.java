package ProdConsSemSync;

// especifica métodos chamados pelo produtor e consumidor
public interface Buffer {
	// coloca valor inteiro no Buffer
	public void set( int value ) throws InterruptedException;

	// retorna valor inteiro do Buffer
	public int get() throws InterruptedException;
}
