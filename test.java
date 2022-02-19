import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


class test extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnPrev, btnNext, btnBookmark;
    ButtonGroup btnGrp;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    
    test(String msg) {
        super(msg);
        label = new JLabel();
        add(label);
        btnGrp = new ButtonGroup();
        for(int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            btnGrp.add(radioButton[i]);
        }

        btnPrev = new JButton("Previous");
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");

        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);

        add(btnPrev);
        add(btnNext);
        add(btnBookmark);

        set();
        // Question bounds
        label.setBounds(30, 40, 900, 20);
        
        // Options bounds
        radioButton[0].setBounds(50, 80, 700, 20);
        radioButton[1].setBounds(50, 110, 700, 20);
        radioButton[2].setBounds(50, 140, 700, 20);
        radioButton[3].setBounds(50, 170, 700, 20);

        // Buttons bounds
        btnPrev.setBounds(100, 240, 100, 30);
        btnNext.setBounds(270, 240, 100, 30);
        btnBookmark.setBounds(440, 240, 100, 30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(200, 100);
        setVisible(true);
        setSize(1000, 600);

    }

    // QUESTION SET IN BELOW

    void set() {

        radioButton[4].setSelected(true);

        if(current == 0) {
            label.setText("Q.1 Look at this series: F2, __, D8, C16, B32, ... What number should fill the blank?");
            radioButton[0].setText("A16");
            radioButton[1].setText("G4");
            radioButton[2].setText("E4");
            radioButton[3].setText("E3");
        }

        if(current == 1) {
            label.setText("Q.2 B2CD, _____, BCD4, B5CD, BC6D");
            radioButton[0].setText("B2C2D");
            radioButton[1].setText("BCD7");
            radioButton[2].setText("BC3D");
            radioButton[3].setText("B2C3D");
        }

        if(current == 2) {
            label.setText("Q.3 Look at this series: 7, 10, 8, 11, 9, 12, ... What number should come next?");
            radioButton[0].setText("7");
            radioButton[1].setText("13");
            radioButton[2].setText("12");
            radioButton[3].setText("10");
        }

        if(current == 3) {
            label.setText("Q.4 Look at this series: 53, 53, 40, 40, 27, 27, ... What number should come next?");
            radioButton[0].setText("12");
            radioButton[1].setText("14");
            radioButton[2].setText("53");
            radioButton[3].setText("27");
        }

        if(current == 4) {
            label.setText("Q.5 Look at this series: U32, V29, __, X23, Y20, ... What number should fill the blank?");
            radioButton[0].setText("W17");
            radioButton[1].setText("W26");
            radioButton[2].setText("Z17");
            radioButton[3].setText("Z26");
        }

        if(current == 5) {
            label.setText("Q.6 Pointing a man, a woman said - His mother is the only daughter of my mother. How is the woman related to the man?");
            radioButton[0].setText("Daughter");
            radioButton[1].setText("Sister");
            radioButton[2].setText("Grandmother");
            radioButton[3].setText("Mother");
        }

        if(current == 6) {
            label.setText("Q.7 P is the mother of K; K is the sister of D; D is the father of J. How is P related to J?");
            radioButton[0].setText("Mother");
            radioButton[1].setText("Grandmother");
            radioButton[2].setText("Aunt");
            radioButton[3].setText("None");
        }

        if(current == 7) {
            label.setText("Q.8 DEF, DEF2, DE2F2, _____, D2E2F3");
            radioButton[0].setText("D2E2F2");
            radioButton[1].setText("D2E3F");
            radioButton[2].setText("D3EF3");
            radioButton[3].setText("DEF3");
        }

        if(current == 8) {
            label.setText("Q.9 BCB, DED, FGF, HIH, ___");
            radioButton[0].setText("JKJ");
            radioButton[1].setText("JHJ");
            radioButton[2].setText("IJI");
            radioButton[3].setText("HJH");
        }

        if(current == 9) {
            label.setText("Q.10 Amit said - This girl is the wife of the grandson of my mother. How is Amit related to the girl?");
            radioButton[0].setText("Brother");
            radioButton[1].setText("Grandfather");
            radioButton[2].setText("Husband");
            radioButton[3].setText("Father-in-law");
        }

        label.setBounds(30, 40, 700, 20);
        for(int i = 0, j = 0; i <= 90; i += 30, j++) {
            radioButton[j].setBounds(50, 80 + i, 200, 20);
        }

    }


    // CORRECT ANSWERS

    boolean check() {
        if(current == 0)
            return (radioButton[2].isSelected());

        if(current == 1)
            return (radioButton[2].isSelected());
        
        if(current == 2)
            return (radioButton[3].isSelected());

        if(current == 3)
            return (radioButton[1].isSelected());

        if(current == 4)
            return (radioButton[1].isSelected());

        if(current == 5)
            return (radioButton[3].isSelected());

        if(current == 6)
            return (radioButton[1].isSelected());

        if(current == 7)
            return (radioButton[0].isSelected());

        if(current == 8)
            return (radioButton[0].isSelected());

        if(current == 9)
            return (radioButton[3].isSelected());

        return false;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnPrev) {
            current--;
            set();
            btnNext.setEnabled(true);
            if(current == 0) {
                btnPrev.setEnabled(false);
            }
        }
        
        if(e.getSource() == btnNext) {
            if(check())
                count++;
            current++;
            set();
            if(current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }

        if(e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(0 + 100 * x, 300, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if(current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
            setVisible(false);
            setVisible(true);
        }

        for(int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if(check())
                    count++;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if(e.getActionCommand().equals("Result")) {
            if(check()) 
                count++;
            current++;
            JOptionPane.showMessageDialog(this, "Correct Answers: " + count);
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new test("MCQ Test App");
    }
}