package orelang.operator;

import java.util.List;

import orelang.Engine;
import orelang.expression.IExpression;

public class EqualOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<IExpression> args) {
		return args.get(0).eval(engine).equals(args.get(1).eval(engine));
	}
}
