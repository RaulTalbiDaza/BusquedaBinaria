package array;
import java.util.*;
public class algt_binario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner (System.in);
		int[] miArray = {15, 16, 1, 20, 10, 5, 2, 19, 8, 3, 7, 4, 6, 11, 14, 13, 12, 18, 17, 9};
		boolean valido=false;
		int obj=0;
		while(!valido) {
			try {
				System.out.println("Elige un número del 1 al 20");
				obj =sc.nextInt();
				 while (obj < 1|| obj>20) {
					 System.out.println("El número tiene que estar entre el 1 y el 20. Introdúcelo otra vez");
					 obj=sc.nextInt();
				 }
				 valido=true;
			}catch(InputMismatchException e) {
				System.out.println("ERROR: El programa solo acepta caracteres numéricos. Introduce el número de nuevo.");
				sc.nextLine();
				valido=false;
			}
		}
		
        
        int []miArray2= ordenarNumeros(miArray);
        
        int posicion = busquedaBinaria(miArray2, obj);
        
        if(posicion != -1) {
        	System.out.println("El número "+obj+" esta en la posición: "+posicion);
        }

        sc.close();
        
	}
	
	
	public static int[] ordenarNumeros(int[] arr) {
	    
	    int[] contador = new int[21];

	    
	    for (int i = 0; i < arr.length; i++) {
	        int valor = arr[i];
	        contador[valor] = contador[valor] + 1;
	    }

	    
	    int posicionActual = 0;
	    for (int numero = 1; numero <= 20; numero++) {
	        for (int j = 0; j < contador[numero]; j++) {
	            arr[posicionActual] = numero;
	            posicionActual++;
	        }
	    }

	    
	    return arr; 
	}
	
	public static int busquedaBinaria(int[] arr, int objetivo) {
	    int inicio = 0;
	    int fin = arr.length - 1;

	    while (inicio <= fin) {
	        int medio = inicio + (fin - inicio) / 2; // Calculamos el centro

	        // 1. ¿Está en el medio?
	        if (arr[medio] == objetivo) {
	            return medio; // Devolvemos la posición donde lo encontró
	        }

	        // 2. ¿Es más pequeño? Buscamos en la izquierda
	        if (arr[medio] > objetivo) {
	            fin = medio - 1;
	        } 
	        // 3. ¿Es más grande? Buscamos en la derecha
	        else {
	            inicio = medio + 1;
	        }
	    }

	    return -1; // No se encontró el número
	}
}


