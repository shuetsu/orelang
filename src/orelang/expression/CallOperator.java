package orelang.expression;

import java.util.List;

import orelang.Closure;
import orelang.Engine;

public class CallOperator implements IExpression {

	private Object operator;
	private List<?> args;
	
	public CallOperator(Object operator, List<?> args){
		this.operator = operator;
		this.args = args;
	}
	
	@Override
	public Object eval(Engine engine) {
		Closure closure = (Closure)engine.eval(operator);
		return closure.eval(args);
	}

}
