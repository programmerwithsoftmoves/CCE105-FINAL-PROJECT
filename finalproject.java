package code;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class finalproject extends JFrame {

    // ==============================
    // COLORS
    // ==============================

    Color darkBlue = new Color(31, 52, 85);
    Color blue = new Color(52, 101, 164);
    Color lightBlue = new Color(235, 242, 250);
    Color white = Color.WHITE;
    Color gray = new Color(100, 100, 100);
    Color lightGray = new Color(245, 247, 250);
    Color green = new Color(45, 140, 85);

    // ==============================
    // FONTS
    // ==============================

    Font titleFont = new Font(
        "SansSerif",
        Font.BOLD,
        26
    );

    Font subtitleFont = new Font(
        "SansSerif",
        Font.PLAIN,
        14
    );

    Font labelFont = new Font(
        "SansSerif",
        Font.PLAIN,
        14
    );

    Font buttonFont = new Font(
        "SansSerif",
        Font.BOLD,
        14
    );

    Font resultFont = new Font(
        "SansSerif",
        Font.BOLD,
        15
    );

    // ==============================
    // MAIN WINDOW
    // ==============================

    finalproject() {

        setTitle("Migratory Birds");
        setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(lightGray);

        // Header
        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(darkBlue);

        add(header).setBounds(
            0, 0, 500, 100
        );

        JLabel lblTitle =
            new JLabel("Migratory Birds");

        lblTitle.setForeground(white);
        lblTitle.setFont(titleFont);

        header.add(lblTitle).setBounds(
            35, 20, 300, 35
        );

        JLabel lblSubtitle =
            new JLabel(
                "Bird frequency analysis system"
            );

        lblSubtitle.setForeground(
            new Color(220, 230, 242)
        );

        lblSubtitle.setFont(subtitleFont);

        header.add(lblSubtitle).setBounds(
            37, 58, 350, 25
        );

        // Instruction
        JLabel lblChoose =
            new JLabel("Choose an option");

        lblChoose.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                16
            )
        );

        lblChoose.setForeground(darkBlue);

        add(lblChoose).setBounds(
            35, 120, 250, 25
        );

        // Input button
        JButton btnInput =
            new JButton("Input Bird Sightings");

        styleButton(btnInput, blue);

        add(btnInput).setBounds(
            35, 165, 430, 45
        );

        // Recent results button
        JButton btnRecent =
            new JButton("View Recent Results");

        styleButton(btnRecent, green);

        add(btnRecent).setBounds(
            35, 225, 430, 45
        );

        // Footer
        JLabel lblFooter =
            new JLabel(
                "Migratory Birds • Java GUI Implementation"
            );

        lblFooter.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                11
            )
        );

        lblFooter.setForeground(gray);

        lblFooter.setHorizontalAlignment(
            SwingConstants.CENTER
        );

        add(lblFooter).setBounds(
            35, 315, 430, 25
        );

        // Button actions
        btnInput.addActionListener(e -> {
            openCountWindow();
        });

        btnRecent.addActionListener(e -> {
            openRecentResults();
        });

        setVisible(true);
    }

    // ==============================
    // BUTTON STYLE
    // ==============================

    public void styleButton(
            JButton button,
            Color color) {

        button.setFont(buttonFont);
        button.setForeground(Color.WHITE);
        button.setBackground(color);

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setCursor(
            new Cursor(Cursor.HAND_CURSOR)
        );
    }

    // ==============================
    // NUMBER OF SIGHTINGS WINDOW
    // ==============================

    public void openCountWindow() {

        JFrame countFrame =
            new JFrame("Input Bird Sightings");

        countFrame.setLayout(null);
        countFrame.setSize(500, 320);

        countFrame.setDefaultCloseOperation(
            JFrame.DISPOSE_ON_CLOSE
        );

        countFrame.setLocationRelativeTo(this);

        countFrame.getContentPane()
            .setBackground(lightGray);

        // Header
        JPanel header =
            new JPanel();

        header.setLayout(null);
        header.setBackground(darkBlue);

        countFrame.add(header).setBounds(
            0, 0, 500, 85
        );

        JLabel lblTitle =
            new JLabel(
                "Input Bird Sightings"
            );

        lblTitle.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                22
            )
        );

        lblTitle.setForeground(white);

        header.add(lblTitle).setBounds(
            30, 20, 400, 30
        );

        JLabel lblSub =
            new JLabel(
                "Enter the total number of sightings"
            );

        lblSub.setForeground(
            new Color(220, 230, 242)
        );

        header.add(lblSub).setBounds(
            32, 50, 400, 20
        );

        // Label
        JLabel lblCount =
            new JLabel(
                "Number of Bird Sightings"
            );

        lblCount.setFont(labelFont);
        lblCount.setForeground(darkBlue);

        countFrame.add(lblCount).setBounds(
            40, 120, 200, 25
        );

        // Text field
        JTextField txtCount =
            new JTextField();

        txtCount.setFont(
            new Font(
                "SansSerif",
                Font.PLAIN,
                14
            )
        );

        txtCount.setBorder(
            BorderFactory.createLineBorder(
                new Color(190, 200, 215)
            )
        );

        countFrame.add(txtCount).setBounds(
            270, 118, 170, 32
        );

        // Continue button
        JButton btnContinue =
            new JButton("Continue");

        styleButton(
            btnContinue,
            blue
        );

        countFrame.add(btnContinue).setBounds(
            155, 185, 190, 40
        );

        // Continue action
        btnContinue.addActionListener(e -> {

            try {

                int n =
                    Integer.parseInt(
                        txtCount.getText().trim()
                    );

                if (n <= 0) {

                    JOptionPane.showMessageDialog(
                        countFrame,
                        "Please enter a number greater than 0.",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                // Close number window
                countFrame.dispose();

                // Open bird input window
                openBirdWindow(n);

            } catch (NumberFormatException x) {

                JOptionPane.showMessageDialog(
                    countFrame,
                    "Please enter a valid whole number.",
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        });

        countFrame.setVisible(true);
    }

    // ==============================
    // BIRD INPUT WINDOW
    // ==============================

    public void openBirdWindow(int n) {

        JFrame birdFrame =
            new JFrame("Enter Bird Sightings");

        birdFrame.setLayout(null);
        birdFrame.setSize(520, 620);

        birdFrame.setDefaultCloseOperation(
            JFrame.DISPOSE_ON_CLOSE
        );

        birdFrame.setLocationRelativeTo(this);

        birdFrame.getContentPane()
            .setBackground(lightGray);

        // Header
        JPanel header =
            new JPanel();

        header.setLayout(null);
        header.setBackground(darkBlue);

        birdFrame.add(header).setBounds(
            0, 0, 520, 85
        );

        JLabel lblTitle =
            new JLabel(
                "Enter Bird IDs"
            );

        lblTitle.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                22
            )
        );

        lblTitle.setForeground(white);

        header.add(lblTitle).setBounds(
            30, 15, 300, 30
        );

        JLabel lblSub =
            new JLabel(
                "Enter values from 1 to 5"
            );

        lblSub.setForeground(
            new Color(220, 230, 242)
        );

        header.add(lblSub).setBounds(
            32, 48, 300, 20
        );

        // Input panel
        JPanel panel =
            new JPanel();

        panel.setLayout(
            new GridLayout(
                n,
                2,
                12,
                12
            )
        );

        panel.setBackground(white);

        panel.setBorder(
            BorderFactory.createEmptyBorder(
                15,
                20,
                15,
                20
            )
        );

        JTextField[] txtBirds =
            new JTextField[n];

        for (int i = 0; i < n; i++) {

            JLabel lblBird =
                new JLabel(
                    "Bird #" + (i + 1)
                );

            lblBird.setFont(labelFont);
            lblBird.setForeground(darkBlue);

            txtBirds[i] =
                new JTextField();

            txtBirds[i].setFont(
                new Font(
                    "SansSerif",
                    Font.PLAIN,
                    14
                )
            );

            txtBirds[i].setHorizontalAlignment(
                SwingConstants.CENTER
            );

            txtBirds[i].setBorder(
                BorderFactory.createLineBorder(
                    new Color(190, 200, 215)
                )
            );

            panel.add(lblBird);
            panel.add(txtBirds[i]);
        }

        JScrollPane pane =
            new JScrollPane(panel);

        pane.setBorder(
            BorderFactory.createLineBorder(
                new Color(210, 215, 225)
            )
        );

        birdFrame.add(pane).setBounds(
            30, 105, 460, 300
        );

        // ==============================
        // BACK BUTTON
        // ==============================

        JButton btnBack =
            new JButton("Back");

        styleButton(
            btnBack,
            darkBlue
        );

        birdFrame.add(btnBack).setBounds(
            30, 425, 100, 40
        );

        btnBack.addActionListener(e -> {

            // Close bird input window
            birdFrame.dispose();

            // Main window remains open
        });

        // ==============================
        // FIND BUTTON
        // ==============================

        JButton btnFind =
            new JButton(
                "Find Most Frequent Bird"
            );

        styleButton(
            btnFind,
            blue
        );

        birdFrame.add(btnFind).setBounds(
            150, 425, 310, 40
        );

        // ==============================
        // RESULT PANEL
        // ==============================

        JPanel resultPanel =
            new JPanel();

        resultPanel.setLayout(null);

        resultPanel.setBackground(
            new Color(232, 246, 237)
        );

        birdFrame.add(resultPanel).setBounds(
            30, 480, 460, 70
        );

        JLabel lblResult =
            new JLabel(
                "Result will appear here"
            );

        lblResult.setFont(resultFont);

        lblResult.setForeground(
            new Color(35, 110, 65)
        );

        resultPanel.add(lblResult).setBounds(
            15, 10, 430, 50
        );

        // ==============================
        // FIND BUTTON ACTION
        // ==============================

        btnFind.addActionListener(e -> {

            int[] arr =
                new int[n];

            // Read and validate bird IDs
            for (int i = 0; i < n; i++) {

                try {

                    arr[i] =
                        Integer.parseInt(
                            txtBirds[i]
                                .getText()
                                .trim()
                        );

                    if (
                        arr[i] < 1 ||
                        arr[i] > 5
                    ) {

                        JOptionPane.showMessageDialog(
                            birdFrame,
                            "Bird #" +
                            (i + 1) +
                            " must be a number from 1 to 5.",
                            "Invalid Bird ID",
                            JOptionPane.WARNING_MESSAGE
                        );

                        return;
                    }

                } catch (
                    NumberFormatException x
                ) {

                    JOptionPane.showMessageDialog(
                        birdFrame,
                        "Please enter a valid number for Bird #"
                        + (i + 1) + ".",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }
            }

            // Start timer
            long startTime =
                System.nanoTime();

            // Run proposed algorithm
            int answer =
                migratoryBirds(arr);

            // End timer
            long endTime =
                System.nanoTime();

            long runtime =
                endTime - startTime;

            // Display result
            lblResult.setText(
                "<html>"
                + "Most Frequent Bird Type: "
                + answer
                + "<br>Execution Time: "
                + runtime
                + " ns"
                + "</html>"
            );

            // Save result
            saveResult(
                arr,
                answer,
                runtime
            );
        });

        birdFrame.setVisible(true);
    }

    // ==============================
    // PROPOSED ALGORITHM
    // ==============================

    public static int migratoryBirds(
            int[] arr) {

        int[] frequency =
            new int[6];

        int maxCount = 0;

        int result = 1;

        for (
            int i = 0;
            i < arr.length;
            i++
        ) {

            int bird =
                arr[i];

            frequency[bird]++;

            if (
                frequency[bird] > maxCount
                ||
                (
                    frequency[bird] == maxCount
                    &&
                    bird < result
                )
            ) {

                maxCount =
                    frequency[bird];

                result =
                    bird;
            }
        }

        return result;
    }

    // ==============================
    // SAVE RESULT TO FILE
    // ==============================

    public static void saveResult(
            int[] arr,
            int answer,
            long runtime) {

        try {

            FileWriter writer =
                new FileWriter(
                    "bird_results.txt",
                    true
                );

            BufferedWriter bufferedWriter =
                new BufferedWriter(writer);

            bufferedWriter.write(
                "===== MIGRATORY BIRDS RESULT ====="
            );

            bufferedWriter.newLine();

            bufferedWriter.write(
                "Bird Sightings: "
                + java.util.Arrays.toString(arr)
            );

            bufferedWriter.newLine();

            bufferedWriter.write(
                "Number of Sightings: "
                + arr.length
            );

            bufferedWriter.newLine();

            bufferedWriter.write(
                "Most Frequent Bird Type: "
                + answer
            );

            bufferedWriter.newLine();

            bufferedWriter.write(
                "Execution Time: "
                + runtime
                + " ns"
            );

            bufferedWriter.newLine();

            bufferedWriter.write(
                "================================="
            );

            bufferedWriter.newLine();

            bufferedWriter.newLine();

            bufferedWriter.close();

        } catch (IOException x) {

            JOptionPane.showMessageDialog(
                null,
                "Error saving result: "
                + x.getMessage(),
                "File Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // ==============================
    // RECENT RESULTS WINDOW
    // ==============================

    public void openRecentResults() {

        JFrame resultFrame =
            new JFrame("Recent Results");

        resultFrame.setLayout(null);
        resultFrame.setSize(600, 550);

        resultFrame.setDefaultCloseOperation(
            JFrame.DISPOSE_ON_CLOSE
        );

        resultFrame.setLocationRelativeTo(this);

        resultFrame.getContentPane()
            .setBackground(lightGray);

        // Header
        JPanel header =
            new JPanel();

        header.setLayout(null);
        header.setBackground(darkBlue);

        resultFrame.add(header).setBounds(
            0, 0, 600, 85
        );

        JLabel lblTitle =
            new JLabel(
                "Recent Results"
            );

        lblTitle.setFont(
            new Font(
                "SansSerif",
                Font.BOLD,
                22
            )
        );

        lblTitle.setForeground(white);

        header.add(lblTitle).setBounds(
            30, 20, 400, 30
        );

        JLabel lblSub =
            new JLabel(
                "Previously saved bird sighting results"
            );

        lblSub.setForeground(
            new Color(220, 230, 242)
        );

        header.add(lblSub).setBounds(
            32, 50, 400, 20
        );

        // Results area
        JTextArea txtResults =
            new JTextArea();

        txtResults.setEditable(false);

        txtResults.setFont(
            new Font(
                "Monospaced",
                Font.PLAIN,
                13
            )
        );

        txtResults.setBackground(white);

        txtResults.setForeground(
            new Color(50, 50, 50)
        );

        txtResults.setMargin(
            new Insets(
                15,
                15,
                15,
                15
            )
        );

        JScrollPane scrollPane =
            new JScrollPane(txtResults);

        scrollPane.setBorder(
            BorderFactory.createLineBorder(
                new Color(210, 215, 225)
            )
        );

        resultFrame.add(scrollPane).setBounds(
            30, 105, 540, 330
        );

        // ==============================
        // BACK BUTTON
        // ==============================

        JButton btnBack =
            new JButton("Back");

        styleButton(
            btnBack,
            darkBlue
        );

        resultFrame.add(btnBack).setBounds(
            220, 455, 150, 35
        );

        btnBack.addActionListener(e -> {

            // Close recent results
            resultFrame.dispose();

            // Main window remains open
        });

        // ==============================
        // READ FILE
        // ==============================

        try {

            File file =
                new File(
                    "bird_results.txt"
                );

            if (!file.exists()) {

                txtResults.setText(
                    "No recent results found."
                );

            } else {

                BufferedReader reader =
                    new BufferedReader(
                        new FileReader(file)
                    );

                String line;

                StringBuilder results =
                    new StringBuilder();

                while (
                    (line =
                        reader.readLine())
                    != null
                ) {

                    results.append(line);
                    results.append("\n");
                }

                reader.close();

                txtResults.setText(
                    results.toString()
                );
            }

        } catch (IOException x) {

            txtResults.setText(
                "Error reading results: "
                + x.getMessage()
            );
        }

        resultFrame.setVisible(true);
    }

    // ==============================
    // MAIN
    // ==============================

    public static void main(
            String[] args) {

        new finalproject();
    }
}
