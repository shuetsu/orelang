import java.io.FileReader;
import java.io.IOException;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;
import orelang.Evaluator;

public class Main {

	public static void main(String[] args) throws JSONException, IOException {
		{
			Evaluator evaluator = new Evaluator();
			Object v = evaluator.eval(JSON.decode(new FileReader("example1.json")));
			System.out.println(v);
		}
		{
			Evaluator evaluator = new Evaluator();
			Object v = evaluator.eval(JSON.decode(new FileReader("example2.json")));
			System.out.println(v);
		}
	}

}
