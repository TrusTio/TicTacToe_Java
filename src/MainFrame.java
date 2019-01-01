import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {
    private static CardLayout cl = new CardLayout(0, 0);
    private static JPanel panelContainer = new JPanel(cl);
    private static MenuPanel menuPanel = new MenuPanel();
    private static PvpGamePanel pvpGamePanel = new PvpGamePanel();

    MainFrame() {
        panelContainer.add(menuPanel, "menuPanel");
        panelContainer.add(pvpGamePanel, "pvpGamePanel");
        this.add(panelContainer);
        cl.show(panelContainer, "menuPanel");
        this.setTitle("Tic Tac Toe");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pack();
        this.setSize(495, 495);
        this.setResizable(false);
    }

    /* Changes the panel of the MainFrame */
    static void changePanel(String panelName) {
        cl.show(panelContainer, panelName);
    }

    /* Resets the content of the pvpGamePanel  */
    static void newGame() {
        pvpGamePanel.resetPvpGamePanel();
        Game.setIsX(true);
        changePanel("pvpGamePanel");
    }

}
