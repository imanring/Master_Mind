import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
public class TwoPlayer extends Player{// implements ActionListener{
  JFrame setFrame = new JFrame("Set Mastemind Key");
  Button [] colors = new Button[7];
  String [] colorNames = new String[]{"Blue","Red","Green","Black","Yellow","Orange","Gray"};
  Button submitKey = new Button("Submit");
  JLabel [] keylbls = new JLabel[4];
  Color [] backGrounds = new Color[]{Color.blue, Color.red,Color.green, Color.black, Color.yellow,Color.orange, Color.GRAY};
  int pos = 0;
  boolean keySubmittable = false;
  public TwoPlayer(){
    super();
  }
  @Override
  public void actionPerformed(ActionEvent e){
    Object theButton = e.getSource();
    for(int i = 0; i<7;i++){
      if(theButton==colors[i]){
        keylbls[pos].setBackground(backGrounds[i]);
        key[pos]=i;
        if(pos<3){pos++;}
        else{pos=0;keySubmittable = true;}
        i=9;
      }
    }
    if(theButton==submitKey){
      if(keySubmittable){
        setFrame.dispose();
        this.GUIsetUp();
      }
    }
    //from Player.java
    else if(theButton==blue){
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
        if(currentRow<8) currentRow++;
        submittable = false;
      }
    }
  }
  @Override
  public void setKey(){
    Container mainSet = new Container();
    mainSet.setLayout(new BorderLayout());
    Container buttons = new Container();
    buttons.setLayout(new GridLayout(2,0));
    for(int i = 0; i < 7;i++){
      colors[i] = new Button(colorNames[i]);
      buttons.add(colors[i]);
      colors[i].addActionListener(this);
    }
    buttons.add(submitKey);
    submitKey.addActionListener(this);
    Container lbls = new Container();
    lbls.setLayout(new GridLayout(0,4));
    EmptyBorder border = new EmptyBorder(5,10,5,10);
    for(int i = 0; i < 4;i++){
      keylbls[i] = new JLabel();
      keylbls[i].setText("*");
      keylbls[i].setBorder(border);
      keylbls[i].setOpaque(true);
      lbls.add(keylbls[i]);
    }
    setFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainSet.add(buttons, BorderLayout.NORTH);
    mainSet.add(lbls, BorderLayout.SOUTH);
    setFrame.add(mainSet);
    setFrame.setVisible(true);
    setFrame.pack();
  }
  @Override
  public void play(){
    setKey();
  }
}
