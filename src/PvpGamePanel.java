import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class PvpGamePanel extends JPanel {
    private ArrayList<GameLabelBox> boxList = GameLabelBox.generateBoxList(9);

    PvpGamePanel() {

        boxList.get(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(0));
                checkForWin();
            }
        });

        boxList.get(1).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(1));
                checkForWin();
            }
        });

        boxList.get(2).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(2));
                checkForWin();
            }
        });

        boxList.get(3).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(3));
                checkForWin();
            }
        });

        boxList.get(4).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(4));
                checkForWin();
            }
        });

        boxList.get(5).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(5));
                checkForWin();
            }
        });

        boxList.get(6).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(6));
                checkForWin();
            }
        });

        boxList.get(7).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(7));
                checkForWin();
            }
        });

        boxList.get(8).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boxClicked(boxList.get(8));
                checkForWin();
            }
        });

        this.setLayout(new GridLayout(3, 3));
        this.add(boxList.get(0));
        this.add(boxList.get(1));
        this.add(boxList.get(2));
        this.add(boxList.get(3));
        this.add(boxList.get(4));
        this.add(boxList.get(5));
        this.add(boxList.get(6));
        this.add(boxList.get(7));
        this.add(boxList.get(8));
    }

    // empties the boxes and the result tracking array
    void resetPvpGamePanel() {
        for (int i = 0; i < 9; i++) {
            boxList.get(i).setText("");
            boxList.get(i).setCurrentState(GameLabelBox.BoxStates.DEFAULT);
        }
    }

    private void boxClicked(GameLabelBox box) {
        if (box.getText().equals("")) { // to change the content only if it's empty
            if (Game.getIsX()) {
                box.setText("X");
                box.setCurrentState(GameLabelBox.BoxStates.TRUE);
            } else {
                box.setText("O");
                box.setCurrentState(GameLabelBox.BoxStates.FALSE);
            }
            Game.setIsX(!Game.getIsX()); // set it to the opposite, so it can rotate between true(X) and false(O)
        }
    }

    private void checkForWin() {
        if (checkRows() || checkColumns() || checkDiagonals()) {
            if(Game.getIsX()){
                JOptionPane.showMessageDialog(this,"O wins");
                MainFrame.changePanel("menuPanel");
            }
            else{
                JOptionPane.showMessageDialog(this,"X wins");
                MainFrame.changePanel("menuPanel");
            }
        }
        else if(checkDraw()) {
                JOptionPane.showMessageDialog(this, "Tie!");
                MainFrame.changePanel("menuPanel");
        }
    }

    private boolean checkRows() {
        if (boxList.get(0).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(1).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(2).getCurrentState() == GameLabelBox.BoxStates.TRUE
                || boxList.get(3).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(4).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(5).getCurrentState() == GameLabelBox.BoxStates.TRUE
                || boxList.get(6).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(7).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(8).getCurrentState() == GameLabelBox.BoxStates.TRUE)
            return true;
        return boxList.get(0).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(1).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(2).getCurrentState() == GameLabelBox.BoxStates.FALSE
                || boxList.get(3).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(4).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(5).getCurrentState() == GameLabelBox.BoxStates.FALSE
                || boxList.get(6).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(7).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(8).getCurrentState() == GameLabelBox.BoxStates.FALSE;
    }

    private boolean checkColumns() {
        if (boxList.get(0).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(3).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(6).getCurrentState() == GameLabelBox.BoxStates.TRUE
                || boxList.get(1).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(4).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(7).getCurrentState() == GameLabelBox.BoxStates.TRUE
                || boxList.get(2).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(5).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(8).getCurrentState() == GameLabelBox.BoxStates.TRUE)
            return true;
        return boxList.get(0).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(3).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(6).getCurrentState() == GameLabelBox.BoxStates.FALSE
                || boxList.get(1).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(4).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(7).getCurrentState() == GameLabelBox.BoxStates.FALSE
                || boxList.get(2).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(5).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(8).getCurrentState() == GameLabelBox.BoxStates.FALSE;
    }

    private boolean checkDiagonals() {
        if (boxList.get(0).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(4).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(8).getCurrentState() == GameLabelBox.BoxStates.TRUE
                || boxList.get(2).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(4).getCurrentState() == GameLabelBox.BoxStates.TRUE
                && boxList.get(6).getCurrentState() == GameLabelBox.BoxStates.TRUE)
            return true;
        return boxList.get(0).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(4).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(8).getCurrentState() == GameLabelBox.BoxStates.FALSE
                || boxList.get(2).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(4).getCurrentState() == GameLabelBox.BoxStates.FALSE
                && boxList.get(6).getCurrentState() == GameLabelBox.BoxStates.FALSE;
    }

    private boolean checkDraw(){
        return boxList.get(0).getCurrentState() != GameLabelBox.BoxStates.DEFAULT
                && boxList.get(1).getCurrentState() != GameLabelBox.BoxStates.DEFAULT
                && boxList.get(2).getCurrentState() != GameLabelBox.BoxStates.DEFAULT
                && boxList.get(3).getCurrentState() != GameLabelBox.BoxStates.DEFAULT
                && boxList.get(4).getCurrentState() != GameLabelBox.BoxStates.DEFAULT
                && boxList.get(5).getCurrentState() != GameLabelBox.BoxStates.DEFAULT
                && boxList.get(6).getCurrentState() != GameLabelBox.BoxStates.DEFAULT
                && boxList.get(7).getCurrentState() != GameLabelBox.BoxStates.DEFAULT
                && boxList.get(8).getCurrentState() != GameLabelBox.BoxStates.DEFAULT;
    }
}
