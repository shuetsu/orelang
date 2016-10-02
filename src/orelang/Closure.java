package orelang;

import java.util.List;

import orelang.operator.IOperator;

public class Closure {

	private Engine engine;
	private IOperator operator;
	
	public Closure(Engine engine, IOperator operator){
		this.engine = engine;
		this.operator = operator;
	}
	
	public Object eval(List<?> args){
		return operator.call(engine, args);
	}

}
