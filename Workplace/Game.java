// Import necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create a class named Game that extends JFrame and implements ActionListener
public class Game extends JFrame implements ActionListener {
    
    // Declare necessary variables
    private JPanel panel;
    private JButton[][] buttons;
    private int[][] map;
    private int playerX, playerY;
    private int rows, cols;
    private int moves;
    private JLabel movesLabel;

    // Create a constructor for the Game class
    public Game() {
        // Set the title of the window
        setTitle("Push Box Game");

        // Set the size of the window
        setSize(500, 500);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Create a new JPanel and set its layout
        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));

        // Initialize the map and player position
        initMap();

        // Create the buttons and add them to the panel
        createButtons();

        // Add the panel to the center of the window
        add(panel, BorderLayout.CENTER);

        // Create a new JPanel for the bottom of the window
        JPanel bottomPanel = new JPanel();

        // Create a new JLabel for the moves counter
        movesLabel = new JLabel("Moves: " + moves);

        // Add the movesLabel to the bottomPanel
        bottomPanel.add(movesLabel);

        // Add the bottomPanel to the bottom of the window
        add(bottomPanel, BorderLayout.SOUTH);

        // Make the window visible
        setVisible(true);
    }

    // Create a method to initialize the map and player position
    private void initMap() {
        // Initialize the map with the following values:
        // 0 - empty space
        // 1 - wall
        // 2 - box
        // 3 - target
        // 4 - player
        map = new int[][] {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 3, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 2, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1}
        };

        // Set the player position to (1, 5)
        playerX = 1;
        playerY = 5;

        // Set the number of rows and columns
        rows = map.length;
        cols = map[0].length;

        // Set the number of moves to 0
        moves = 0;
    }

    // Create a method to create the buttons and add them to the panel
    private void createButtons() {
        // Initialize the buttons array
        buttons = new JButton[rows][cols];

        // Loop through each element in the map array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Create a new JButton and set its background color based on the value in the map array
                JButton button = new JButton();
                if (map[i][j] == 1) {
                    button.setBackground(Color.BLACK);
                } else if (map[i][j] == 2) {
                    button.setBackground(Color.BLUE);
                } else if (map[i][j] == 3) {
                    button.setBackground(Color.GREEN);
                } else if (map[i][j] == 4) {
                    button.setBackground(Color.RED);
                } else {
                    button.setBackground(Color.WHITE);
                }

                // Add an ActionListener to the button
                button.addActionListener(this);

                // Add the button to the panel and the buttons array
                panel.add(button);
                buttons[i][j] = button;
            }
        }
    }

    // Override the actionPerformed method from the ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        // Loop through each element in the buttons array to find the button that was clicked
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (e.getSource() == buttons[i][j]) {
                    // Move the player in the direction of the clicked button
                    if (i == playerX - 1 && j == playerY) {
                        movePlayer(-1, 0);
                    } else if (i == playerX + 1 && j == playerY) {
                        movePlayer(1, 0);
                    } else if (i == playerX && j == playerY - 1) {
                        movePlayer(0, -1);
                    } else if (i == playerX && j == playerY + 1) {
                        movePlayer(0, 1);
                    }
                }
            }
        }
    }

    // Create a method to move the player in the specified direction
    private void movePlayer(int dx, int dy) {
        // Calculate the new position of the player
        int newX = playerX + dx;
        int newY = playerY + dy;

        // Check if the new position is within the bounds of the map
if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) {
    return;
}

// Check if the new position is a wall
if (map[newX][newY] == 1) {
    return;
}

// Check if the new position is a box
if (map[newX][newY] == 2) {
    // Calculate the new position of the box
    int newBoxX = newX + dx;
    int newBoxY = newY + dy;

    // Check if the new position of the box is within the bounds of the map
    if (newBoxX < 0 || newBoxX >= rows || newBoxY < 0 || newBoxY >= cols) {
        return;
    }

    // Check if the new position of the box is a wall or another box
    if (map[newBoxX][newBoxY] == 1 || map[newBoxX][newBoxY] == 2) {
        return;
    }

    // Move the box to the new position
    map[newBoxX][newBoxY] = 2;
    map[newX][newY] = 4;
    map[playerX][playerY] = 0;

    // Update the player position
    playerX = newX;
    playerY = newY;

    // Update the moves counter
    moves++;
    movesLabel.setText("Moves: " + moves);
} else {
    // Move the player to the new position
    map[newX][newY] = 4;
    map[playerX][playerY] = 0;

    // Update the player position
    playerX = newX;
    playerY = newY;

    // Update the moves counter
    moves++;
    movesLabel.setText("Moves: " + moves);
}
}
public static void main(String[] args) {
    Game game = new Game();
}
}