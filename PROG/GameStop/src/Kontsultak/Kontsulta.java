package Kontsultak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Funciones.Clear;
import Funciones.Logo;
import Funciones.MenuP;

public class Kontsulta {
	
	public static void MenuFitxategiak(){
        Clear func_clear = new Clear();
        Logo func_logo = new Logo();
        Scanner scanner = new Scanner(System.in);
        MenuP func_menup = new MenuP();
        
		String menu2 = "";
		
        boolean m_exist2 = false;
        
        while (!menu2.equals("6")) { 
            func_clear.clear();
            func_logo.logo();
            
            System.out.println("FITXATEGIEN MENUA");
            System.out.println("");
            System.out.println("1) Langileak");
            System.out.println("2) Bezeroak");
            System.out.println("3) Bezeroen Telefonoa");
            System.out.println("4) Eskaria");
            System.out.println("5) Eskari lerroa");
            System.out.println("6) Bueltatu");
            System.out.println("(1, 2, 3, 4, 5 edo 6)");
            
            if(m_exist2 == true) {
            	System.out.println();
            	System.out.println("Ez da existitzen aukera hau sartu beste bat: ");
            }
            
            menu2 = scanner.nextLine();
            String letra = "";
            
            switch (menu2) {
                case "1":
                	letra = "";
                	Kontsultak("LANGILE");
                	
                	while(!letra.equals("atera")){
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "2":
                	letra = "";
                	Kontsultak("BEZERO");
                	
                	while(!letra.equals("atera")){
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "3":
                	letra = "";
                	Kontsultak("BEZERO_TELEFONO");
                	
                	while(!letra.equals("atera")){
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "4":
                	letra = "";
                	Kontsultak("ESKARI");
                	
                	while(!letra.equals("atera")){
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "5":
                	letra = "";
                	Kontsultak("ESKARI_LERRO");
                	
                	while(!letra.equals("atera")){
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "6":
                	func_menup.menup();
                    break;
                default:
                    m_exist2 = true;
                    break;
            }
        }
	}
	
	public static void Kontsultak(String archivo) {
		try {
            FileReader fr = new FileReader("DB/" + archivo +  ".txt");  // Ruta al archivo de trabajadores
            BufferedReader br = new BufferedReader(fr);
            
            String lerroa;
            boolean primeraLinea = true;

            // Leer el archivo línea por línea
            while ((lerroa = br.readLine()) != null) {
               
                do {
                	lerroa = br.readLine();
                	if (lerroa != null) {
                	System.out.println(lerroa);
                	}
                	} while (lerroa != null);
                
            }
            
            br.close();
            fr.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Errorea: Fitxategia ezin da aurkitu.");
        } catch (IOException e) {
            System.out.println("Errorea: Fitxategia irakurtzean arazo bat gertatu da.");
        }
	}
}
