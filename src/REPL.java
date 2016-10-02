import java.util.Scanner;

import orelang.Engine;
import orelang.Transpiler;

public class REPL {

	public static void main(String[] args){
		Engine engine = new Engine();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("> ");
			String l = sc.nextLine();
			if (l.length() > 0){
				try{
					System.out.println(engine.eval(Transpiler.transpile(l)));
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}else{
				break;
			}
		}
		sc.close();
	}
	
}
