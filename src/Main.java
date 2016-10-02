import java.io.FileReader;
import java.io.IOException;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;
import orelang.Engine;

public class Main {

	public static void main(String[] args) throws JSONException, IOException {
		{
			System.out.println("example: (+ 1 2 (* 3 4))");
			Engine engine = new Engine();
			Object result = engine.eval(JSON.decode("[\"+\", 1, 2, [\"*\", 3, 4]]"));
			System.out.println(result);
		}
		{
			System.out.println("example: 1から10までの和");
			Engine engine = new Engine();
			engine.eval(JSON.decode(new FileReader("example_sum1to10.json")));
		}
		{
			System.out.println("example: オペレータの動的ディスパッチ");
			Engine engine = new Engine();
			engine.eval(JSON.decode(new FileReader("example_dynamic_op.json")));
		}
		{
			System.out.println("example: 手続きの定義(lambdaオペレータ)");
			Engine engine = new Engine();
			engine.eval(JSON.decode(new FileReader("example_lambda.json")));
		}
		{
			System.out.println("example: ローカル変数");
			Engine engine = new Engine();
			engine.eval(JSON.decode(new FileReader("example_local_var.json")));
		}
	}

}
