import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GameLabelBox extends JLabel {
    enum BoxStates {DEFAULT, TRUE, FALSE}
    private BoxStates currentState = BoxStates.DEFAULT;
    private GameLabelBox() {
        this.setSize(165, 165);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        this.setFont(new Font("SansSerif", Font.PLAIN, 95));
        this.setVisible(true);
    }

    static ArrayList<GameLabelBox> generateBoxList(int size) {
        ArrayList<GameLabelBox> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new GameLabelBox());
        }
        return list;
    }

    BoxStates getCurrentState() {
        return currentState;
    }

    void setCurrentState(BoxStates currentState) {
        this.currentState = currentState;
    }
}
