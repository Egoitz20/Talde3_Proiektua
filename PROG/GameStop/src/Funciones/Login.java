package Funciones;

import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login {

	public static void login_vista() {
		Scanner scanner = new Scanner(System.in);
		JPasswordField passwordField = new JPasswordField();
		
		System.out.println("");
		System.out.println("");
		System.out.print("Erabiltzailea: ");
		String user = scanner.nextLine();
		System.out.println("");
		System.out.print("Pasahitza: ");

        Object[] message = { "Ingresa tu contraseña:", passwordField };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            char[] password = passwordField.getPassword();
        }
	}
}
