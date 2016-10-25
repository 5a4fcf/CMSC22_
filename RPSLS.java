import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * Created by IRIS on 10/25/2016.
 */
public class RPSLS extends Frame {

    private Label choice;
    private CheckboxGroup chg;
    private Checkbox rock , paper , scissors , lizard , spock;
    private TextArea results;
    private Button b;
    private Label p;
    private Label c;
    private TextField tfp;
    private TextField tfc;
    private int ps;
    private int cs;
    private String winner;
    private static Dialog d;

    public RPSLS(){
        setLayout(new FlowLayout());
        choice = new Label("Your Choice:");
        chg = new CheckboxGroup();
        rock = new Checkbox("ROCK", chg, true);
        paper = new Checkbox("PAPER", chg, true);
        scissors = new Checkbox("SCISSORS", chg, true);
        lizard = new Checkbox("LIZARD", chg, true);
        spock = new Checkbox("SPOCK", chg, true);
        results = new TextArea("Result: \n",10,25);
        results.setEditable(false);
        b = new Button("RockPaperScissorsLizardSpock!");
        p = new Label("Player's Score: ");
        c = new Label("Computer's Score: ");
        tfp = new TextField("0",10);
        tfp.setEditable(false);
        tfc = new TextField("0",10);
        tfc.setEditable(false);
        ps = 0;
        cs = 0;
        winner = "";

        /**when button b is clicked**/
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                results.setText("Result:\n\n");

                Checkbox ch = chg.getSelectedCheckbox();
                String p1choice = ch.getLabel();
                results.append("Player chose " + p1choice + "\n");

                String[] cchoices = {"ROCK","PAPER","SCISSORS","LIZARD","SPOCK"};
                String crandchoice = (cchoices[new Random().nextInt(cchoices.length)]);
                results.append("Computer chose " + crandchoice + "\n");

                if(p1choice.equals(crandchoice)){
                    results.append("\n\nDRAW FOR THIS ROUND!\n");
                }else{
                    if(p1choice.equals("SPOCK")){
                        if(crandchoice.equals("SPOCK") || crandchoice.equals("PAPER")){
                            winner = "Computer";
                        }else{
                            winner = "Player";
                        }
                    }else if(p1choice.equals("PAPER")){
                        if(crandchoice.equals("SCISSORS") || crandchoice.equals("Lizard")){
                            winner = "Computer";
                        }else{
                            winner = "Player";
                        }
                    }else if(p1choice.equals("SCISSORS")){
                        if(crandchoice.equals("SPOCK") || crandchoice.equals("Rock")){
                            winner = "Computer";
                        }else{
                            winner = "Player";
                        }
                    }else if(p1choice.equals("LIZARD")){
                        if(crandchoice.equals("SCISSORS") || crandchoice.equals("Rock")){
                            winner = "Computer";
                        }else{
                            winner = "Player";
                        }
                    }else if(p1choice.equals("SPOCK")) {
                        if (crandchoice.equals("PAPER") || crandchoice.equals("Lizard")) {
                            winner = "Computer";
                        } else {
                            winner = "Player";
                        }
                    }

                    if(winner.equals("Computer")){
                        cs++;
                        results.append("\n\nCOMPUTER WINS THIS ROUND.");
                    }else{
                        ps++;
                        results.append("\n\nYOU WIN THIS ROUND.");
                    }
                }

                tfp.setText(ps+"");
                tfc.setText(cs+"");


                /**if one player reaches 5 points, declare winner**/
                if (ps == 5 || cs == 5){
                    d = new Dialog(RPSLS.this, true);
                    d.setLayout(new FlowLayout());
                    d.setLocationRelativeTo(RPSLS.this);
                    d.setSize(150,300);
                    Button k = new Button("OK!");
                    k.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ps = 0;
                            cs = 0;
                            tfp.setText("");
                            tfc.setText("");
                            results.setText("Result:\n\n");
                            d.setVisible(false);
                        }
                    });
                    d.add(new Label("GAME OVER.\n" + winner + " WINS!!"));
                    d.add(k);

                    d.pack();
                    d.setVisible(true);

                }


            }
        });
        add(choice);
        add(rock);
        add(paper);
        add(scissors);
        add(lizard);
        add(spock);
        add(results);
        add(b);
        add(p);
        add(tfp);
        add(c);
        add(tfc);

        setTitle("RPSLS");
        setSize(500, 350);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        new RPSLS();
    }


}
