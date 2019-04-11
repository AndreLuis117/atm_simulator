package entity;


import core.Session;
import tools.File_tools;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Transactions {


    public void deposit(Account account, double valor){
        String saldo = "0";
        try {
            Path path = Paths.get("C:\\Users\\dante\\Downloads\\contas.txt");
            FileReader fileReader = new FileReader(File_tools.accounts_file());
            BufferedReader reader = new BufferedReader(fileReader);
            String[] aux;
            String aux2;
            List<String> line = Files.readAllLines(path);

            for (int i = 0; i < line.size(); i ++) {
                aux = line.get(i).split(";");

                if (aux[0].equals(account.getNum_account())){
                    saldo = aux[2];
                    log_transaction(account,Double.valueOf(saldo),valor);
                    valor = valor + Double.valueOf(saldo);
                    aux2 = aux[0] + ";" + aux[1] + ";" + valor;
                    line.remove(i);
                    line.add(i,aux2);
                    break;

                }

            }

            fileReader.close();
            reader.close();

            FileWriter file_w = new FileWriter(File_tools.accounts_file(), false);
            BufferedWriter writer = new BufferedWriter(file_w);
            for (int i = 0; i < line.size(); i ++){
                writer.write(line.get(i));
                writer.newLine();

            }

            writer.close();
            file_w.close();

        } catch (Exception e){
            e.printStackTrace();
        }



    }

    public void transfer(Account account,int transfer_acc, double value){
        Transactions trans = new Transactions();
        trans.withdraw(account,value);
        Account account2 = new Account();
        account2.setNum_account(String.valueOf(transfer_acc));
        trans.deposit(account2, value);

    }

    public void withdraw(Account account, double value){
        String balance;
        try {
            FileReader fileReader = new FileReader(File_tools.accounts_file());
            BufferedReader read = new BufferedReader(fileReader);
            String aux2 = " ";
            String[] aux;
            List<String> line = Files.readAllLines(File_tools.accounts_path());

            for (int i = 0; i < line.size(); i ++) {
                aux = line.get(i).split(";");

                if (aux[0].equals(account.getNum_account())){
                    balance = aux[2];
                    log_transaction(account,Double.valueOf(balance),(-1*value));
                    value = Double.valueOf(balance) + (-1*value);
                    aux2 = aux[0] + ";" + aux[1] + ";" + value;
                    line.remove(i);
                    line.add(i,aux2);
                    break;

                }

            }


            fileReader.close();
            read.close();

            FileWriter writer = new FileWriter(File_tools.accounts_file(), false);
            BufferedWriter write = new BufferedWriter(writer);
            for (int i = 0; i < line.size(); i ++){
                write.write(line.get(i));
                write.newLine();

            }
            write.close();
            writer.close();

        } catch (Exception e){
            e.printStackTrace();
        }



    }

    public void log_transaction(Account account,Double current_balance, Double mov){
        try {
            FileReader fileReader = new FileReader(File_tools.statement_file());
            BufferedReader reader = new BufferedReader(fileReader);
            String[] aux;
            String aux2;
            List<String> line = Files.readAllLines(File_tools.statement_path());
            for (int i = 0; i < line.size(); i ++) {
                aux = line.get(i).split(";");

                if (aux[0].equals(account.getNum_account())){
                    aux2 = line.get(i) + "Saldo: " + String.valueOf(current_balance) + ";" + String.valueOf(mov) + ";" + "Saldo: " +String.valueOf(current_balance + mov) + ";" ;
                    line.remove(i);
                    line.add(i,aux2);
                    break;

                }

            }
            fileReader.close();
            reader.close();

            FileWriter file_w = new FileWriter(File_tools.statement_file(), false);
            BufferedWriter writer = new BufferedWriter(file_w);
            for (int i = 0; i < line.size(); i ++){
                writer.write(line.get(i));
                writer.newLine();

            }

            writer.close();
            file_w.close();

        } catch (Exception e){
            e.printStackTrace();
        }



    }
    public  void statement (Account account){
        try {
            FileReader fileReader = new FileReader(File_tools.statement_file());
            BufferedReader reader = new BufferedReader(fileReader);
            String line = " ";
            String[] aux;
            while (line != null) {
                line = reader.readLine();
                    aux = line.split(";");
                    if (aux[0].equals(account.getNum_account())) {
                        System.out.println("Extrato bancário completo: \n \n");
                        for (int i = 1; i < aux.length; i++) {
                            System.out.println(aux[i]);

                    }
                    break;
                }
            }
            fileReader.close();
            reader.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
