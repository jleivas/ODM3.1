
import entities.Ficha;
import fn.FnFicha;
import java.awt.Font;
import java.io.File;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author home
 */
public class NewClass {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        DecimalFormat formateador = new DecimalFormat("###,###,###"); 
//        int valor = 200700;
//        String v1 = ""+formateador.format (valor);
//        System.out.println (v1);
//        String v2 = v1.replace(".", "");
//        v2 = v2.replace(",", "");
//        System.out.println (v1);
        Date d1 = new Date(-604070999750L);
        System.out.println(""+d1);
    }
    
}
