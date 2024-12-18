package Funciones;

public class Logo {

	public static void logo() {
		
		int rows = 7; // Numero máximo de estrellas en una fila
		
		//Piramide hacia abajo:
		
        for (int i = rows; i >= 2; i -= 2) { 
            for (int b = 0; b < (rows-i)/2; b++) {
                System.out.print(" "); 		// Espacios en blanco entre las estrellas
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); 		// Estrellas 
            }
            System.out.println();
        }
        
        // Piramide hacia arriba
        
        for (int i = 1; i <= rows; i += 2) { 
            for (int b = 0; b < (rows-i)/2; b++) {
                System.out.print(" "); 		// Espacios en blanco entre las estrellas
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*"); 		// Estrellas
            }
            System.out.println();
        }
        
        // Piramide con espacios en el centro
        
        int rows2 = 4; 		// Número máximo de filas
        
        for (int i = 1; i <= rows2; i++) {
            for (int b = i; b < rows2; b++) {
                System.out.print(" ");		// Espacios en blanco fuera las estrellas
            }
            
            System.out.print("*");  // Estrellas en la izquierda
            
            if (i > 1) {
                for (int k = 1; k <= 2 * (i - 1) - 1; k++) {
                    System.out.print(" "); // Espacios en blanco entre las estrellas
                }
                
                System.out.print("*");	// Estrellas en la derecha
            }

            System.out.println();
        }
        
        // Linea recta con "*"
        
        for(int i = 1; i <= 7; i++) {
        	System.out.print("*");		// Estrellas en fila con print en vez de pintln
        }
        
        System.out.println();
        
        // Linea recta hacia abajo
        int rows3 = 3;
        
        for (int i = 1; i <= rows3; i++) {
            for (int b = 1; b < rows2; b++) {
                System.out.print(" ");		// Espacios en blanco a los lados de las estrellas
            }
            
            System.out.println("*");	// Una estrella por linea
        }
        
        // Linea recta con "*"
        
        for(int i = 1; i <= 7; i++) {
        	System.out.print("*");		// Estrellas en fila con print en vez de pintln
        }
        
        System.out.println();
        
        // Piramide con espacios en el centro
        
        for (int i = 1; i <= rows2; i++) {
            for (int b = i; b < rows2; b++) {
                System.out.print(" ");		// Espacios en blanco fuera las estrellas
            }
            
            System.out.print("*");		// Estrellas en la izquierda
            
            if (i > 1) {
                for (int k = 1; k <= 2 * (i - 1) - 1; k++) {
                    System.out.print(" ");		// Espacios en blanco entre las estrellas
                }
                
                System.out.print("*");  // Estrellas en la derecha
            }

            System.out.println();
            System.out.println();
        }
	}
}
