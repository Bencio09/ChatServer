package com.itismeucci.bencinicangelosi;

public class Comandi {
    char chiaveComando = '&';
    ServerThread serverThread;

    public Comandi(ServerThread serverThread){
        this.serverThread = serverThread;
    }

    public boolean isKey(String testoRicevuto){
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
                        serverThread.outVersoClient.writeBytes("Il comando inserito non è supportato.\nFai "+ chiaveComando +"? per una lista dei comandi disponibili");
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
            }
        }
    }
}
