package structure.stack;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author ljj
 * @version sprint 24
 * @className TransNifixExpressionToPostfixExpression
 * @description 中缀表达式转后缀表达式
 * @date 2020-07-21 19:51:14
 */
public class TransNifixExpressionToPostfixExpression {
    /**
     * 中缀表达式转后缀表达式
     * @param nifixExpression 中缀表达式
     * @return 后缀表达式
     */
    public String doTransfer(String nifixExpression){
        if (StringUtils.isEmpty(nifixExpression)){
            throw new NullPointerException("中缀表达式为空");
        }
        //创建s1栈，用于存放运算符
        Stack<Character> s1 = new Stack<>();
        //创建s2栈，用于存放中间结果
        Stack<Character> s2 = new Stack<>();
        nifixExpression = nifixExpression.replaceAll("\\s+","");
        //把表达式拆分成单个字符放入数组
        for (int i = 0; i < nifixExpression.length(); i++) {
            char expressionChar = nifixExpression.charAt(i);
            //当字符为数字时，直接入s2栈
            if (Pattern.matches("\\d+",String.valueOf(expressionChar))){
                s2.push(expressionChar);
            }else{
                //括号处理
                if ('('==expressionChar){
                    s1.push(expressionChar);
                    continue;
                }else if (')'==expressionChar){
                    while (true){
                        Character topChar = s1.pop();
                        if (topChar=='('){
                            break;
                        }
                        s2.push(topChar);
                    }
                    continue;
                }
                //当字符为符号时，就需要和s1栈的栈顶元素进行优先级对比了
                //当符号栈为空，或者
                if (s1.empty()||'('==s1.peek()){
                    s1.push(expressionChar);
                }else if(checkPriority(expressionChar,s1.peek())){
                    //当自身优先级大于等于s1的栈顶字符时，就直接入栈
                    s1.push(expressionChar);
                }else{
                    while (!s1.empty()&&!checkPriority(expressionChar,s1.peek())){
                        //把s1优先级高的出栈，入s2栈
                        s2.push(s1.pop());
                    }
                    s1.push(expressionChar);
                }
            }
        }
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.toString().replace("[","").replace("]","").replaceAll("\\,","");
    }

    private boolean checkPriority(Character char1,Character char2){
        int priority1 = getOpPriority(char1);
        int priority2 = getOpPriority(char2);
        //优先级高，直接插入
        return priority1 >= priority2;
    }

    /**
     * 获取操作符合的优先级
     * @return
     */
    private int getOpPriority(char operator){
        if ('*'==operator||'/'==operator){
            return 1;
        }else if('+'==operator||'-'==operator){
            return 0;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        TransNifixExpressionToPostfixExpression expressionToPostfixExpression = new TransNifixExpressionToPostfixExpression();
        System.out.println(expressionToPostfixExpression.doTransfer("(3+5)*6-4"));
    }
}
