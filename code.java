
package code;

import javax.swing.*;
import java.awt.*;

public class code extends JFrame {

    code() {

        setTitle("Migratory Birds");
        setLayout(null);
        setSize(400, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // TITLE

        JLabel lblTitle = new JLabel("Migratory Birds");
        add(lblTitle).setBounds(30, 20, 200, 25);

        // NUMBER OF SIGHTINGS

        JLabel lblCount = new JLabel("Number of Bird Sightings");
        add(lblCount).setBounds(30, 60, 200, 25);

        JTextField txtCount = new JTextField();
        add(txtCount).setBounds(220, 60, 130, 25);

        // CONTINUE BUTTON

        JButton btnContinue = new JButton("Continue");
        add(btnContinue).setBounds(120, 110, 130, 30);

        // CONTINUE FUNCTION

        btnContinue.addActionListener(e -> {

            try {

                int n = Integer.parseInt(
                        txtCount.getText().trim()
                );

                if (n <= 0) {

                    JOptionPane.showMessageDialog(null,
                            "Please enter a number greater than 0.");

                    return;
                }

                openBirdWindow(n);

            } catch (NumberFormatException x) {

                JOptionPane.showMessageDialog(null,
                        "Please enter a valid whole number.");

            }

        });

        setVisible(true);

    }

    // BIRD INPUT WINDOW

    public void openBirdWindow(int n) {

        JFrame birdFrame = new JFrame("Enter Bird Sightings");

        birdFrame.setLayout(null);
        birdFrame.setSize(450, 500);
        birdFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        birdFrame.setLocationRelativeTo(null);

        // TITLE

        JLabel lblTitle = new JLabel("Enter Bird IDs (1-5)");
        birdFrame.add(lblTitle).setBounds(30, 15, 250, 25);

        // PANEL FOR BIRD TEXT FIELDS

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(n, 2, 10, 10));

        // ARRAY OF TEXT FIELDS

        JTextField[] txtBirds = new JTextField[n];

        // CREATE A TEXT FIELD FOR EACH BIRD

        for (int i = 0; i < n; i++) {

            JLabel lblBird = new JLabel("Bird #" + (i + 1));

            txtBirds[i] = new JTextField();

            panel.add(lblBird);
            panel.add(txtBirds[i]);

        }

        // SCROLL PANE

        JScrollPane pane = new JScrollPane(panel);

        birdFrame.add(pane).setBounds(30, 50, 370, 300);

        // FIND BUTTON

        JButton btnFind = new JButton("Find Most Frequent Bird");

        birdFrame.add(btnFind).setBounds(90, 370, 250, 30);

        // RESULT LABEL

        JLabel lblResult = new JLabel("Result:");
        birdFrame.add(lblResult).setBounds(30, 415, 390, 40);

        // FIND FUNCTION

        btnFind.addActionListener(e -> {

            int[] arr = new int[n];

            // GET AND VALIDATE BIRD IDs

            for (int i = 0; i < n; i++) {

                try {

                    arr[i] = Integer.parseInt(
                            txtBirds[i].getText().trim()
                    );

                    if (arr[i] < 1 || arr[i] > 5) {

                        JOptionPane.showMessageDialog(birdFrame,
                                "Bird #" + (i + 1) +
                                " must be a number from 1 to 5.");

                        return;
                    }

                } catch (NumberFormatException x) {

                    JOptionPane.showMessageDialog(birdFrame,
                            "Please enter a valid number for Bird #" +
                            (i + 1) + ".");

                    return;
                }

            }

            // START TIMER

            long startTime = System.nanoTime();

            // RUN ORIGINAL ALGORITHM

            int answer = migratoryBirds(arr);

            // STOP TIMER

            long endTime = System.nanoTime();

            // CALCULATE RUNTIME

            long runtime = endTime - startTime;

            double runtimeMs = runtime / 1_000_000.0;

            // DISPLAY RESULT AND RUNTIME

            lblResult.setText(
                    "<html>Most Frequent Bird Type: " + answer +
                    "<br>Runtime: " + runtime + " ns" +
                    "<br>Runtime: " + runtimeMs + " ms</html>"
            );

        });

        birdFrame.setVisible(true);

    }

    // ORIGINAL MIGRATORY BIRDS FUNCTION
    // REPEATED-SCANNING ALGORITHM

    public static int migratoryBirds(int[] arr) {

        int maxCount = 0;
        int result = 1;

        // CHECK EACH POSSIBLE BIRD TYPE

        for (int type = 1; type <= 5; type++) {

            int count = 0;

            // COUNT HOW MANY TIMES THIS BIRD TYPE APPEARS

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == type) {

                    count++;

                }

            }

            // UPDATE ONLY IF THE FREQUENCY IS GREATER

            if (count > maxCount) {

                maxCount = count;
                result = type;

            }

        }

        return result;

    }

    public static void main(String args[]) {

        new code();

    }

}
