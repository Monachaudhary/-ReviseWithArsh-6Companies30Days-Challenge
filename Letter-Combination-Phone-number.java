class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        String [] map = {"abc", "def","ghi","jkl","mno","pqrs","tuv", "wxyz"};
        List<String> answer = new ArrayList<>();
        backtrack("", digits, map, answer);
        return answer;        
    }
    private void backtrack(String combination, String next_digit, String[]map, List<String> answer){
        if(next_digit.isEmpty()){
            answer.add(combination);
            return;
        }
        String letters = map[next_digit.charAt(0)-'2'];
        for(char letter: letters.toCharArray()){
            backtrack(combination + letter, next_digit.substring(1), map, answer);
        }
    }
}
