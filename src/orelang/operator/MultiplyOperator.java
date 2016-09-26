package orelang.operator;

import java.math.BigDecimal;
import java.util.List;

import orelang.Engine;

public class MultiplyOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		BigDecimal retValue = BigDecimal.ONE;
		for(Object arg: args){
			Object v = engine.eval(arg);
			retValue = retValue.multiply((BigDecimal)v);
		}
		return retValue;
	}
}
