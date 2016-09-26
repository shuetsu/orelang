package orelang.operator;

import java.util.List;

import orelang.Evaluator;
import orelang.expression.IExpression;

public class StepOperator implements IOperator {
	@Override
	public Object call(Evaluator evaluator, List<IExpression> args) {
		Object retVal = null;
		for(IExpression arg: args){
			retVal = arg.eval(evaluator);
		}
		return retVal;
	}
}
