package orelang.expression;

import orelang.Evaluator;

public class ImmediateValue implements IExpression {

	private Object value;
	
	public ImmediateValue(Object value){
		this.value = value;
	}
	
	@Override
	public Object eval(Evaluator evaluator) {
		return value;
	}

}
