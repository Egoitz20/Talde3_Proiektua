package App;

import Funciones.Logo;
import Funciones.Login;
import Funciones.Kontsulta;
import Funciones.Clear;
import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Logo func_logo = new Logo();
        Login func_login = new Login();
        Clear func_clear = new Clear();
        Kontsulta func_kontsulta = new Kontsulta();
        Scanner scanner = new Scanner(System.in);
        
        boolean login = false;
        boolean logout = false;
        
        while(true) {
        	func_clear.clear();
      
        	boolean login_m = false;
        	
	        while (!login) {
	        	
	        	func_clear.clear();
	            func_logo.logo();
	            
	            if(logout == true) {
	            	System.out.println("Saioa itxi da");
	            	System.out.println();
	            }
	            
	        	if(login_m == true) {
	        		System.out.println("Erabiltzailea edo pasahitza gaizki dago");
	        		System.out.println();
	        	}
	            login = func_login.login(); 
	            if(login == false) {
	            	login_m = true;
	            	logout = false;
	            }
	        }
	
	        String menu = "";
	
	        boolean m_exist = false;
	        
	        while (!menu.equals("4")) { 
	            func_clear.clear();
	            func_logo.logo();
	            
	            System.out.println("MENU");
	            System.out.println("");
	            System.out.println("1) Langileak");
	            System.out.println("2) Bezeroak");
	            System.out.println("3) Kontsulta");
	            System.out.println("4) Saioa itxi");
	            System.out.println("(1, 2, 3 edo 4)");
	            
	            if(m_exist == true) {
	            	System.out.println();
	            	System.out.println("Ez da existitzen aukera hau sartu beste bat: ");
	            }
	            
	            menu = scanner.nextLine();
	            
	            switch (menu) {
	                case "1":
	                    func_kontsulta.Langileak();
	                    break;
	                case "2":
	                    func_kontsulta.Bezeroak();
	                    break;
	                case "3":
	                    func_kontsulta.Fitxategiak();
	                    break;
	                case "4":
	                    login = false;
	                    logout = true;
	                    break;
	                default:
	                    m_exist = true;
	                    break;
	            }
	        }
        }
    }
}

