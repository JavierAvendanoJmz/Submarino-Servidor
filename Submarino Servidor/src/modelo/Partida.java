/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j4v13
 */
public class Partida extends Thread {
    
    private Socket cliente1;
    private Socket cliente2;  
    private ObjectInputStream reader1;
    private ObjectOutputStream writer1;
    private ObjectInputStream reader2;
    private ObjectOutputStream writer2;

    public Partida(Socket cliente1, Socket cliente2) throws IOException {
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
        this.reader1 = new ObjectInputStream(cliente1.getInputStream());
        this.writer1 = new ObjectOutputStream(cliente1.getOutputStream());
        this.reader2 = new ObjectInputStream(cliente2.getInputStream());
        this.writer2 = new ObjectOutputStream(cliente2.getOutputStream());
    }
    
    public void cerrarConexion() throws IOException {
        this.reader1.close();
        this.writer1.close();
        this.reader2.close();
        this.writer2.close();
        this.cliente1.close();
        this.cliente2.close();
    }

    @Override
    public void run() {
        try {
            int victoria = 0;
            System.out.println((String)reader1.readObject());
            System.out.println("run2");
            System.out.println((String)reader2.readObject());
            System.out.println("run3");
            writer1.writeObject("1");
            System.out.println("run4");
            writer2.writeObject("-1");
            System.out.println("run5");
            while(victoria == 0) {
                
                
                System.out.println("hola");
                String s = (String)reader1.readObject();
                System.out.println(s);
                writer2.writeObject(s);
                s = (String)reader2.readObject();
                System.out.println("mapa,victoria"+s);
                writer1.writeObject(s);
                if(s.charAt(1) == '1')
                    victoria = 1;
                System.out.println("hol2");
                
                
                if(victoria == 0)    {      
                    s = (String)reader2.readObject();
                    System.out.println(s);
                    writer1.writeObject(s);
                    s = (String)reader1.readObject();
                    System.out.println(s);                    
                    
                    writer2.writeObject(s); 
                    
                    if(s.charAt(1) == '1')
                        victoria = 1;
                    System.out.println("hol2");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
