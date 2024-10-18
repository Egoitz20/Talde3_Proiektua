package Funciones;

import javax.swing.*;
import java.util.Scanner;

public class Login {
    private static boolean login = false; 

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);
        JPasswordField passwordField = new JPasswordField();

        System.out.println("");
        System.out.print("Erabiltzailea: "); 
        String user = scanner.nextLine();
        System.out.println("");

        int option = JOptionPane.showConfirmDialog(null, new Object[]{"Ingresa tu contraseña:", passwordField}, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            char[] passwordArray = passwordField.getPassword();
            String password = new String(passwordArray); 

            if ("Asier".equals(user) && "123".equals(password)) {
                login = true;
            } else {
                login = false; 
            }
        }

        return login;
    }
}
