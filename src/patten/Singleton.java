package patten;

public class Singleton {

	private static Singleton singleton = new Singleton();

	protected Singleton()
	{
		System.out.println("Maked Singleton");
	}

	public static Singleton getInstance()
	{
		return singleton;
	}
}
