package orelang.expression;

import orelang.Engine;

public interface IExpression {
	Object eval(Engine engine);
}
