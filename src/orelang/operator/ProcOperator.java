package orelang.operator;

import java.util.List;

import orelang.Engine;

public class ProcOperator implements IOperator {

	private List<?> argNames;
	private Object procedure;
	
	public ProcOperator(List<?> argNames, Object procedure){
		this.argNames = argNames;
		this.procedure = procedure;
	}
	
	@Override
	public Object call(Engine engine, List<?> args) {
		Engine _engine = new Engine(engine);
		for(int i = 0;i < this.argNames.size();i++){
			_engine.variables.put(
					(String)this.argNames.get(i), engine.eval(args.get(i))); 
		}
		return _engine.eval(procedure);
	}

}
