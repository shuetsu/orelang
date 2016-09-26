package orelang.operator;

import java.util.List;

import orelang.Engine;
import orelang.expression.IExpression;

public class StepOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<IExpression> args) {
		Object retVal = null;
		for(IExpression arg: args){
			retVal = arg.eval(engine);
		}
		return retVal;
	}
}
