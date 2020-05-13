import cliente.FrameChat;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cássio e Frederico
 */

public class Main {
    public static void main(String[] args) {
        //Try catch apenas para definir o look and feel para windows
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try {
            FrameChat chat = new FrameChat();
            chat.setLocationRelativeTo(null);
            chat.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
