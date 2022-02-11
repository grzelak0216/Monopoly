package lab.projeckt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel{
    private static final long serialVersionUID = 1L;
    private Integer size = 12;
    private ImageIcon img = new ImageIcon("E:\\programowanie\\TO\\Projekt\\src\\lab\\monopoly_board.jpg");
    private IGameInitialization gameInitialization;

    public static void game(IGameInitialization game) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Board panel = new Board(game);
                panel.setPreferredSize(new Dimension(602, 602));
                panel.animate();
                JFrame frame = new JFrame("Monopoly PK");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public Board(IGameInitialization game) {
        gameInitialization = game;
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setOpaque(true);
    }

    public void animate() {
        new Timer(15, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint(0, 0, 602, 602);
            }
        }).start();
    }

    public void paint(Graphics g){
        super.paint(g);

        img.paintIcon(this, g, 1, 1);

        for (int i = 0; i < gameInitialization.getPlayers().size(); i ++){
            switch (i) {
                case 0:
                    g.setColor(Color.BLUE);
                    break;
                case 1:
                    g.setColor(Color.RED);
                    break;
                case 2:
                    g.setColor(Color.GREEN);
                    break;
                case 3:
                    g.setColor(Color.YELLOW);
                    break;
            }
            Integer position = gameInitialization.getPlayers().get(i).getPosition();
            Integer posX = gameInitialization.getPlayerPosition().get(position)[0];
            Integer posY = gameInitialization.getPlayerPosition().get(position)[1];
            g.fillOval(posX + (9 * i), posY + (9 * i), size, size);
        }
    }
}





