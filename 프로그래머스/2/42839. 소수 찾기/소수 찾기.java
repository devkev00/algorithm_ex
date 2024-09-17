import java.util.*;

class Solution {
    
    public boolean isPrime(int num) {
        if (num < 2) return false;

        for(int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public void makePermutation(String str, String current, boolean[] used, Set<Integer> result) {
        if (!current.isEmpty()){
            result.add(Integer.parseInt(current));
             // 빈 문자열이 아닌 경우에만 추가
        }
       
        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) { // used[i]가 true가 아닌 경우
                used[i] = true;
                makePermutation(str, current + str.charAt(i), used, result);
                //charAt(i) -> 문자열의 i번째 문자를 반환
                used[i] = false;
            }
        } 
    }
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] used = new boolean[numbers.length()];
        // boolean 배열은 처음 선언하면 자동으로 false로 초기화됨
        
        Set<Integer> combinations = new HashSet<>();
        
        makePermutation(numbers, "", used, combinations);
                
        for (int num : combinations) {
            
            String numStr = String.valueOf(num);
            if (numStr.startsWith("0")) continue;
            
            if (num != 0 && isPrime(num)) {
                answer++;
            } 
        }
        return answer;
    }
}