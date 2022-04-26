//Jogo da Velha - Jordan

//------Pacote JogoDaVelha
package JogoDaVelha;
//------Bibliotecas Usadas
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

//------Classe Pai do Jogo
public class Jogo {

    //------Atributos
    //------Atributo computador
    Computador computador = new Computador();
    //------Atributo computador_nivel_1
    Computador_Nivel_1 computador_nivel_1 = new Computador_Nivel_1();
    //------Atributo computador_nivel_2
    Computador_Nivel_2 computador_nivel_2 = new Computador_Nivel_2();
    //------Atributo computador_nivel_3
    Computador_Nivel_3 computador_nivel_3 = new Computador_Nivel_3();
    //------Atributo tabuleiro
    Tabuleiro tabuleiro = new Tabuleiro();
    //------Atributo jogador
    Jogador jogador = new Jogador();
    //------Variavel Random Com o Nome aleatorio
    Random aleatorio = new Random();
    //------Variavel JFrame Com o Nome Moldura
    JFrame moldura = new JFrame();
    //------Variavel JPanel com o Nome Painel do Titulo
    JPanel painel_do_titulo = new JPanel();
    //------Variavel JPanel com o Nome Painel de Botão
    JPanel painel_de_botao = new JPanel();
    //------Variavel JLabel com o Nome Campo de Texto
    JLabel campodetexto = new JLabel();
    //------Variavel JButton com o Nome Botões
    JButton[] botoes = new JButton[9];
    //------Icone da Bandeja do Sistema
    TrayIcon bandejaIcon;
    //------Bandeja do Sistema
    SystemTray bandeja;

    //------Jogo
    Jogo(){
        //------Dizendo para a Moldura Que Ela Pode Ser Fechada
        moldura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //------Dizendo o Titulo da Moldura
        moldura.setTitle("Jogo da Velha - Jordan");
        //------Dizendo o Tamanho da Moldura
        moldura.setSize(800,600);
        //------Dizendo a Cor de Fundo da Moldura
        moldura.getContentPane().setBackground(new Color(50,50,50));
        //------Dizendo a Posição da Moldura
        moldura.setLocationRelativeTo(null);
        //------Dizendo o Layout da Moldura
        moldura.setLayout(new BorderLayout());
        //------Dizendo que a Moldura é Visivel
        moldura.setVisible(true);
        //------Dizendo a Cor de Fundo do Campo de Texto
        campodetexto.setBackground(new Color(25,25,25));
        //------Dizendo a Cor do Texto do Campo de Texto
        campodetexto.setForeground(new Color(255,5,80));
        //------Dizendo a Fonte do Campo de Texto
        campodetexto.setFont(new Font("BEBAS NEUE", Font.BOLD,75));
        //------Dizendo o Alinhamento do Texto do Campo de Texto
        campodetexto.setHorizontalAlignment(JLabel.CENTER);
        //------Dizendo o Texto do Campo de Texto
        campodetexto.setText("Jogo da Velha");
        //------Dizendo a Opacidade do Campo de Texto
        campodetexto.setOpaque(true);
        //------Setando o layout do Painel do Titulo para BorderLayout
        painel_do_titulo.setLayout(new BorderLayout());
        //------Setando o Tamanho do Painel do Titulo
        painel_do_titulo.setBounds(0,0,800,100);
        //------Setando o layout do Painel de Botão para GridLayout 3x3
        painel_de_botao.setLayout(new GridLayout(3,3));
        //------Setando o a cor de Fundo do Painel de Botão
        painel_de_botao.setBackground(new Color(150,150,150));

        //------Definindo o Estilo do Programa
        //------Tenta
        try {
            //------Define o Estilo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //------Se Falhar
        } catch (Exception e) {
            //------Imprimi Aviso Que Não foi Possivel Definir
            System.out.println("Não foi possível definir LookAndFeel");
        }
        //------Definindo o Icone do Programa
        moldura.setIconImage(Toolkit.getDefaultToolkit().getImage("src/JogoDaVelha/icon.png"));

        //------Criando os Botões no Painel de Botão
        //------Pra i igual a 0 e i menor que 9 adiciona mais 1
        for(int i=0;i<9;i++) {
            //------botoes[i] = a novo JButton
            botoes[i] = new JButton();
            //------Adiciona o botoes[i]
            painel_de_botao.add(botoes[i]);
            //------Defiine a Fonte do Botoes e o Tamanho
            botoes[i].setFont(new Font("MV Boli", Font.BOLD,120));
            //------Define o Foco = Falso
            botoes[i].setFocusable(false);
            //------Define a Ação dos Botões
            botoes[i].addActionListener(jogador);
            //------Define se Ele Está Ativado
            botoes[i].setEnabled(false);
        }

        //------Adicionando o Campo de Texto no Painel do Titulo
        painel_do_titulo.add(campodetexto);
        //------Adicionando o Painel do Titulo na Moldura
        moldura.add(painel_do_titulo, BorderLayout.NORTH);
        //------Adicionando o Painel de Botao na Moldura
        moldura.add(painel_de_botao);

        //------Enquanto o Resultado do Nivel Selecionado for Diferente Continua, Se Não, Vai para Proxima
        while(!tabuleiro.nivelresultado) {

            //------#AINDA FALTA
            //------Variavel Objeto possiveisValores = Nivel 1, Nivel 2 e Nivel 3
            Object[] possiveisValores = { "Nivel 1", "Nivel 2", "Nivel 3" };
            //------Variavel Objeto ValorSelecionado = Popup
            Object ValorSelecionado = JOptionPane.showInputDialog(null,
                    //------Titulo do Popup
                    "Escolha o Nivel do Jogo", "Jogo da Velha - Jordan",
                    //------Estilo do Popup
                    JOptionPane.INFORMATION_MESSAGE, null,
                    //------Setando o valor que vai aparecer ao iniciar o Popup
                    possiveisValores, possiveisValores[0]);

            //------Se o Valor for Igual "Nivel 1"
            if (ValorSelecionado == possiveisValores[0]) {
                //------Booleana Nivel Resultado = Verdadeiro
                tabuleiro.nivelresultado = true;
                //------Booleana Turno do Computador1 = Verdadeiro
                computador.TurnoDoComputador1 = true;
                //------Executa o Primeiro Turno
                tabuleiro.PrimeiroTurno();

            }
            //------Se o Valor for Igual "Nivel 2"
            else if (ValorSelecionado == possiveisValores[1]) {
                //------Booleana Nivel Resultado = Verdadeiro
                tabuleiro.nivelresultado = true;
                //------Booleana Turno do Computador2 = Verdadeiro
                computador.TurnoDoComputador2 = true;
                //------Executa o Primeiro Turno2
                tabuleiro.PrimeiroTurno2();

            }
            //------Se o Valor for Igual "Nivel 3"
            else if (ValorSelecionado == possiveisValores[2]) {
                //------Booleana Nivel Resultado = Verdadeiro
                tabuleiro.nivelresultado = true;
                //------Booleana Turno do Computador3 = Verdadeiro
                computador.TurnoDoComputador3 = true;
                //------Executa o Primeiro Turno3
                tabuleiro.PrimeiroTurno3();
            }
        }
    }

//-----------------------------------------------------------------------------------------------------------------------

    //------Classe Jogador
    public class Jogador implements ActionListener {
        //------Booleana Turno do Jogador
        boolean TurnoDoJogador;
        @Override
        //------Metodo
        public void actionPerformed(ActionEvent e) {

            //------Para i = 0 e i<9, i++
            for(int i=0;i<9;i++){
                //------Se e.getSource() = Botão Selecionado
                if(e.getSource()==botoes[i]){
                    //------Se Turno do Computador 1 = Verdadeiro
                    if(computador.TurnoDoComputador1 == true) {
                        //------Se Turno do Jogador
                        if (TurnoDoJogador) {
                            //------Se o Botão Escolhido Estiver com o Texto == ""
                            if (botoes[i].getText() == "") {
                                //------Seta a Cor Vermelha do Texto do Botão
                                botoes[i].setForeground(new Color(255, 0, 0));
                                //------Seta o Texto do Botão Para "X"
                                botoes[i].setText("X");
                                //------Turno do Jogador = Falso
                                TurnoDoJogador = false;
                                //------Seta o Campo de Texto para "Turno do O"
                                campodetexto.setText("Turno do O");
                                //------Verifica
                                tabuleiro.Verificar();
                                //------Vai pro Turno do Computador
                                computador_nivel_1.TurnoDoComputador1();
                            }
                            //------Se não
                        } else {
                            //------Turno do Jogador = Falso
                            TurnoDoJogador = true;
                            //------Verifica
                            tabuleiro.Verificar();
                        }
                        //------Se Não Se Turno do Computador 2 = Verdadeiro
                    }else if (computador.TurnoDoComputador2 == true){
                        //------Se o Turno Do Jogador = Verdadeiro
                        if (TurnoDoJogador) {
                            //------Se o Botão Escolhido Estiver com o Texto == ""
                            if (botoes[i].getText() == "") {
                                //------Seta a Cor Vermelha do Texto do Botão
                                botoes[i].setForeground(new Color(255, 0, 0));
                                //------Seta o Texto do Botão Para "X"
                                botoes[i].setText("X");
                                //------Turno do Jogador = Falso
                                TurnoDoJogador = false;
                                //------Seta o Campo de Texto para "Turno do O"
                                campodetexto.setText("Turno do O");
                                //------Verifica
                                tabuleiro.Verificar();
                                //------Vai pro Turno do Computador 2
                                computador_nivel_2.TurnoDoComputador2();
                            }
                            //------Se Não
                        } else {
                            //------Turno Do Jogador = Verdadeiro
                            TurnoDoJogador = true;
                            //------Verifica
                            tabuleiro.Verificar();
                        }
                        //------Se Não Se Turno do Computador 3 = Verdadeiro
                    } else if (computador.TurnoDoComputador3 == true){
                        //------Se o Turno Do Jogador
                        if (TurnoDoJogador) {
                            //------Se o Botão Escolhido Estiver com o Texto == ""
                            if (botoes[i].getText() == "") {
                                //------Seta a Cor Vermelha do Texto do Botão
                                botoes[i].setForeground(new Color(255, 0, 0));
                                //------Seta o Texto do Botão Para "X"
                                botoes[i].setText("X");
                                //------Turno do Jogador = Falso
                                TurnoDoJogador = false;
                                //------Seta o Campo de Texto para "Turno do O"
                                campodetexto.setText("Turno do O");
                                //------Verifica
                                tabuleiro.Verificar();
                                //------Vai pro Turno do Computador 3
                                computador_nivel_3.TurnoDoComputador3();
                            }
                            //------Se não
                        } else {
                            //------Turno Do Jogador = Verdadeiro
                            TurnoDoJogador = true;
                            //------Verificar
                            tabuleiro.Verificar();
                        }
                    }
                }
            }
        }
    }

    //------Classe Computador
    public class Computador {
        //------Booleana Turno do (Computador1, Computador2 e Computador3) = Falso
        boolean TurnoDoComputador1, TurnoDoComputador2, TurnoDoComputador3 = false;
    }

    //------Classe Computador Nivel 1 Filha da Classe Computador
    public class Computador_Nivel_1 extends Computador {
        //------Metodo Turno do Computador 1
        public void TurnoDoComputador1() {
            //------Tenta
            try {
                //------Espera 80 milisegundos
                Thread.sleep(80);
                //------Se Falhar
            } catch (InterruptedException e) {
                //------Imprime o Erro
                e.printStackTrace();
            }

            //------Se Fim Do Jogo
            if (tabuleiro.FimDoJogo) {
                //------Enquanto For Diferente de Turno do Jogador
                while (!jogador.TurnoDoJogador) {
                    //------i = 0
                    int i = 0;
                    //------i = aleatorio.proximonumero(limitado a 9)
                    i = aleatorio.nextInt(9);
                    //------Se i != aleatorio.proximonumero(limitado a 9)
                    if (i != aleatorio.nextInt(9)) {
                        //------Se Botão Selecionado Estiver com o Texto ""
                        if (botoes[i].getText() == "") {
                            //------Seta a Cor do Texto Do Botão Selecionado Para Azul
                            botoes[i].setForeground(new Color(0, 0, 255));
                            //------Seta o Texto do Botão Selecionado Para O
                            botoes[i].setText("O");
                            //------Turno do Jogador = Verdadeiro
                            jogador.TurnoDoJogador = true;
                            //------Define o Texto do Campo de Texto Para "Turno do O"
                            campodetexto.setText("Turno do X");
                            //------Verifica
                            tabuleiro.Verificar();
                        }
                        //------Se o Botão Selecionado Estiver com o Texto "X"
                        if (botoes[i].getText() == "X") {
                            //------Se o i != aleatorio.proximonumero(limitado a 9)
                            if (i != aleatorio.nextInt(9)) {
                                //------Se o Botão Selecionado Estiver com o Texto ""
                                if (botoes[i].getText() == "") {
                                    //------Define a Cor do Texto do Botão Selecionado Para Azul
                                    botoes[i].setForeground(new Color(0, 0, 255));
                                    //------Seta o Texto do Botão Selecionado Para O
                                    botoes[i].setText("O");
                                    //------Turno do Jogador = Verdadeiro
                                    jogador.TurnoDoJogador = true;
                                    //------Verifica
                                    tabuleiro.Verificar();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //------Classe Computador Nivel 2 Filha da Classe Computador
    public class Computador_Nivel_2 extends Computador {
        //------Metodo Turno do Computador 2
        public void TurnoDoComputador2() {
            //------Se Fim de Jogo
            if(tabuleiro.FimDoJogo) {
                //------Enquanto For Diferente de Turno do Jogador
                while (!jogador.TurnoDoJogador) {
                    //------i = 0
                    int i = 0;
                    //------i = aleatorio.proximonumero(limitado a 9)
                    i = aleatorio.nextInt(9);
                    //------Se i != aleatorio.proximonumero(limitado a 9)
                    if (i != aleatorio.nextInt(9)) {
                        //------Se Botão Selecionado Estiver com o Texto ""
                        if (botoes[i].getText() == "") {
                            //------Seta a Cor do Texto Do Botão Selecionado Para Azul
                            botoes[i].setForeground(new Color(0, 0, 255));
                            //------Seta o Texto do Botão Selecionado Para O
                            botoes[i].setText("O");
                            //------Turno do Jogador = Verdadeiro
                            jogador.TurnoDoJogador = true;
                            //------Verifica
                            tabuleiro.Verificar();
                        }
                        //------Se o Botão Selecionado Estiver com o Texto "X"
                        if (botoes[i].getText() == "X") {
                            //------Se o i != aleatorio.proximonumero(limitado a 9)
                            if (i != aleatorio.nextInt(9)) {
                                //------Se o Botão Selecionado Estiver com o Texto ""
                                if (botoes[i].getText() == "") {
                                    //------Define a Cor do Texto do Botão Selecionado Para Azul
                                    botoes[i].setForeground(new Color(0, 0, 255));
                                    //------Seta o Texto do Botão Selecionado Para O
                                    botoes[i].setText("O");
                                    //------Turno do Jogador = Verdadeiro
                                    jogador.TurnoDoJogador = true;
                                    //------Verifica
                                    tabuleiro.Verificar();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //------Classe Computador Nivel 3 Filha da Classe Computador
    public class Computador_Nivel_3 extends Computador {
        //------Metodo Turno do Computador 3
        public void TurnoDoComputador3() {
            //------Se Fim de Jogo
            if(tabuleiro.FimDoJogo) {
                //------Enquanto For Diferente de Turno do Jogador
                while (!jogador.TurnoDoJogador) {
                    //------i = 0
                    int i = 0;
                    //------i = aleatorio.proximonumero(limitado a 9)
                    i = aleatorio.nextInt(9);
                    //------Se i != aleatorio.proximonumero(limitado a 9)
                    if (i != aleatorio.nextInt(9)) {
                        //------Se Botão Selecionado Estiver com o Texto ""
                        if (botoes[i].getText() == "") {
                            //------Seta a Cor do Texto Do Botão Selecionado Para Azul
                            botoes[i].setForeground(new Color(0, 0, 255));
                            //------Seta o Texto do Botão Selecionado Para O
                            botoes[i].setText("O");
                            //------Turno do Jogador = Verdadeiro
                            jogador.TurnoDoJogador = true;
                            //------Verifica
                            tabuleiro.Verificar();
                        }
                        //------Se o Botão Selecionado Estiver com o Texto "X"
                        if (botoes[i].getText() == "X") {
                            //------Se o i != aleatorio.proximonumero(limitado a 9)
                            if (i != aleatorio.nextInt(9)) {
                                //------Se o Botão Selecionado Estiver com o Texto ""
                                if (botoes[i].getText() == "") {
                                    //------Define a Cor do Texto do Botão Selecionado Para Azul
                                    botoes[i].setForeground(new Color(0, 0, 255));
                                    //------Seta o Texto do Botão Selecionado Para O
                                    botoes[i].setText("O");
                                    //------Turno do Jogador = Verdadeiro
                                    jogador.TurnoDoJogador = true;
                                    //------Verifica
                                    tabuleiro.Verificar();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //------Classe Tabuleiro
    public class Tabuleiro {
        //------Booleana Fim do Jogo = Verdadeiro
        boolean FimDoJogo = true;
        //------Booleana Resultado do Nivel Selecionado Para Jogar
        boolean nivelresultado;
        //------Metodo Primeiro Turno
        public void PrimeiroTurno(){

            //------TENTA
            try {
                //------Dorme por 2000 milisegundos
                Thread.sleep(2000);
            //------Se Falhar
            } catch (InterruptedException e) {
                //------Se Houver um Erro Printa
                e.printStackTrace();
            }

            //------Para i igual a 0 e i menor que 9 adiciona mais 1
            for(int i=0; i<9;i++) {
                //------Ativa os Botões
                botoes[i].setEnabled(true);
            }

            //------Se O Proximo Numero Aleatorio que é igual a 0 e limitado a 2
            if(aleatorio.nextInt(2)==0){
                //------Booleana FimDoJogo = Verdadeiro
                FimDoJogo = true;
                //------Booleana TurnoDoJogador = Verdadeiro
                jogador.TurnoDoJogador = true;
                //------Define o Texto do Campo de Texto Para "Turno do X"
                campodetexto.setText("Turno do X");
            }
            else{
                //------Booleana FimDoJogo = Verdadeiro
                FimDoJogo = true;
                //------Booleana TurnoDoJogador = Falso
                jogador.TurnoDoJogador = false;
                //------Define o Texto do Campo de Texto Para "Turno do O"
                campodetexto.setText("Turno do O");
                //------Ativa TurnoDoComputador1
                computador_nivel_1.TurnoDoComputador1();
            }
        }

        //------Metodo Primeiro Turno 2
        public void PrimeiroTurno2(){

            //------TENTA
            try {
                //------Dorme por 2000 milisegundos
                Thread.sleep(2000);
            //------Se Falhar
            } catch (InterruptedException e) {
                //------Se Houver um Erro Printa
                e.printStackTrace();
            }

            //------Para i igual a 0 e i menor que 9 adiciona mais 1
            for(int i=0; i<9;i++) {
                //------Ativa os Botões
                botoes[i].setEnabled(true);
            }

            //------Se O Proximo Numero Aleatorio que é igual a 0 e limitado a 2
            if(aleatorio.nextInt(2)==0){
                //------Booleana FimDoJogo = Verdadeiro
                FimDoJogo = true;
                //------Booleana TurnoDoJogador = Verdadeiro
                jogador.TurnoDoJogador = true;
                //------Define o Texto do Campo de Texto Para "Turno do X"
                campodetexto.setText("Turno do X");
            }
            else{
                //------Booleana FimDoJogo = Verdadeiro
                FimDoJogo = true;
                //------Booleana TurnoDoJogador = Falso
                jogador.TurnoDoJogador = false;
                //------Define o Texto do Campo de Texto Para "Turno do O"
                campodetexto.setText("Turno do O");
                //------Ativa TurnoDoComputador2
                computador_nivel_2.TurnoDoComputador2();
            }
        }

        //------Metodo Primeiro Turno 3
        public void PrimeiroTurno3(){

            //------TENTA
            try {
                //------Dorme por 2000 milisegundos
                Thread.sleep(2000);
            //------Se Falhar
            } catch (InterruptedException e) {
                //------Se Houver um Erro Printa
                e.printStackTrace();
            }

            //------Para i igual a 0 e i menor que 9 adiciona mais 1
            for(int i=0; i<9;i++) {
                //------Ativa os Botões
                botoes[i].setEnabled(true);
            }

            //------Se O Proximo Numero Aleatorio que é igual a 0 e limitado a 2
            if(aleatorio.nextInt(2)==0){
                //------Booleana FimDoJogo = Verdadeiro
                FimDoJogo = true;
                //------Booleana TurnoDoJogador = Verdadeiro
                jogador.TurnoDoJogador = true;
                //------Define o Texto do Campo de Texto Para "Turno do X"
                campodetexto.setText("Turno do X");
            }
            else{
                //------Booleana FimDoJogo = Verdadeiro
                FimDoJogo = true;
                //------Booleana TurnoDoJogador = Falso
                jogador.TurnoDoJogador = false;
                //------Define o Texto do Campo de Texto Para "Turno do O"
                campodetexto.setText("Turno do O");
                //------Ativa TurnoDoComputador3
                computador_nivel_3.TurnoDoComputador3();
            }
        }

        //------Metodo Verificar
        public void Verificar() {
            //------Se
            if (
                //------Botão da Posição [0] == "X"
                    (botoes[0].getText() == "X") &&
                            //------//------Botão da Posição [1] == "X"
                            (botoes[1].getText() == "X") &&
                            //------//------Botão da Posição [2] == "X"
                            (botoes[2].getText() == "X")
            ) {
                //------"X" Vence com A Posição [0], [1] e [2]
                XVencedor(0, 1, 2);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [3] == "X"
                    (botoes[3].getText() == "X") &&
                            //------Botão da Posição [4] == "X"
                            (botoes[4].getText() == "X") &&
                            //------Botão da Posição [5] == "X"
                            (botoes[5].getText() == "X")
            ) {
                //------"X" Vence com A Posição [3], [4] e [5]
                XVencedor(3, 4, 5);
            }
            else if (
                //------Botão da Posição [6] == "X"
                    (botoes[6].getText() == "X") &&
                            //------Botão da Posição [7] == "X"
                            (botoes[7].getText() == "X") &&
                            //------Botão da Posição [8] == "X"
                            (botoes[8].getText() == "X")
            ) {
                //------"X" Vence com A Posição [6], [7] e [8]
                XVencedor(6, 7, 8);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [0] == "X"
                    (botoes[0].getText() == "X") &&
                            //------Botão da Posição [3] == "X"
                            (botoes[3].getText() == "X") &&
                            //------Botão da Posição [6] == "X"
                            (botoes[6].getText() == "X")
            ) {
                //------"X" Vence com A Posição [0], [3] e [6]
                XVencedor(0, 3, 6);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [1] == "X"
                    (botoes[1].getText() == "X") &&
                            //------Botão da Posição [4] == "X"
                            (botoes[4].getText() == "X") &&
                            //------Botão da Posição [7] == "X"
                            (botoes[7].getText() == "X")
            ) {
                //------"X" Vence com A Posição [1], [4] e [7]
                XVencedor(1, 4, 7);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [2] == "X"
                    (botoes[2].getText() == "X") &&
                            //------Botão da Posição [5] == "X"
                            (botoes[5].getText() == "X") &&
                            //------Botão da Posição [8] == "X"
                            (botoes[8].getText() == "X")
            ) {
                //------"X" Vence com A Posição [2], [5] e [8]
                XVencedor(2, 5, 8);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [0] == "X"
                    (botoes[0].getText() == "X") &&
                            //------Botão da Posição [4] == "X"
                            (botoes[4].getText() == "X") &&
                            //------Botão da Posição [8] == "X"
                            (botoes[8].getText() == "X")
            ) {
                //------"X" Vence com A Posição [0], [4] e [8]
                XVencedor(0, 4, 8);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [2] == "X"
                    (botoes[2].getText() == "X") &&
                            //------Botão da Posição [4] == "X"
                            (botoes[4].getText() == "X") &&
                            //------Botão da Posição [6] == "X"
                            (botoes[6].getText() == "X")
            ) {
                //------"X" Vence com A Posição [2], [4] e [6]
                XVencedor(2, 4, 6);
            }

            //------Verificar OVencedor

            //------Se Não Se
            else if (
                //------Botão da Posição [0] == "O"
                    (botoes[0].getText() == "O") &&
                            //------Botão da Posição [1] == "O"
                            (botoes[1].getText() == "O") &&
                            //------Botão da Posição [2] == "O"
                            (botoes[2].getText() == "O")
            ) {
                //------"O" Vence com A Posição [0], [1] e [2]
                OVencedor(0, 1, 2);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [3] == "O"
                    (botoes[3].getText() == "O") &&
                            //------Botão da Posição [4] == "O"
                            (botoes[4].getText() == "O") &&
                            //------Botão da Posição [5] == "O"
                            (botoes[5].getText() == "O")
            ) {
                //------"O" Vence com A Posição [3], [4] e [5]
                OVencedor(3, 4, 5);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [6] == "O"
                    (botoes[6].getText() == "O") &&
                            //------Botão da Posição [7] == "O"
                            (botoes[7].getText() == "O") &&
                            //------Botão da Posição [8] == "O"
                            (botoes[8].getText() == "O")
            ) {
                //------"O" Vence com A Posição [6], [7] e [8]
                OVencedor(6, 7, 8);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [0] == "O"
                    (botoes[0].getText() == "O") &&
                            //------Botão da Posição [3] == "O"
                            (botoes[3].getText() == "O") &&
                            //------Botão da Posição [6] == "O"
                            (botoes[6].getText() == "O")
            ) {
                //------"O" Vence com A Posição [0], [3] e [6]
                OVencedor(0, 3, 6);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [1] == "O"
                    (botoes[1].getText() == "O") &&
                            //------Botão da Posição [4] == "O"
                            (botoes[4].getText() == "O") &&
                            //------Botão da Posição [7] == "O"
                            (botoes[7].getText() == "O")
            ) {
                //------"O" Vence com A Posição [1], [4] e [7]
                OVencedor(1, 4, 7);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [2] == "O"
                    (botoes[2].getText() == "O") &&
                            //------Botão da Posição [5] == "O"
                            (botoes[5].getText() == "O") &&
                            //------Botão da Posição [8] == "O"
                            (botoes[8].getText() == "O")
            ) {
                //------"O" Vence com A Posição [2], [5] e [8]
                OVencedor(2, 5, 8);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [0] == "O"
                    (botoes[0].getText() == "O") &&
                            //------Botão da Posição [4] == "O"
                            (botoes[4].getText() == "O") &&
                            //------Botão da Posição [8] == "O"
                            (botoes[8].getText() == "O")
            ) {
                //------"O" Vence com A Posição [0], [4] e [8]
                OVencedor(0, 4, 8);
            }
            //------Se Não Se
            else if (
                //------Botão da Posição [2] == "O"
                    (botoes[2].getText() == "O") &&
                            //------Botão da Posição [4] == "O"
                            (botoes[4].getText() == "O") &&
                            //------Botão da Posição [6] == "O"
                            (botoes[6].getText() == "O")
            ) {
                //------"O" Vence com A Posição [2], [4] e [6]
                OVencedor(2, 4, 6);
            }
            //------Se Não
            else {
                //------VerificarEmpate = 0
                int verificarEmpate = 0;
                //------Para JButton i botoes
                for(JButton i : botoes) {
                    //------Se Texto do Botão I == "O" ou Texto do Botão I == "X"
                    if(i.getText()=="O" || i.getText()=="X") {
                        //------Verifica Empate + 1
                        verificarEmpate++;
                    }
                    //------If Verificar Empate == 9
                    if(verificarEmpate==9) {
                        //------Empate
                        Empate();
                    }
                }
            }

        }

        //------Metodo Novo Jogo
        public void NovoJogo() {

            //------Para i = 0, i<9,i+1
            for(int i=0;i<9;i++) {
                //------Ativa os Botões
                botoes[i].setEnabled(true);
                //------Define o Texto de Todos os Botões Para ""
                botoes[i].setText("");
                //------Pega a Cor do Botão Padrão e Coloca na Variavel b_color
                JButton b_color = new JButton();
                //------Variavel da Cor do Botão
                Color b_colorreal = b_color.getBackground();
                //------Define a Cor do Fundo dos Botões Para o Padrão
                botoes[i].setBackground(b_colorreal);
                //------Define a Cor dos Botões Para o Padrão
                botoes[i].setForeground(b_colorreal);
            }

            //------Primeiro Turno
            PrimeiroTurno();
        }

        //------Metodo Empate
        public void Empate() {
            //------EMPATE
            campodetexto.setText("EMPATE");
            //------Para i = 0, i<9,i+1
            for(int i=0;i<9;i++) {
                //------Desativa os Botões
                botoes[i].setEnabled(false);
            }

            //------resultado = Popup de Confirmação / Mensagem: "Começar denovo?", Titulo: "Jogo da Velha", Tipo de Popup: Confirmação Sim e Não
            int resultado = JOptionPane.showConfirmDialog(null, "Começar denovo?", "Jogo da Velha", JOptionPane.YES_NO_OPTION);
            //------Troca
            switch (resultado) {
                //------Caso for Confirmação Sim
                case JOptionPane.YES_OPTION:
                    //------Começa NovoJogo
                    NovoJogo();
                    //------Quebra
                    break;
                //------Caso for Confirmação Não
                case JOptionPane.NO_OPTION:
                    //------Fecha o Jogo
                    System.exit(0);
                    //------Quebra
                    break;
            }
        }

        //------Metodo XVencedor com (Valor a, Valor b, Valor C)
        public void XVencedor(int a, int b,int c){

            //------Seta o Botão[a] Com a Cor Verde
            botoes[a].setBackground(Color.GREEN);
            //------Seta o Botão[b] Com a Cor Verde
            botoes[b].setBackground(Color.GREEN);
            //------Seta o Botão[c] Com a Cor Verde
            botoes[c].setBackground(Color.GREEN);

            //------Para i = 0, i<9,i+1
            for(int i=0;i<9;i++) {
                //------Fim Do Jogo = Falso
                FimDoJogo = false;
                //------Desativa os Botões
                botoes[i].setEnabled(false);
            }
            //------Jogador Venceu
            campodetexto.setText("Jogador Venceu");

            //------resultado = Popup de Confirmação / Mensagem: "Começar denovo?", Titulo: "Jogo da Velha", Tipo de Popup: Confirmação Sim e Não
            int resultado = JOptionPane.showConfirmDialog(null, "Começar denovo?", "Jogo da Velha", JOptionPane.YES_NO_OPTION);
            //------Troca resultado
            switch (resultado) {
                //------Caso for Confirmação Sim
                case JOptionPane.YES_OPTION:
                    //------Novo Jogo
                    NovoJogo();
                    //------Quebra
                    break;
                //------Caso for Confirmação Não
                case JOptionPane.NO_OPTION:
                    //------Fecha o Jogo
                    System.exit(0);
                    //------Quebra
                    break;
            }


        }

        //------Metodo OVencedor com (Valor a, Valor b, Valor C)
        public void OVencedor(int a, int b,int c){

            //------Seta o Botão[a] Com a Cor Verde
            botoes[a].setBackground(Color.GREEN);
            //------Seta o Botão[b] Com a Cor Verde
            botoes[b].setBackground(Color.GREEN);
            //------Seta o Botão[c] Com a Cor Verde
            botoes[c].setBackground(Color.GREEN);

            //------Para i = 0, i<9,i+1
            for(int i=0;i<9;i++) {
                //------Fim Do Jogo = Falso
                FimDoJogo = false;
                //------Desativa os Botões
                botoes[i].setEnabled(false);
            }
            //------Computador Venceu
            campodetexto.setText("Computador Venceu");

            //------resultado = Popup de Confirmação / Mensagem: "Começar denovo?", Titulo: "Jogo da Velha", Tipo de Popup: Confirmação Sim e Não
            int resultado = JOptionPane.showConfirmDialog(null, "Começar denovo?", "Jogo da Velha", JOptionPane.YES_NO_OPTION);
            //------Troca resultado
            switch (resultado) {
                //------Caso for Confirmação Sim
                case JOptionPane.YES_OPTION:
                    //------Começa NovoJogo
                    NovoJogo();
                    //------Quebra
                    break;
                //------Caso for Confirmação Não
                case JOptionPane.NO_OPTION:
                    //------Fecha o Jogo
                    System.exit(0);
                    //------Quebra
                    break;
            }
        }

        //------Metodo Para Jogo
        public void ParaJogo () {
            //------Fim do Jogo = Falso
            FimDoJogo = false;
        }
    }

}
