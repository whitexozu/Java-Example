package streamExample;

import java.util.Arrays;
import java.util.stream.IntStream;
 
public class AsDoubleStreamAndBoxedExam {
 
    public static void main(String[] args) {
        int[] intArr = {10, 20, 30, 40, 50, 60};
        
        IntStream intStream = Arrays.stream(intArr);
        intStream.asDoubleStream()
            .forEach(d -> System.out.println(d));
        
        System.out.println();
        
        intStream = Arrays.stream(intArr);
        intStream.boxed()
            .forEach(obj -> System.out.println(obj.intValue()));
        
        
    }
 
}


//출처: http://palpit.tistory.com/649 [palpit's log-b]