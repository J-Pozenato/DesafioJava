package Q2;
import java.util.Scanner; // Chamando a classe de entrada no console
import java.util.regex.Pattern; //importando a classe que define e checa padrões

public class Q2 {
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    // Chamando a função de entrada no console
        String senha;  
        boolean senhaValida = false;
             
        
        while(!senhaValida) {            //loop até a senhaValida se tornar verdadeiro
            int numCaracter = 0;         //numero de caracteres minimo necessarios para completar a senha    

            System.out.print("Escreva sua senha:");
            senha = input.next();
            

            if (!checaMaiuscolo(senha)) { //chamando a função que checa letra Maiscula
                numCaracter ++;           // caso não tenha nenhuma letra Maiscula adicionar 1 ao numero de caracteres
            }
            if (!checaMinusculo(senha)) { //chamando a função que checa letra minuscula
                numCaracter ++;           // caso não tenha nenhuma letra minuscula adicionar 1 ao numero de caracteres
            }
            if (!checaNum(senha)) {       //chamando a função que checa numeros
                numCaracter ++;           // caso não tenha nenhum numero adicionar 1 ao numero de caracteres
            }
            if (!checaCaracterEspecial(senha)) { //chamando a função que checa caracter especial
                numCaracter ++;           // caso não tenha nenhum caracter especial adicionar 1 ao numero de caracteres
            }
            if(!checa6(senha)) {  //chamando a função que checa o numero total de caracteres
                numCaracter += (6 - (numCaracter + senha.length()));  // caso não tenha o numero minimo de caracteres e a soma de caracteres que precisam ser adicionados com os existentes for menor que 6 adicionar ao numero de caracteres minimo que vai ser retornado ao usuario
            }

            if(numCaracter == 0) {  // Checando se é necessario alguma mudança na senha, ou seja, se o numero de caracteres minimo que precisam ser adicionados é 0, se for 0 a senha é valida
                senhaValida = true;
            } else {
                System.out.println("Sua senha precisa de no minimo mais " + numCaracter + " Caracteres");  // Avisando o usuario de quantos caracteres no minimo ele precisa adicionar
            }



        }

        input.close();


        
    }

    public static  boolean checa6(String senha) {
        if(senha.length() >= 6) { //checando se a senha tem no minimo 6 caracteres
            return(true);
        }
        System.out.println("Sua senha precisa ter no minimo 6 caracteres"); // Avisando o usuario que a senha precisa de no minimo 6 caracteres caso ela não tenha
        return(false);

    }
    public static  boolean checaNum(String senha) {
        Pattern numPattern = Pattern.compile("[0-9 ]");  //preparando o padrão que precisa ser checado

        if(numPattern.matcher(senha).find()) { //checando o padrão
            return(true);
        }
        System.out.println("Sua senha precisa ter no minimo 1 numero"); // Avisando o usuario que a senha precisa de no minimo 1 numero caso ela não tenha
        return(false);

    }
    public static  boolean checaMaiuscolo(String senha) {
        Pattern maiusculoPattern = Pattern.compile("[A-Z ]");  //preparando o padrão que precisa ser checado

        if(maiusculoPattern.matcher(senha).find()) { //checando o padrão
            return(true);
        }
        System.out.println("Sua senha precisa ter no minimo 1 letra Maiuscula"); // Avisando o usuario que a senha precisa de no minimo 1 letra maiuscula caso ela não tenha
        return(false);
    }
    public static  boolean checaMinusculo(String senha) {
        Pattern minusculoCasePattern = Pattern.compile("[a-z ]");  //preparando o padrão que precisa ser checado
        
        if(minusculoCasePattern.matcher(senha).find()) { //checando o padrão
            return(true);
        }
        System.out.println("Sua senha precisa ter no minimo 1 letra Minuscula"); // Avisando o usuario que a senha precisa de no minimo 1 letra minuscula caso ela não tenha
        return(false);
    }
    public static  boolean checaCaracterEspecial(String senha) {
        Pattern especialPattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);  //preparando o padrão que precisa ser checado

        
        if(especialPattern.matcher(senha).find()) { //checando o padrão
            return(true);
        }
        System.out.println("Sua senha precisa ter no minimo 1 desses caracteres: !@#$%^&*()-+"); // Avisando o usuario que a senha precisa de no minimo 1 caracter especial caso ela não tenha
        return(false);
    }
}
