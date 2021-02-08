package Pasarela;

public class Pasarela
{
	// TODO: Se puede usar un objeto de una clase en general como monitor.
	//	     No obstante, para este tipo de casos con un Object miObjeto es mas claro.
	//		 Lo acabo de ejecutar con algunos casos y al ver la traza, lo veo bien.
	private static Maximo sema=new Maximo(5);

	private int nDer=0;
	private int nIzq=0;

	public void entrar(boolean der)
	{
		if(der)
		{
			// TODO: No es claro, cuando der == true, el sentido es Derecha-Izquierda ?
			//		 Supongo que es de Derecha a Izquierda
			while(nIzq!=0) // Estan entrando los de la izquierda (eso entiendo)
			{
				try
				{
					synchronized(sema) {
					sema.wait();}
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized(sema) {
			nDer++;
			System.out.println("der: "+nDer);}
			caminar(der);
		}
		else
		{
			while(nDer!=0)
			{
				try 
				{
					synchronized(sema) {
					sema.wait();}
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized(sema) {
			nIzq++;
			System.out.println("izq: "+nDer);}
			caminar(der);
			
		}
	}
	
	public void caminar(boolean der)
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salir(der);
	}
	
	public void salir(boolean der)
	{
		if(der)
		{
			synchronized(sema) {
			nDer--;}
			System.out.println("saliendo der");
			if(nDer==0)
			{
				System.out.println("Fin der");
				synchronized(sema) {
				sema.notifyAll();}
			}
		}
		else
		{
			synchronized(sema) {
			nIzq--;}
			System.out.println("saliendo izq");
			if(nIzq==0)
			{
				System.out.println("Fin izq");
				synchronized(sema) {
				sema.notifyAll();}
			}
		}
	}
}
