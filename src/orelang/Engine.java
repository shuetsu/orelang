package orelang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import orelang.expression.CallOperator;
import orelang.expression.IExpression;
import orelang.expression.ImmediateValue;
import orelang.operator.AddOperator;
import orelang.operator.DefineOperator;
import orelang.operator.EqualOperator;
import orelang.operator.GetOperator;
import orelang.operator.IOperator;
import orelang.operator.LambdaOperator;
import orelang.operator.MultiplyOperator;
import orelang.operator.PrintOperator;
import orelang.operator.SetOperator;
import orelang.operator.StepOperator;
import orelang.operator.UntilOperator;

public class Engine {

	public Map<String, IOperator> operators;
	public Map<String, Object> variables = new HashMap<String, Object>();
	
	private Engine _super = null;
	
	public Engine(){
		operators = new HashMap<String, IOperator>();
		operators.put("+", new AddOperator());
		operators.put("*", new MultiplyOperator());
		operators.put("=", new EqualOperator());
		operators.put("def", new DefineOperator());
		operators.put("set", new SetOperator());
		operators.put("get", new GetOperator());
		operators.put("until", new UntilOperator());
		operators.put("step", new StepOperator());
		operators.put("lambda", new LambdaOperator());
		operators.put("print", new PrintOperator());
	}
	
	public Engine(Engine _super){
		this._super = _super;
		this.operators = _super.operators;
	}
	
	public Object eval(Object script){
		return getExpression(script).eval(this);
	}
	
	private IExpression getExpression(Object script){
		if (script instanceof List){
			List<?> scriptList = (List<?>)script;
			return new CallOperator(
					scriptList.get(0), 
					scriptList.subList(1, scriptList.size()));
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
				new RuntimeException("Unknown variable:" + name);
			}
		}
	}
}
