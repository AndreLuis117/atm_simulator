package core;

import entity.Account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Session {
    private static Account session_user;

    public static Account get_session_user() {

        return session_user;
    }



    public static boolean login(Account account) {
        boolean validated = false;

        try {
            if (validate_login(account)== true) {
                Session.session_user = account;
                System.out.println("LOGIN EFETUADO COM SUCESSO!");
                validated = true;

            }
            else {
                System.out.println("FALHA NO LOGIN! REVISE AS CREDENCIAIS E TENTE NOVAMENTE.");

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }





        return validated;
    }

    public static boolean validate_login(Account account){
        boolean validated = false;
        try {
            File arq = new File("C:\\Users\\dante\\Downloads\\contas.txt");
            FileReader fileReader = new FileReader(arq);
            BufferedReader ler = new BufferedReader(fileReader);
            String line = " ";
            while (line != null & validated == false) {

                line = ler.readLine();
                line = line.substring(0,line.indexOf(";")) + line.substring(line.indexOf(";") + 1, line.indexOf("#"));

                if (line.equals(account.getNum_account() + account.getId_pass())){
                    validated = true;
                }

            }
            fileReader.close();
            ler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validated;
    }


    }



