package orelang.operator;

import java.util.List;

import orelang.Evaluator;
import orelang.expression.IExpression;

public class EqualOperator implements IOperator {
	@Override
	public Object call(Evaluator evaluator, List<IExpression> args) {
		return args.get(0).eval(evaluator).equals(args.get(1).eval(evaluator));
	}
}
