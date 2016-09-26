package orelang.operator;

import java.util.List;

import orelang.Engine;
import orelang.expression.IExpression;

public class GetOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<IExpression> args) {
		return engine.variables.get(args.get(0).eval(engine));
	}
}
