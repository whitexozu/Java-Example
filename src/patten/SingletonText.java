package patten;

public class SingletonText {

	public static void main(String[] args) {
		System.out.println("Singleton pattern");
		Singleton sg1 = Singleton.getInstance();
		Singleton sg2 = Singleton.getInstance();

		if (sg1 == sg2)
		{
			System.out.println("Equal");
		}
		else
		{
			System.out.println("Not Equal");
		}
	}
}
