
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

public class RTA extends JFrame{
    private int n;
    public RTA(String simbol,String nom, int Adivina, int n)throws FileNotFoundException, IOException{
        //this.setUndecorated(true);
        this.setSize(970,550);
        this.setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.RED);
        Panel(simbol,nom,Adivina,n);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
    }
    
    public void Panel(String simbol,String nom, int Adivina, int n){
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
        titulo.setFont(new Font("Arial",Font.BOLD,28));
        JLabel Stil= new JLabel();
        Stil.setFont(new Font("Arial",Font.BOLD,24));
        if(n==0){
            titulo.setText("No Acertaste");
            Stil.setText("El elmento era:");
        }else if(n==1){
            titulo.setText("Acertaste el Elemento");
            Stil.setText("El elmento es:");
        }
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBounds(310,28,350,40);
        UPB.add(titulo);
        Stil.setHorizontalAlignment(SwingConstants.CENTER);
        Stil.setOpaque(true);
        Stil.setBounds(310,70,350,40);
        UPB.add(Stil);
        //Numero
        JLabel Numero = new JLabel();
        Numero.setFont(new Font("Arial",Font.BOLD,30));
        int num=Adivina+1;
        String N =num+"";
        Numero.setText(N);
        Numero.setHorizontalAlignment(SwingConstants.CENTER);
        Numero.setOpaque(true);
        Numero.setBounds(535,120,50,50);
        UPB.add(Numero); 
        //Nombre
        JLabel Nombre = new JLabel();
        Nombre.setFont(new Font("Arial",Font.BOLD,20));
        Nombre.setText(nom);
        Nombre.setHorizontalAlignment(SwingConstants.CENTER);
        Nombre.setOpaque(true);
        Nombre.setBounds(385,270,200,40);
        UPB.add(Nombre);
        //Simbolo
        JLabel Simbolo = new JLabel();
        Simbolo.setFont(new Font("Arial",Font.BOLD,80));
        Simbolo.setText(simbol);
        Simbolo.setHorizontalAlignment(SwingConstants.CENTER);
        Simbolo.setOpaque(true);
        Simbolo.setBounds(385,120,200,200);
        UPB.add(Simbolo);
        
        
        
        //Menu
        //Compuesto Químicos
        JButton menu = new JButton();
        menu.setFont(new Font("Arial",Font.BOLD,14));
        menu.setText("Menu");
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.setBounds(670, 370, 200, 40);
        UPB.add(menu);
        ActionListener selcMenu = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Menu menu = null;
                try {
                    menu = new Menu();
                } catch (IOException ex) {
                    Logger.getLogger(RTA.class.getName()).log(Level.SEVERE, null, ex);
                }
                menu.setVisible(true);
                dispose();                
            }
        };
        menu.addActionListener(selcMenu);
        
        //Fondo
        JLabel upb = new JLabel();
        ImageIcon imUPB = new ImageIcon("src/tablaperiodica_aq/Imagenes/UPB.jpg");
        upb.setIcon(new ImageIcon(imUPB.getImage().getScaledInstance(x,y,Image.SCALE_SMOOTH)));
        upb.setOpaque(false);
        upb.setBounds(5,5,x,y);
        UPB.add(upb);
        
        
    }

   
    
}
