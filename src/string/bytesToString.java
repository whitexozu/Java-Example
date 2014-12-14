package string;

public class bytesToString {

	public static void main(String[] args) {

        
        byte[] byteArray = new byte[] {87, 79, 87, 46, 46, 46};
        
        System.out.println(byteArray);
        
        String value = new String(byteArray);
        
        System.out.println(value);
        
        System.out.println(value.getBytes());
        
        byte[] temp = value.getBytes();
        
        System.out.println(new String(temp));
    }
}
