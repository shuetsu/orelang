package orelang.expression;

import java.util.List;

import orelang.Engine;
import orelang.operator.IOperator;

public class CallOperator implements IExpression {

	private Object operator;
	private List<?> args;
	
	public CallOperator(Object operator, List<?> args){
		this.operator = operator;
		this.args = args;
	}
	
	@Override
	public Object eval(Engine engine) {
		IOperator op = (IOperator)engine.eval(operator);
		return op.call(engine, args);
	}

}
