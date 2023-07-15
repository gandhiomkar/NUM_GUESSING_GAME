import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGameGUI extends JFrame {
    private int numberToGuess;
    private int attempts;
    private JTextField guessField;
    private JLabel resultLabel;

    public NumberGuessingGameGUI() {
        super("Number Guessing Game");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        numberToGuess = (int) (Math.random() * 100) + 1;
        attempts = 0;

        JLabel titleLabel = new JLabel("Guess a number between 1 and 100:\n");
        add(titleLabel);

        guessField = new JTextField(10);
        add(guessField);

        JButton submitButton = new JButton("Submit");
        add(submitButton);

       

        resultLabel = new JLabel("result",JLabel.CENTER);
        resultLabel.setBounds(100, 100 ,100, 30);
       

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(resultLabel);
        add(panel1);

        

      

        submitButton.addActionListener(new submitListener());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class submitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            try {
                int guess = Integer.parseInt(guessField.getText());
                attempts++;

                if (guess == numberToGuess) {
                    resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                    pack();
                } else if (guess < numberToGuess) {
                    resultLabel.setText("Too low. Try again.");
                    pack();
                    
                } else {
                    resultLabel.setText("Too high. Try again.");
                    pack();
                   
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
            }

            guessField.setText("");
            guessField.requestFocus();
        }
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGuessingGameGUI();
            }
        });
    }
}
