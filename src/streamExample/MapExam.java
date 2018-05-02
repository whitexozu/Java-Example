package streamExample;

import java.util.Arrays;
import java.util.List;
 
public class MapExam {
	public static void main(String[] args) {
		List<Student> student = Arrays.asList(new Student("Jack", 10), new Student("Jolie", 20), new Student("Smith", 30));
		student.stream()
			.mapToInt(Student::getScore)
			.forEach(score -> System.out.println(score));
	}
}

//출처: http://palpit.tistory.com/649 [palpit's log-b]
