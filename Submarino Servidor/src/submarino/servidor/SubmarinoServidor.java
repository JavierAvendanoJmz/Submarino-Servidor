/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package submarino.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Partida;

/**
 *
 * @author j4v13
 */
public class SubmarinoServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket server = new ServerSocket(3000);
            System.out.println("inicio");
            while(true) {
                Socket cliente1 = server.accept();
                System.out.println("Jugador 1: conectado");
                Socket cliente2 = server.accept();
                System.out.println("Jugador 2: conectado");
                Partida partida = new Partida(cliente1,cliente2);
                partida.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SubmarinoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
