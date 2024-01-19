
package tablaperiodica_aq;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Tabla extends JFrame{
    private String texto1, texto2, texto3, texto4, texto5, texto6, elemento,elemento1, elemento2, elemento3, elemento4,Este, numero;
    private int Adivina,turno, x,y, n;
    //private ArrayList<String> Simbolo, Nombre;
        
    public Tabla() throws FileNotFoundException, IOException{
        //this.setUndecorated(true);
        this.setSize(1160,660);
        this.setLocationRelativeTo(null);
        PeridoGrupo();
        Elementos();
        Panel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
    }
    
    public void Panel(){
        x=1150;
        y=650;
        JPanel UPB = new JPanel();
        UPB.setLayout(null);
        UPB.setBounds(0,0,x,y);
        UPB.setBackground(Color.RED);
        this.getContentPane().add(UPB);
        
        //TÍTULO
        JLabel titulo = new JLabel();
        titulo.setFont(new Font("Arial",Font.BOLD,36));
        titulo.setText("ADIVINA QUIEN");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBounds(400,28,350,40);
        UPB.add(titulo);
        
        //Ayudas
        JLabel Tayudas = new JLabel();
        Tayudas.setFont(new Font("Arial",Font.BOLD,12));
        Tayudas.setText("AYUDAS");
        Tayudas.setHorizontalAlignment(SwingConstants.CENTER);
        Tayudas.setOpaque(true);
        Tayudas.setBounds(525,460,100,20);
        UPB.add(Tayudas);
        //Salir
        JButton salir = new JButton();
        salir.setFont(new Font("Arial",Font.BOLD,14));
        salir.setText("Salir");
        salir.setHorizontalAlignment(SwingConstants.CENTER);
        salir.setBounds(10, 620, 70, 22);
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
    
    private void Elementos() throws FileNotFoundException, IOException{
        //Generación del numero atómico aleatoriamente
        Adivina=(int)(Math.random()*53);
        System.out.println(Adivina);
        //Turno
        turno=12;
        JPanel Turno = new JPanel();
        Turno.setLayout(null);
        Turno.setBounds(1050,20,70,70);
        Turno.setBackground(Color.RED);
        this.getContentPane().add(Turno);
        
        JLabel Tconteo = new JLabel();
        Tconteo.setFont(new Font("Arial",Font.BOLD,16));
        Tconteo.setText("Intentos");
        Tconteo.setHorizontalAlignment(SwingConstants.CENTER);
        Tconteo.setOpaque(true);
        Tconteo.setBounds(0,0,70,20);
        Turno.add(Tconteo);
        JLabel Conteo = new JLabel();
        numero = turno+"";
        Conteo.setFont(new Font("Arial",Font.BOLD,36));
        Conteo.setText(numero);
        Conteo.setHorizontalAlignment(SwingConstants.CENTER);
        Conteo.setOpaque(true);
        Conteo.setBounds(0,20,70,50);
        Turno.add(Conteo);
        
        //Lectura de archivos 
        String archivo1= "src/tablaperiodica_aq/TXT/Elementos_Simbolo.txt";
        String archivo2= "src/tablaperiodica_aq/TXT/Elementos_Nombre.txt";
        String archivo3= "src/tablaperiodica_aq/TXT/CapaValencia.txt";
        String archivo4= "src/tablaperiodica_aq/TXT/Valencia.txt";
        String archivo5= "src/tablaperiodica_aq/TXT/SubcapaValencia.txt";
        String archivo6= "src/tablaperiodica_aq/TXT/Core.txt";
      
        ArrayList Simbolo = new ArrayList<String>();
        ArrayList NomEle = new ArrayList<String>();
        ArrayList CapaV = new ArrayList<String>();
        ArrayList Valencia = new ArrayList<String>();
        ArrayList SubcapaV = new ArrayList<String>();
        ArrayList Core = new ArrayList<String>();
        BufferedReader linea1 = null;
        BufferedReader linea2 = null;
        BufferedReader linea3 = null;
        BufferedReader linea4 = null;
        BufferedReader linea5 = null;
        BufferedReader linea6 = null;
        try {
            linea1 = new BufferedReader(new FileReader(archivo1));
            linea2 = new BufferedReader(new FileReader(archivo2));
            linea3 = new BufferedReader(new FileReader(archivo3));
            linea4 = new BufferedReader(new FileReader(archivo4));
            linea5 = new BufferedReader(new FileReader(archivo5));
            linea6 = new BufferedReader(new FileReader(archivo6));
            //Simbolo
            texto1=linea1.readLine();
            Simbolo.add(texto1);
            while((texto1=linea1.readLine())!=null){
                Simbolo.add(texto1);
                texto1=linea1.readLine();
                Simbolo.add(texto1);
            }
            //Nombre
            texto2=linea2.readLine();
            NomEle.add(texto2);
            while((texto2=linea2.readLine())!=null){
                NomEle.add(texto2);
                texto2=linea2.readLine();
                NomEle.add(texto2);
            }
            //Capa de Valencia
            texto3=linea3.readLine();
            CapaV.add(texto3);
            while((texto3=linea3.readLine())!=null){
                CapaV.add(texto3);
                texto3=linea3.readLine();
                CapaV.add(texto3);
            }
            //Valencia
            texto4=linea4.readLine();
            Valencia.add(texto4);
            while((texto4=linea4.readLine())!=null){
                Valencia.add(texto4);
                texto4=linea4.readLine();
                Valencia.add(texto4);
            }
            //Subcapa de Valencia
            texto5=linea5.readLine();
            SubcapaV.add(texto5);
            while((texto5=linea5.readLine())!=null){
                SubcapaV.add(texto5);
                texto5=linea5.readLine();
                SubcapaV.add(texto5);
            }
            //Electrones Internos
            texto6=linea6.readLine();
            Core.add(texto6);
            while((texto6=linea6.readLine())!=null){
                Core.add(texto6);
                texto6=linea6.readLine();
                Core.add(texto6);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error: Fichero no encontrado");
            JOptionPane.showMessageDialog(null,"Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        }
        Este=Simbolo.get(Adivina).toString();
        //Ayudas
        //Electrones Internos
        JPanel JCore = new JPanel();
        JCore.setLayout(null);
        JCore.setBounds(130,480,220,40);
        JCore.setOpaque(false);
        this.getContentPane().add(JCore);
        JButton Acore = new JButton();
        Acore.setFont(new Font("Arial",Font.BOLD,14));
        Acore.setText("Electrónes Internos");
        Acore.setHorizontalAlignment(SwingConstants.CENTER);
        Acore.setBounds(0, 0, 220, 20);
        JCore.add(Acore);
        JLabel EI = new JLabel();
        EI.setFont(new Font("Arial",Font.BOLD,14));
        texto1=Core.get(Adivina).toString();
        EI.setText(texto1);
        EI.setHorizontalAlignment(SwingConstants.CENTER);
        EI.setOpaque(true);
        EI.setBounds(20, 20, 180, 20);
        EI.setVisible(false);
        JCore.add(EI);
        ActionListener AcCore = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  Acore.setEnabled(false);
                  EI.setVisible(true);
                  turno=turno-4;
                  numero = turno+"";
                  if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                      } catch (IOException ex) {
                          Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                      dispose();
                  }
                  Conteo.setText(numero);
                }
            };
        Acore.addActionListener(AcCore);
        //Electrones de Valencia
        JPanel JValen = new JPanel();
        JValen.setLayout(null);
        JValen.setBounds(355,480,220,40);
        JValen.setOpaque(false);
        this.getContentPane().add(JValen);
        JButton Avalen = new JButton();
        Avalen.setFont(new Font("Arial",Font.BOLD,14));
        Avalen.setText("Electrónes de Valencia");
        Avalen.setHorizontalAlignment(SwingConstants.CENTER);
        Avalen.setBounds(0, 0, 220, 20);
        JValen.add(Avalen);
        JLabel EV = new JLabel();
        EV.setFont(new Font("Arial",Font.BOLD,14));
        texto1=Valencia.get(Adivina).toString();
        EV.setText(texto1);
        EV.setHorizontalAlignment(SwingConstants.CENTER);
        EV.setOpaque(true);
        EV.setBounds(20, 20, 180, 20);
        EV.setVisible(false);
        JValen.add(EV);
        ActionListener AcValen = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  Avalen.setEnabled(false);
                  EV.setVisible(true);
                  turno=turno-4;
                  numero = turno+"";
                   if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                      } catch (IOException ex) {
                          Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                      dispose();
                  }
                  Conteo.setText(numero);
                }
            };
        Avalen.addActionListener(AcValen);
        //Subcapas de valencia
        JPanel Jscapa = new JPanel();
        Jscapa.setLayout(null);
        Jscapa.setBounds(585,480,220,40);
        Jscapa.setOpaque(false);
        this.getContentPane().add(Jscapa);
        JButton Ascapa = new JButton();
        Ascapa.setFont(new Font("Arial",Font.BOLD,14));
        Ascapa.setText("Subcapas de Valencia");
        Ascapa.setHorizontalAlignment(SwingConstants.CENTER);
        Ascapa.setBounds(0, 0, 220, 20);
        Jscapa.add(Ascapa);
        JLabel Scapa = new JLabel();
        Scapa.setFont(new Font("Arial",Font.BOLD,14));
        texto1=SubcapaV.get(Adivina).toString();
        Scapa.setText(texto1);
        Scapa.setHorizontalAlignment(SwingConstants.CENTER);
        Scapa.setOpaque(true);
        Scapa.setBounds(20, 20, 180, 20);
        Scapa.setVisible(false);
        Jscapa.add(Scapa);
        ActionListener AcScapa = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  Ascapa.setEnabled(false);
                  Scapa.setVisible(true);
                  turno=turno-4;
                  numero = turno+"";
                   if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                      } catch (IOException ex) {
                          Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                      dispose();
                  }
                  Conteo.setText(numero);
                }
            };
        Ascapa.addActionListener(AcScapa);
        //Nivel de Energía mas alto
        JPanel JEnergia = new JPanel();
        JEnergia.setLayout(null);
        JEnergia.setBounds(810,480,220,40);
        JEnergia.setOpaque(false);
        this.getContentPane().add(JEnergia);
        JButton Aenergia = new JButton();
        Aenergia.setFont(new Font("Arial",Font.BOLD,14));
        Aenergia.setText("Nivel de Energia mas alto");
        Aenergia.setHorizontalAlignment(SwingConstants.CENTER);
        Aenergia.setBounds(0, 0, 220, 20);
        JEnergia.add(Aenergia);
        JLabel Energia = new JLabel();
        Energia.setFont(new Font("Arial",Font.BOLD,14));
        texto1=CapaV.get(Adivina).toString();
        Energia.setText(texto1);
        Energia.setHorizontalAlignment(SwingConstants.CENTER);
        Energia.setOpaque(true);
        Energia.setBounds(20, 20, 180, 20);
        Energia.setVisible(false);
        JEnergia.add(Energia);
        ActionListener AcEnergia = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                  Aenergia.setEnabled(false);
                  Energia.setVisible(true);
                  turno=turno-4;
                  numero = turno+"";
                   if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                      } catch (IOException ex) {
                          Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                      dispose();
                  }
                  Conteo.setText(numero);
                }
            };
        Aenergia.addActionListener(AcEnergia);
        //x=900;//Largo de la tabla
        //y=350;//Alto de la tabla
        
        //Grupo A1
        JPanel A1 = new JPanel();
        A1.setLayout(null);
        A1.setBounds(130,100,50,350);
        this.getContentPane().add(A1);
        int a=50,b=0;
        int k=0;
        for(int i=0;i<7;i++){
            elemento=Simbolo.get(k).toString();
            JButton elemento = new JButton();
            if(i==0){
               elemento.setBackground(Color.WHITE);
            }else{
                elemento.setBackground(Color.ORANGE);
            }
            texto1=Simbolo.get(k).toString();
            elemento.setFont(new Font("Arial",Font.BOLD,11));
            //System.out.println(texto1);
            elemento.setText(texto1);
            elemento.setHorizontalAlignment(SwingConstants.CENTER);
            elemento.setBounds(0, b, a, a);
            if(i>=5){
                elemento.setEnabled(false);
            }
                
            b=b+50;
            A1.add(elemento);
            if(k==Adivina){
                ActionListener Action = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String simbol=Simbolo.get(Adivina).toString();
                        String nom=NomEle.get(Adivina).toString();
                        int n=1;
                        try {  
                            RTA rta = new RTA(simbol,nom,Adivina,n);
                            rta.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    }
                };
                elemento.addActionListener(Action);
            }else{
                ActionListener Accion = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        elemento.setEnabled(false);
                        elemento.setBackground(Color.LIGHT_GRAY);
                        turno=turno-1;
                         if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                          } catch (IOException ex) {
                             Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      
                           dispose();
                        }
                        numero = turno+"";
                        Conteo.setText(numero);
                    }
                };
                elemento.addActionListener(Accion);
            };
            if(i==0){
                k=k+2;
                System.out.println(k);
            }else if(i==1 || i==2){
                k=k+8;
            }else if(i==3||i==4){
                k=k+18;
            }else if(i==5){
                k=k+32;
            }
        //Grupo A2
        JPanel A2 = new JPanel();
        A2.setLayout(null);
        A2.setBounds(180,150,50,300);
        this.getContentPane().add(A2);
        int c=50,d=0;
        int w=3;
        for(int j=0;j<6;j++){
            elemento1=Simbolo.get(w).toString();
            JButton elemento1 = new JButton();
            elemento1.setBackground(Color.orange);
            texto1=Simbolo.get(w).toString();
            elemento1.setFont(new Font("Arial",Font.BOLD,11));
            elemento1.setText(texto1);
            elemento1.setHorizontalAlignment(SwingConstants.CENTER);
            elemento1.setBounds(0, d, c, c);
            if(j>=4){
                elemento1.setEnabled(false);
            }
            d=d+50;
            A2.add(elemento1);
            if(w==Adivina){
                ActionListener Action = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String simbol=Simbolo.get(Adivina).toString();
                        String nom=NomEle.get(Adivina).toString();
                        int n=1;
                        try {  
                            RTA rta = new RTA(simbol,nom,Adivina,n);
                            rta.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    }
                };
                elemento1.addActionListener(Action);
            }else{
                ActionListener Accion = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        elemento1.setEnabled(false);
                        elemento1.setBackground(Color.LIGHT_GRAY);
                        turno=turno-1;
                         if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                         } catch (IOException ex) {
                           Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                         }
                      
                           dispose();
                         }
                        numero = turno+"";
                        Conteo.setText(numero);
                    }
                };
                elemento1.addActionListener(Accion);
            };
            if(j==0 || j==1){
                w=w+8;
            }else if(j==2||j==3){
                w=w+18;
            }else if(j==4){
                w=w+32;
            }
        }
        //Grupo A8
        JPanel A8 = new JPanel();
        A8.setLayout(null);
        A8.setBounds(980,100,50,350);
        this.getContentPane().add(A8);
        int e=50,f=0;
        int l=1;
        for(int p=0;p<7;p++){
            elemento2=Simbolo.get(l).toString();
            JButton elemento2 = new JButton();
            elemento2.setBackground(Color.MAGENTA);
            texto1=Simbolo.get(l).toString();
            elemento2.setFont(new Font("Arial",Font.BOLD,11));
            elemento2.setText(texto1);
            elemento2.setHorizontalAlignment(SwingConstants.CENTER);
            elemento2.setBounds(0, f, e, e);
            if(p>=5){
                elemento2.setEnabled(false);
            }
            f=f+50;
            A8.add(elemento2);
            if(l==Adivina){
                ActionListener Action = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String simbol=Simbolo.get(Adivina).toString();
                        String nom=NomEle.get(Adivina).toString();
                        int n=1;
                        try {  
                            RTA rta = new RTA(simbol,nom,Adivina,n);
                            rta.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    }
                };
                elemento2.addActionListener(Action);
            }else{
                ActionListener Accion = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        elemento2.setEnabled(false);
                        elemento2.setBackground(Color.LIGHT_GRAY);
                        turno=turno-1;
                         if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                         } catch (IOException ex) {
                          Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                         }
                      
                           dispose();
                         }
                        numero = turno+"";
                        Conteo.setText(numero);
                    }
                };
                elemento2.addActionListener(Accion);
            };
            if(p==0 || p==1){
                l=l+8;
            }else if(p==2||p==3){
                l=l+18;
            }else if(p==4||p==5){
                l=l+32;
            }
        }
        //Grupos A3-A5
        JPanel A = new JPanel();
        A.setLayout(null);
        A.setBounds(730,150,250,300);
        this.getContentPane().add(A);
        int g=50,h=0,j=0;
        int q=4;
        for(int s=0;s<30;s++){
            elemento3=Simbolo.get(q).toString();
            JButton elemento3 = new JButton();
            texto1=Simbolo.get(q).toString();
            elemento3.setBackground(Color.CYAN);
            elemento3.setFont(new Font("Arial",Font.BOLD,11));
            elemento3.setText(texto1);
            elemento3.setHorizontalAlignment(SwingConstants.CENTER);
            elemento3.setBounds(h, j, g, g);
            if(s>=20){
                elemento3.setEnabled(false);
            }
            h=h+50;
            A.add(elemento3);
            if(q==Adivina){
                ActionListener Action = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String simbol=Simbolo.get(Adivina).toString();
                        String nom=NomEle.get(Adivina).toString();
                        int n=1;
                        try {  
                            RTA rta = new RTA(simbol,nom,Adivina,n);
                            rta.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    }
                };
                elemento3.addActionListener(Action);
            }else{
                ActionListener Accion = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        elemento3.setEnabled(false);
                        elemento3.setBackground(Color.LIGHT_GRAY);
                        turno=turno-1;
                         if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                        } catch (IOException ex) {
                          Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                         dispose();
                        }
                        numero = turno+"";
                        Conteo.setText(numero);
                    }
                };
                elemento3.addActionListener(Accion);
            };
            q=q+1;
            if(s==4){
                h=0;j=j+50;
                q=12;
            }else if(s==9){
                h=0;j=j+50;
                q=30;
            }else if(s==14){
                h=0;j=j+50;
                q=48;
            }else if(s==19){
                h=0;j=j+50;
                q=80;
                
            }else if(s==24){
                h=0;j=j+50;
                q=112;
            }
        }
        //Metales de transicion
        JPanel T = new JPanel();
        T.setLayout(null);
        T.setBounds(230,250,500,200);
        this.getContentPane().add(T);
        int r=50,t=0,u=0;
        int v=20;
        for(int s=0;s<40;s++){
            elemento4=Simbolo.get(v).toString();
            JButton elemento4 = new JButton();
            texto1=Simbolo.get(v).toString();
            elemento4.setBackground(Color.YELLOW);
            elemento4.setFont(new Font("Arial",Font.BOLD,11));
            elemento4.setText(texto1);
            elemento4.setHorizontalAlignment(SwingConstants.CENTER);
            elemento4.setBounds(t, u, r, r);
            if(s>=20){
                elemento4.setEnabled(false);
            }
            t=t+50;
            T.add(elemento4);
            if(v==Adivina){
                ActionListener Action = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String simbol=Simbolo.get(Adivina).toString();
                        String nom=NomEle.get(Adivina).toString();
                        int n=1;
                        try {  
                            RTA rta = new RTA(simbol,nom,Adivina,n);
                            rta.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    }
                };
                elemento4.addActionListener(Action);
            }else{
                ActionListener Accion = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        elemento4.setEnabled(false);
                        elemento4.setBackground(Color.LIGHT_GRAY);
                        turno=turno-1;
                         if(turno<1){
                      try {
                          String simbol=Simbolo.get(Adivina).toString();
                          String nom=NomEle.get(Adivina).toString();
                          int n=0;
                          RTA rta = new RTA(simbol,nom,Adivina,n);
                          rta.setVisible(true);
                        } catch (IOException ex) {
                          Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
                        }
                      
                         dispose();
                       }   
                        numero = turno+"";
                        Conteo.setText(numero);
                    }
                };
                elemento4.addActionListener(Accion);
            };
            v=v+1;
            if(s==9){
                t=0;u=u+50;
                v=38;
            }else if(s==19){
                t=0;u=u+50;
                v=70;
            }else if(s==29){
                t=0;u=u+50;
                v=103;
            }
        }
    }
           
}
    
    private void PeridoGrupo(){
        
        JPanel P = new JPanel();
        P.setLayout(null);
        P.setBounds(80, 100, 50, 350);
        P.setOpaque(false);
        //P.setBackground(Color.red);
        this.getContentPane().add(P);
        ArrayList gp = new ArrayList<>();
        gp.add("1");gp.add("2");gp.add("3");gp.add("4");gp.add("5");gp.add("6");gp.add("7");
        int x=1;
        for(int i=0;i<7;i++){
            JLabel periodo = new JLabel();
            periodo.setFont(new Font("Arial",Font.BOLD,36));
            periodo.setBackground(new Color(0,0,0,0));
            periodo.setForeground(Color.WHITE);
            periodo.setText(gp.get(i).toString());
            periodo.setHorizontalAlignment(SwingConstants.CENTER);
            periodo.setOpaque(true);
            periodo.setBounds(x,y,50,50);
            y=y+50;
            P.add(periodo);
        }
        //Grupos
        ArrayList gg = new ArrayList<>();
        gg.add("1A");gg.add("8A");gg.add("2A");gg.add("3A");gg.add("4A");gg.add("5A");gg.add("6A");gg.add("7A");
        gg.add("3B");gg.add("4B");gg.add("5B");gg.add("6B");gg.add("7B");gg.add("8B");gg.add("8B");gg.add("8B");gg.add("1B");gg.add("2B");
        for(int j=0;j<18;j++){
            JPanel G = new JPanel();
            G.setLayout(null);
            JLabel grupo = new JLabel();
            grupo.setFont(new Font("Arial",Font.BOLD,30));
            grupo.setBackground(new Color(0,0,0,0));
            grupo.setForeground(Color.WHITE);
            grupo.setBounds(0,0,50,50);
            grupo.setText(gg.get(j).toString());
            grupo.setHorizontalAlignment(SwingConstants.CENTER);
            grupo.setOpaque(true);
            switch(j){
                case 0: G.setBounds(130, 50, 50, 50); break;
                case 1: G.setBounds(980, 50, 50, 50); break;
                case 2: G.setBounds(180, 100, 50, 50); break;
                case 3: G.setBounds(730, 100, 50, 50); break;
                case 4: G.setBounds(780, 100, 50, 50); break;
                case 5: G.setBounds(830, 100, 50, 50); break;
                case 6: G.setBounds(880, 100, 50, 50); break;
                case 7: G.setBounds(930, 100, 50, 50); break;
                case 8: G.setBounds(230, 200, 50, 50); break;
                case 9: G.setBounds(280, 200, 50, 50); break;
                case 10: G.setBounds(330, 200, 50, 50); break;
                case 11: G.setBounds(380, 200, 50, 50); break;
                case 12: G.setBounds(430, 200, 50, 50); break;
                case 13: G.setBounds(480, 200, 50, 50); break;
                case 14: G.setBounds(530, 200, 50, 50); break;
                case 15: G.setBounds(580, 200, 50, 50); break;
                case 16: G.setBounds(630, 200, 50, 50); break;
                case 17: G.setBounds(680, 200, 50, 50); break;
            }
            G.setOpaque(false);
            this.getContentPane().add(G);
            G.add(grupo);
        }
        
    }
}
