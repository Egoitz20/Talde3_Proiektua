package Kontsultak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import Funciones.Clear;
import Funciones.Logo;
import Funciones.MenuP;

public class Bezeroak {

	public static void BezeroMenua() {
        Clear func_clear = new Clear();
        Logo func_logo = new Logo();
        MenuP func_menup = new MenuP();
        Scanner scanner = new Scanner(System.in);
		
		String menu3 = "";
        boolean m_exist3 = false;

        while (!menu3.equals("3")) { 
            func_clear.clear();
            func_logo.logo();
            
            System.out.println("BEZEROEN MENUA");
            System.out.println("");
            System.out.println("1) Bezeroen kontaktuak");
            System.out.println("2) Bezero baten faktura sortu");
            System.out.println("3) Bueltatu");
            System.out.println("(1, 2 edo 3)");
            
            if(m_exist3 == true) {
            	System.out.println();
            	System.out.println("Ez da existitzen aukera hau sartu beste bat: ");
            }
            
            menu3 = scanner.nextLine();
            String letra = "";
            
            switch (menu3) {
                case "1":
                	letra = "";

                	BezeroContc();
                	
                	while(!letra.equals("atera")){
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "2":
                	letra = "";

                	FakturaSortu();
                	
                	while(!letra.equals("atera")){
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "3":
                	func_menup.menup();
                default:
                    m_exist3 = true;
                    break;
            }
        }
	}
	
	public static void BezeroContc() {
        Scanner scanner = new Scanner(System.in);
        
        // Creamos un HashMap para asociar IDs de clientes con sus teléfonos
        HashMap<String, String> telefonoak = new HashMap<>();

        try {
            // Leemos primero el archivo de teléfonos y lo almacenamos en el HashMap
            FileReader frt = new FileReader("DB/BEZERO_TELEFONO.txt");
            BufferedReader brt = new BufferedReader(frt);

            String lerroaT;
            boolean primeraLineaT = true;

            while ((lerroaT = brt.readLine()) != null) {
                if (primeraLineaT) {
                    primeraLineaT = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }

                String[] lerroZatiakT = lerroaT.split("\t");
                String id_bezero = lerroZatiakT[1]; // ID del cliente
                String zbk = lerroZatiakT[2]; // Teléfono

                // Asociamos el ID del cliente con su número de teléfono
                telefonoak.put(id_bezero, zbk);
            }

            brt.close();
            frt.close();
        } catch (IOException e) {
            System.out.println("Errorea: Telefono fitxategia irakurtzean arazo bat gertatu da.");
            return;
        }

        try {
            // Ahora leemos el archivo de clientes y mostramos la información junto con los teléfonos
            FileReader frb = new FileReader("DB/BEZERO.txt");
            BufferedReader brb = new BufferedReader(frb);

            String lerroaB;
            boolean primeraLineaB = true;

            while ((lerroaB = brb.readLine()) != null) {
                if (primeraLineaB) {
                    primeraLineaB = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }

                String[] lerroZatiakB = lerroaB.split("\t");

                String id = lerroZatiakB[0];     // ID del cliente
                String izena = lerroZatiakB[1];  // Nombre
                String abizena = lerroZatiakB[2]; // Apellido
                String emaila = lerroZatiakB[4];  // Email

                // Buscamos el teléfono del cliente en el HashMap
                String zbk = telefonoak.get(id);

                if (zbk != null) {
                    System.out.println(izena + "    " + abizena + "    " + emaila + "    " + zbk);
                } else {
                    System.out.println(izena + "    " + abizena + "    " + emaila + "    (telefonoa ez dago)");
                }
            }

            brb.close();
            frb.close();
        } catch (IOException e) {
            System.out.println("Errorea: Bezero fitxategia irakurtzean arazo bat gertatu da.");
        }
    }
	
	public static void FakturaSortu() {
        Scanner scanner = new Scanner(System.in);
        
        // Creamos un HashMap para asociar IDs de pedidos con sus lineas de pedidos
        HashMap<String, String> idPedidoCliente = new HashMap<>();

        try {
            // Leemos primero el archivo de pedidos y lo almacenamos en el HashMap
            FileReader frp = new FileReader("DB/ESKARI.txt");
            BufferedReader brp = new BufferedReader(frp);

            String lerroaP;
            boolean primeraLineaP = true;

            while ((lerroaP = brp.readLine()) != null) {
                if (primeraLineaP) {
                    primeraLineaP = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }

                String[] lerroZatiakP = lerroaP.split("\t");
                String id = lerroZatiakP[0]; // ID del pedido
                String id_bezero = lerroZatiakP[1]; // Id bezero

                // Asociamos el ID del cliente con su número de id de pedido
                idPedidoCliente.put(id, id_bezero);
            }

            brp.close();
            frp.close();
        } catch (IOException e) {
            System.out.println("Errorea: Telefono fitxategia irakurtzean arazo bat gertatu da.");
            return;
        }
        
        try {
            // Ahora leemos el archivo de clientes y mostramos la información junto con los teléfonos
            FileReader frl = new FileReader("DB/ESKARI_LERRO.txt");
            BufferedReader brl = new BufferedReader(frl);

            String lerroaL;
            boolean primeraLineaL = true;

            while ((lerroaL = brl.readLine()) != null) {
                if (primeraLineaL) {
                    primeraLineaL = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }

                String[] lerroZatiakL = lerroaL.split("\t");

                String id_lerro = lerroZatiakL[0];     // ID eskari
                String cantidad = lerroZatiakL[1];	// Cantidad de producto
                String precio = lerroZatiakL[3];  // Dinero por producto

                // Buscamos el teléfono del cliente en el HashMap
                String id_bezero = idPedidoCliente.get(id_lerro);
                
                System.out.println(id_lerro + "	" + id_bezero + "	" + precio);
            }

            brl.close();
            frl.close();
        } catch (IOException e) {
            System.out.println("Errorea: Bezero fitxategia irakurtzean arazo bat gertatu da.");
        }
	}
}
