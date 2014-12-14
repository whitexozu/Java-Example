package awt;

import java.awt.*;  
class ShapeFrame extends Frame {  
    public ShapeFrame() { 
        this.setTitle("Draw Shape!"); 
    } 
    public void paint(Graphics g) { 
        g.drawString("Draw Shape!", 20,50); //좌표 50,50에 문자열 그리기 
        g.setColor(Color.blue);//파란색으로 셋팅 
        g.drawOval(50,60,30,30); //원그리기 
        g.setColor(Color.red); //빨간색으로 셋팅 
        g.drawLine(80,80, 100,100);// 라인그리기 
        g.setColor(Color.black); //검은색으로 셋팅 
        g.drawRect(70,100,50,50); //사각형 그리기 
        g.setColor(Color.orange); //오랜지색으로 셋팅 
        g.fillRect(100,120,50,50); //채워진 사각형 그리기 
    } 
} //end of ShapeFrame class 

public class ShapeFrameMain {  
    public static void main (String[] args) {  
        Frame f = new ShapeFrame();  
        f.setSize(200, 200);  
        f.show(); 
    } //end of main 
} //end of ShapeFrameMain class 
