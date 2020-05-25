package encriptador;

/**
 * Encriptador de mensajes que utiliza un algoritmo de transposición
 * y sustitución simple. Los valores pueden ser cambiados para obtener
 * un encriptador distinto al original.
 * 
 * @version 0.1
 * 
 * @author Jaime Reyes Cárdenas
 *
 */
public class Encriptador {
	
    /**
     * Encripta un mensaje usando un algoritmo de transposición y sustitución
     * simple.
     * 
     * @param cadena El mensaje a encriptar
     * @return El mensaje encriptado
     */
    public String encriptar(String cadena){

        char[] letras = cadena.toCharArray();
        avanzarPosicionesArray(letras, 5);
        
        for (int i = 0; i < letras.length; i++){
            
            for (int j = 0; j < ORDEN.length; j++){
                
                if (letras[i] == ORDEN[j]){
                    
                    letras[i] = CLAVE[j];
                    break;
                    
                }
                
            }
            
        }
        
        String cadenaEncriptada = String.valueOf(letras);
        
        return cadenaEncriptada;

    }
    
    /**
     * Desencripta un mensaje generado por el método encriptar().
     * @see encriptar(String cadena)
     * 
     * @param cadena El mensaje a desencriptar
     * @return El mensaje desencriptado
     */
    public String desencriptar(String cadena){

        char[] letras = cadena.toCharArray();
        retrocederPosicionesArray(letras, 5);
        
        for (int i = 0; i < letras.length; i++){
            
            for (int j = 0; j < CLAVE.length; j++){
                
                if (letras[i] == CLAVE[j]){
                    
                    letras[i] = ORDEN[j];
                    break;
                    
                }
                
            }
            
        }
        
        String cadenaDesencriptada = String.valueOf(letras);
        
        return cadenaDesencriptada;

    }
    
    /**
     * Reordena un arreglo de caracteres especificado, retrocediendo en n
     * posiciones la posición de cada caracter.
     * 
     * @param array El arreglo a reordenar
     * @param n El número de posiciones a retroceder por cada caracter
     */
    public static void retrocederPosicionesArray(char[] array, int n){
        
        if (array.length > 1 && n > 0) {
            
            for (int i = 0; i < n; i++) {
            
                for (int j = 0; j < array.length - 1; j++) {
                	
                	char aux = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = aux;
                	
                }
            
            }
            
        }
        
    }
    

    /**
     * Reordena un arreglo de caracteres especificado, avanzando en n
     * posiciones la posición de cada caracter.
     * 
     * @param array El arreglo a reordenar
     * @param n El número de posiciones a avanzar por cada caracter
     */
    public static void avanzarPosicionesArray(char[] array, int n){
        
        if (array.length > 1 && n > 0) {
            
            for (int i = 0; i < n; i++) {
            
                for (int j = array.length - 1; j > 0; j--) {
                	
                	char aux = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = aux;
                	
                }

            }
            
        }

    }
    
    /**
     * Arreglo de caracteres que contiene los caracteres que reemplazarán
     * a los caracteres originales al ejecutar el proceso de sustitución.
     */
    private static final char[] CLAVE = {'s', 'M', 'k', 'É', 'i', '1', ')',
							             'H', '6', 'o', 'ó', '&', 'Í', 'g',
							             'y', 'P', 'ü', 'X', 'c', '7', 'Q',
							             'z', '¿', 'e', ' ', 'n', 'V', '!',
							             '$', '*', '4', 'h', 'í', '_', 'j',
							             'Ñ', 'R', 'm', '3', 'Ú', ';', 'a',
							             '.', '2', 'W', '9', 'B', '>', '¡',
							             'u', 'F', 'x', '+', 'E', 't', 'Á',
							             '%', '5', 'S', ':', 'l', ',', 'Ó',
							             '?', 'N', 'K', 'b', 'ú', '\\', 'Y',
							             'I', '<', 'f', 'A', '8', 'v', 'p',
							             'Z', 'O', '#', 'q', '/', 'C', 'L',
							             'T', 'w', 'ñ', '-', 'J', 'U', '\"',
							             'é', '\'', 'r', 'G', '(', '@', 'D',
							             '0', '=', 'á', 'Ü', 'd'};
    
    /**
     * Arreglo de caracteres que contiene el orden de los caracteres que
     * serán reemplazados al momento de ejecutar el proceso de sustitución.
     * Cualquier caracter que no esté en este arreglo no será reemplazado,
     * y se incluirá en el mensaje tal como es.
     */
    private static final char[] ORDEN = {'0', '1', '2', '3', '4', '5', '6',
							             '7', '8', '9', 'A', 'B', 'C', 'D',
							             'E', 'F', 'G', 'H', 'I', 'J', 'K',
							             'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 
							             'R', 'S', 'T', 'U', 'V', 'W', 'X',
							             'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
							             'f', 'g', 'h', 'i', 'j', 'k', 'l',
							             'm', 'n', 'ñ', 'o', 'p', 'q', 'r',
							             's', 't', 'u', 'v', 'w', 'x', 'y',
							             'z', 'Á', 'É', 'Í', 'Ó', 'Ú', 'Ü',
							             'á', 'é', 'í', 'ó', 'ú', 'ü', '<',
							             '>', '=', '¡', '!', '?', '¿', '\"',
							             '\'', '#', '$', '%', '&', '/', '(',
							             ')', '@', '+', '*', '.', ',', '-',
							             '_', ';', ':', '\\', ' '};
        
}
