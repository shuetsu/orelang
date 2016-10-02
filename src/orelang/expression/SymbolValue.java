package orelang.expression;

import orelang.Engine;

public class SymbolValue implements IExpression {

	private String symbol;
	
	public SymbolValue(String symbol){
		this.symbol = symbol;
	}
	
	@Override
	public Object eval(Engine engine) {
		return engine.getVariable(symbol);
	}

}
