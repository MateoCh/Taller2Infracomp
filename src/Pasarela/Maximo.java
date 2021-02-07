package Pasarela;

public class Maximo {
	
	private int cont, maximo, nThreads ;
	
	public Maximo (int numT) 
	{
		nThreads= numT ;
		maximo=	0 ;
		cont=0 ;
	}
	
	public int darMaximo()
	{
		return maximo;
	}
	
	public synchronized boolean anotar (int	n)
	{
		if (n> maximo) 
		{
			maximo = n ;
		}
		return (++cont == nThreads) ? true: false;
	}
}
