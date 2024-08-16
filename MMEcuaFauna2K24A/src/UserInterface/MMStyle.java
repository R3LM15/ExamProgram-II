package UserInterface;

import java.net.URL;
import javax.swing.JOptionPane;
public abstract class MMStyle {
   
    public static final URL URL_LOGO  = MMStyle.class.getResource("/UserInterface/Resource/Img/Logo.png");
    public static final URL URL_SPLASH= MMStyle.class.getResource("/UserInterface/Resource/Img/Logo.png");

    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, " EcuaFauna2K24A", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, " EcuaFauna2K24A", JOptionPane.OK_OPTION);
    }
    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, " EcuaFauna2K24A", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}
