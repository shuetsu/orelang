package orelang.operator;

import java.math.BigDecimal;
import java.util.List;

import orelang.Engine;

public class AddOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		BigDecimal retValue = BigDecimal.ZERO;
		for(Object arg: args){
			Object v = engine.eval(arg);
			retValue = retValue.add((BigDecimal)v);
		}
		return retValue;
	}
}
