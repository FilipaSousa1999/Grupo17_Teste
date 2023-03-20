import javax.swing.*;
import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main ( String[] args ) {
        //ServerThread server = new ServerThread ( 8888 );
        try {
            //creates the objects to instantiate the server
            JLabel lblMessage = new JLabel("Porta do servidor: ");
            JTextField txtPorta = new JTextField("8888");
            Object[] texts = {lblMessage, txtPorta};
            JOptionPane.showMessageDialog(null, texts);
            ServerSocket server = new ServerSocket(Integer.parseInt(txtPorta.getText()));
            ArrayList<BufferedWriter> clientes = new ArrayList<BufferedWriter>();
            JOptionPane.showMessageDialog(null, "Servidor ativo na porta: " + txtPorta.getText());

            while (true) {
                System.out.println("Aguardar conexão...");
                Socket con = server.accept();
                System.out.println("Cliente conetado...");
                Thread t = new ServerThread(con);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}