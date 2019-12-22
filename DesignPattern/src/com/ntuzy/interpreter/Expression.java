package com.ntuzy.interpreter;

import java.util.HashMap;

/**
 * 抽象类表达式 通过HashMap键值对 可以获取变量的值
 * 
 * @author Administrator
 *
 */
public abstract class Expression {
	// a + b - c
	// 解释公式和数值 key就是公式 参数 value就是具体的值
	// HashMap {a=10, b=20}
	public abstract int interpreter(HashMap<String, Integer> var);
}
