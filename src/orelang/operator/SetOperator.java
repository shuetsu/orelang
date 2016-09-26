package orelang.operator;

import java.util.List;

import orelang.Engine;

public class SetOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		Object value = engine.eval(args.get(1));
		engine.variables.put((String)engine.eval(args.get(0)), value);
		return value;
	}
}
