package App;

import Funciones.Logo;
import Funciones.MenuP;
import Kontsultak.Kontsulta;
import Funciones.Login;
import Funciones.Clear;
import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Logo func_logo = new Logo();
        Login func_login = new Login();
        Clear func_clear = new Clear();
        Kontsulta func_kontsulta = new Kontsulta();
        MenuP func_menup = new MenuP();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {  // Bucle principal
            func_clear.clear();
            
            boolean login_m = false;  // Mensaje de error si el login falla
            
            while (!func_login.isLoggedIn()) {  // Bucle de inicio de sesión
                func_clear.clear();
                func_logo.logo();
                
                if (login_m) { // Si las credenciales del inicio de sesion no son correctas sale el mensaje
                    System.out.println("Erabiltzailea edo pasahitza gaizki dago");
                    System.out.println();
                }
                
                login_m = !func_login.login();  // Lógica para login
            }
            
            func_menup.menup(func_login);  // Llamar al menú
            
            System.out.println("Saioa ondo itxi da.");
        }
    }
}


