package br.com.loja.telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TelaPrincipal extends JFrame {

    private JTextField usuarioTextField;
    private JPanel TelaPrincipal;


    public TelaPrincipal() {
        setTitle("Sistemas de OS");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Criando os JMenus e JMenuItems
        JMenuBar menuBar = new JMenuBar();
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenu relatorioMenu = new JMenu("Relatório");
        JMenu ajudaMenu = new JMenu("Ajuda");
        JMenu opcoesMenu = new JMenu("Opções");

        JMenuItem clienteMenuItem = new JMenuItem("Cliente");
        JMenuItem osMenuItem = new JMenuItem("OS");
        JMenuItem usuariosMenuItem = new JMenuItem("Usuários");
        JMenuItem servicosMenuItem = new JMenuItem("Serviços");
        JMenuItem sobreMenuItem = new JMenuItem("Sobre");
        JMenuItem sairMenuItem = new JMenuItem("Sair");

        // Adicionando os JMenuItems aos JMenus
        cadastroMenu.add(clienteMenuItem);
        cadastroMenu.add(osMenuItem);
        cadastroMenu.add(usuariosMenuItem);
        relatorioMenu.add(servicosMenuItem);
        ajudaMenu.add(sobreMenuItem);
        opcoesMenu.add(sairMenuItem);

        // Adicionando os JMenus à JMenuBar
        menuBar.add(cadastroMenu);
        menuBar.add(relatorioMenu);
        menuBar.add(ajudaMenu);
        menuBar.add(opcoesMenu);          
        // Adicionando a JMenuBar à janela
        setJMenuBar(menuBar);
        private void formWindowActivated(java.awt.event.WindowEvent evt) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // Define o formato de data e hora
            String formattedDate = formatter.format(date); // Formata a data atual
            lblDate.setText(formattedDate); // Exibe a data no JLabel
        }
        // Definindo ações para os JMenuItems (exemplo)
        sairMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Exibindo a janela
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal principal = new TelaPrincipal();
            principal.setVisible(true);
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
