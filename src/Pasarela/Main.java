package Pasarela;

public class Main 
{
	private static int max=10;
	public static void main(String args[])
	{
		for(int i=0;i<max;i++)
		{
			new Persona(i).start();
		}
	}
}
