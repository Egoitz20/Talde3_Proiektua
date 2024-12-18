package Kontsultak;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

import Funciones.Clear;
import Funciones.Login;
import Funciones.Logo;
import Funciones.MenuP;

public class Bezeroak {

	public static void BezeroMenua() {
        Clear func_clear = new Clear();
        Logo func_logo = new Logo();
        MenuP func_menup = new MenuP();
        Scanner scanner = new Scanner(System.in);
        Login func_login = new Login();
		
		String menu3 = "";	// En esta variable se guarda la opcion elegida del menu
        boolean m_exist3 = false;	// Si la opcion elegida no esta en el menu sera true
        
        while (!menu3.equals("3")) {  // Mientras que la opcion del menu no sea "3" seguira el bucle
            func_clear.clear();	// Limpiar pantalla
            func_logo.logo();	// Que salga el logo
            
            System.out.println("BEZEROEN MENUA");
            System.out.println("");
            System.out.println("1) Bezeroen kontaktuak");
            System.out.println("2) Bezero baten faktura sortu");
            System.out.println("3) Bueltatu");
            System.out.println("(1, 2 edo 3)");
            
            if(m_exist3 == true) {	// Al ser true saldra el mensaje
            	System.out.println();
            	System.out.println("Ez da existitzen aukera hau sartu beste bat: ");
            }
            
            m_exist3 = false;	// Despues de salir la variable se resetea la variable
            menu3 = scanner.nextLine();	// Se recoge la opcion elegida en el menu
            String letra = "";	// Variable para saber si quiere salir de la funcion elegida
            
            switch (menu3) {
                case "1":
                	letra = "";	// Resetar variable

                	BezeroContc();	// Se llama a la funcion de encontrar contactos de clientes
                	
                	while(!letra.equals("atera")){	// Mientras que variable letra no sea "atera" seguira el bucle
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();	
                    	letra = letra.toLowerCase();	// Todo lo escrito se pasa a minusculas
                	}
                    break;
                case "2":
                	letra = "";

                	FakturaSortu();		// Se llama a la funcion de crear factura
                	
                	while(!letra.equals("atera")){
                		System.out.println();
                    	System.out.println("Sartu 'atera': ");
                    	letra = scanner.nextLine();
                    	letra = letra.toLowerCase();
                	}
                    break;
                case "3":
                	return;	// Para que vuelva al menu principal
                default:
                    m_exist3 = true;	// Si la opcion elegida en el menu no es la correcta la variable se vuelve true para que salga el mensaje anterior
                    break;
            }
        }
	}
	
	public static void BezeroContc() {	// Encontrar contactos de los clientes
        Scanner scanner = new Scanner(System.in);
        
        // Creamos un HashMap para asociar IDs de clientes con sus teléfonos
        HashMap<String, String> telefonoak = new HashMap<>();

        try {
            // Leemos primero el archivo de teléfonos y lo almacenamos en el HashMap
            FileReader frt = new FileReader("DB/BEZERO_TELEFONO.txt");
            BufferedReader brt = new BufferedReader(frt);

            String lerroaT;	
            boolean primeraLineaT = true;	// Variable para saber si hay primera linea en el .txt

            while ((lerroaT = brt.readLine()) != null) {	// Bucle para leer todas las lineas del .txt
                if (primeraLineaT) {
                    primeraLineaT = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }

                String[] lerroZatiakT = lerroaT.split("\t");	// La informacion se separa con tabulaciones(\t)
                String id_bezero = lerroZatiakT[1]; // ID del cliente
                String zbk = lerroZatiakT[2]; // Teléfono

                // Asociamos el ID del cliente con su número de teléfono
                telefonoak.put(id_bezero, zbk);
            }

            brt.close();	// Cerramos las funciones para que no haya errores
            frt.close();
        } catch (IOException e) {	// Si hay algun error saldra en la pantalla
            System.out.println("Errorea: Telefono fitxategia irakurtzean arazo bat gertatu da.");
            return;
        }

        try {
            // Ahora leemos el archivo de clientes y mostramos la información junto con los teléfonos
            FileReader frb = new FileReader("DB/BEZERO.txt");
            BufferedReader brb = new BufferedReader(frb);

            String lerroaB;
            boolean primeraLineaB = true;	// Variable para saber si hay primera linea en el .txt

            while ((lerroaB = brb.readLine()) != null) {	// Bucle para leer todas las lineas del .txt
                if (primeraLineaB) {
                    primeraLineaB = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }

                String[] lerroZatiakB = lerroaB.split("\t");	// La informacion se separa con tabulaciones(\t)

                String id = lerroZatiakB[0];     // ID del cliente
                String izena = lerroZatiakB[1];  // Nombre
                String abizena = lerroZatiakB[2]; // Apellido
                String emaila = lerroZatiakB[4];  // Email

                // Buscamos el teléfono del cliente en el HashMap
                String zbk = telefonoak.get(id);

                if (zbk != null) {	// Si variable zbk(numero de telefono) no es nulo saldra el primer mensaje, sino el segundo
                    System.out.println(izena + "    " + abizena + "    " + emaila + "    " + zbk);
                } else {
                    System.out.println(izena + "    " + abizena + "    " + emaila + "    (telefonoa ez dago)");
                }
            }

            brb.close();	// Cerramos las funciones para que no haya errores
            frb.close();
        } catch (IOException e) {	// Si hay algun error saldra el mensaje de abajo
            System.out.println("Errorea: Bezero fitxategia irakurtzean arazo bat gertatu da.");
        }
    }
	
	public static void FakturaSortu() {		// Funcion para crear una factura de los clientes
        Scanner scanner = new Scanner(System.in);
        Logo func_logo = new Logo();
        DecimalFormat df = new DecimalFormat("#.##");	// Funcion para indicar el formato de la variable "double"
        
        System.out.println("Sartu bezero baten id-a: ");
        String InBezeroId = scanner.nextLine();
        String ruta;	// Variable para saber la ruta en la que crear el archivo 
        
        // Creamos un HashMap para asociar IDs de pedidos con sus lineas de pedidos
        HashMap<String, String> idPedidoCliente = new HashMap<>();
        
        try {
            // Leemos primero el archivo de pedidos y lo almacenamos en el HashMap
            FileReader frp = new FileReader("DB/ESKARI.txt");
            BufferedReader brp = new BufferedReader(frp);

            String lerroaP;
            boolean primeraLineaP = true;	// Si hay primera linea en el .txt pondra "true"

            while ((lerroaP = brp.readLine()) != null) {	// Bucle para que lea todo el .txt
                if (primeraLineaP) {
                    primeraLineaP = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }

                String[] lerroZatiakP = lerroaP.split("\t");	// La informacion del .txt se separa con tab(\t)
                String id = lerroZatiakP[0]; // ID del pedido
                String id_bezero = lerroZatiakP[1]; // Id bezero

                // Asociamos el ID del cliente con su número de id de pedido
                idPedidoCliente.put(id, id_bezero);
            }

            brp.close();	// Cerramos funciones para que no haya errores
            frp.close();
        } catch (IOException e) {	// Si hay errores saldra el mensaje de abajo
            System.out.println("Errorea: Telefono fitxategia irakurtzean arazo bat gertatu da.");
            return;
        }
        
        try {
            // Ahora leemos el archivo de clientes y mostramos la información junto con los teléfonos
            FileReader frl = new FileReader("DB/ESKARI_LERRO.txt");
            BufferedReader brl = new BufferedReader(frl);

            String lerroaL;		// Variable para saber si hay primera linea
            boolean primeraLineaL = true;	// Variable para saber si hay primera linea
            boolean encontrado = false;		// Si encuentra el id del cliente sera true
            double TotalPrecio = 0.0;	// Variable del precio total 
            
            StringBuilder contenido_txt = new StringBuilder();
            
            while ((lerroaL = brl.readLine()) != null) {	// El bucle acaba cuando a leido todo el .txt
                if (primeraLineaL) {
                    primeraLineaL = false;  // Saltamos la primera línea (encabezados)
                    continue;
                }
                
                String[] lerroZatiakL = lerroaL.split("\t");	// Se separa la informacion con tab(\t) .txt

                String id_eskari = lerroZatiakL[0];     // ID eskari
                String id_produktu = lerroZatiakL[2];	// Id del producto
                String cantidadStr = lerroZatiakL[3];	// Cantidad de producto
                String precioStr = lerroZatiakL[4];  // Dinero por producto

                precioStr = precioStr.replace(",", ".").trim();		// En el caso de que los numeros del .txt tengan "," los reemplazara por "."
                
                String id_bezero = idPedidoCliente.get(id_eskari);	// Relaciona el id del cliente con el de la factura
                
                if (id_bezero != null && id_bezero.equalsIgnoreCase(InBezeroId)) {	// Si el id del cliente no es nulo y es igual a uno que este en el .txt
                	try {
                	    double precio = Double.parseDouble(precioStr);	// Se pasa el precio del .txt a una variable "double"
                	    double cantidad = Double.parseDouble(cantidadStr);	// Se pasa la cantidad del .txt a una variable "double"
                	    double subtotal = precio*cantidad;	// Se multiplica cantidad por precio
                	    
                	    String subtotalF = df.format(subtotal);		// Se le pasa el formato que emos asignado antes a la variable subtotal

                	    TotalPrecio += subtotal;	// Se suman todos los subtotales
                	    
                	    String TotalPrecioF = df.format(TotalPrecio);	// Se pasa la variable TotalPrecio al formato indicado antes para el double
                	    
                	    contenido_txt.append("Produktu id-a: ").append(id_produktu)		// Guardamos en nuestra variable lo que queremos que se escriba en nuestro .txt
                        			.append("	Prezioa: ").append(precio).append(" EUR")
			                        .append("	Kantitatea: ").append(cantidad)
			                        .append("  .................... ").append(subtotalF).append(" EUR\n \n");
                	    
                	} catch (NumberFormatException e) {	// Si hay algun error saltara el mensaje
                	    System.out.println("Error al convertir el precio: " + precioStr);
                	}
                	
                    encontrado = true;  // Marcamos que hemos encontrado una coincidencia
                }
            }

            brl.close();	// Se cierran las funciones para que no haya errores
            frl.close();
            
            if(encontrado) {	// Si emos encontrado el id del cliente
                ruta = "./BEZEROEN_ESKARIAK/" + InBezeroId + ".Bezero_Eskaria.txt";	// Ruta del archivo 
                File archivo = new File(ruta);	// Ruta del archivo
                Path dirPath = Paths.get("./BEZEROEN_ESKARIAK"); // Ruta de la carpeta
                
                boolean resultCarpeta = false;
                
                if (Files.notExists(dirPath)) {	// Si no existe la carpeta "BEZEROEN_ESKARIAK" se creará
                    File directory = new File("./BEZEROEN_ESKARIAK");
                    resultCarpeta = directory.mkdir();
                    System.out.println("'BEZEROEN_ESKARIAK' karpeta sortu egin da.");
                }
                
                if(!archivo.exists())	// Si no existe
                {
                   archivo.createNewFile();	// Se crea el archivo
                
                
                FileWriter fw = new FileWriter(ruta, true);		// Para escribir en el archivo (se añade la ruta del archivo)
                BufferedWriter bw = new BufferedWriter(fw);		// Para escribir en el .txt
               
            
                bw.write("Bezeroaren faktura " + InBezeroId + " ID-arekin" + "\n");		// Lo que queremos que salga en el archivo ("\n" es salto de linea)
                bw.newLine();
                bw.newLine();
                bw.write(contenido_txt.toString());  // Escribimos todos los productos
                bw.newLine();
                bw.newLine();
                bw.newLine();
                
                String TotalPrecioF = df.format(TotalPrecio);	// Escribimos el precio total con el formato double creado antes (0,00)
                bw.write(".............................................................  Ordaintzeko totala: " + TotalPrecioF + " EUR\n");
                bw.newLine();
                bw.close();	// Se cierra la funcion para que no haya errores
                
                System.out.println("Faktura sortu eta fitxategian gorde da.");
                
                Desktop dt = Desktop.getDesktop();	// Para que se habra el archivo al crearlo
                File file = new File("./BEZEROEN_ESKARIAK/" + InBezeroId + ".Bezero_Eskaria.txt");	// La ruta del archivo
                dt.open(file);	// Comando final para que se habra en tu editor de texto
                
                }else {	// Si la factura ya esta creada saltara el mensaje de abajo
                	System.out.println("Eskari hau dagoeneko sortuta dago");	
                    Desktop dt = Desktop.getDesktop();	// Para que se habra el archivo al crearlo
                    File file = new File("./BEZEROEN_ESKARIAK/" + InBezeroId + ".Bezero_Eskaria.txt");	// La ruta del archivo
                    dt.open(file);	// Comando final para que se habra en tu editor de texto
                }
            
            }else {		// Si el id del cliente del que has pedido la factura no existe saldra el mensaje de abajo
            	System.out.println("Id hau ez da existitzen edo ez du erosketarik egin.");
            }
            
        } catch (IOException e) {	// Si hay algun error saldra este mensaje
            System.out.println("Errorea: Bezero fitxategia irakurtzean arazo bat gertatu da.");
        }
	}
}
