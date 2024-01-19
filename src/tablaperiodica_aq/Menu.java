
package tablaperiodica_aq;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JFrame{
    public Menu()throws FileNotFoundException, IOException{
        this.setUndecorated(true);
        this.setSize(970,550);
        this.setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.RED);
        Panel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    
    public void Panel(){
        int x,y;
        x=960;
        y=540;
        JPanel UPB = new JPanel();
        UPB.setLayout(null);
        UPB.setBounds(0,0,970,550);
        UPB.setBackground(Color.RED);
        this.getContentPane().add(UPB);
        
        //TÍTULO
        JLabel titulo = new JLabel();
        titulo.setFont(new Font("Arial",Font.BOLD,36));
        titulo.setText("ADIVINA QUIEN");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBounds(310,28,350,40);
        UPB.add(titulo);
        
        //Table Periodica
        JButton tp = new JButton();
        tp.setFont(new Font("Arial",Font.BOLD,14));
        tp.setText("Table Periódica");
        tp.setHorizontalAlignment(SwingConstants.CENTER);
        tp.setBounds(100, 370, 200, 40);
        UPB.add(tp);
        ActionListener selcTP = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Tabla tabla;
                try {
                    tabla = new Tabla();
                    tabla.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }                
                dispose();                
            }
        };
        tp.addActionListener(selcTP);
        
        //Compuesto Químicos
        JButton cq = new JButton();
        cq.setFont(new Font("Arial",Font.BOLD,14));
        cq.setText("Compuestos Químicos");
        cq.setHorizontalAlignment(SwingConstants.CENTER);
        cq.setBounds(385, 370, 200, 40);
        UPB.add(cq);
        
        //Salir
        //Compuesto Químicos
        JButton salir = new JButton();
        salir.setFont(new Font("Arial",Font.BOLD,14));
        salir.setText("Salir");
        salir.setHorizontalAlignment(SwingConstants.CENTER);
        salir.setBounds(670, 370, 200, 40);
        UPB.add(salir);
        ActionListener selcSalir = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();                
            }
        };
        salir.addActionListener(selcSalir);
        
        //Fondo
        JLabel upb = new JLabel();
        ImageIcon imUPB = new ImageIcon("src/tablaperiodica_aq/Imagenes/UPB.jpg");
        upb.setIcon(new ImageIcon(imUPB.getImage().getScaledInstance(x,y,Image.SCALE_SMOOTH)));
        upb.setOpaque(false);
        upb.setBounds(5,5,x,y);
        UPB.add(upb);
        
        
    }

   
    
}
