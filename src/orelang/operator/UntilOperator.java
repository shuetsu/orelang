package orelang.operator;

import java.util.List;

import orelang.Evaluator;
import orelang.expression.IExpression;

public class UntilOperator implements IOperator {
	@Override
	public Object call(Evaluator evaluator, List<IExpression> args) {
		Object retVal = null;
		while(!(boolean)args.get(0).eval(evaluator)){
			retVal = args.get(1).eval(evaluator);
		}
		return retVal;
	}
}
