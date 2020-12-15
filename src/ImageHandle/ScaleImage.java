/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageHandle;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author acer
 */
public class ScaleImage {
    private ImageIcon icon;
    public ImageIcon ScaleImageProduct(String path){
        icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        return scaledIcon;
    }
}
