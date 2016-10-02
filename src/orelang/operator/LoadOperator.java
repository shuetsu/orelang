package orelang.operator;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import orelang.Engine;
import orelang.Transpiler;

public class LoadOperator implements IOperator {
	@Override
	public Object call(Engine engine, List<?> args) {
		try {
			String path = (String)args.get(0) + ".orelang";
			return engine.eval(Transpiler.transpile(new FileReader(path)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
