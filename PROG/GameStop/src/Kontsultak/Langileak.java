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

public class Langileak {
	public static void LangileMenua() {
        Clear func_clear = new Clear();
        Logo func_logo = new Logo();
        Scanner scanner = new Scanner(System.in);
        Kontsulta func_kontsulta = new Kontsulta();
        MenuP func_menup = new MenuP();
        Login func_login = new Login();
	
		String menu3 = "";	// Variable en la que se guarda la opcion elegida en el menu
        boolean m_exist3 = false;	// Variable para saber si la opcion elegida en el menu existe 

        while (!menu3.equals("3")) { // Seguira el bucle hasta que la opcion elegida del menu sea "3"
            func_clear.clear();		// Limpiar pantalla
            func_logo.logo();	// Sacar logo
            	
            System.out.println("LANGILEEN MENUA");
            System.out.println("");
            System.out.println("1) Kontsultatu langile bat");
            System.out.println("2) Nagusi baten langileen zerrenda");
            System.out.println("3) Bueltatu");
            System.out.println("(1, 2 edo 3)");
            
            if(m_exist3 == true) {	// Si la opcion elegida en el menu no es valida saldra el mensaje
            	System.out.println();
            	System.out.println("Ez da existitzen aukera hau sartu beste bat: ");
            }
            
            m_exist3 = false;	// Resetar variable
            menu3 = scanner.nextLine();
            String letra = "";
            
            switch (menu3) {
                case "1":
                	letra = "";
                	Langilea();	// Llamar a la funcion 
                	
                	while(!letra.equals("atera")){	// Al acabar la funcion hasta  que no salga "atera" no salir
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "2":
                	letra = "";
                	LangileNagusi();	// Llamar a la funcion 
                	
                	while(!letra.equals("atera")){	// Al acabar la funcion hasta  que no salga "atera" no salir
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "3":
                	return;	// Volver al menu principal
                default:
                    m_exist3 = true;	// Si la opcion elegida no es una de las 3 anteriores volver variable a "true"
                    break;
            }
        }
	}
	
	public static void Langilea(){
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Idatzi langilearen izena: ");
        String InIzena = scanner.nextLine();
        
        System.out.println("Idatzi langilearen abizena: ");
        String InAbizena = scanner.nextLine();
        
		boolean langileaAurkitua = false;	// Si el trabajador ingresado anteriormente existe en el .txt la variable sera "true"
		
		try {
            FileReader fr = new FileReader("DB/LANGILE.txt");  // Ruta al archivo de trabajadores
            BufferedReader br = new BufferedReader(fr);
            
            String lerroa;
            boolean primeraLinea = true;

            // Leer el archivo línea por línea
            while ((lerroa = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }
                
                String[] lerroZatiak = lerroa.split("\t");	// La informacion estara separada con tab(\t)
                
                String izena = lerroZatiak[1];	// La segunda columna son los nombres (Se empieza a contar desde el 0)
                String abizena = lerroZatiak[2];	// La tercera columna seran los apellidos
                
                // Comparamos los nombres y apellidos con los ingresados
                if (izena.equalsIgnoreCase(InIzena) && abizena.equalsIgnoreCase(InAbizena)) {
                    // Si coincide, mostramos la información del trabajador
                    System.out.println(lerroa);
                    langileaAurkitua = true;
                    break;  // Detenemos la búsqueda al encontrar una coincidencia
                }
            }
            
            if (!langileaAurkitua) {	// Si no se encuentra el trabajador indicado saltara el mensaje
                System.out.println("Ez dago pertsona hau gure datu-basean.");
            }
                
            br.close();		// Cerrar funciones para que no den errores
            fr.close();
            
        } catch (FileNotFoundException e) {	// Si hay algun error saldra el mensaje
            System.out.println("Errorea: Fitxategia ezin da aurkitu.");
        } catch (IOException e) {
            System.out.println("Errorea: Fitxategia irakurtzean arazo bat gertatu da.");
        }
	}
	
	public static void LangileNagusi() {
		Scanner scanner = new Scanner(System.in);
		
        System.out.println("Idatzi nagusiaren id-a: ");
        String InNagusi_id = scanner.nextLine();
        
		boolean langileakAurkitua = false;	// Si encuentra al trabajador saldra true
		
		try {
            FileReader fr = new FileReader("DB/LANGILE.txt");  // Ruta al archivo de trabajadores
            BufferedReader br = new BufferedReader(fr);
            
            String lerroa;
            boolean primeraLinea = true;


            while ((lerroa = br.readLine()) != null) {  // Leer el archivo línea por línea
                if (primeraLinea) {
                    primeraLinea = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }
                
                String[] lerroZatiak = lerroa.split("\t");	// La informacion del .txt se separa con el tab(\t)
                
                String nagusi_id = lerroZatiak[6];	// El id del jefe esta en la columna 7 (Se empieza a contar desde 0)
                
                // Comparamos los nombres y apellidos con los ingresados
                if (nagusi_id.equalsIgnoreCase(InNagusi_id)) {
                    // Si coincide, mostramos la información del trabajador
                    System.out.println(lerroa);
                    langileakAurkitua = true;
                }
            }
            
            if (!langileakAurkitua) {	// Si no se encuentra el jefe saldra el mensaje
                System.out.println("Ez dago nagusi hau gure datu-basean");
            }
                
            br.close();		// Cerrar funciones para que no hay errores
            fr.close();
            
        } catch (FileNotFoundException e) {	// Si hay algun error saltaran los mensajes
            System.out.println("Errorea: Fitxategia ezin da aurkitu.");
        } catch (IOException e) {
            System.out.println("Errorea: Fitxategia irakurtzean arazo bat gertatu da.");
        }
	}
}
