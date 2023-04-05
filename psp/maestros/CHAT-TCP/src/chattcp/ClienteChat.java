
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ClienteChat extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    static JTextField mensaje = new JTextField();
    static JTextArea textarea1;
    
    public static void main(String args[]) {
        int puerto = 44444;
        String dirServidor = "localhost";
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");
        // Socket s = new Socket("localhost", Servidor.PUERTO);
        // Creacion del socket, y la conexion a la maquina remota con direccion
        // IP "192.168.0.193"
        //
        Socket s = null;
        try {
            s = new Socket(dirServidor, puerto);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + e.getMessage(),
                    "<<MENSAJE DE ERROR:1>>", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if (!nombre.trim().equals("")) {
            ClienteChat cliente = new ClienteChat(s, nombre);
            cliente.setBounds(0, 0, 540, 400);
            cliente.setVisible(true);
            cliente.ejecutar();
        } else {
            System.out.println("El nombre esta vacio....");
        }
    }// fin main
    
    
    Socket socket = null;
    // streams
    DataInputStream fentrada;
    DataOutputStream fsalida;
    String nombre;

    private JScrollPane scrollpane1;
    JButton boton = new JButton("Enviar");
    JButton desconectar = new JButton("Salir");
    boolean repetir = true;

    //constructor ClienteChat
    public ClienteChat(Socket s, String nombre) {
        super(" CONEXION DEL CLIENTE CHAT: " + nombre);
        setLayout(null);

        mensaje.setBounds(10, 10, 400, 30);
        add(mensaje);

        textarea1 = new JTextArea();
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10, 50, 400, 300);
        add(scrollpane1);
        boton.setBounds(420, 10, 100, 30);
        add(boton);
        desconectar.setBounds(420, 50, 100, 30);
        add(desconectar);

        textarea1.setEditable(false);
        boton.addActionListener(this);
        desconectar.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        socket = s;
        this.nombre = nombre;
        try {
            fentrada = new DataInputStream(socket.getInputStream());
            // CREO FLUJO DE SALIDA AL socket de escritura
            fsalida = new DataOutputStream(socket.getOutputStream());
            String texto = nombre + "> Entra en el Chat... ";
            fsalida.writeUTF(texto);
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            e.printStackTrace();
            System.exit(0);
        }
    }// fin constructor

    // accion cuando pulsamos botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) { // SE PULSA EL ENVIAR
            String texto = nombre + "> " + mensaje.getText();
            try {
                mensaje.setText("");
                fsalida.writeUTF(texto);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == desconectar) { // SE PULSA DESCONECTAR
            String texto =  nombre+"-> Abandona el chat.";
            try {
                fsalida.writeUTF(texto);
                fsalida.writeUTF("*");
                repetir = false;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }// fin actionPerformed

    //
    public void ejecutar() {
        String texto = "";
        while (repetir) {
            try {
                texto = fentrada.readUTF();
                textarea1.setText(texto);
            } catch (IOException e) {
                // este error sale cuando el servidor se cierra
                JOptionPane.showMessageDialog(null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + e.getMessage(), "<<MENSAJE DE ERROR:2>>", JOptionPane.ERROR_MESSAGE);
                // System.exit(0);
                repetir = false;
            }
        }// fin while

        try {
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// fin ejecutar
}// fin ClienteChat
