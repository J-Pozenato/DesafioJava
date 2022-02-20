package Q3;

import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Q3 {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str1 = "1";
        Pattern numPattern = Pattern.compile("[0-9 ]");  //preparando o padrão que checa se tem numeros na string
        Pattern especialPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);  //preparando o padrão que checa se tem caracteres especiais na string
        int resultado = 0;

        while(numPattern.matcher(str1).find() || especialPattern.matcher(str1).find() ){ //caso tenha algum numero na string, repetir o loop até receber uma string só de letras

            System.out.println("Escreva uma palavra"); 
            
            str1 = input.next();
            
        }
        
        input.close();
        

        for(int i = 0; i < str1.length(); i++ ) { 
            for(int j = (i+1); j <= str1.length(); j++){
                String str2 = str1.substring(i, j);             // monta a segunda string para enviar pro contador de anagramas
                    resultado += contaAnagrama(str1.substring(i, str1.length()), str2); 
            }       //envia duas strings para a Função que conta a quantidade de Anagramas, o envio é feito eliminando as partes ja checadas.
        }

        System.out.println("A palavra \"" + str1 + "\" possui " + resultado + " Anagramas" );

    }

    
    
    
    static boolean checaAnagrama(String s1, String s2) { // Função utilizada para ver se duas string são iguais


        char[] ch1 = s1.toCharArray();              // converte as strings para Arrays
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);               // organiza os Arrays na ordem alfabetica
        Arrays.sort(ch2);

        if (Arrays.equals(ch1, ch2))          // Checa a igualdade entra os dois Arrays, se for igual então são anagramas
            return true;
        else
            return false;
    }
 
    static int contaAnagrama(String text, String word) {    // recebe duas strings e conta quantos anagramas tem entre elas

        int N = text.length();
        int n = word.length();
        int res = -1;                                       // defini como -1, para que ele não conte ele mesmo como um anagrama
 
        for (int i = 0; i <= N - n; i++) {
 
            String s = text.substring(i, i + n);
 
            
            if (checaAnagrama(word, s))     //chama a função que checa se duas strings são anagramas 
                res++;
        }
     
        return res; //retorna a quantidade de anagramas encontrados para as duas strings
    }
}


