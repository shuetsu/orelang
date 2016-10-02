import java.io.FileReader;
import java.io.IOException;

import orelang.Engine;
import orelang.Transpiler;

public class Main {

	public static void main(String[] args) throws IOException {
		{
			System.out.println("example: (+ 1 2 (* 3 4))");
			Engine engine = new Engine();
			Object result = engine.eval(Transpiler.transpile("(+ 1 2 (* 3 4))"));
			System.out.println(result);
		}
		{
			System.out.println("example: 1から10までの和");
			Engine engine = new Engine();
			engine.eval(Transpiler.transpile(new FileReader("example_sum1to10.orelang")));
		}
		{
			System.out.println("example: オペレータの動的ディスパッチ");
			Engine engine = new Engine();
			engine.eval(Transpiler.transpile(new FileReader("example_dynamic_op.orelang")));
		}
		{
			System.out.println("example: 手続きの定義(lambdaオペレータ)");
			Engine engine = new Engine();
			engine.eval(Transpiler.transpile(new FileReader("example_lambda.orelang")));
		}
		{
			System.out.println("example: ローカル変数");
			Engine engine = new Engine();
			engine.eval(Transpiler.transpile(new FileReader("example_local_var.orelang")));
		}
		{
			System.out.println("example: 引数を持つ手続きの定義");
			Engine engine = new Engine();
			engine.eval(Transpiler.transpile(new FileReader("example_arg.orelang")));
		}
	}

}
