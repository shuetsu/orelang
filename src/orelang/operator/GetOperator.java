package orelang.operator;

import java.util.List;

import orelang.Engine;

public class GetOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		return engine.getVariable((String)args.get(0));
	}
}
