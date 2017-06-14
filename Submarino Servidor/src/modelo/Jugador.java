/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j4v13
 */
public class Jugador extends Thread {
    
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    private Partida partida;

    public Jugador(ObjectInputStream reader, ObjectOutputStream writer, Partida partida) {
        this.reader = reader;
        this.writer = writer;
        this.partida = partida;
    }
    
    public void cerrarConexion() throws IOException {
        reader.close();
        writer.close();
    }
    
    public int[] tira() throws IOException {
        int f = reader.readInt();
        int c = reader.readInt();
        int[] i = {f,c};
        return i;
    }

    @Override
    public void run() {
        try {
            boolean f = true;
            reader.readInt();
            while(f) {
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
