package tools;

public class Printer {

    public static void initial_menu(){
        System.out.println(
                "Qual serviço você deseja usar?\n" +
                "Digite '1' para abrir uma conta \n" +
                "Digite '2' para fazer LOGIN");
    }

    public  static void main_menu(){
        System.out.println(
                "Qual serviço você deseja usar?\n" +
                "Digite 1 para consultar saldo\n" +
                "Digite 2 para depositar\n" +
                "Digite 3 para realizar um saque\n" +
                "Digite 4 para fazer transferência entre contas\n" +
                "Digite 5 para consultar um extrato");
    }

    public static void final_menu(){
        System.out.println("\n------------------------------------------------------------------------------\n"+
                "Deseja fazer logoff?\n" +
                "Digite 1 para FAZER logoff\n" +
                "Digite 2 para NÃO fazer logoff e retornar ao início do menu");

    }

}
