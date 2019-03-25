package entity;

import core.Session;
import tools.File_tools;

import java.io.*;


public class Account {
    private double balance;
    private String id_pass;
    private String num_account;

    public String getId_pass() {
        return id_pass;
    }

    public void setId_pass(String id_pass) {
        this.id_pass = id_pass;
    }

    public String getNum_account() {
        return num_account;
    }

    public void setNum_account(String num_account) {
        this.num_account = num_account;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public  void reg_account(long id_pass) {
        File_tools file_tools = new File_tools();
        try {
            FileWriter file = new FileWriter(File_tools.accounts_file(), true);
            BufferedWriter write = new BufferedWriter(file);
            write.write(String.valueOf(file_tools.file_size() + 1)+";");
            write.write(String.valueOf(id_pass)+ "#");
            write.write("0");
            write.newLine();
            write.close();
            file.close();
            } catch (Exception e){
            e.printStackTrace();
        }


    }

    //Consulta de contas e informações - Método para retornar todas as contas, senhas e saldos
    public void consul_all_accounts(){
        try {
            FileReader file_reader = new FileReader(File_tools.accounts_file());
            BufferedReader read = new BufferedReader(file_reader);
            String line = read.readLine();
            while (line != null) {
                System.out.println(line);
                line = read.readLine();
            }

            file_reader.close();
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Consulta de saldo - Método para retornar saldo da account bancária
    public String consul_balance(Account account){
        String balance = "0";
        boolean validated = false;
        try {
            FileReader file_reader = new FileReader(File_tools.accounts_file());
            BufferedReader read = new BufferedReader(file_reader);
            String line = " ";
            String aux;

            while (line != null & validated == false) {
                line = read.readLine();
                aux = line;
                line = line.substring(0,line.indexOf(";")) + line.substring(line.indexOf(";") + 1, line.indexOf("#"));

                if (line.equals(account.getNum_account() + account.getId_pass())){
                    balance = aux.substring(aux.indexOf("#") +1, aux.length());
                    validated = true;
                }

            }
            file_reader.close();
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return balance;
    }



}
