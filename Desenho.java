package game2d;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sara Tuma
 * Estudante: Universidade Católica de Angola
 * Ano : 3º
 * Disciplina: Computação Gráfica
 * Tema: Mini-Jogo usando JAVA 2D
 */
public final class Desenho extends JPanel implements Runnable{

    Thread t = new Thread(this);
    Teclado entrada = new Teclado();
    private int nCarros=0;
    private int py=0,qmov=5;
    private int ponto=0,nivel=1,vida=3,sleep=15;
    private Random novo = new Random();
    private Image img = new ImageIcon(getClass().getResource("img/gameOver.jpg")).getImage();
    private boolean gameOver=false;
    private Image fundo=new ImageIcon(getClass().getResource("img/fundoJogo.jpg")).getImage();
    Objecto estrada,pessoa;
    Carro carro1,carro2,carro3,carro4,carro5,carro6,carro7,carro8,carro9,carro10,carro11,carro12;
    //Carregando o som ou audio
    URL url =getClass().getResource("img/somEstrada.wav");
    AudioClip audio = Applet.newAudioClip(url);
    
    
    public Desenho()
    {
        JFrame f = new JFrame();
        f.setSize(1000,700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.addKeyListener(entrada);
        f.setLocationRelativeTo(null);
        this.setSize(700,700);
        this.setVisible(true);
            
        estrada=new Objecto(100,0,600,this.getHeight());
        pessoa = new Objecto(30,this.getHeight()/2,50,70); pessoa.load();
            // posy da estrada +100
        carro1=new Carro(estrada.getPosx()+225,10); carro1.setBaixo(true); carro1.load();
        carro2=new Carro(estrada.getPosx()+230,400); carro2.setBaixo(true); carro2.load();  
        carro3=new Carro(estrada.getPosx()+230,6800); carro3.setBaixo(true); carro3.load();    
        carro4=new Carro(estrada.getPosx()+230,1200); carro4.setBaixo(true); carro4.load();
        carro5=new Carro(estrada.getPosx()+50,10); carro5.setDy(-1); carro5.load();
        carro6=new Carro(estrada.getPosx()+50,400); carro6.setDy(-1); carro6.load();
        carro7=new Carro(estrada.getPosx()+50,800); carro7.setDy(-1); carro7.load();    
        carro8=new Carro(estrada.getPosx()+50,1200); carro8.setDy(-1); carro8.load();    
        carro9=new Carro(estrada.getPosx()+410,10); carro9.setDy(-1); carro9.load();    
        carro10=new Carro(estrada.getPosx()+410,300); carro10.setDy(-1); carro10.load();    
        carro11=new Carro(estrada.getPosx()+410,600); carro11.setDy(-1); carro11.load();
        carro12=new Carro(estrada.getPosx()+410,900); carro12.setDy(-1); carro12.load();
                    
        t.start();
        f.add(this);
        f.setVisible(true);
    } 
      
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(fundo,0,0,this.getWidth(),this.getHeight(), this);
        if(gameOver){
            //Imagem e testos que aparecem no final
            g2.drawImage(img, 0,0,this.getWidth(),this.getHeight(),Color.RED, this);
            g2.setColor(Color.green);
            Font font = new Font("Serif", Font.BOLD, 30);
            g2.setFont(font);
            g2.drawString("PONTUAÇÃO : "+ponto,this.getWidth()/2-100,600);
            if(nivel==4)
                g2.drawString("VOCÊ VENCEU, PARABÉNS!!",this.getWidth()/2-150,650);
        }else{
        
            // AREA DA PONTUAÇAO
            g2.setColor(Color.BLACK);
            g2.fillRoundRect(750, this.getHeight()/2, 200, 130, 20, 20);
            g2.setColor(Color.green);
            Font font = new Font("Serif", Font.BOLD, 20);
            g2.setFont(font);
            g2.drawString("PONTO : "+ponto, 800, (this.getHeight()/2)+40);
            g2.drawString("VIDA : "+vida, 800, (this.getHeight()/2)+70);
            g2.drawString("NIVEL : "+nivel, 800, (this.getHeight()/2)+100);

            //Desenhando a estrada
            g2.setColor(Color.BLACK);
            g2.fillRect(estrada.getPosx(), estrada.getPosy(), estrada.getLargura(), estrada.getAltura());
            //   Pintando a estrada
            float dashes[] = { 70 }; // specify dash pattern          
                g2.setPaint( Color.WHITE );                            
            g2.setStroke( new BasicStroke( 5, BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND, 120, dashes, 0 ) );
            g2.draw( new Line2D.Double( 320, 0, 320, this.getHeight() ) );
            g2.draw( new Line2D.Double( 508, 0, 508, this.getHeight() ) );

           //Desenhando os 12 carros
           g2.drawImage(carro1.getImg(), carro1.getPosx(),carro1.getPosy() ,carro1.getLargura(),carro1.getAltura(),Color.black, this);
           g2.drawImage(carro2.getImg(), carro2.getPosx(),carro2.getPosy() ,carro2.getLargura(),carro2.getAltura(),Color.black, this);
           g2.drawImage(carro3.getImg(), carro3.getPosx(),carro3.getPosy() ,carro3.getLargura(),carro3.getAltura(),Color.black, this);
           g2.drawImage(carro4.getImg(), carro4.getPosx(),carro4.getPosy() ,carro4.getLargura(),carro4.getAltura(),Color.black, this);
           g2.drawImage(carro5.getImg(), carro5.getPosx(),carro5.getPosy() ,carro5.getLargura(),carro5.getAltura(),Color.black, this);
           g2.drawImage(carro6.getImg(), carro6.getPosx(),carro6.getPosy() ,carro6.getLargura(),carro6.getAltura(),Color.black, this);
           g2.drawImage(carro7.getImg(), carro7.getPosx(),carro7.getPosy() ,carro7.getLargura(),carro7.getAltura(),Color.black, this);
           g2.drawImage(carro8.getImg(), carro8.getPosx(),carro8.getPosy() ,carro8.getLargura(),carro8.getAltura(),Color.black, this);
           g2.drawImage(carro9.getImg(), carro9.getPosx(),carro9.getPosy() ,carro9.getLargura(),carro9.getAltura(),Color.black, this);
           g2.drawImage(carro10.getImg(), carro10.getPosx(),carro10.getPosy() ,carro10.getLargura(),carro10.getAltura(),Color.black, this);
           g2.drawImage(carro11.getImg(), carro11.getPosx(),carro11.getPosy() ,carro11.getLargura(),carro11.getAltura(),Color.black, this);
           g2.drawImage(carro12.getImg(), carro12.getPosx(),carro12.getPosy() ,carro12.getLargura(),carro12.getAltura(),Color.black, this);

            // Desenhando a Pessoa  
            g2.drawImage(pessoa.getImg(),pessoa.getPosx(), pessoa.getPosy(), pessoa.getLargura(), pessoa.getAltura(),this);
        }
    }
        
    public void dormir(){
        try {
            t.sleep(sleep);
        } catch (InterruptedException ex) {
            Logger.getLogger(Desenho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void actualizar(){
        // Verificando o nivel para aumentar a velocidade do jogo
        //Ou seja mexendo na variavel qie permite a thread dormir
        if(nivel==2) sleep=8;
        if(nivel==3) sleep=3;
        if(nivel==4) vida=0;
        
        if(pessoa.getPosx()==estrada.getPosx()+estrada.getLargura()){
            JOptionPane.showMessageDialog(this, "YOU WIN !!", "Parabéns!!! Pontuação: "+ponto, -1);
            pessoa.setPosx(30); pessoa.setPosy(this.getHeight()/2); 
            if(entrada.isDireita()) entrada.setDireita(false);
            nivel++;
        }  
        // Actualizando a posicão e imagaemde cada carro
        repaintCarro(carro1); repaintCarro(carro2); repaintCarro(carro3); repaintCarro(carro4);
        repaintCarro(carro5); repaintCarro(carro6);repaintCarro(carro7); repaintCarro(carro8);
        repaintCarro(carro9); repaintCarro(carro10);repaintCarro(carro11); repaintCarro(carro12);
        
        //Verificando a colisão entre a pessoa e cada carro da estrada
        verifColisao(carro2); verifColisao(carro3); verifColisao(carro4);
        verifColisao(carro5); verifColisao(carro6); verifColisao(carro7); 
        verifColisao(carro8); verifColisao(carro9);
        verifColisao(carro10); verifColisao(carro11); verifColisao(carro12);
        
        // TECLADO
       if(entrada.isCima() && pessoa.getPosy()>0){
           pessoa.setPosy(pessoa.getPosy()-5); 
           if(pessoa.getPosx()>=estrada.getPosx()+10)
               ponto+=qmov;
       }
       if(entrada.isBaixo() && pessoa.getPosy()+pessoa.getAltura()<this.getHeight()){
           pessoa.setPosy(pessoa.getPosy()+5);
           if(pessoa.getPosx()>=estrada.getPosx()+10)
               ponto+=qmov;
       }
       if(entrada.isDireita() && pessoa.getPosx()+pessoa.getLargura()<this.getWidth()) {
            pessoa.setPosx(pessoa.getPosx()+5); 
            ponto+=qmov;
       }
    }
       
    @Override
    public void run() {
       this.audio.loop();
        while(vida>0){
            actualizar();
            repaint();
            dormir();
        }
        this.audio.stop();
        gameOver=true;
        repaint();       
    }
    
    private void repaintCarro(Carro c){
        if(c.getPosy()==-510){
            c.setPosy(this.getHeight()+10); c.load();
        }
        else if(c.getPosy()==this.getHeight()+210){
            c.setPosy(-510); c.load();
        }     
        c.setPosy(c.getDy()+c.getPosy());
    }
        
    //Método para verificar colisão, aqui crio dois rectângulos e verifico se eles se intersectam.
    private void verifColisao(Carro c){
       Rectangle area1 = new Rectangle(c.getPosx(),c.getPosy(),c.getLargura(),c.getAltura());
       Rectangle area2 = new Rectangle(pessoa.getPosx(),pessoa.getPosy(),pessoa.getLargura(),pessoa.getAltura());
       
       if(area1.getBounds().intersects(area2)){
            JOptionPane.showMessageDialog(this, "PERDEU UMA VIDA", "UM CHOQUE", JOptionPane.NO_OPTION);
            vida--;
            if(entrada.isDireita()) entrada.setDireita(false);
                pessoa.setPosx(30); pessoa.setPosy(this.getHeight()/2);
       }
    }
  
}
