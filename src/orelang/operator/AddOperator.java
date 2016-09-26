package orelang.operator;

import java.math.BigDecimal;
import java.util.List;

import orelang.Engine;
import orelang.expression.IExpression;

public class AddOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<IExpression> args) {
		BigDecimal retValue = BigDecimal.ZERO;
		for(IExpression arg: args){
			Object v = arg.eval(engine);
			retValue = retValue.add((BigDecimal)v);
		}
		return retValue;
	}
}
