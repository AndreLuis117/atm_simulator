import core.Session;
import entity.Account;
import entity.Transactions;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static  void  main(String[] args) throws IOException {
        Boolean finish = false;
        String input = "0";
        String input2 = "0";
        Account account = new Account();
        Transactions trans = new Transactions();
        Scanner read_in = new Scanner(System.in);
    while (true) {
        System.out.println("Qual serviço você deseja usar?\n" +
                "Digite '1' para abrir uma conta \n" +
                "Digite '2' para fazer LOGIN");
        input = read_in.next();


        switch (input) {
            case "1":
                System.out.println("Digite seu Id Pass");
                input = read_in.next();
                account.reg_account(Long.valueOf(input));

            case "2":
                System.out.println("Digite o número da sua conta");
                input = read_in.next();
                account.setNum_account(input);
                System.out.println("Digite o seu Id Pass");
                input2 = read_in.next();
                account.setId_pass(input2);
                if (Session.login(account) == true) {
                    while (true) {
                        System.out.println("Qual serviço você deseja usar?\n" +
                                "Digite 1 para consultar saldo\n" +
                                "Digite 2 para depositar\n" +
                                "Digite 3 para realizar um saque\n" +
                                "Digite 4 para fazer transferência entre contas\n" +
                                "Digite 5 para consultar um extrato");
                        input = read_in.next();
                        switch (input) {
                            case "1":
                                System.out.println("Saldo: " + account.consul_balance(Session.get_session_user()));
                                break;

                            case "2":
                                System.out.println("Digite o valor que deseja depositar em sua conta");
                                input = read_in.next();
                                trans.deposit(Session.get_session_user(), Double.valueOf(input));
                                System.out.println("Depósito concluído com sucesso!");
                                break;
                            case "3":
                                System.out.println("Digite o valor que deseja sacar");
                                input = read_in.next();
                                trans.withdraw(Session.get_session_user(), Double.valueOf(input));
                                System.out.println("Saque concluído com sucesso!");
                                break;
                            case "4":
                                System.out.println("Digite a conta para qual deseja realizar a transferência");
                                input = read_in.next();
                                System.out.println("Digite o valor que deseja transferir");
                                input2 = read_in.next();
                                trans.transfer(Session.get_session_user(), Integer.valueOf(input), Double.valueOf(input2));
                                System.out.println("Transferência realizada com sucesso!");
                                break;

                            case  "5":
                                trans.statement(Session.get_session_user());
                        }
                        System.out.println("\n------------------------------------------------------------------------------\n"+
                                "Deseja fazer logoff?\n" +
                                "Digite 1 para fazer logoff\n" +
                                "Digite 2 para NÃO fazer logoff e retornar ao inicio do menu");
                        input = read_in.next();
                        if (input.equals("1")) {
                            break;
                        }

                    }
                }


        }


    }

    }
}











