package orelang.operator;

import java.util.List;

import orelang.Engine;

public class PrintOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		Object value = engine.eval(args.get(0)).toString();
		System.out.println(value);
		return value;
	}
}
