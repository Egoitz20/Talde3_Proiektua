package Funciones;

import java.util.Scanner;

import Kontsultak.Bezeroak;
import Kontsultak.Kontsulta;
import Kontsultak.Langileak;

public class MenuP {

	public static void menup(Login func_login) {
        Logo func_logo = new Logo();
        Clear func_clear = new Clear();
        Scanner scanner = new Scanner(System.in);
        Kontsulta func_kontsulta = new Kontsulta();
        Langileak func_langilea = new Langileak();
        Bezeroak func_bezero = new Bezeroak();
		
		String menu = "";	// Variable para saber que opcion elige del menu
		boolean mensaje_m = false;	// Variable para que salga un mensaje si se elige una opcion que no este en el menu
       
        
        while (!menu.equals("4")) { 	// Mientras que la opcion del menu no sea "4 seguira el bucle"
            func_clear.clear();	// Limpiar pantalla
            func_logo.logo();	// Que salga el logo
            
            System.out.println("MENU");
            System.out.println("");
            System.out.println("1) Langileak");
            System.out.println("2) Bezeroak");
            System.out.println("3) Kontsulta");
            System.out.println("4) Saioa itxi");
            System.out.println("(1, 2, 3 edo 4)");
            
            if(mensaje_m == true) {		// Sale el mensaje si la opcion elegida no esta en el menu
            	System.out.println();
            	System.out.println("Ez da aukera zuzena. Saiatu berriro.");
            }
            
            mensaje_m = false;	// Despues de que salga el mensaje se resetea la variable
            
            menu = scanner.nextLine();	// Se lee la opcion elegida
           
            switch (menu) {
                case "1":
                    func_langilea.LangileMenua();
                    break;
                case "2":
                    func_bezero.BezeroMenua();
                    break;
                case "3":
                    func_kontsulta.MenuFitxategiak();
                    break;
                case "4":
                    if (func_login.logout()) {
                        return;  // Salimos inmediatamente del método menup()
                    }
                    break;
                default:
                    mensaje_m = true;	// Sale el mensaje si la opcion elegida no esta en el menu
                    break;
            }
        }

	}

}
