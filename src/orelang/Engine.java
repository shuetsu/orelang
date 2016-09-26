package orelang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import orelang.expression.CallOperator;
import orelang.expression.IExpression;
import orelang.expression.ImmediateValue;
import orelang.operator.AddOperator;
import orelang.operator.EqualOperator;
import orelang.operator.GetOperator;
import orelang.operator.IOperator;
import orelang.operator.MultiplyOperator;
import orelang.operator.SetOperator;
import orelang.operator.StepOperator;
import orelang.operator.UntilOperator;

public class Engine {

	public Map<String, IOperator> operators = new HashMap<String, IOperator>();
	public Map<String, Object> variables = new HashMap<String, Object>();
	
	public Engine(){
		operators.put("+", new AddOperator());
		operators.put("*", new MultiplyOperator());
		operators.put("=", new EqualOperator());
		operators.put("set", new SetOperator());
		operators.put("get", new GetOperator());
		operators.put("until", new UntilOperator());
		operators.put("step", new StepOperator());
	}
	
	public Object eval(Object script){
		return getExpression(script).eval(this);
	}
	
	private IExpression getExpression(Object script){
		if (script instanceof List){
			List<?> scriptList = (List<?>)script;
			return new CallOperator(
					operators.get(scriptList.get(0)), 
					scriptList.subList(1, scriptList.size()));
		}else{
			return new ImmediateValue(script);
		}
	}

}
