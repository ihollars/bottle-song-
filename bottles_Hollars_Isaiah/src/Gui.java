/**
 * This Gui class is the backbone of the entire program. This class contains the code
 * for the gui elements of the program. It also implements action listeners in order
 * to feed the correct parameters to the singBottleSong method.
 *
 * The GUI class constructor calls the method setupBottleGui.
 * The bottle GUI has an action listener that will call the method setupCountGui.
 * The count GUI will supply the parameters: bottles and countBy to the
 * singBottleSong method when its action listener is called.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    //fields to provide the song method
    private int bottles;
    private int countBy;

    //fields for setupBottleGui
    public JFrame frame;
    public JLabel invalidNumber;
    public JTextField bottleText;

    //fields for setupCountGui
    private JFrame frame2;
    private JTextField countText;
    private JLabel invalidNumber2;

//This is the gui constructor that will basically run the entire program
    public Gui(){
        setupBottleGui();
        //the bottle gui will call the setupCountGui method when its action listener is called
    }

//getter methods
    public int getBottles(){return bottles;}
    public int getCountBy(){return countBy;}



    public void setupBottleGui(){
        bottles=0;

        frame = new JFrame();
        frame.setSize(350,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);

        //text used for negative number errors
        invalidNumber = new JLabel("**Classic bottles of milk on the wall song!**");
        invalidNumber.setBounds(10,10,1000,30);
        panel.add(invalidNumber);

        //bottle amount label
        JLabel bottleLabel = new JLabel("Total Number of Purity Bottles : ");
        bottleLabel.setBounds(10,50,100,40);
        panel.add(bottleLabel);

        //bottle amount text box
        bottleText = new JTextField(10);
        bottleText.setBounds(100,50,180,40);
        panel.add(bottleText);

        //button that adds an instance of the ActionListener class below
        JButton button = new JButton("Enter");
        button.setBounds(120,400,90,40);
        button.addActionListener(new BottleListener());
        panel.add(button);

        frame.setVisible(true);

    }

    //This is the action listener used for the button on the Bottle Gui
    private class BottleListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int bottlesResponse = Math.round( Float.parseFloat(bottleText.getText()) );
            if(bottlesResponse<10){
                invalidNumber.setText("     ***** Please Enter a Number 10 or Greater *****     ");
            }
            else{
                bottles=bottlesResponse;
                frame.setVisible(false);
                setupCountGui();     //This will setup the count gui when the bottle gui is complete
            }

        }

    }







//the count gui is called via the action listener of the bottle gui
    public void setupCountGui(){
        countBy=0;

        frame2 = new JFrame();
        frame2.setSize(350,150);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame2.add(panel);

        //text used for negative number errors
        invalidNumber2 = new JLabel("**After hitting Enter, song is printed to console**");
        invalidNumber2.setBounds(10,10,1000,30);
        panel.add(invalidNumber2);

        //count amount label
        JLabel countLabel = new JLabel("Count Down by number : ");
        countLabel.setBounds(10,50,100,40);
        panel.add(countLabel);

        //count amount text box
        countText = new JTextField(10);
        countText.setBounds(100,50,180,40);
        panel.add(countText);

        //this button adds an instance of the ActionListener class below
        JButton button = new JButton("Enter");
        button.setBounds(120,400,90,40);
        button.addActionListener(new CountListener() );
        panel.add(button);

        frame2.setVisible(true);

    }


    //This is the action listener used for the button on the Count Gui
    private class CountListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int countResponse = (int) Math.round(Integer.parseInt(countText.getText() ));
            if(countResponse<=0){
                invalidNumber2.setText("**Enter a positive number to count by**");
            }
            else{
                countBy=countResponse;

                //The bottle song is called from a method written in the BottleSong Class
                //the parameters: number of bottles and the countBy number
                //are retrieved via the getter methods of this Gui instance
                BottleSong.singBottleSong(getBottles(),getCountBy());
                System.exit(0);
            }

        }
    }
}

