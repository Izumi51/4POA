package view;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import control.DinossauroThread;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

    private final JButton btnCorrida;
    private final JButton btnCancel;
    private final JLabel lblPista;
    private final ImageIcon imgDinossauro1;
    private final ImageIcon imgDinossauro2;
    private final ImageIcon imgDinossauro3;
    private final ImageIcon pista;

    public Janela() {
        super();
        // ADICIONANDO ELEMENTOS AO FORMUL�RIO
        this.setLayout(null);
        this.setSize(1280, 650);
        this.setLocation(50, 50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);
       
        this.setTitle("Corrida de Threads");
        this.pista = new ImageIcon("./src/imagens/pista2.jpg");

        this.lblPista = new JLabel(pista);
        // POSICIONANDO OS ELEMENTOS DO FORM
        this.lblPista.setBounds(0, 0, 1280, 650);
       
        this.add(lblPista);

        this.lblPista.setBackground(Color.BLACK);

        this.btnCorrida = new JButton("Começar");
        this.btnCancel = new JButton("Terminar");
        // POSICIONADO OS BOTES
        this.btnCorrida.setBounds(500, 550, 120, 50);
        this.btnCancel.setBounds(640, 550, 120, 50);
        // INSERINDO AS IMAGENS DOS CARROS
        imgDinossauro1 = new ImageIcon("./src/imagens/d1.png");
        imgDinossauro2 = new ImageIcon("./src/imagens/d2.png");
        imgDinossauro3 = new ImageIcon("./src/imagens/d3.png");
       
        this.lblPista.add(btnCorrida);
        this.lblPista.add(btnCancel);

        this.setVisible(true);

        btnCorrida.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setBorder(BorderFactory.createTitledBorder("[Grupo de Trabalho]"));
        jPanel.setVisible(true);

        this.repaint();

    }
     // INSERINDO AS JLABELS DOS CARROS
     public JLabel JLabelDinossauros(String nome, ImageIcon img, int posX, int posY) {
        DinossauroThread dinossauro = new DinossauroThread(nome, img, posX, posY);
        dinossauro.setSize(256, 141);
        dinossauro.setVisible(true);
        this.add(dinossauro);
        return dinossauro;
    }

    // PROGRAMANDO A A��O DOS BOT�ES
    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida) {
            this.lblPista.add(JLabelDinossauros("Dinossauro1", imgDinossauro1, 0, 50));
            this.lblPista.add(JLabelDinossauros("Dinossauro2", imgDinossauro2, 0, 200));
            this.lblPista.add(JLabelDinossauros("Dinossauro3", imgDinossauro3, 0, 350));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}