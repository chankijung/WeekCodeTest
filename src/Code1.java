import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public int solution(int n) {
    int[] intArray = new int[n];

    //에라토스테네스의 체
    //소수를 판별할때 소수가 아닌것들을 배제하는 방식

    for (int i = 2; i < n; i++) {
      intArray[i] = 1;
    }

    for (int i = 2; i <=(int)Math.sqrt(n); i++) {
      //일반적으로 특정 조건을 만족하는 경우 특정 반복을 건너 뛰고자 할 때 사용
      // 여기서는 intArray[i]==0인 경우들을 제외하기 위해 continue
      if(intArray[i]==0) continue;
      int num = i * 2;

      while (num < n) {
        intArray[num] = 0;
        num += i;
      }
    }

    return Arrays.stream(intArray).sum();
  }
}

class Solution2{
  public int solution(String[] names){

    //중복 제거는 set 사용!!
    Set<String> set= new HashSet<>(Arrays.asList(names));
    int n= set.size();
    int m=4;

    // n C 4 계산
    long numerator=1;
    long denominator=1;
    for (int i = 0; i < m; i++) {
      numerator *= n-i;
      denominator *= (i+1);
    }
    return (int) (numerator/denominator);
  }
}
public class Main {

  public static void main(String[] args) {


//    int n=7;
//    Solution sol = new Solution();
//    int result= sol.solution(n);

    String[] names={"제로", "베이스","자바","스쿨","자바","베이스","베이스","백엔드","화이팅"};

    System.out.println(new Solution2().solution(names));
  }
}