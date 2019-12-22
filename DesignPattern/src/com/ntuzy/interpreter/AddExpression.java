package com.ntuzy.interpreter;

import java.util.HashMap;

/**
 *
 * @author Administrator
 *
 */
public class AddExpression extends SymbolExpression  {

	public AddExpression(Expression left, Expression right) {
		super(left, right);
	}

	public int interpreter(HashMap<String, Integer> var) {
		//super.left.interpreter(var) 返回left 表达式返回值 a = 10
		//super.right.interpreter(var): 返回right 表达式对应值 b = 20
		return super.left.interpreter(var) + super.right.interpreter(var);
	}
}
