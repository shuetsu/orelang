package orelang.operator;

import java.util.List;

import orelang.Evaluator;
import orelang.expression.IExpression;

public class GetOperator implements IOperator {
	@Override
	public Object call(Evaluator evaluator, List<IExpression> args) {
		return evaluator.variables.get(args.get(0).eval(evaluator));
	}
}
