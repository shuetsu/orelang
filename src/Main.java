import java.io.FileReader;
import java.io.IOException;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;
import orelang.Engine;

public class Main {

	public static void main(String[] args) throws JSONException, IOException {
		{
			Engine engine = new Engine();
			Object result = engine.eval(JSON.decode("[\"+\", 1, 2, [\"*\", 3, 4]]"));
			System.out.println(result);
		}
		{
			Engine engine = new Engine();
			Object result = engine.eval(JSON.decode(new FileReader("example_sum1to10.json")));
			System.out.println(result);
		}
		{
			Engine engine = new Engine();
			Object result = engine.eval(JSON.decode(new FileReader("example_dynamic_op.json")));
			System.out.println(result);
		}
	}

}
