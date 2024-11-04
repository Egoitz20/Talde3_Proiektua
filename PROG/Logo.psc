Algoritmo Logo
	
		// Secci�n 1: Pir�mide hacia abajo
		Definir filas, i, b, j, k Como Entero
		filas = 7
		
		Para i = filas Hasta 1 Con Paso -2 Hacer
			espacios = (filas - i) / 2  // Calcula el n�mero de espacios necesarios
			
			// Imprime los espacios en blanco antes de las estrellas
			Para j = 0 Hasta espacios Hacer
				Escribir Sin Saltar " "
			FinPara
			
			// Imprime las estrellas de la fila
			Para j = 1 Hasta i Hacer
				Escribir Sin Saltar "*"
			FinPara
			
			Escribir ""  // Salto de l�nea para pasar a la siguiente fila
		FinPara
		
		// Secci�n 2: Pir�mide hacia arriba
		Para i = 3 Hasta filas Con Paso 2 Hacer
			Para b = 0 Hasta (filas - i) / 2 Hacer
				Escribir Sin Saltar " "
			FinPara
			Para j = 1 Hasta i Hacer
				Escribir Sin Saltar "*"
			FinPara
			Escribir ""  // Salto de l�nea
		FinPara
		
		// Secci�n 3: Pir�mide con espacio en el centro
		Definir filas2 Como Entero
		filas2 = 4
		
		Para i = 1 Hasta filas2 Hacer
			Para b = i Hasta filas2 Hacer
				Escribir Sin Saltar " "
			FinPara
			Escribir Sin Saltar "*"
			Si i > 1 Entonces
				Para k = 1 Hasta 2 * (i - 1) - 1 Hacer
					Escribir Sin Saltar " "
				FinPara
				Escribir Sin Saltar "*"
			FinSi
			Escribir ""  // Salto de l�nea
		FinPara
		
		// Secci�n 4: L�nea recta de estrellas
		Escribir Sin Saltar " "
		Para i = 1 Hasta filas Hacer
			Escribir Sin Saltar "*"
		FinPara
		Escribir ""  // Salto de l�nea
		
		// Secci�n 5: L�nea vertical central
		Para i = 1 Hasta 3 Hacer
			Para b = 1 Hasta (filas + 1) / 2 Hacer
				Escribir Sin Saltar " "
			FinPara
			Escribir "*"
		FinPara
		
		// Secci�n 6: Otra l�nea recta de estrellas
		Escribir Sin Saltar " "
		Para i = 1 Hasta filas Hacer
			Escribir Sin Saltar "*"
		FinPara
		Escribir ""  // Salto de l�nea
		
		// Secci�n 7: Segunda pir�mide con espacios en el centro
		Para i = 1 Hasta filas2 Hacer
			Para b = i Hasta filas2 Hacer
				Escribir Sin Saltar " "
			FinPara
			Escribir Sin Saltar "*"
			Si i > 1 Entonces
				Para k = 1 Hasta 2 * (i - 1) - 1 Hacer
					Escribir Sin Saltar " "
				FinPara
				Escribir Sin Saltar "*"
			FinSi
			Escribir ""  // Salto de l�nea adicional
    FinPara

FinAlgoritmo
