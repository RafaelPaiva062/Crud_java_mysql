package br.com.loja.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaPrincipal extends JFrame {
    private JLabel ldlDate;
    private JLabel lblUsuario;
    private JLabel lblAvatar;

    public TelaPrincipal() {
        setTitle("Sistema de OS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel central com imagem de fundo
        JPanel painelCentral = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("/br/com/loja/icones/Tela DE fundo.png");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        painelCentral.setLayout(new BorderLayout());
        add(painelCentral, BorderLayout.CENTER);

        // Painel lateral direito
        JPanel painelDireito = new JPanel();
        painelDireito.setLayout(new BoxLayout(painelDireito, BoxLayout.Y_AXIS));
        painelDireito.setPreferredSize(new Dimension(200, getHeight()));
        painelDireito.setBackground(new Color(220, 220, 220));

        // Label para exibir o nome do usuário
        lblUsuario = new JLabel("USUÁRIO", SwingConstants.CENTER);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Label para exibir a data
        ldlDate = new JLabel("", SwingConstants.CENTER);
        ldlDate.setFont(new Font("Arial", Font.PLAIN, 12));
        ldlDate.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ícone do avatar
        ImageIcon avatarIcon = new ImageIcon("/br/com/loja/icones/java.png");
        lblAvatar = new JLabel(avatarIcon);
        lblAvatar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionar componentes ao painel direito
        painelDireito.add(Box.createVerticalGlue());
        painelDireito.add(lblUsuario);
        painelDireito.add(ldlDate);
        painelDireito.add(lblAvatar);
        painelDireito.add(Box.createVerticalGlue());

        add(painelDireito, BorderLayout.EAST);

        // Barra de menu
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

        // Adicionar itens de menu
        cadastroMenu.add(clienteMenuItem);
        cadastroMenu.add(osMenuItem);
        cadastroMenu.add(usuariosMenuItem);
        relatorioMenu.add(servicosMenuItem);
        ajudaMenu.add(sobreMenuItem);
        opcoesMenu.add(sairMenuItem);

        menuBar.add(cadastroMenu);
        menuBar.add(relatorioMenu);
        menuBar.add(ajudaMenu);
        menuBar.add(opcoesMenu);
        setJMenuBar(menuBar);

        // Atualizar data ao ativar a janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = formatter.format(date);
                ldlDate.setText(formattedDate);
            }
        });

        // Ação para o item de menu "Sair"
        sairMenuItem.addActionListener(e -> System.exit(0));

        // Exibir a janela
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal principal = new TelaPrincipal();
            principal.setVisible(true);
        });
    }
}
