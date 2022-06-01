package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class _220601 {

    public String solution(String sentence) {
        StringBuilder answerList = new StringBuilder();
        LinkedHashMap<Character, ArrayList<Integer>> lowerCount = new LinkedHashMap<>();
        String invalid = "invalid";
        try {
            int size = sentence.length();

            //소문자의 종류와 각 종류 별로 위치 파악
            for(int i=0; i<size; i++){
                char c = sentence.charAt(i);

                if(Character.isLowerCase(c)){
                    if(!lowerCount.containsKey(c)){
                        lowerCount.put(c, new ArrayList<Integer>());
                    }
                    lowerCount.get(c).add(i);
                }
            }

            int stringIdx = 0;
            int startChar, endChar;
            int lastStartChar = -1, lastEndChar = -1;
            int startWord = 0, endWord = 0;
            int lastStartWord= -1, lastEndWord = -1;
            int count, distance;
            int rule = 0;

            ArrayList<Integer> temp;
            for(char c : lowerCount.keySet()){
                temp = lowerCount.get(c);
                // HaEaLaLaO인 경우, c=a일 때,
                // temp = [1,3,5,7]
                count = temp.size();
                startChar = temp.get(0);
                endChar = temp.get(count-1);

                //HaEaLaLaO , CbAbR
                if(count == 1 || count >= 3){ // 1개 → AbA , 3개 이상 → AbAbAb
                    for(int i=1; i<count; i++){
                        // 간격이 2를 넘어가면 CbbA같은 경우로 x
                        if(temp.get(i) - temp.get(i-1) != 2) return invalid;
                    }
                    rule = 1;
                }

                else if (count == 2){ // CbSb 나 bCSb 일지도?
                    distance = endChar - startChar;
                    // distance=2가 나오는 경우 CbSb => 3-1
                    if(distance == 2 && (endChar < lastEndChar && startChar > lastStartChar)){
                        rule = 1;
                    }
                    // distance>=2 나오는 경우 bCSb => 3-0=3
                    else if(distance >= 2){
                        rule = 2;
                    }
                    //소문자 연속은 x
                    else return invalid;
                }

                // 예외 거르기
                if(rule == 1){
                    //기호 위치에서 앞뒤로 한칸씩
                    startWord = startChar -1;
                    endWord = endChar+1;

                    //이전 단어 안에 포함되어 있는 경우 ex.HaEaLaLaOWaOaRaLaD
                    if(lastStartWord < startWord && lastEndWord > endWord){
                        //규칙 2 아니면 안됨
                        if(startChar - lastStartChar  == 2 && lastEndChar - endChar == 2){
                            continue;
                        }
                        else return invalid;
                    }
                }

                else if (rule == 2){
                    startWord = startChar;
                    endWord = endChar;
                    //규칙 2는 중복되면 안됨
                    if(lastStartWord < startWord && lastEndWord > endWord) return invalid;
                }

                if(lastEndWord >= startWord) return  invalid;

                //소문자 등장 이전에 존재하던 앞의 단어 추가
                if(stringIdx < startWord){
                    answerList.append(makeWord(sentence,stringIdx,startWord-1));
                    answerList.append(" ");
                }
                
                answerList.append(makeWord(sentence,startWord,endWord));
                answerList.append(" ");
                lastStartWord = startWord;
                lastEndWord = endWord;
                lastStartChar = startChar;
                lastEndChar = endChar;
                stringIdx = endWord+1;
            }
            //뒤에 남는 단어들도 더하기
            if(stringIdx < size){
                answerList.append(makeWord(sentence,stringIdx,size-1));
            }
        }
        catch (Exception e){
            return invalid;
        }
        return answerList.toString().trim();
    }

    public String makeWord(String sentence, int start, int end){
        String word = sentence.substring(start, end+1);
        return word.replaceAll("[a-z]","");
    }

    public static void main(String[] args) {
        _220601 test = new _220601();

        test.solution("HaEaLaLaObWORLDb");
    }
}
