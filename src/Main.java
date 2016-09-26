import java.io.FileReader;
import java.io.IOException;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;
import orelang.Engine;

public class Main {

	public static void main(String[] args) throws JSONException, IOException {
		{
			Engine engine = new Engine();
			Object v = engine.eval(JSON.decode(new FileReader("example1.json")));
			System.out.println(v);
		}
		{
			Engine engine = new Engine();
			Object v = engine.eval(JSON.decode(new FileReader("example2.json")));
			System.out.println(v);
		}
	}

}
