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
        char comando;
        String text;
        if(testoRicevuto.charAt(1) != '?'){
            text = testoRicevuto.toUpperCase();
            comando = text.charAt(1);
        }
        comando = testoRicevuto.charAt(1);
        switch (comando) {
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
                this.helpMessage();
                break;
            default:
                try {
                    serverThread.outVersoClient.writeBytes("Il comando inserito non è supportato.\nDigita "+ chiaveComando +"? per una lista dei comandi disponibili");
                } catch (Exception e) {
                    System.err.println(e);
                }
                break;
        }
    }

    public void helpMessage(){
        System.out.println(chiaveComando + "E ---> Serve per eseguire il logout dalla chat, la sintassi è: " + chiaveComando + "E\n");
        System.out.println(chiaveComando + "T ---> Serve per inviare un messaggio a un solo utente in particolare, la sintassi è: " + chiaveComando + "T <NOME UTENTE> <MESSAGGIO>\n");
        System.out.println(chiaveComando + "A ---> Serve per inviare un messaggio a tutti i partecipanti alla chat, la sintassi è: " + chiaveComando + "A <MESSAGGIO>\n");
        System.out.println(chiaveComando + "B ---> Serve per bannare (rimuovere) dalla chat un utente specifico, la sintassi è: " + chiaveComando + "B <NOME UTENTE>\n");
        System.out.println(chiaveComando + "L ---> Serve per listare (mostrare) tutti gli utenti della chat, la sintassi è: " + chiaveComando + "L\n");
        System.out.println(chiaveComando + "? ---> Mostra questo messaggio, la sintassi è: " + chiaveComando + "?\n");
    }
}
