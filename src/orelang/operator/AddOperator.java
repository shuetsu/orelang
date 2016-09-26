package orelang.operator;

import java.math.BigDecimal;
import java.util.List;

import orelang.Evaluator;
import orelang.expression.IExpression;

public class AddOperator implements IOperator {
	@Override
	public Object call(Evaluator evaluator, List<IExpression> args) {
		BigDecimal retValue = BigDecimal.ZERO;
		for(IExpression arg: args){
			Object v = arg.eval(evaluator);
			retValue = retValue.add((BigDecimal)v);
		}
		return retValue;
	}
}
