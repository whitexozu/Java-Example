/* 
https://galid1.tistory.com/509
https://coding-start.tistory.com/131

*/

package lambda;

public class BasicUsage 
{
  public static void main(final String[] args) {
    // Calculator cal = (int num1, int num2) -> {
    //   return num1 + num2;
    // };
    // System.out.println(cal.cal(1, 2));

    // cal = (num1, num2) -> { return num1 + num2; };        
    // System.out.println(cal.cal(1, 2));

    final Calculator cal = () -> { System.out.println("매개변수가 없는 경우"); };
    cal.noarg();
  }
}
