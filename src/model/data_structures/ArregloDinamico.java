package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico <K>  implements IArregloDinamico <K> {
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
        private K elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = (K[]) new Object[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( K dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    K [ ] copia = elementos;
                    elementos = (K[]) new Object[tamanoMax];
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

		public K darElemento(int i) {
			// TODO implementar
			
			K elemento = null;
			
			if (! elementos[i].equals(null) ) {
			
				elemento = elementos[i];
			}
			
			return elemento;
		}

		public K buscar(K dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			K elementoEncontrado = null;
			
			for (int i = 0; i < elementos.length; i++) {
				
				if (elementos[i].equals(dato)) {
					elementoEncontrado = elementos[i];
				}
				
			}
			
			
			return elementoEncontrado;
		}

		public K eliminar(K dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			
			
			K buscado = null;
			
			//Si el arrelgo está vacío
			if(elementos == null)
			{
				return null;
			}
			
			//Arreglo  auxiliar
			K [] auxiliar = (K[]) new Object[elementos.length-1];
			
			
			
			
			int contador = 0;
			//Copiar los elementos menos el que se elimina
			for (int i = 0; i < auxiliar.length; i++) {
				
				if (elementos[i].equals(dato)) {
					buscado = elementos[i];
					
				}
				else
				{
					auxiliar[contador] = elementos[i];
				}
				
			}
			
			elementos = auxiliar;
			
			return buscado;
		}
}
