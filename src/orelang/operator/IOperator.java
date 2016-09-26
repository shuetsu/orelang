package orelang.operator;

import java.util.List;

import orelang.Engine;
import orelang.expression.IExpression;

public interface IOperator {
	Object call(Engine engine, List<IExpression> args);
}
