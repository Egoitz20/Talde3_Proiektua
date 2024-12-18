package Funciones;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    private static boolean login = false; 	// Valor inicial de la variable login es "false"

    public static boolean login() {		// Funcion que solo puede devolve true o false
        Scanner scanner = new Scanner(System.in);		
        JPasswordField passwordField = new JPasswordField();	// Clase importada que se usa para recoger contraseñas
        
        System.out.print("Erabiltzailea: "); 
        String user = scanner.nextLine();  // Leer el usuario que se ingresa
        System.out.println("");

        // Usar JOptionPane para solicitar la contraseña
        int option = JOptionPane.showConfirmDialog(null, new Object[]{"Pasahitza sartu:", passwordField}, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option != JOptionPane.OK_OPTION) {
            // Si el usuario cancela, simplemente retornamos false
            return false;
        }
        
        // Convertir la contraseña ingresada a String
        char[] passwordArray = passwordField.getPassword();
        String password = new String(passwordArray); 

        try {
            FileReader fr = new FileReader("DB/ERABILTZAILEAK.txt");  // Ruta al archivo de usuarios
            BufferedReader br = new BufferedReader(fr);
            
            String lerroa;
            boolean primeraLinea = true;

            // Leer el archivo línea por línea
            while ((lerroa = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }
               
                // Dividir la línea por tabulaciones
                String[] lerroZatiak = lerroa.split("\t");
                
                String id = lerroZatiak[0];
                String erabiltzailea = lerroZatiak[1];  // Nombre de usuario
                String pasahitza = lerroZatiak[2];      // Contraseña
                
                // Comprobar si el nombre de usuario y la contraseña coinciden
                if (erabiltzailea.equals(user) && pasahitza.equals(password)) {
                    login = true;  // Si coinciden, el login es exitoso
                    break;         // Salir del bucle una vez que se ha autenticado
                }
            }
            
            br.close();
            fr.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Errorea: Fitxategia ezin da aurkitu.");
        } catch (IOException e) {
            System.out.println("Errorea: Fitxategia irakurtzean arazo bat gertatu da.");
        }
        
        return login;  // Devolver el valor de login (true si es exitoso, false si falla)
    }

    
    
    public boolean logout() {
        Scanner scanner = new Scanner(System.in);	
        Clear func_clear = new Clear();
        
    	boolean logoutConfirmed = false;	// Variable para saber si se ha cerrado sesion
    	String saiBE = "";	// Variable para confirmar si el usuario quiere cerrar sesion
    	
    	while (!saiBE.equals("bai") && !saiBE.equals("ez")) {
        	func_clear.clear();
    		
    		System.out.println("Saioa itxi nahi duzu? (bai/ez)");	// Se guarda si el usuario quiere cerrar sesion
        	saiBE = scanner.nextLine().trim().toLowerCase();
        	
        	if (saiBE.equals("bai")) {	// Si es "bai" se cierra sesion
        		logoutConfirmed = true;
        		login = false;  // Actualizamos el estado de login a false
        	} else if (saiBE.equals("ez")) {	// Si es "ez" no se cierra la sesion
        		logoutConfirmed = false;
        	} else {
        		System.out.println("Ez da erantzun egokia idatzi berriro.");	// Si escribe algo que no sea "ez" o "bai" sale el mensaje
        		return logout();
        	}
    	}
    	
    	return logoutConfirmed;
    }

    // Método para verificar si el usuario está logueado
    public boolean isLoggedIn() {
        return login;  // Método para verificar si el usuario está logueado
    }
}

