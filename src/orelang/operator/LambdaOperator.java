package orelang.operator;

import java.util.List;

import orelang.Engine;

public class LambdaOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		return new ProcOperator((List<?>)args.get(0), args.get(1));
	}
}
