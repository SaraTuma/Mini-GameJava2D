package game2d;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * @author :  Sara Tuma
 * Estudante: Universidade Católica de Angola
 * Ano : 3º
 * Disciplina: Computação Gráfica
 * Tema: Mini-Jogo usando JAVA 2D
 */
public class Carro {
    private int posx;
    private int posy;
    //Todo carro terá o mesmo tamanho (altura e largura)
    private int largura=160;
    private int altura=200;
    private int dx=1;
    private int dy=1;
    private Image img;
    // Lista para colocar todas imagens de carros para o jogo
    private ArrayList<String> carro= new ArrayList(); 
    // Valor aleatório para alterar a imagem dos carros
    private Random novo = new Random();
    private boolean baixo;
  
    
    public Carro (int posx,int posy){
        this.posx=posx; this.posy=posy;       
    }

    //Método para carregar a imagem do carro de forma aleartória
    public void load(){  // Aqui crio duas listas, mas para cada carro cria-se apenas uma!
        int pos;
        //Todas imagens encontram-se na pasta "img"
        if(baixo){ //Colocando imagens de carros virados para baixo
            carro.add("img/baixo1.png"); carro.add("img/baixo2.png"); carro.add("img/baixo3.png"); 
            carro.add("img/baixo4.png"); carro.add("img/baixo5.png"); carro.add("img/baixo6.png");
        }
        else{ //Ou de carros virados para cima
            carro.add("img/cima1.png"); carro.add("img/cima2.png"); carro.add("img/cima3.png"); 
            carro.add("img/cima4.png"); carro.add("img/cima5.png"); carro.add("img/cima6.png"); 
            carro.add("img/cima7.png"); carro.add("img/cima8.png");carro.add("img/cima9.png"); 
            carro.add("img/cima10.png");  carro.add("img/cima11.png"); 
        } 
        //Escolher uma posicao aleatória na lista
        pos=novo.nextInt(carro.size());
        //Carregando a imagem selecionada para este carro
        this.img = new ImageIcon(getClass().getResource(carro.get(pos))).getImage();
    }

    public boolean isBaixo() {
        return baixo;
    }

    public void setBaixo(boolean baixo) {
        this.baixo = baixo;
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public ArrayList<String> getCarro() {
        return carro;
    }    
}
