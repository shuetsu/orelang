package orelang.operator;

import java.util.List;

import orelang.Engine;

public class ProcOperator implements IOperator {

	private Object procedure;
	
	public ProcOperator(Object procedure){
		this.procedure = procedure;
	}
	
	@Override
	public Object call(Engine engine, List<?> args) {
		return engine.eval(procedure);
	}

}
