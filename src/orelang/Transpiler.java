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
	        builder.append(l);
	    }
	    return transpile(builder.toString());
	}

	public static Object transpile(String script){
		String ret = script;
		ret = ret.replaceAll("\\(", "["); // ( -> [
		ret = ret.replaceAll("\\)", "]"); // ( -> ]
		ret = ret.replaceAll(";.*", ""); // remove comments
		ret = ret.replaceAll("\n", ""); // remove line return
		ret = ret.replaceAll("\\=", "\"=\""); // escape =
		ret = ret.replaceAll("\\+", "\"+\""); // escape +
		ret = ret.replaceAll("\\*", "\"*\""); // escape *
		ret = ret.replaceAll("\\s\\s+", " "); // folds spaces into one space
		ret = ret.replaceAll("\\s", ", "); // join by space with ,
		ret = ret.replaceAll(",\\s*\\]", "]"); // remove comma of last elements [a, b, c,] -> [a, b, c
		ret = ret.replaceAll("\\[(?!\")(([a-z]|[A-Z]|_)([a-z]|[A-Z]|[0-9]|_)*)", "[\"$1\""); // escape symbols
		ret = ret.replaceAll("\\s(([a-z]|[A-Z]|_)([a-z]|[A-Z]|[0-9]|_)*)\\s", "\"$1\""); // escape symbols
		ret = ret.replaceAll(",\\s(([a-z]|[A-Z]|_)([a-z]|[A-Z]|[0-9]|_)*)", ", \"$1\""); // escape symbols
		return JSON.decode(ret);
	}

}
