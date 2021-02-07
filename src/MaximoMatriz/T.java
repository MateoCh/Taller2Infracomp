package MaximoMatriz;

import java.util.concurrent.ThreadLocalRandom;

public class T extends Thread
{
	private static Identificar objId ;
	private static Maximo	m ;
	private final static int DIM = 3;
	private static int [][] mat = new int[DIM][DIM];
	private final static int INT_MAX = 105345;
	
	public void run ()
	{
		int locMax	=	0 ;
		int id	= objId.darNumId () ;
		for (int j=0; j <mat[id].length ; j++) 
		{
			if (mat[id][j] > locMax) 
			{
				locMax	= mat[id][j] ;
			}
		}
		if (m.anotar(locMax))
		{
			System.out.println("Max:" +m.darMaximo ()) ;			
		}
	}
	public static void main (String[] args) 
	{
		int	n= DIM ;
		crearMatriz(); 
		objId= new Identificar () ;
		m	= new Maximo (n) ;
		for (int i=0;i<	n; i++)
		{
			new T().start() ;
		}
	}
	
	public static void crearMatriz() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				mat[i][j] = ThreadLocalRandom.current().nextInt(0,INT_MAX);
			}
		}
		
		System.out.println("Matriz:");
		System.out.println("=========================");
		imprimirMatriz();
	}
	
	private static void imprimirMatriz() {
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
}
