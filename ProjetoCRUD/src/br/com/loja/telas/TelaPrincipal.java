package br.com.loja.telas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JPanel Opções;
    private JTextField usuárioTextField;
    private JTextField dataTextField;
    private JComboBox Cadastro;
    private JComboBox Relatório;
    private JComboBox Ajuda;
    private JComboBox Opões;

    public  TelaPrincipal()
    {
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JMenuBar menoBar = new JMenuBar();
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenuItem clienteItem = new JCheckBoxMenuItem("Cliente");
        JMenuItem osItem = new JMenuItem("Os");
        JMenuItem usuarioItem = new JMenuItem("Usuário");

        cadastroMenu.add(clienteItem);
        cadastroMenu.add(osItem);
        cadastroMenu.add(usuarioItem);

        JMenu relatario = new JMenu("Relatório");
        JMenuItem servico = new JMenuItem("Serviço");

        relatario.add(relatario);

         JMenu ajuda = new JMenu("Ajuda");
         JMenuItem sobre = new JMenuItem("Sobre");

         ajuda.add(sobre);
         JMenu opcoes = new JMenu("Opções");
         JMenuItem sair = new JMenuItem("Sair");
         opcoes.add("Sair");
         frame.setJMenuBar(menoBar);
         clienteItem.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(TelaPrincipal.this,"Cliente");
             }
         });

    }
    public static void  mein( String [] arg)
    {
        SwingUtilities.invokeLater(() -> {
           TelaPrincipal principal = new TelaPrincipal();
           principal.setVisible(true);
        });
    }


}
