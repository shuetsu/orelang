package orelang.operator;

import java.util.List;

import orelang.Engine;
import orelang.expression.IExpression;

public class SetOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<IExpression> args) {
		Object value = args.get(1).eval(engine);
		engine.variables.put((String)args.get(0).eval(engine), value);
		return value;
	}
}
