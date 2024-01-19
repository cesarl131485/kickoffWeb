
package tablaperiodica_aq;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Cargando extends JFrame {
   public Cargando(String arch){
       Logo(arch);
       this.setUndecorated(true);
       this.setSize(1000,250);
       this.setLocationRelativeTo(null);
       this.getContentPane().setLayout(null);
       this.getRootPane().setOpaque(false);
       this.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
       this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
       
   }

    
   
   private void Logo(String arch){
       JLabel logo = new JLabel();
       ImageIcon imagen = new ImageIcon("src/tablaperiodica_aq/Imagenes/Logo1.jpg");
       logo.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(1000,176, Image.SCALE_SMOOTH)));
       logo.setOpaque(false);
       logo.setBounds(0,0,1000,176);
       JLabel porcentaje = new JLabel("100%");
       porcentaje.setOpaque(false);
       porcentaje.setLabelFor(null);
       porcentaje.setFont(new Font("Arial",Font.BOLD,18));
       porcentaje.setHorizontalAlignment(SwingConstants.CENTER);
       porcentaje.setBounds(650,20,46,30);
       porcentaje.setBackground(Color.WHITE);
       this.getContentPane().add(porcentaje);
       this.getContentPane().add(logo);
       JProgressBar barra = new JProgressBar();
       barra.setBounds(350,70,600,20);
       this.getContentPane().add(barra);
       
       
       String archivo = arch;
       
       Thread hilo = new Thread(new Runnable() {
            int x=0;
            //int y=60;
            @Override
            public void run() {
                try{
                    while(x<=100){
                        barra.setValue(x);
                        porcentaje.setText(x+"%");
                        x++;
                        //y=y-60/100;
                        Thread.sleep(60);
                    }
                    dispose();
                    if(arch=="Menu"){
                        Menu menu;
                        menu =  new Menu();
                        menu.setVisible(true);
                    }
                    } catch (InterruptedException ex) {
                    Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
                }
            
        });
        hilo.start();
       
   }
    
      
}

