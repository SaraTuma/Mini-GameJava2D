package game2d;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Sara Tuma
 *  * Estudante: Universidade Católica de Angola
 * Ano : 3º
 * Disciplina: Computação Gráfica
 * Tema: Mini-Jogo usando JAVA 2D
 */
public class Objecto {
    
    private int posx;
    private int posy;
    private int largura;
    private int altura;
    private int dx=1;
    private int dy=1;
    private Image img;
    
    public Objecto (int posx,int posy,int largura,int altura){
        this.posx=posx; this.posy=posy; this.altura=altura;
        this.largura= largura;        
    }
    
    public void load(){ 
        this.img = new ImageIcon(getClass().getResource("img/home2.png")).getImage();
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(posx,posy,largura,altura);
    }

}
