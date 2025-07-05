function solution(s){
    let balance = 0; // 괄호의 균형을 추적하는 변수

    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            balance++; // 여는 괄호를 만나면 balance 증가
        } else if (s[i] === ')') {
            balance--; // 닫는 괄호를 만나면 balance 감소
        }
        if (balance < 0) {
            return false;
        }
    }
    return balance === 0;
}