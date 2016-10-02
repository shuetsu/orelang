package orelang.expression;

import java.util.List;

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
		Object op = engine.eval(operator);
		if (engine.operators.containsKey(op)){
			return engine.operators.get(op).call(engine, args);
		}
		throw new RuntimeException("Unknown operator: " + op.toString());
	}

}
