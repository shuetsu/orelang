package orelang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import orelang.expression.CallOperator;
import orelang.expression.IExpression;
import orelang.expression.ImmediateValue;
import orelang.expression.SymbolValue;
import orelang.operator.AddOperator;
import orelang.operator.DefineOperator;
import orelang.operator.EqualOperator;
import orelang.operator.GetOperator;
import orelang.operator.IOperator;
import orelang.operator.LambdaOperator;
import orelang.operator.LoadOperator;
import orelang.operator.MultiplyOperator;
import orelang.operator.PrintOperator;
import orelang.operator.SetOperator;
import orelang.operator.StepOperator;
import orelang.operator.UntilOperator;

public class Engine {

	public Map<String, Object> variables = new HashMap<String, Object>();
	
	private Engine _super = null;
	
	public Engine(){
		variables.put("+", new AddOperator());
		variables.put("*", new MultiplyOperator());
		variables.put("=", new EqualOperator());
		variables.put("def", new DefineOperator());
		variables.put("set", new SetOperator());
		variables.put("get", new GetOperator());
		variables.put("until", new UntilOperator());
		variables.put("step", new StepOperator());
		variables.put("lambda", new LambdaOperator());
		variables.put("print", new PrintOperator());
		variables.put("load", new LoadOperator());
	}
	
	public Engine(Engine _super){
		this._super = _super;
	}
	
	public Object eval(Object script){
		Object retVal = getExpression(script).eval(this);
		if (retVal instanceof IOperator){
			return new Closure(this, (IOperator)retVal);
		}else{
			return retVal;
		}
	}
	
	private IExpression getExpression(Object script){
		if (script instanceof List){
			List<?> scriptList = (List<?>)script;
			return new CallOperator(
					scriptList.get(0), 
					scriptList.subList(1, scriptList.size()));
		}else if (script instanceof String){
			return new SymbolValue((String)script);
		}else{
			return new ImmediateValue(script);
		}
	}

	public Object defineVariable(String name, Object value){
		variables.put(name, value);
		return value;
	}
	
	public Object setVariable(String name, Object value){
		Engine engine = this;
		while(true){
			if (engine.variables.containsKey(name)){
				engine.variables.put(name, value);
				return value;
			}else if (engine._super != null){
				engine = engine._super;
			}else{
				engine.defineVariable(name, value);
			}
		}
	}
	
	public Object getVariable(String name){
		Engine engine = this;
		while(true){
			if (engine.variables.containsKey(name)){
				return engine.variables.get(name);
			}else if (engine._super != null){
				engine = engine._super;
			}else{
				throw new RuntimeException("Unknown variable:" + name);
			}
		}
	}
}
