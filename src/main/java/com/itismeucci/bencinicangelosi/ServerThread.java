package com.itismeucci.bencinicangelosi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    MultiServer multiServer = null;
    Socket client = null;
    String nomeUtente = null;
    String stringaRicevuta = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    Comandi comandi;

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

    public void comunica() throws Exception{
        for(;;){
            comandi.commandReader(inDalClient.readLine());
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
            comunica();
        } catch (Exception e) {
            System.out.println("Non è stato possibile eseguire il metodo comunica\n");
        }
    }
}
