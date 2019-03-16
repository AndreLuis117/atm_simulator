package entity;


import core.Session;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Transactions {


    public void deposit(Account account, double valor){
        String saldo = "0";
        try {
            File file = new File("C:\\Users\\dante\\Downloads\\contas.txt");
            Path path = Paths.get("C:\\Users\\dante\\Downloads\\contas.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String aux = " ";
            List<String> linhas = Files.readAllLines(path);
            for (int i = 0; i < linhas.size(); i ++) {
                if (linhas.get(i).substring(0, linhas.get(i).indexOf(";")).equals(account.getNum_account())){
                    saldo = linhas.get(i).substring(linhas.get(i).indexOf("#") + 1,linhas.get(i).length());
                    log_transaction(account,Double.valueOf(saldo),valor);
                    valor = valor + Double.valueOf(saldo);
                    aux = linhas.get(i).substring(0,linhas.get(i).indexOf("#") +1 ) + String.valueOf(valor);
                    linhas.remove(i);
                    linhas.add(i,aux);
                    break;

                }

            }
            fileReader.close();
            reader.close();

            FileWriter file_w = new FileWriter(file, false);
            BufferedWriter writer = new BufferedWriter(file_w);
            for (int i = 0; i < linhas.size(); i ++){
                writer.write(linhas.get(i));
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
        String balance = "0";
        try {
            File file = new File("C:\\Users\\dante\\Downloads\\contas.txt");
            Path path = Paths.get("C:\\Users\\dante\\Downloads\\contas.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader read = new BufferedReader(fileReader);
            String line = " ";
            String aux = " ";
            long aux2 = 0;
            List<String> lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size(); i ++) {
                if (lines.get(i).substring(0, lines.get(i).indexOf(";")).equals(Session.get_session_user().getNum_account())){
                    balance = lines.get(i).substring(lines.get(i).indexOf("#") + 1,lines.get(i).length());
                    log_transaction(Session.get_session_user(), Double.valueOf(balance), (-1*value));
                    value = Double.valueOf(balance) + (-1*value);
                    aux = lines.get(i).substring(0,lines.get(i).indexOf("#") + 1 ) + String.valueOf(value);
                    lines.remove(i);
                    lines.add(i,aux);
                    break;

                }

            }
            fileReader.close();
            read.close();

            FileWriter writer = new FileWriter(file, false);
            BufferedWriter write = new BufferedWriter(writer);
            for (int i = 0; i < lines.size(); i ++){
                write.write(lines.get(i));
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
            File file = new File("C:\\Users\\dante\\Downloads\\extratos.txt");
            Path path = Paths.get("C:\\Users\\dante\\Downloads\\extratos.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String[] aux;
            String aux2;
            List<String> linhas = Files.readAllLines(path);
            for (int i = 0; i < linhas.size(); i ++) {
                aux = linhas.get(i).split(";");

                if (aux[0].equals(account.getNum_account())){
                    aux2 = linhas.get(i) + "Saldo: " + String.valueOf(current_balance) + ";" + String.valueOf(mov) + ";" + "Saldo: " +String.valueOf(current_balance + mov) + ";" ;
                    linhas.remove(i);
                    linhas.add(i,aux2);
                    break;

                }

            }
            fileReader.close();
            reader.close();

            FileWriter file_w = new FileWriter(file, false);
            BufferedWriter writer = new BufferedWriter(file_w);
            for (int i = 0; i < linhas.size(); i ++){
                writer.write(linhas.get(i));
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
            File file = new File("C:\\Users\\dante\\Downloads\\extratos.txt");
            FileReader fileReader = new FileReader(file);
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
