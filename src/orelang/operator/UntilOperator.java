package orelang.operator;

import java.util.List;

import orelang.Engine;
import orelang.expression.IExpression;

public class UntilOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<IExpression> args) {
		Object retVal = null;
		while(!(boolean)args.get(0).eval(engine)){
			retVal = args.get(1).eval(engine);
		}
		return retVal;
	}
}
