import java.util.Stack;
import java.util.ArrayList;
import java.util.logging.Logger;

/*
 * Дана строка содержащая последовательность логически верно открывающихся и закрывающихся скобок.
 * Требуется написать метод, удаляющий крайние скобки и выводящий при этом логически 
 * правильное выражение.
 * Пример 1: Ввод: s = "(()())(())" Вывод: "()()()”
 * Пример 2: Ввод: s = "()()" Вывод: ""
 */

public class Task2HM {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        String s = "(()())(())";
        ArrayList<Character> result = getCorrectBrackets(s);
        if (result.isEmpty()) {
            logger.info(String.format("Result: %s", result.toString()));
        } else {
            result.remove(0);
            StringBuffer resString = new StringBuffer();
            for (Character item : result) {
                resString.append(item);
            }
            logger.info(String.format("Result: %s", resString.toString()));
        }
    }
    public static ArrayList<Character> getCorrectBrackets(String str) {
        boolean isDoubled;           
        Stack<Character> stack = new Stack<>();
        stack.push(' ');
        isDoubled = false;
        ArrayList<Character> resList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    if (stack.peek() == ' ') {
                        stack.push(str.charAt(i));
                        break;
                    } else if (stack.peek() == '(') {
                        isDoubled = true;
                        break;
                    } else if (stack.peek() == ')') {
                        stack.push(str.charAt(i));
                        break;
                    }
                case ')':
                    if (stack.peek() == '(') {
                        stack.push(str.charAt(i));
                        break;
                    }        
            } 
        }
        if (!isDoubled) {
            resList.clear();
            System.out.println(resList);
            return resList;
        }
        resList.addAll(stack);
        return resList;
    }
}