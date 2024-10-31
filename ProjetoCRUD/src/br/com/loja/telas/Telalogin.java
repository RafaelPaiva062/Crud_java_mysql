package br.com.loja.telas;

import java.sql.*;
import br.com.loja.dal.ModulloConexao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Telalogin extends javax.swing.JFrame {

    private JTextField usuario;
    private JPasswordField senha;
    private JButton botaoLogin;
    private JLabel statusIcon;

    public Telalogin() {
        setTitle("Tela de Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Layout absoluto para controle mais detalhado

        // Definindo cor de fundo
        getContentPane().setBackground(new Color(60, 63, 65));

        // Configuração de fonte padrão
        Font fontePadrao = new Font("Arial", Font.PLAIN, 14);

        // Configuração do rótulo de usuário
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setForeground(Color.WHITE);
        labelUsuario.setFont(fontePadrao);
        labelUsuario.setBounds(50, 50, 100, 25);
        add(labelUsuario);

        // Campo de texto de usuário
        usuario = new JTextField();
        usuario.setFont(fontePadrao);
        usuario.setBounds(150, 50, 180, 25);
        usuario.setBackground(new Color(220, 220, 220));
        usuario.setForeground(Color.DARK_GRAY);
        add(usuario);

        // Configuração do rótulo de senha
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setForeground(Color.WHITE);
        labelSenha.setFont(fontePadrao);
        labelSenha.setBounds(50, 100, 100, 25);
        add(labelSenha);

        // Campo de senha
        senha = new JPasswordField();
        senha.setFont(fontePadrao);
        senha.setBounds(150, 100, 180, 25);
        senha.setBackground(new Color(220, 220, 220));
        senha.setForeground(Color.DARK_GRAY);
        add(senha);

        // Botão de login estilizado
        botaoLogin = new JButton("Login") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(75, 110, 175)); // Cor do botão
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Bordas arredondadas
                super.paintComponent(g2d);
            }
        };
        botaoLogin.setFocusPainted(false);
        botaoLogin.setForeground(Color.WHITE);
        botaoLogin.setFont(new Font("Arial", Font.BOLD, 14));
        botaoLogin.setBounds(150, 150, 180, 30);
        botaoLogin.setContentAreaFilled(false);

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });
        add(botaoLogin);

        // JLabel para mostrar o ícone de conexão
        statusIcon = new JLabel();
        statusIcon.setBounds(30, 200, 25, 25); // Posição visível
        add(statusIcon);
        verificarConexao();
    }

    private void verificarConexao() {
        String statusConexao = ModulloConexao.testConnection();
        if (statusConexao.contains("bem-sucedida")) {
            statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/IconesdeVerificado.png")));
        } else {
            statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/download.png")));
        }
    }

    private void realizarLogin() {
        String campoUsuario = usuario.getText();
        String campoSenha = new String(senha.getPassword());

        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";

        try (Connection conexao = ModulloConexao.connection();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, campoUsuario);
            pst.setString(2, campoSenha);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    // Login bem-sucedido
                    statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/IconesdeVerificado.png")));
                    JOptionPane.showMessageDialog(this, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                     this.dispose();
                     conexao.close();

                } else {
                    // Login falhou
                    statusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icones/download.png")));
                    JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)
 {
     realizarLogin();
 }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Telalogin telalogin = new Telalogin();
            telalogin.setVisible(true);
        });
    }
}
