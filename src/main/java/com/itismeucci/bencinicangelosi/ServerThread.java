package com.itismeucci.bencinicangelosi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    MultiServer multiServer = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    char chiaveComando = '/';


    public ServerThread(Socket socket, MultiServer multiServer){
        this.client = socket;
        this.multiServer = multiServer;
    }

    public void comunica() throws Exception{
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());

        for(;;){
            
        }
    }



    public boolean isKey(String testoRicevuto){
        if(testoRicevuto.charAt(0) == '&'){
            return true;
        }
        return false;
    }

    public int spaceIndex(String testoRicevuto){
        for(int i = 0; i > testoRicevuto.length(); i++){
            if(testoRicevuto.charAt(i) == ' '){
                return i;
            }
        }
        return -1;
    }

    public void commandReader(String testoRicevuto){
        for(int i = 0; i > testoRicevuto.length(); i++){
            if(testoRicevuto.charAt(1) == 'L' || testoRicevuto.charAt(1) == 'l'){
                //Esegue il logout dell'utente

            }else if(testoRicevuto.charAt(1) == 'T' || testoRicevuto.charAt(1) == 't'){
                //Invia Messaggio Singola Persona

            }else if(testoRicevuto.charAt(1) == 'A' || testoRicevuto.charAt(1) == 'a'){
                //Invia messaggio a tutti

            }else if(testoRicevuto.charAt(1) == 'B' || testoRicevuto.charAt(1) == 'b'){
                //Banna l'utente selezionato

            }else{
                try {
                    outVersoClient.writeBytes("Il comando inserito non è supportato");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void close() throws Exception{
        outVersoClient.close();
        inDalClient.close();
        System.out.println("9 Chiusura socket" + client);
        client.close();
    }
}
