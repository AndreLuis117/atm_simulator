package core;

import entity.Account;
import tools.File_tools;

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

                if (validate_login(account) == true) {
                    Session.session_user = account;
                    System.out.println("LOGIN EFETUADO COM SUCESSO!");
                    validated = true;

                } else {
                    throw new Exception("FALHA NO LOGIN! REVISE AS CREDENCIAIS E TENTE NOVAMENTE.");

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
            FileReader fileReader = new FileReader(File_tools.accounts_file());
            BufferedReader read = new BufferedReader(fileReader);
            String line = " ";
            String[] aux;
            while (line != null && validated == false) {
                line = read.readLine();
                aux = line.split(";");
                if (aux[0].equals(account.getNum_account()) & aux[1].equals(account.getId_pass())){
                    validated = true;
                }
                else {
                    throw new Exception("Não foram encontrados registros correspondentes.");
                }
            }

            fileReader.close();
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validated;
    }


    }



