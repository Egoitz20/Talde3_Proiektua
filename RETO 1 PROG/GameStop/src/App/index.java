package App;

import Funciones.Logo;
import Funciones.Login;

public class index {

	public static void main(String[] args) {
		Logo func_logo = new Logo();
		Login func_login = new Login();
		
		boolean login = false;
		
		do {
			func_logo.logo();
			func_login.login_vista();
			
			try {
	            String sistemaOperativo = System.getProperty("os.name");

	            if (sistemaOperativo.contains("Windows")) {
	                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	            } else {
	                new ProcessBuilder("clear").inheritIO().start().waitFor();
	            }
	        } catch (Exception e) {
	        }
			
			System.out.println("");
			System.out.println("");
			
		    } while(login != false);

		
		System.out.println("MENU");
		System.out.println("");
		System.out.println("1) ");
		System.out.println("2) ");
		System.out.println("3) ");
		System.out.println("4) ");
		System.out.println("5) ");
		System.out.println("6) ");
		System.out.println("7) ");
		System.out.println("8) ");
		
	}
}