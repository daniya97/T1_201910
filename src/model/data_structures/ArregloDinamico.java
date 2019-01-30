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
			return tamanoAct;
		}

		public String darElemento(int i) {
			// TODO implementar
			
			if (i>=tamanoAct) {
				return null;
			}
			
			return elementos[i];
			
		}

		public String buscar(String dato) {

			Boolean encontrado = false;
			
			for (int i = 0; i < tamanoAct && !encontrado; i++) 
			{
				if (dato.equals(elementos[i])) {
					encontrado = true;
				}
				
			}
			
			
			if (encontrado) {
				return dato;
			}
			return null;
		}

		public String eliminar(String dato) {
		
			String [] auxiliar = new String[tamanoAct];
			boolean encontrado = false;
			int tamanoAuxiliar = 0;
			
			int contador = 0;
			
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
			
		if(!encontrado) return null;
		int numeroEliminados = tamanoAct - tamanoAuxiliar;
		
		
		if(numeroEliminados == tamanoAct){
			elementos  = new String[1];
			tamanoAct = 0;
			tamanoMax = 1;
			return dato;
		}
		
		
		tamanoAct = tamanoAuxiliar;
		while(tamanoAuxiliar <= tamanoMax/2){
			tamanoMax = tamanoMax/2;
		}
			
			
		
		elementos = new String[tamanoMax];
		
		for(int i = 0; i<tamanoAct; i++){
			elementos[i] = auxiliar[i];
			}
		
		return dato;	
	}
}
