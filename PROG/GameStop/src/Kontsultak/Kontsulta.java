package Kontsultak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Funciones.Clear;
import Funciones.Login;
import Funciones.Logo;
import Funciones.MenuP;

public class Kontsulta {
	
	public static void MenuFitxategiak(){
        Clear func_clear = new Clear();
        Logo func_logo = new Logo();
        Scanner scanner = new Scanner(System.in);
        MenuP func_menup = new MenuP();
        Login func_login = new Login();
        
		String menu2 = "";	// Variable para guardar la opcion elegida en 
        boolean m_exist2 = false;	//	Si la opcion elegida en el menu no existe cambiara a "true"
        
        while (!menu2.equals("6")) { // Mientras la opcion elegida en el menu no sea "6" seguira el bucle
            func_clear.clear();	// Limpiar pantalla
            func_logo.logo();	// Que salga el logo
            
            System.out.println("FITXATEGIEN MENUA");
            System.out.println("");
            System.out.println("1) Langileak");
            System.out.println("2) Bezeroak");
            System.out.println("3) Bezeroen Telefonoa");
            System.out.println("4) Eskaria");
            System.out.println("5) Eskari lerroa");
            System.out.println("6) Bueltatu");
            System.out.println("(1, 2, 3, 4, 5 edo 6)");
            
            if(m_exist2 == true) {	// Si el la variable es true saldra el mensaje 
            	System.out.println();
            	System.out.println("Ez da existitzen aukera hau sartu beste bat: ");
            }
            
            m_exist2 = false;	// Se resetea la variable
            menu2 = scanner.nextLine();		
            String letra = "";	
            
            switch (menu2) {
                case "1":
                	letra = "";
                	Kontsultak("LANGILE");	// Se llama a la funcion "Kontsulta" y se le pasa el nombre del archivo que se quiera leer en este caso LANGILE
                	
                	while(!letra.equals("atera")){	// Cuando acabe la funcion anterior seguira el bucle hasta que se escriba "atera"
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "2":
                	letra = "";
                	Kontsultak("BEZERO");	// Se llama a la funcion "Kontsulta" y se le pasa el nombre del archivo que se quiera leer en este caso BEZERO
                	
                	while(!letra.equals("atera")){	// Cuando acabe la funcion anterior seguira el bucle hasta que se escriba "atera"
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "3":
                	letra = "";
                	Kontsultak("BEZERO_TELEFONO");	// Se llama a la funcion "Kontsulta" y se le pasa el nombre del archivo que se quiera leer en este caso BEZERO_TELEFONO
                	
                	while(!letra.equals("atera")){	// Cuando acabe la funcion anterior seguira el bucle hasta que se escriba "atera"
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "4":
                	letra = "";
                	Kontsultak("ESKARI");	// Se llama a la funcion "Kontsulta" y se le pasa el nombre del archivo que se quiera leer en este caso ESKARI
                	
                	while(!letra.equals("atera")){	// Cuando acabe la funcion anterior seguira el bucle hasta que se escriba "atera"
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "5":
                	letra = "";
                	Kontsultak("ESKARI_LERRO");		// Se llama a la funcion "Kontsulta" y se le pasa el nombre del archivo que se quiera leer en este caso ESKARI_LERRO
                	
                	while(!letra.equals("atera")){	// Cuando acabe la funcion anterior seguira el bucle hasta que se escriba "atera"
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "6":
                	return;	// Ira al menu principal
                default:
                    m_exist2 = true;	// Si la opcion del menu no es ninguna de las anteriores la variable sera true
                    break;
            }
        }
	}
	
	public static void Kontsultak(String archivo) {		// Se le pasa el archivo que se quiera leer
		try {
            FileReader fr = new FileReader("DB/" + archivo +  ".txt");  // Ruta al archivo elegido
            BufferedReader br = new BufferedReader(fr);	// Para leer el .txt
            
            String lerroa;
            boolean primeraLinea = true;

            // Leer el archivo línea por línea
            while ((lerroa = br.readLine()) != null) {	// Para que lea el .txt entero
               
                do {	// Saca en la pantalla el documento entero
                	lerroa = br.readLine();
                	if (lerroa != null) {
                	System.out.println(lerroa);
                	}
                	} while (lerroa != null);
                
            }
            
            br.close();		// Se cierran las funciones para que no den errores
            fr.close();
            
        } catch (FileNotFoundException e) {	// Si hay algun errror saldran los mensajes de abajo
            System.out.println("Errorea: Fitxategia ezin da aurkitu.");
        } catch (IOException e) {
            System.out.println("Errorea: Fitxategia irakurtzean arazo bat gertatu da.");
        }
	}
}
