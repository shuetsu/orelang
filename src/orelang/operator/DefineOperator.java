package orelang.operator;

import java.util.List;

import orelang.Engine;

public class DefineOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		return engine.defineVariable(
				(String)args.get(0), 
				engine.eval(args.get(1)));
	}
}
