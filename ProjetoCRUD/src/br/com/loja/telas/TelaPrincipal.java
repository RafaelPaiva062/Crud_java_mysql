package br.com.loja.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaPrincipal extends JFrame {
    private final JLabel ldlDate  = new JLabel("", SwingConstants.CENTER);  // A variável já está declarada aqui
    private JLabel grandeIcon; // Declare grandeIcon

    public TelaPrincipal() {
        setTitle("Sistema de OS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel central com a imagem de fundo
        JPanel painelCentral = createBackgroundPanel();
        painelCentral.setPreferredSize(new Dimension(600, 600));  // Controla o tamanho do painel central
        add(painelCentral, BorderLayout.CENTER);

        // Painel lateral direito com BoxLayout
        JPanel painelDireito = createRightPanel();
        painelDireito.setPreferredSize(new Dimension(200, getHeight()));
        add(painelDireito, BorderLayout.EAST);

        // Barra de menu
        setJMenuBar(createMenuBar());

        // Atualizar a data ao ativar a janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                updateDate();
            }
        });

        // Ação para o item de menu "Sair"
        JMenuItem sairMenuItem = ((JMenu) getJMenuBar().getMenu(3)).getItem(0); // Menu "Opções" -> "Sair"
        sairMenuItem.addActionListener(e -> System.exit(0));

        // Exibir a janela
        setVisible(true);
    }

    // Método para criar o painel de fundo
    private JPanel createBackgroundPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fundoIcon = new ImageIcon(getClass().getResource("/br/com/loja/icones/4k-oled-background-qdvijfjpxohfcw90.jpg"));
                g.drawImage(fundoIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
    }

    // Método para criar o painel lateral direito com os componentes do usuário e a data
    private JPanel createRightPanel() {
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS));
        painelDireito.setBackground(new Color(220, 220, 220));

        // Label para exibir o nome do usuário
        JLabel lblUsuario = new JLabel("USUÁRIO", SwingConstants.CENTER);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Não declare ldlDate novamente, use a variável de classe já existente
        ldlDate.setFont(new Font("Arial", Font.PLAIN, 12));
        ldlDate.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ícone do avatar - Redimensionando a imagem
        grandeIcon = new JLabel();
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/br/com/loja/icones/java.png"));
        Image resizedImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        grandeIcon.setIcon(new ImageIcon(resizedImage));
        grandeIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adiciona os componentes ao painel direito
        painelDireito.add(Box.createVerticalGlue());
        painelDireito.add(lblUsuario);
        painelDireito.add(ldlDate);  // Use a variável já declarada na classe
        painelDireito.add(grandeIcon);
        painelDireito.add(Box.createVerticalGlue());

        return painelDireito;
    }

    // Método para criar a barra de menu
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Menu "Cadastro"
        JMenu cadastroMenu = new JMenu("Cadastro");
        cadastroMenu.add(new JMenuItem("Cliente"));
        cadastroMenu.add(new JMenuItem("OS"));
        cadastroMenu.add(new JMenuItem("Usuários"));

        // Menu "Relatório"
        JMenu relatorioMenu = new JMenu("Relatório");
        relatorioMenu.add(new JMenuItem("Serviços"));

        // Menu "Ajuda"
        JMenu ajudaMenu = new JMenu("Ajuda");
        ajudaMenu.add(new JMenuItem("Sobre"));

        // Menu "Opções"
        JMenu opcoesMenu = new JMenu("Opções");
        JMenuItem sairMenuItem = new JMenuItem("Sair");
        opcoesMenu.add(sairMenuItem);

        // Adiciona os menus na barra
        menuBar.add(cadastroMenu);
        menuBar.add(relatorioMenu);
        menuBar.add(ajudaMenu);
        menuBar.add(opcoesMenu);

        return menuBar;
    }

    // Método para atualizar a data
    private void updateDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ldlDate.setText(formatter.format(date));  // Atualiza o texto do ldlDate com a data
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal();
        });
    }
}
