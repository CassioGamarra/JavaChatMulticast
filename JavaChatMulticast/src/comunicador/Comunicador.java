package comunicador;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 *
 * @author Cássio e Frederico
 */
public class Comunicador {
    public Comunicador(){
        
    }
    //Monta a mensagem
    public DatagramPacket montarMensagem(String mensagem, String ip, int porta) {
        try {
            byte[] buffer = mensagem.getBytes();
            //Montando o pacote com o buffer, o endereço e a porta
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), porta);
            return pacote;
        }
        catch (UnknownHostException ex) {
            System.out.println(ex); //Log no console
            return null;
        }
    }
    //Enviar a mensagem
    public void enviarMensagem(DatagramSocket socket, DatagramPacket pacote) {
        try {
            //Envia o pacote
            socket.send(pacote);
        }
        catch (IOException e) {
            System.out.println(e); //Log no console
        }
    }
    //Recebe a mensagem
    public DatagramPacket receberMensagem(DatagramSocket socket) {
        try {
            //Criando um pacote de 512 bytes
            DatagramPacket pacote = new DatagramPacket(new byte[512], 512);
            //Bloqueia enquanto aguarda a resposta
            socket.receive(pacote);
            return pacote;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}
