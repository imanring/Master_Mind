import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Player extends Game implements ActionListener{
  JFrame frame = new JFrame("Mastermind");
  Container surface = frame.getContentPane();
  Button blue = new Button("Blue");
  Button green = new Button("Green");
  Button black = new Button("Black");
  Button yellow = new Button("Yellow");
  Button orange = new Button("Orange");
  Button red = new Button("Red");
  Button purple = new Button("Gray");
  Button submit = new Button("Submit");
  JLabel[][] guessRows = new JLabel[9][5];
  boolean submittable = false;
  Player(){
    super();
    EmptyBorder border = new EmptyBorder(5,10,5,10);
    for(int r = 0; r < 9; r++){
      for(int c = 0; c < 5; c++){
        guessRows[r][c] = new JLabel();guessRows[r][c].setText("*");
        guessRows[r][c].setBorder(border);
        guessRows[r][c].setOpaque(true);
      }
    }
  }
    
  public void actionPerformed(ActionEvent e){
    Object theButton = e.getSource();
    if(theButton==blue){
      action(Color.blue, 0);
    }else if(theButton==red){
      action(Color.red,1);
    }else if(theButton==green){
      action(Color.green,2);
    }else if(theButton==black){
      action(Color.black,3);
    }else if(theButton==yellow){
      action(Color.yellow,4);
    }else if(theButton==orange){
      action(Color.orange,5);
    }else if(theButton==purple){
      action(Color.GRAY,6);
    }else if(theButton==submit){
      if(submittable){
        indexAt=0;
        guessRows[currentRow][4].setText(board[currentRow].scoreGuess(key));
        currentRow++;
        submittable = false;
      }
    }
  }
  public void action(Color c, int val){
    board[currentRow].makeGuess(indexAt, val);
    guessRows[currentRow][indexAt].setBackground(c);
    if(indexAt<3){indexAt++;}
    else{indexAt=0;submittable=true;}
  }
  public void GUIsetUp(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    surface.setLayout(new BorderLayout());
    Container buttons = new Container();
    buttons.setLayout(new GridLayout(2,0));
    buttons.add(blue);
    buttons.add(red);
    buttons.add(green);
    buttons.add(black);
    buttons.add(yellow);
    buttons.add(orange);
    buttons.add(purple);
    buttons.add(submit);
    Container lbls = new Container();
    lbls.setLayout(new GridLayout(0,5));
    for(int r = 0; r < 9; r++){
      for(int c = 0; c < 5; c++){
        lbls.add(guessRows[r][c]);
      }
    }
    surface.add(buttons, BorderLayout.NORTH);
    surface.add(lbls, BorderLayout.SOUTH);
    submit.addActionListener(this);
    red.addActionListener(this);
    blue.addActionListener(this);
    green.addActionListener(this);
    black.addActionListener(this);
    yellow.addActionListener(this);
    orange.addActionListener(this);
    purple.addActionListener(this);
    //frame.setSize(400,400);
    frame.pack();
    frame.setVisible(true);
  }
  public static void main(String[] args){
    Player a = new Player();
    a.setKey();
    a.GUIsetUp();
  }
}
