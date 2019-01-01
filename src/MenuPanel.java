import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class MenuPanel extends JPanel {

    MenuPanel(){
        Font menuTextFont= new Font("SansSerif", Font.PLAIN, 20);
        JLabel titleLabel= new JLabel("<html> <div style='color:red'> Tic|Tac|Toe </div> </html>");
        titleLabel.setFont(new Font("Forte", Font.BOLD,35));
        titleLabel.setBounds(132,20,230,60);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setVisible(true);
        JLabel playerVsPlayerButton = new JLabel("Player vs Player");
        playerVsPlayerButton.setBounds(167,130,160,60);
        playerVsPlayerButton.setVisible(true);
        playerVsPlayerButton.setHorizontalAlignment(SwingConstants.CENTER);
        playerVsPlayerButton.setVerticalAlignment(SwingConstants.CENTER);
        playerVsPlayerButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        playerVsPlayerButton.setFont(menuTextFont);
        playerVsPlayerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.newGame();
            }
        });


        JLabel exitButton = new JLabel("Exit");
        exitButton.setBounds(167,210,160,60);
        exitButton.setVisible(true);
        exitButton.setHorizontalAlignment(SwingConstants.CENTER);
        exitButton.setVerticalAlignment(SwingConstants.CENTER);
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        exitButton.setFont(menuTextFont);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        this.add(titleLabel);
        this.add(playerVsPlayerButton);
        this.add(exitButton);
        this.setLayout(null);

    }
}
