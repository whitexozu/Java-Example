package streamExample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
 
public class SortingExam {
 
    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[] {9, 6, 11, 2, 3});
        intStream
            .sorted()
            .forEach(n -> System.out.print(n + ", "));
        
        System.out.println();
        
        List<Student> studentList = Arrays.asList(
                new Student("Jack", 80),
                new Student("John", 100),
                new Student("Andy", 99),
                new Student("Jolie", 70)
        );
        
        studentList.stream()
            .sorted()
            .forEach(s -> System.out.print(s.getScore() + ", "));
        
        System.out.println();
        
        studentList.stream()
            .sorted( Comparator.reverseOrder())
            .forEach(s -> System.out.print(s.getScore() + ", "));
    }
 
}

// 출처: http://palpit.tistory.com/649 [palpit's log-b]