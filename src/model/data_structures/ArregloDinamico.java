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
			// TODO implementar
			
			tamanoAct = elementos.length;
			
			return tamanoAct;
		}

		public String darElemento(int i) {
			// TODO implementar
			
			String elemento = null;
			
			if (! elementos[i].equals(null) ) {
			
				elemento = elementos[i];
			}
			
			return elemento;
		}

		public String buscar(String dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			String elementoEncontrado = null;
			
			for (int i = 0; i < elementos.length; i++) {
				
				if (elementos[i].compareTo(dato)== 0) {
					elementoEncontrado = elementos[i];
				}
				
			}
			
			
			return elementoEncontrado;
		}

		public String eliminar(String dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			
			
			String buscado = null;
			
			//Si el arrelgo está vacío
			if(elementos == null)
			{
				return null;
			}
			
			//Arreglo  auxiliar
			String [] auxiliar = new String [elementos.length-1];
			
			
			
			
			int contador = 0;
			//Copiar los elementos menos el que se elimina
			for (int i = 0; i < auxiliar.length; i++) {
				
				if (!elementos[i].equals(dato)) {
					
					auxiliar[contador] = elementos[i];
				}
				else
				{
					buscado = elementos[i];
				}
				
			}
			
			elementos = auxiliar;
			
			return buscado;
		}
}
