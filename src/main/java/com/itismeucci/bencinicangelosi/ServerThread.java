package com.itismeucci.bencinicangelosi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread
{
    MultiServer multiServer = null;
    Socket client = null;
    String nomeUtente = null;
    String stringaRicevuta = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    Comandi comandi;
    boolean stato = true;

    public ServerThread(Socket socket, MultiServer multiServer){
        this.client = socket;
        this.multiServer = multiServer;
        this.comandi = new Comandi(this);
        
        try {
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
            this.nomeUtente = inDalClient.readLine();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
    
    public void close() throws Exception{
        outVersoClient.close();
        inDalClient.close();
        System.out.println("9 Chiusura socket" + client);
        client.close();
    }

    public void run(){
        try {
            login();
            for(;;){
                stringaRicevuta = inDalClient.readLine();
                comandi.commandReader(stringaRicevuta);
            }
        } catch (Exception e) {
            System.out.println("Non è stato possibile eseguire il metodo comunica\n");
        }
    }

    public void login()throws Exception{
        boolean isAdded;

        comandi.commandReader("&t Benvenuto!!!\nInserisci il tuo username");
        
        
    }

}
