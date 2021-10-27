package com.itismeucci.bencinicangelosi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    MultiServer multiServer = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    Comandi comandi;
    //char chiaveComando = '&';


    public ServerThread(Socket socket, MultiServer multiServer){
        this.client = socket;
        this.multiServer = multiServer;
        this.comandi = comandi;
    }

    public void comunica() throws Exception{
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outVersoClient = new DataOutputStream(client.getOutputStream());

        for(;;){
            
        }
    }



    /* public boolean isKey(String testoRicevuto){
        if(testoRicevuto.charAt(0) == chiaveComando){
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

            switch (testoRicevuto.charAt(1)) {
                case 'E':
                    //Esegue il logout dell'utente
                    break;
                case 'T':
                    //Invia Messaggio Singola Persona
                    break;
                case 'A':
                    //Invia messaggio a tutti
                    break;
                case 'B':
                    //Banna l'utente selezionato
                    break;
                case 'L':
                    //Mostra gli utenti connessi
                    break;
                case '?':
                    //Mostra una lista dei comandi disponibili
                    break;
                default:
                    try {
                        outVersoClient.writeBytes("Il comando inserito non è supportato.\nFai "+ chiaveComando +"? per una lista dei comandi disponibili");
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
            }
        }
    } */
    
    public void close() throws Exception{
        outVersoClient.close();
        inDalClient.close();
        System.out.println("9 Chiusura socket" + client);
        client.close();
    }
}
