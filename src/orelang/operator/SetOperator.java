package orelang.operator;

import java.util.List;

import orelang.Evaluator;
import orelang.expression.IExpression;

public class SetOperator implements IOperator {
	@Override
	public Object call(Evaluator evaluator, List<IExpression> args) {
		Object value = args.get(1).eval(evaluator);
		evaluator.variables.put((String)args.get(0).eval(evaluator), value);
		return value;
	}
}
