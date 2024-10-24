package Funciones;

public class Clear {	// Comando para vaciar la pantalla en Cmd de Windows y Shell de Linux
	public static void clear() {
		try {
            String sistemaOperativo = System.getProperty("os.name");

            if (sistemaOperativo.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
        }
	}
}
