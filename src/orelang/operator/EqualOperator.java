package orelang.operator;

import java.util.List;

import orelang.Engine;

public class EqualOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		return engine.eval(args.get(0)).equals(engine.eval(args.get(1)));
	}
}
