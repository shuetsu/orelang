package orelang.operator;

import java.util.List;

import orelang.Engine;

public class UntilOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		Object retVal = null;
		while(!(boolean)engine.eval(args.get(0))){
			retVal = engine.eval(args.get(1));
		}
		return retVal;
	}
}
