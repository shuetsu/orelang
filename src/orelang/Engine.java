package orelang;

import java.util.ArrayList;
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
			IOperator operator = operators.get(scriptList.get(0));
			List<IExpression> args = new ArrayList<IExpression>();
			for(int i = 1;i < scriptList.size();i++){
				args.add(getExpression(scriptList.get(i)));
			}
			return new CallOperator(operator, args);
		}else{
			return new ImmediateValue(script);
		}
	}

}
