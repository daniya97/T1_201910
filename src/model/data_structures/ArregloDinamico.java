package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private String elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darTamano() {
			
			//Devuelve le tamaño actual guardado como atributo
			return tamanoAct;
		}

		public String darElemento(int i) {
			// TODO implementar
			
			//Si la posición es mayor al tamaño actual se devuelve null
			if (i>=tamanoAct) {
				return null;
			}
			
			
			//Si no se devuelve el elemento
			return elementos[i];
			
		}

		public String buscar(String dato) {
			
			
			//Boolean para identificar si ya fue encontrado el dato o no
			Boolean encontrado = false;
			
			for (int i = 0; i < tamanoAct && !encontrado; i++) 
			{
				//Se compara con equals pues lo implementa cualquier objeto
				if (dato.equals(elementos[i])) {
					encontrado = true;
				}
				
			}
			
			
			if (encontrado) {
				//Si se encontró se devuelve el objeto sino se devuelve null
				return dato;
			}
			return null;
		}

		public String eliminar(String dato) {
		
			
			//Se crea un arreglo auxiliar para guardar los Strings que no se eliminan
			String [] auxiliar = new String[tamanoAct];
			boolean encontrado = false;
			int tamanoAuxiliar = 0;
			
			int contador = 0;
		
			
		//Se recorre el arreglo original transferiendo los String al auxiliar excepto que sea el dato en cuestión
		for (int i = 0; i <tamanoAct; i++) {
				if(!dato.equals(elementos[i])){
					auxiliar[contador] = elementos[i];
					contador ++;
					tamanoAuxiliar++;
				}
				else
				{
				encontrado = true;
				}
		}
			
		
		//si nunca se encontró se devuelve null
		if(!encontrado) return null;
		
		//Se encuentra el número total de datos eliminados
		int numeroEliminados = tamanoAct - tamanoAuxiliar;
		
		
		
		//Caso de que se hayan eliminado todos los elementos
		if(numeroEliminados == tamanoAct){
			elementos  = new String[1];
			tamanoAct = 0;
			tamanoMax = 1;
			return dato;
		}
		
		
		//Caso restante: Queda el arreglo auxiliar como el arreglo elementos
		tamanoAct = tamanoAuxiliar;
		while(tamanoAuxiliar <= tamanoMax/2){
			tamanoMax = tamanoMax/2;
		}
			
			
		
		elementos = new String[tamanoMax];
		
		for(int i = 0; i<tamanoAct; i++){
			elementos[i] = auxiliar[i];
			}
		
		
		//Se devuelve el dato eliminado
		return dato;	
	}
}
