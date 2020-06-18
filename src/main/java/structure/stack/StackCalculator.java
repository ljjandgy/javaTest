package structure.stack;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author ljj
 * @version sprint 23
 * @className StackCalculator
 * @description 用栈实现计算器
 * @date 2020-06-18 19:07:43
 */
public class StackCalculator {
    private ArrayCalculatorStack numStack = new ArrayCalculatorStack(40);
    private ArrayCalculatorStack operatorStack = new ArrayCalculatorStack(20);

    /**
     * 对表达式进行求值
     * @param expression 计算表达式
     * @return
     */
    public double calculateValue(String expression){
        int index = 0;
        String num = "";
        while (index!=expression.length()){
            char str = expression.charAt(index++);
            //当不是运算符时
            if (isOperator(str)){
                numStack.push(Double.parseDouble(num));
                //先操作操作符
                if (operatorStack.isNull()){
                    operatorStack.push(str);
                }else{
                    //当栈中的操作符优先级大于等于当前操作符时，就从数栈中弹出两个数，从符号栈中弹出一个符号进行计算，然后把计算的值存入数栈中
                    if (getOpPriority(operatorStack.peer().toString().charAt(0))>=getOpPriority(str)){
                        calculate();
                        operatorStack.push(str);
                    }else{
                        //当前符号优先级大于符号栈中优先级时，就直接入栈即可
                        operatorStack.push(str);
                    }
                }
                num = "";
            }else{
                num =num+str;
            }
        }
        //最后个数入栈
        numStack.push(Double.parseDouble(num));
        //对栈中剩下的数据进行计算，直到数栈中只剩下一个数，就是结果
        while (numStack.getSize()>1){
            calculate();
        }
        return Double.parseDouble(numStack.peer().toString());
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

    /**
     * 计算值
     */
    private void calculate(){
        double num = 0.0d;
        //数栈出两个数
        double num1 = Double.parseDouble(numStack.pop().toString());
        double num2 = Double.parseDouble(numStack.pop().toString());
        //符号栈出一个符号
        char operator = operatorStack.pop().toString().charAt(0);
        switch (operator){
            case '*':
                num = num1*num2;
                break;
            case '/':
                num = num2/num1;
                break;
            case '+':
                num = num1+num2;
                break;
            case '-':
                num = num2-num1;
                break;
            default:
                break;
        }
        //把计算结果入栈
        numStack.push(num);
    }

    /**
     * 检验是否是数字
     * @return true：是数字
     */
    private boolean isOperator(char obj){
        if ('*'==obj||'/'==obj||'+'==obj||'-'==obj){
            return true;
        }
        return false;
    }
}

class ArrayCalculatorStack{
    //栈顶指针,顺序存储里面，序号就代表的是相应的对象。链式存储就不行
    private int top=-1;
    //栈本身
    private Object[] stack;
    //栈的最大容量
    private int maxStackSize;

    public ArrayCalculatorStack(int maxStackSize){
        this.stack = new Object[maxStackSize];
        this.maxStackSize = maxStackSize;
    }

    /**
     * 入栈
     * @param obj 加入栈的对象
     */
    public void push(Object obj){
        if (isFull()){
            throw new IllegalArgumentException("栈已满，不能入栈");
        }
        //先移动栈顶指针
        top++;
        //然后保存对象
        stack[top] = obj;
    }

    /**
     * 出栈
     * @return 栈顶对象
     */
    public Object pop(){
        if (isNull()){
            throw new NullPointerException("栈为空，不能出栈");
        }
        Object temp = stack[top];
        stack[top] = null;
        top--;
        return temp;
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素
     */
    public Object peer(){
        return stack[top];
    }
    /**
     * 遍历栈
     */
    public void list(){
        if (isNull()){
            System.out.println("栈为空~~");
            return;
        }
        for (int i =0;i<=top; ++i){
            System.out.println(stack[i].toString());
        }
    }
    /**
     * 判断栈是否为空
     * @return true：空
     */
    public boolean isNull(){
        return top == -1;
    }

    /**
     * 判断栈是否已满
     * @return true：已满
     */
    public boolean isFull(){
        return top == maxStackSize - 1;
    }

    public long getSize(){
        return Stream.of(stack).filter(Objects::nonNull).count();
    }
}

class StackCalculatorTest{
    public static void main(String[] args) {
        StackCalculator stackCalculator = new StackCalculator();

        String expression = "55.2+33.2*20*15-13/12";
        System.out.println(stackCalculator.calculateValue(expression));
    }

}
