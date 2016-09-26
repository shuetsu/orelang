package orelang.expression;

import orelang.Evaluator;

public interface IExpression {
	Object eval(Evaluator evaluator);
}
