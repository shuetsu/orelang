package orelang.operator;

import java.util.List;

import orelang.Engine;

public class LambdaOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		int s = args.size();
		return new ProcOperator(args.subList(0, s - 1), args.get(s - 1), engine);
	}
}
