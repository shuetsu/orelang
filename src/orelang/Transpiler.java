// オリジナル版はこちら：https://github.com/alphaKAI/Orelang_TS/blob/master/Transpiler.ts

package orelang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import net.arnx.jsonic.JSON;


public class Transpiler {

	public static Object transpile(Reader reader) throws IOException{
		StringBuilder builder = new StringBuilder();
	    BufferedReader br = new BufferedReader(reader);
	    String l;
	    while ((l = br.readLine()) != null){
	        builder.append(l).append("\n");
	    }
	    return transpile(builder.toString());
	}

	public static Object transpile(String script){
		String s = script;
		s = s.replaceAll(";.*", "");
		s = s.replaceAll("\\(\\s*", "[");
		s = s.replaceAll("\\s*\\)", "]");
		s = s.replaceAll("\n", "");
		s = s.replaceAll("^\\s+", "");
		s = s.replaceAll("\\s+$", "");
		s = s.replaceAll("\\s+", ", ");
		s = s.replaceAll("[+*=](?=[, \\]])", "\"$0\"");
		s = s.replaceAll("[a-zA-Z_][a-zA-Z0-9_]*", "\"$0\"");
		return JSON.decode(s);
	}

}
