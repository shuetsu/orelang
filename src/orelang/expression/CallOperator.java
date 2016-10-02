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
		return getOperator(engine, engine.eval(operator)).call(engine, args);
	}

	private IOperator getOperator(Engine engine, Object op){
		if (op instanceof IOperator){
			return (IOperator)op;
		}else if (engine.operators.containsKey(op)){
			return engine.operators.get(op);
		}
		throw new RuntimeException("Unknown operator: " + op.toString());
	}
}
