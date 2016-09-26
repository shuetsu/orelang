package orelang.expression;

import java.util.List;

import orelang.Evaluator;
import orelang.operator.IOperator;

public class CallOperator implements IExpression {

	private IOperator operator;
	private List<IExpression> args;
	
	public CallOperator(IOperator operator, List<IExpression> args){
		this.operator = operator;
		this.args = args;
	}
	
	@Override
	public Object eval(Evaluator evaluator) {
		return operator.call(evaluator, args);
	}

}
