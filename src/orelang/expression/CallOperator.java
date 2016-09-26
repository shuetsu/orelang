package orelang.expression;

import java.util.List;

import orelang.Engine;
import orelang.operator.IOperator;

public class CallOperator implements IExpression {

	private IOperator operator;
	private List<IExpression> args;
	
	public CallOperator(IOperator operator, List<IExpression> args){
		this.operator = operator;
		this.args = args;
	}
	
	@Override
	public Object eval(Engine engine) {
		return operator.call(engine, args);
	}

}
