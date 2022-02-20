package Q1;
import java.util.Scanner;

public class Q1{

    public static void main(String[] args) {
        wait(500);         //Esperando um pouco pro o usuario sentir que o programa está fazendo algo
        Scanner input = new Scanner(System.in);         // Chamando a função de entrada no console

        int n = 0;

        while(n <= 0){          //A altura da escada precisa ser positiva então o while checa isso para todas as entradas e retorna feedback pro usuario
            System.out.println("Por favor, escreva uma altura positiva");
            n = input.nextInt();        //Guardando o valor recebido pelo console
            System.out.println("Checando se a altura inserida é negativa ou zero");
            wait(500);
        }
        input.close();    //Como não vou mais usar o scanner estou fechando ele
        System.out.println("Tudo certo!!!!\nVamos construir sua escada agora");
        escada(n);     //chamando função que imprime escada

    }

    public static void escada(int n) {
        wait(500);         //Esperando um pouco pro o usuario sentir que o programa está fazendo algo
        System.out.println("Aguarde um momento, Preparando sua escada");
        wait(500);         //Esperando um pouco pro o usuario sentir que o programa está fazendo algo
        System.out.println("\n.");
        wait(500);         //Esperando um pouco pro o usuario sentir que o programa está fazendo algo
        System.out.println("\n.");
        wait(500);         //Esperando um pouco pro o usuario sentir que o programa está fazendo algo
        System.out.println("\n.");
        wait(500);         //Esperando um pouco pro o usuario sentir que o programa está fazendo algo
        
        
        String espaco = " ";
        String asterisco = "*";

        for(int i = n; i > 0; i--) { //loop onde faz n vezes o codigo abaixo
            System.out.println(espaco.repeat(i-1) + asterisco.repeat(n-(i-1)));
        }   //inicialmente eu ia fazer mais for loops pra realizar esse codigo mas encontrei esse comando String.repeat() o que facilitou muito
        
        System.out.println("\nSua escada de " + n + " de altura está pronta");

    }


    public static void wait(int ms){        //Função responsavel por fazer uma pausa.
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}