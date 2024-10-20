package Funciones;

public class Logo {

	public static void logo() {
		
		int rows = 7;
		
		//Piramide hacia abajo
		
        for (int i = rows; i >= 2; i -= 2) {
            for (int b = 0; b < (rows-i)/2; b++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Piramide hacia arriba
        
        for (int i = 1; i <= rows; i += 2) {
            for (int b = 0; b < (rows-i)/2; b++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Piramide con espacios en el centro
        
        int rows2 = 4;
        
        for (int i = 1; i <= rows2; i++) {
            for (int b = i; b < rows2; b++) {
                System.out.print(" ");
            }
            
            System.out.print("*");
            
            if (i > 1) {
                for (int k = 1; k <= 2 * (i - 1) - 1; k++) {
                    System.out.print(" ");
                }
                
                System.out.print("*");
            }

            System.out.println();
        }
        
        // Linea recta con "*"
        
        for(int i = 1; i <= 7; i++) {
        	System.out.print("*");
        }
        
        System.out.println();
        
        // Linea recta hacia abajo
        int rows3 = 3;
        
        for (int i = 1; i <= rows3; i++) {
            for (int b = 1; b < rows2; b++) {
                System.out.print(" ");
            }
            
            System.out.println("*");
        }
        
        // Linea recta con "*"
        
        for(int i = 1; i <= 7; i++) {
        	System.out.print("*");
        }
        
        System.out.println();
        
        // Piramide con espacios en el centro
        
        for (int i = 1; i <= rows2; i++) {
            for (int b = i; b < rows2; b++) {
                System.out.print(" ");
            }
            
            System.out.print("*");
            
            if (i > 1) {
                for (int k = 1; k <= 2 * (i - 1) - 1; k++) {
                    System.out.print(" ");
                }
                
                System.out.print("*");
            }

            System.out.println();
            System.out.println();
        }
	}
}
