package com.ntuzy.interpreter;

import java.util.HashMap;

/**
 * 抽象运算符号解释器 每个运算符号斗志和自己作用后两个数字有关系
 *  但是左右两个数字可能也是一个解析的结果 无论何种类型 都是Expression类的实现类
 * @author Administrator
 */
public class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    // 因为是让其子类实现因此interpreter是默认实现
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        // TODO Auto-generated method stub
        return 0;
    }
}
