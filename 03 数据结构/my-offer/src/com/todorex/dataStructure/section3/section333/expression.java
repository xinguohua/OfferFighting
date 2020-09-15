package com.todorex.dataStructure.section3.section333;



import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class expression {
    static int MAXOP=100; //操作数序列可能的最大长度
    static double INFINITY=1E+9; //操作数序列可能的最大长度
    static int start=0;
    static String[] str=new String[MAXOP];

    enum Type
    {
        num,opr,end;
    }

    public static void main(String[] args) {
//        char[] Expr=new char[MAXOP];
        String[] Expr=new String[]{"1.2", "1.3","+","jieshu"};
        double v = PostfixExp(Expr);
        if (v<INFINITY)
            System.out.println(v);
        else
            System.out.println("表达式错误");

    }



    private static double PostfixExp(String[] Expr) {
        //调用GetOp函数读入后缀表达式并求值
        double Op1,Op2=0;
        Type T;

        //申请一个新栈
        Stack<Double> S = new Stack<>();


        while ((T=GetOp(Expr,start,str))!=Type.end){
            //当未读到输入结束时
            if(T==Type.num)
                S.push(Double.valueOf(str[0])); //当读入一个运算数 压入栈
            else{
                //当读入的是个运算符 弹出操作数Op2、Op1
                if (!S.empty())
                    Op2=S.pop(); //运算符 弹出适量的运算数
                else
                    Op2=INFINITY;
                if (!S.empty())
                    Op1=S.pop(); //运算符 弹出适量的运算数
                else
                    Op1=INFINITY;
                //判断读到的操作符 为什么是str[0]???????????????????????????
                switch (str[0]){
                    case "+":S.push(Op1+Op2); break;
                    case "*":S.push(Op1*Op2); break;
                    case "-":S.push(Op1-Op2); break;
                    case "/":
                        if (Op2!=0.0)  //检查除法的分母是否为0
                            S.push(Op1/Op2);
                        else{
                            System.out.println("错误:除法分母为0");
                            Op2=INFINITY;
                        }
                        break;
                    default:
                        System.out.println("错误:未知运算符！");
                        Op2=INFINITY;
                        break;
                }
                if (Op2>=INFINITY) break;
            }
        }
        if (Op2<INFINITY)  //处理完表达式
            if (!S.empty())  //此时堆栈正常
                Op2=S.pop();    //取出计算结果
            else Op2=INFINITY;  //否则标记错误

        return Op2;

    }

    private static Type GetOp(String[] expr, int start, String[] str) {
        //从start开始读入下一个对象（操作符或运算符），并保存在字符串str中
        //跳过表达式前空格
        if ( expr[start].equals(" "))
            start++;
        str[0]=expr[start];
            start++;


        //读到结束
        if (str[0].equals("jieshu"))
            return Type.end;
        else if (isNumeric(str[0])) //取出两个操作数
            return  Type.num;
        else
            return Type.opr;
    }

    public static boolean isNumeric(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }

        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
