package Pasarela;

public class Persona extends Thread
{
	private int id;
	private int ref;
	private static Pasarela p= new Pasarela();
	
	public Persona(int pid)
	{
		id=pid;
	}
	
	public void run()
	{
		boolean der=id%2==0;
		p.entrar(der);
	}
}
