package lambda;

import java.util.Arrays;
import java.util.List;

import java.util.function.Predicate;
import java.util.function.Consumer;

public class LambdaTest {
 
  public static void main(String[] args) {
      /*
       * Predicate
       * 문자열을 받아서 해당 문자열이 빈 문자열인지를 반환
       */
      String str = "asd";
      System.out.println(lambdaIsEqual(p->p.isEmpty(), str));
      
      /*
       * Cunsumer
       * 인수를 각각 +1 해줌.
       */
      List<Integer> list = Arrays.asList(1,2,3,4,5);
      lambdaProcessParam( (Integer c)->{
                                      list.set(c-1,c+1);
                                      } , list);
      System.out.println(Arrays.toString(list.toArray()));
      
      // /*
      //  * Function
      //  * 문자열 리스트를 받아서 각각의 문자열의 길이를 담은 리스트로 반환
      //  */
      // List<String> list2 = Arrays.asList("ab","cds","ewwqd","a");
      // List<Integer> result = lambdaConvertParam(list2, f->f.length());
      // System.out.println(Arrays.toString(result.toArray()));
      
      // /*
      //  * Supplier
      //  * 랜덤한 숫자를 반환한다.
      //  */
      // System.out.println(lambdaSupplier(()->{
      //     return (int)(Math.random()*10)+1;
      // }));
      
      // /*
      //  * UnaryOperator
      //  * 숫자 리스트를 받아 각 숫자에 +2한 값을 담은 리스트로 반환
      //  */
      // List<Integer> ele = Arrays.asList(1,2,3,4,5);
      // List<Integer> result2 = lambdaUnaryOper(ele, uo->uo+2);
      // System.out.println(Arrays.toString(result2.toArray()));
      
      // /*
      //  * BinaryOperator
      //  * 두개의 문자열을 받아서 공백을 기준으로 두개의 문자열을 합하여 반환
      //  */
      // String str1 = "yeoseong";
      // String str2 = "yoon";
      // System.out.println(lambdaBinaryOper(str1, str2, (bo1,bo2)->bo1+" "+bo2));
      
      // /*
      //  * 하나의 정수와 문자열을 입력받아 정수와 문자열의 길이가 같은지 검사
      //  */
      // System.out.println(lambdaBiPred(4, "yoon", (bp1,bp2)->bp1 == bp2.length()));
      
      // /*
      //  * 문자열 리스트에 인덱스한 숫자 번호를 붙여준다.
      //  */
      // List<String> list3 = Arrays.asList("a","b","c","d");
      // List<String> result4 = new ArrayList<>();
      // lambdaBiConsumer(result4,list3, ()->(int)(Math.random()*10)+1, (bc1,bc2)->{
      //     bc1 = bc1.concat("-"+bc2+"");
      //     result4.add(bc1);
      // });
      // System.out.println(Arrays.toString(result4.toArray()));
      
      // /*
      //  * lambda를 포함하면서 길이가 5이상인 문자열인가?
      //  */
      // System.out.println(lambdaPredAnd("It's lambda", (String p1)->p1.contains("lambda"), (String p2)->p2.length()>5));
      
      // /*
      //  * 숫자를 입력받아서 +1한 후에 *2를 수행한 숫자를 반환
      //  */
      // System.out.println(lambdaFuncAndThen(1, f1->f1+1, f2->f2*2));
  }
  
  /**
   * boolean Predicate<T>
   * 하나의 인수를 받아서 적절한 로직을 처리한 후에 boolean을 반환한다.
   */
  public static <T> boolean lambdaIsEqual(Predicate<T> predicate,T t) {
      return predicate.test(t);
  }
  
  /**
   * void Consumer<T>
   * 하나의 인수를 받아서 인수를 소모한후 void를 반환.
   */
  public static <T> void lambdaProcessParam(Consumer<T> consumer,List<T> list) {
      list.forEach(e->consumer.accept(e));
  }
  
  // /**
  //  * R Function<T>
  //  * <T,R>의 인수를 받아서 T타입을 R타입으로 변환후 반환한다.
  //  */
  // public static <T,R> List<R> lambdaConvertParam(List<T> list, Function<T, R> f) {
  //     List<R> result = new ArrayList<>();
  //     list.forEach(c->{
  //         result.add(f.apply(c));
  //     });
  //     return result;
  // }
  
  // /**
  //  * T Supplier
  //  * 매개변수는 없고 T타입을 반환한다.
  //  * @return 
  //  */
  // public static <T> T lambdaSupplier(Supplier<T> s) {
  //     return s.get();
  // }
  // /**
  //  * T타입의 매개변수를 받아 같은 타입의 T타입의 값을 반환
  //  */
  // public static <T> List<T> lambdaUnaryOper(List<T> list,UnaryOperator<T> uo){
  //     List<T> result = new ArrayList<>();
  //     list.forEach(c->{
  //         result.add(uo.apply(c));
  //     });
  //     return result;
  // }
  
  // /**
  //  * T타입의 매개변수를 2개 받아서, T타입의 값으로 반환
  //  */
  // public static <T> T lambdaBinaryOper(T a,T b,BinaryOperator<T> bo) {
  //     return bo.apply(a, b);
  // }
  
  // /**
  //  * T,R타입의 매개변수를 받아서 boolean 값을 반환
  //  */
  // public static <T,R> boolean lambdaBiPred(T t,R r,BiPredicate<T, R> bp) {
  //     return bp.test(t, r);
  // }
  
  // /**
  //  * T,R타입의 매개변수를 받아서 적절한 처리를 한다. void 반환
  //  */
  // public static <T,R> void lambdaBiConsumer(List<T> result,List<T> t , Supplier<R> r , BiConsumer<T, R> bc) {
  //     t.forEach(c->{
  //         bc.accept(c,r.get());
  //     });
  // }
  
  // /**
  //  * Predicate and/or/negate
  //  * 두개 이상의 Predicate를 and로 묶을 수 있다.
  //  */
  // public static <T> boolean lambdaPredAnd(T t,Predicate<T> p1,Predicate<T> p2) {
  //     return p1.and(p2).test(t);
  // }
  
  // /**
  //  * Function andThen,compose
  //  * andThen a.andThen(b) a를 먼저 수행한 결과를 b의 함수의 입력으로 가져간다.
  //  * compose a.compose(b) b를 먼저 수행한 결과를 a의 함수의 입력으로 가져간다.
  //  */
  // public static <T> T lambdaFuncAndThen(T t, Function<T, T> f1, Function<T, T> f2) {
  //     return f1.andThen(f2).apply(t);
  // }
}