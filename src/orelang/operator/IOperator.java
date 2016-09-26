package orelang.operator;

import java.util.List;

import orelang.Evaluator;
import orelang.expression.IExpression;

public interface IOperator {
	Object call(Evaluator evaluator, List<IExpression> args);
}
