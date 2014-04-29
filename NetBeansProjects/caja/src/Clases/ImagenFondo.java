package Clases;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
/**
 *
 * @author STARK
 */
public class ImagenFondo implements Border{
    public BufferedImage back;
    public ImagenFondo(){
        try{
            URL imagePath = new URL(getClass().getResource("../siscajaImagenes/fondo0.jpg").toString());
            back=ImageIO.read(imagePath);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    @Override
    public void paintBorder(Component C, Graphics g, int x,  int y, int width, int height) {
        g.drawImage(back, (x +(width - back.getWidth())/2),(y +(height - back.getHeight())/2), null);
    }

    @Override
    public Insets getBorderInsets(Component C) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
    
}
