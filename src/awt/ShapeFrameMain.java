package awt;

import java.awt.*;  
class ShapeFrame extends Frame {  
    public ShapeFrame() { 
        this.setTitle("Draw Shape!"); 
    } 
    public void paint(Graphics g) { 
        g.drawString("Draw Shape!", 20,50); //��ǥ 50,50�� ���ڿ� �׸��� 
        g.setColor(Color.blue);//�Ķ������� ���� 
        g.drawOval(50,60,30,30); //���׸��� 
        g.setColor(Color.red); //���������� ���� 
        g.drawLine(80,80, 100,100);// ���α׸��� 
        g.setColor(Color.black); //���������� ���� 
        g.drawRect(70,100,50,50); //�簢�� �׸��� 
        g.setColor(Color.orange); //������������ ���� 
        g.fillRect(100,120,50,50); //ä���� �簢�� �׸��� 
    } 
} //end of ShapeFrame class 

public class ShapeFrameMain {  
    public static void main (String[] args) {  
        Frame f = new ShapeFrame();  
        f.setSize(200, 200);  
        f.show(); 
    } //end of main 
} //end of ShapeFrameMain class 
