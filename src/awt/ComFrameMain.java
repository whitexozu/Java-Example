package awt;

import java.awt.*; 

class ComFrame extends Frame{ 
    private Label a = new Label("레이블 테스트"); 
    private Button b = new Button("버튼 테스트"); 
    private TextField tf = new TextField(20); 
    public ComFrame(){ 
        this.setLayout(new FlowLayout()); 
        this.add(a); 
        this.add(b); 
        this.add(tf); 
    } 
} //end of ComFrame class 

public class ComFrameMain{ 
    public static void main(String[] args){ 
        Frame f = new ComFrame(); 
        f.setSize(300,150); 
        f.show(); 
    } //end of main 
} //end of ComFrameMain class 