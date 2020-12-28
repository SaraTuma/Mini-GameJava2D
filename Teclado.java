package game2d;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Sara Tuma
 * Estudante: Universidade Católica de Angola
 * Ano : 3º
 * Disciplina: Computação Gráfica
 * Tema: Mini-Jogo usando JAVA 2D
 */
public class Teclado implements KeyListener{
    private boolean cima=false;
    private boolean baixo=false;
    private boolean espaço=false;
    private boolean esquerda=false;
    private boolean direita=false;

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_UP){ this.cima=true; }
        if(ke.getKeyCode()==KeyEvent.VK_DOWN){ this.baixo=true; }
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT){ this.direita=true; }
    }
    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode()==KeyEvent.VK_UP){ this.cima=false; }
        if(ke.getKeyCode()==KeyEvent.VK_DOWN){ this.baixo=false; }
        if(ke.getKeyCode()==KeyEvent.VK_RIGHT){ this.direita=false; }   
    }
    public boolean isCima() { return cima; }
    public boolean isBaixo() { return baixo; }
    public boolean isDireita() { return direita; }
    public void setDireita(boolean direita) { this.direita = direita; } 
}
