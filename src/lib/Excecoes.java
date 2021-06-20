package lib;

public class Excecoes {
    
     public static void isNulo ( String atributo, String valor ) {

	if ( valor == null || valor.isEmpty()) 
            throw new IllegalArgumentException( atributo + " não pode ser nulo!");		
    }
     
     public static void verificaTamanho ( String atributo, String valor ) {

	if ( valor.length() < 8 ) 
            throw new IllegalArgumentException( atributo + " tem que possuir no minimo oito caracteres");		
    }
     
      public static void menorQueZero ( String atributo, int valor ) {

	if ( valor <= 0 ) 
            throw new IllegalArgumentException( atributo + " tem que ser maior que 0");		
    }
    
}
