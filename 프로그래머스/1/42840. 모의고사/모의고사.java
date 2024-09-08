import java.util.*;

    class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = {0, 0, 0}; // 1번, 2번, 3번 수포자의 점수
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supo1[(i % supo1.length)]) 
            scores[0]++;
            if (answers[i] == supo2[(i % supo2.length)]) 
            scores[1]++;
            if (answers[i] == supo3[(i % supo3.length)]) 
            scores[2]++;
        }
        int maxScores = Math.max(scores[0], Math.max(scores[1], scores[2]));
        // Math.max()가 파라미터를 2개 밖에 못 받아서 이렇게 하는 것
        
        ArrayList<Integer> results = new ArrayList<>();
        
        if (maxScores == scores[0]) results.add(1);
        if (maxScores == scores[1]) results.add(2);
        if (maxScores == scores[2]) results.add(3);
        
        // 클래스의 반환값이 배열이라서, 리스트를 배열로 바꿔줌
        int[] resultsArray = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultsArray[i] = results.get(i);
        }
        
        return resultsArray;
      
    }
}