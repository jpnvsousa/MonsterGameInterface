package projeto;

import java.awt.event.KeyEvent;
import java.util.Random;

public class jogoDoMonstro extends javax.swing.JFrame {

	private boolean impossibilidadeDeAndarMonstro = true, temBuracoCima, temBuracoBaixo, temBuracoEsquerda,
			temBuracoDireita;
	private int xJogador, yJogador, contBuracos, contBuracos2, xMonstro, yMonstro, contAlternadorMovimento, contadorDeRodadas;
	private int xMatrizJogador, yMatrizJogador, xMatrizMonstro, yMatrizMonstro;
	private String labirintoString[][] = new String[9][17];
	private Random g = new Random();

	public jogoDoMonstro() {
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
	}

	public void movimentoMonstroCima() {
		if (yMonstro >= 91) {
			int k = yMonstro;
			while (yMonstro > k - 68) {
				monstro.setLocation(xMonstro, yMonstro);
				yMonstro--;
			}
		}
	}

	public void movimentoMonstroBaixo() {
		int k = yMonstro;
		if (yMonstro <= (70 * 8)) {
			while (yMonstro < k + 68) {
				monstro.setLocation(xMonstro, yMonstro);
				yMonstro++;
			}
		}
	}

	public void movimentoMonstroEsquerda() {
		if (xMonstro >= 91) {
			int k = xMonstro;
			while (xMonstro > k - 76) {
				monstro.setLocation(xMonstro, yMonstro);
				xMonstro--;
			}

		}
	}

	public void movimentoMonstroDireita() {
		int k = xMonstro;
		if (xMonstro <= (77 * 15)) {
			while (xMonstro < k + 76) {
				monstro.setLocation(xMonstro, yMonstro);
				xMonstro++;
			}

		}
	}

	public void movimentoJogadorCima() {
		int k = yJogador;
		while (yJogador > k - 70) {
			jogador.setLocation(xJogador, yJogador);
			yJogador--;
		}
	}

	public void movimentoJogadorBaixo() {
		int k = yJogador;
		while (yJogador < k + 70) {
			jogador.setLocation(xJogador, yJogador);
			yJogador++;
		}
	}

	public void movimentoJogadorDireita() {
		int k = xJogador;
		while (xJogador < k + 77) {
			jogador.setLocation(xJogador, yJogador);
			xJogador++;
		}
	}

	public void movimentoJogadorEsquerda() {
		int k = xJogador;
		while (xJogador > k - 77) {
			jogador.setLocation(xJogador, yJogador);
			xJogador--;
		}
	}

	public void movimentoNaMatrizMonstroCima() {
		xMatrizMonstro--;
		labirintoString[xMatrizMonstro][yMatrizMonstro] = "M";
		labirintoString[xMatrizMonstro + 1][yMatrizMonstro] = " ";
	}

	public void movimentoNaMatrizMonstroBaixo() {
		xMatrizMonstro++;
		labirintoString[xMatrizMonstro][yMatrizMonstro] = "M";
		labirintoString[xMatrizMonstro - 1][yMatrizMonstro] = " ";
	}

	public void movimentoNaMatrizMonstroEsquerda() {
		yMatrizMonstro--;
		labirintoString[xMatrizMonstro][yMatrizMonstro] = "M";
		labirintoString[xMatrizMonstro][yMatrizMonstro + 1] = " ";
	}

	public void movimentoNaMatrizMonstroDireita() {
		yMatrizMonstro++;
		labirintoString[xMatrizMonstro][yMatrizMonstro] = "M";
		labirintoString[xMatrizMonstro][yMatrizMonstro - 1] = " ";
	}

	public void movimentoNaMatrizJogadorCima() {
		xMatrizJogador--;
		labirintoString[xMatrizJogador][yMatrizJogador] = "J";
		labirintoString[xMatrizJogador + 1][yMatrizJogador] = " ";
	}

	public void movimentoNaMatrizJogadorBaixo() {
		xMatrizJogador++;
		labirintoString[xMatrizJogador][yMatrizJogador] = "J";
		labirintoString[xMatrizJogador - 1][yMatrizJogador] = " ";
	}

	public void movimentoNaMatrizJogadorDireita() {
		yMatrizJogador++;
		labirintoString[xMatrizJogador][yMatrizJogador] = "J";
		labirintoString[xMatrizJogador][yMatrizJogador - 1] = " ";
	}

	public void movimentoNaMatrizJogadorEsquerda() {
		yMatrizJogador--;
		labirintoString[xMatrizJogador][yMatrizJogador] = "J";
		labirintoString[xMatrizJogador][yMatrizJogador + 1] = " ";
	}

	public void imprimirLabirintoConsole() {
		for (int i = 1; i <= 8; i++) {// IMRPRIMIR LABIRINTO INICIAL NO CONSOLE
			for (int j = 1; j <= 16; j++) {
				if (j == 17 - 1) {
					System.out.printf("| %s |", labirintoString[i][j]);
				} else {
					System.out.printf("| %s ", labirintoString[i][j]);
				}

			}
			System.out.println();
		}
	}

	public void criarJogadorRandomicamente() {
		// FOR PARA CRIAR O JOGADOR RANDOMICAMENTE
		for (int i = 0; i < 1;) {
			int rndx = g.nextInt(8);
			int rndy = g.nextInt(16);
			if (rndx != 0 && rndy != 0) {
				if (labirintoString[rndx][rndy] != "B" && labirintoString[rndx][rndy] != "M") {
					jogador.setBounds(91 + (77 * (rndy - 1)), 79 + (70 * (rndx - 1)), 30, 42);
					xJogador = 91 + (77 * (rndy - 1));
					yJogador = 79 + (70 * (rndx - 1));
					labirintoString[rndx][rndy] = "J";
					xMatrizJogador = rndx;
					yMatrizJogador = rndy;
					i++;
				}
			}
		}
	}

	public void criarMonstroRandomicamente() {
		// FOR PARA CRIAR O MONSTRO RANDOMICAMENTE
		for (int i = 0; i < 1;) {
			int rndx = g.nextInt(8);
			int rndy = g.nextInt(16);
			if (rndx != 0 && rndy != 0) {
				if (labirintoString[rndx][rndy] != "B") {
					monstro.setBounds(76 + (76 * (rndy - 1)), 67 + (68 * (rndx - 1)), 80, 70);
					xMonstro = 76 + (76 * (rndy - 1));
					yMonstro = 67 + (68 * (rndx - 1));
					labirintoString[rndx][rndy] = "M";
					xMatrizMonstro = rndx;
					yMatrizMonstro = rndy;
					i++;
				}
			}
		}
	}

	public void criarMapaMatrizStringVazio() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 17; j++) {
				labirintoString[i][j] = " ";
			}
		}
	}

	public void criarBuracosRandomicamente() {
		// FOR PARA DEFINIR BURACOS RANDOMICAMENTE
		int x = 1;
		for (int i = 1; i <= 25;) {
			int rndx = g.nextInt(9);
			int rndy = g.nextInt(17);
			if (rndx != 0 && rndy != 0) {
				if (labirintoString[rndx][rndy] != "B") {
					labirintoString[rndx][rndy] = "B";

					// labirintoCordenadas[rndx][rndy] = 0;

					if (x == 1) {
						b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b1);
						b1.setBounds(76 * (rndy), 71 * (rndx), 80, 70);

					} else if (x == 2) {
						b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b2);
						b2.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 3) {
						b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b3);
						b3.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 4) {
						b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b4);
						b4.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 5) {
						b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b5);
						b5.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 6) {
						b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b6);
						b6.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 7) {
						b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b7);
						b7.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 8) {
						b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b8);
						b8.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 9) {
						b9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b9);
						b9.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 10) {
						b10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b10);
						b10.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 11) {
						b11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b11);
						b11.setBounds(76 * (rndy), 71 * (rndx), 80, 70);

					} else if (x == 12) {
						b12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b12);
						b12.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 13) {
						b13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b13);
						b13.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 14) {
						b14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b14);
						b14.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 15) {
						b15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b15);
						b15.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 16) {
						b16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b16);
						b16.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 17) {
						b17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b17);
						b17.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 18) {
						b18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b18);
						b18.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 19) {
						b19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b19);
						b19.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 20) {
						b20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b20);
						b20.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 21) {
						b21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b21);
						b21.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 22) {
						b22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b22);
						b22.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 23) {
						b23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b23);
						b23.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 24) {
						b24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b24);
						b24.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					} else if (x == 25) {
						b25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buraco.png")));
						getContentPane().add(b25);
						b25.setBounds(76 * (rndy), 71 * (rndx), 80, 70);
					}
					x++;
					i++;
				}
			}
		}
	}

	public void verificadorDeBuracosNaMatriz(String tipo) {
		if (tipo.equals("monstro")) {
			contBuracos2 = 0;
			if (labirintoString[xMatrizMonstro + 1][yMatrizMonstro] == "B") {
				temBuracoBaixo = true;
				contBuracos2++;
			}
			if (labirintoString[xMatrizMonstro - 1][yMatrizMonstro] == "B") {
				temBuracoCima = true;
				contBuracos2++;
			}
			if (labirintoString[xMatrizMonstro][yMatrizMonstro + 1] == "B") {
				temBuracoDireita = true;
				contBuracos++;
			}
			if (labirintoString[xMatrizMonstro][yMatrizMonstro - 1] == "B") {
				temBuracoEsquerda = true;
				contBuracos2++;
			}

			if (contBuracos2 == 0) {
				impossibilidadeDeAndarMonstro = false;
			} else {
				impossibilidadeDeAndarMonstro = true;
			}

		} else if (tipo.equals("jogador")) {
			contBuracos = 0;
			if (labirintoString[xMatrizJogador + 1][yMatrizJogador] == "B") {
				contBuracos++;
			}
			if (labirintoString[xMatrizJogador - 1][yMatrizJogador] == "B") {
				contBuracos++;
			}
			if (labirintoString[xMatrizJogador][yMatrizJogador + 1] == "B") {
				contBuracos++;
			}
			if (labirintoString[xMatrizJogador][yMatrizJogador - 1] == "B") {
				contBuracos++;
			}

		}

	}

	public void avisoDeBuracos() {
		if (contBuracos == 0) {
			chatEvento.setText(" ");
		} else if (contBuracos == 1) {
			chatEvento.setText("Você está sentindo 1 brisa");
		} else {
			chatEvento.setText("Você está sentindo " + contBuracos + " brisas");
		}
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		tempoShow = new javax.swing.JLabel();
		chatEvento = new javax.swing.JLabel();
		fundoChatEvent = new javax.swing.JLabel();
		tempo = new javax.swing.JLabel();
		item1 = new javax.swing.JLabel();
		item2 = new javax.swing.JLabel();
		item3 = new javax.swing.JLabel();
		vida1 = new javax.swing.JLabel();
		vida2 = new javax.swing.JLabel();
		vida3 = new javax.swing.JLabel();
		fundoItens = new javax.swing.JLabel();
		jogador = new javax.swing.JLabel();
		monstro = new javax.swing.JLabel();
		b1 = new javax.swing.JLabel();
		b2 = new javax.swing.JLabel();
		b3 = new javax.swing.JLabel();
		b4 = new javax.swing.JLabel();
		b5 = new javax.swing.JLabel();
		b6 = new javax.swing.JLabel();
		b7 = new javax.swing.JLabel();
		b8 = new javax.swing.JLabel();
		b9 = new javax.swing.JLabel();
		b10 = new javax.swing.JLabel();
		b11 = new javax.swing.JLabel();
		b12 = new javax.swing.JLabel();
		b13 = new javax.swing.JLabel();
		b14 = new javax.swing.JLabel();
		b15 = new javax.swing.JLabel();
		b16 = new javax.swing.JLabel();
		b17 = new javax.swing.JLabel();
		b18 = new javax.swing.JLabel();
		b19 = new javax.swing.JLabel();
		b20 = new javax.swing.JLabel();
		b21 = new javax.swing.JLabel();
		b22 = new javax.swing.JLabel();
		b23 = new javax.swing.JLabel();
		b24 = new javax.swing.JLabel();
		b25 = new javax.swing.JLabel();
		fundo = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Monster Game - BLUEBOOK");
		setPreferredSize(new java.awt.Dimension(550, 700));
		getContentPane().setLayout(null);

		tempoShow.setFont(tempoShow.getFont().deriveFont(tempoShow.getFont().getStyle() | java.awt.Font.BOLD,
				tempoShow.getFont().getSize() + 7));
		tempoShow.setForeground(new java.awt.Color(255, 255, 255));
		tempoShow.setText("04:20");
		getContentPane().add(tempoShow);
		tempoShow.setBounds(170, 10, 60, 40);

		chatEvento.setFont(chatEvento.getFont().deriveFont(chatEvento.getFont().getStyle() | java.awt.Font.BOLD,
				chatEvento.getFont().getSize() + 7));
		chatEvento.setForeground(new java.awt.Color(153, 51, 0));
		chatEvento.setText("O JOGO COMEÇOU!");
		getContentPane().add(chatEvento);
		chatEvento.setBounds(90, 640, 370, 50);

		fundoChatEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundoChatEvent1.png")));
		getContentPane().add(fundoChatEvent);
		fundoChatEvent.setBounds(70, 620, 390, 90);

		tempo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/relogio.png")));
		tempo.setText("relogio");
		getContentPane().add(tempo);
		tempo.setBounds(120, 0, 40, 60);
		tempo.getAccessibleContext().setAccessibleName("tempo");

		item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/espada1.png")));
		getContentPane().add(item1);
		item1.setBounds(710, 640, 40, 50);

		item2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/potion.png")));
		getContentPane().add(item2);
		item2.setBounds(770, 640, 30, 50);
		item2.getAccessibleContext().setAccessibleName("potion");

		item3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/escudo.png")));
		getContentPane().add(item3);
		item3.setBounds(810, 640, 50, 50);

		vida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vidaC.png")));
		getContentPane().add(vida1);
		vida1.setBounds(1200, 10, 40, 40);

		vida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vidaC.png")));
		getContentPane().add(vida2);
		vida2.setBounds(1150, 10, 40, 40);

		vida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vidaV.png")));
		getContentPane().add(vida3);
		vida3.setBounds(1100, 10, 40, 40);

		fundoItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundoItens.png")));
		getContentPane().add(fundoItens);
		fundoItens.setBounds(700, 640, 490, 50);

		monstro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/monstro.gif")));
		getContentPane().add(monstro);

		jogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jogador.png")));
		getContentPane().add(jogador);

		// CHAMANDO OS METODOS PARA CRIAR O JOGO
		criarMapaMatrizStringVazio();
		criarBuracosRandomicamente();

		criarMonstroRandomicamente();
		criarJogadorRandomicamente();
		imprimirLabirintoConsole();

		// MAPA DO JOGO
		fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapa.png")));
		fundo.setPreferredSize(new java.awt.Dimension(1366, 768));
		getContentPane().add(fundo);
		fundo.setBounds(0, -30, 1390, 760);
		pack();

		// ANDAR USANDO TECLADO
		addKeyListener(new java.awt.event.KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				// nada acontece
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();

				// andar monstro
			
					verificadorDeBuracosNaMatriz("monstro");

					if (!impossibilidadeDeAndarMonstro) {
					//	if (contAlternadorMovimento == 0) {
							if (xMonstro > xJogador && xMonstro > xJogador - 50) {
								movimentoMonstroEsquerda();
								movimentoNaMatrizMonstroEsquerda();
							} else if (xMonstro < xJogador && xMonstro < xJogador - 50) {
								movimentoMonstroDireita();
								movimentoNaMatrizMonstroDireita();
							} else {
								if (yMonstro > yJogador && yMonstro > yJogador - 50) {
									movimentoMonstroCima();
									movimentoNaMatrizMonstroCima();
								} else if (yMonstro < yJogador && yMonstro < yJogador - 50) {
									movimentoMonstroBaixo();
									movimentoNaMatrizMonstroBaixo();
								}
							}
				/*			contAlternadorMovimento++;
						} else {
							if (yMonstro > yJogador && yMonstro > yJogador - 50) {
								movimentoMonstroCima();
								movimentoNaMatrizMonstroCima();
							} else if (yMonstro < yJogador && yMonstro < yJogador - 50) {
								movimentoMonstroBaixo();
								movimentoNaMatrizMonstroBaixo();
							} else {
								if (xMonstro > xJogador && xMonstro > xJogador - 50) {
									movimentoMonstroEsquerda();
									movimentoNaMatrizMonstroEsquerda();
								} else if (xMonstro < xJogador && xMonstro < xJogador - 50) {
									movimentoMonstroDireita();
									movimentoNaMatrizMonstroDireita();
								}

							}

							contAlternadorMovimento = 0;
						}*/
							
						chatEvento.setText("n");
						
					} else {
						impossibilidadeDeAndarMonstro = false;
						if (xMonstro > xJogador && xMonstro > xJogador - 50 && temBuracoEsquerda) {
							// movimentoMonstroEsquerda();
							// movimentoNaMatrizMonstroEsquerda();
							if (yMonstro > yJogador && yMonstro > yJogador - 50 && temBuracoCima == false) {
								movimentoMonstroCima();
								movimentoNaMatrizMonstroCima();
								chatEvento.setText("n tem em cima, fui p cima");
							} else if (yMonstro < yJogador && yMonstro < yJogador - 50 && temBuracoBaixo == false) {
								movimentoMonstroBaixo();
								movimentoNaMatrizMonstroBaixo();
								chatEvento.setText("tem em cima, fui p baixo");
							} else if(temBuracoCima = true && temBuracoBaixo == false){
								movimentoMonstroBaixo();
								movimentoNaMatrizMonstroBaixo();
								chatEvento.setText("tem em cima, fui p baixo");
							} else if(temBuracoBaixo = true && temBuracoCima == false){
								movimentoMonstroCima();
								movimentoNaMatrizMonstroCima();
								chatEvento.setText("n tem em cima, fui p cima");
							}else{
								movimentoMonstroDireita();
								movimentoNaMatrizMonstroDireita();
							}
							
							

						} else if (xMonstro < xJogador && xMonstro < xJogador - 50 && temBuracoDireita) {
							// movimentoMonstroDireita();
							// movimentoNaMatrizMonstroDireita();
							if (yMonstro > yJogador && yMonstro > yJogador - 50 && temBuracoCima == false) {
								movimentoMonstroCima();
								movimentoNaMatrizMonstroCima();
								chatEvento.setText("n tem em cima, fui p cima");
							} else if (yMonstro < yJogador && yMonstro < yJogador - 50 && temBuracoBaixo == false) {
								movimentoMonstroBaixo();
								movimentoNaMatrizMonstroBaixo();
								chatEvento.setText("tem em cima, fui p baixo");
							} else if(temBuracoCima = true && temBuracoBaixo == false){
								movimentoMonstroBaixo();
								movimentoNaMatrizMonstroBaixo();
								chatEvento.setText("tem em cima, fui p baixo");
							} else if(temBuracoBaixo = true && temBuracoCima == false){
								movimentoMonstroCima();
								movimentoNaMatrizMonstroCima();
								chatEvento.setText("n tem em cima, fui p cima");
							} else  {
								movimentoMonstroEsquerda();
								movimentoNaMatrizMonstroEsquerda();
							}

						} else if (yMonstro > yJogador && yMonstro > yJogador - 50 && temBuracoCima) {
							// movimentoMonstroCima();
							// movimentoNaMatrizMonstroCima();

							if (xMonstro < xJogador && xMonstro < xJogador - 50 && temBuracoDireita == false) {
								movimentoMonstroDireita();
								movimentoNaMatrizMonstroDireita();

							} else if (xMonstro > xJogador && xMonstro > xJogador - 50 && temBuracoEsquerda == false) {
								movimentoMonstroEsquerda();
								movimentoNaMatrizMonstroEsquerda();
							}else if(temBuracoEsquerda = true && temBuracoDireita == false){
								movimentoMonstroDireita();
								movimentoNaMatrizMonstroDireita();
							} else if(temBuracoDireita = true && temBuracoEsquerda == false){
								movimentoMonstroEsquerda();
								movimentoNaMatrizMonstroEsquerda();
							} else {
								movimentoMonstroBaixo();
								movimentoNaMatrizMonstroBaixo();
							}

						}

					}


				// andar jogador
				if (key == KeyEvent.VK_LEFT) {
					jogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jogadoresquerda.gif")));
					// IF PARA O JOGADOR NAO PASSAR DA PAREDE
					if (xJogador >= 91 + (77 * 1)) {
						movimentoJogadorEsquerda();
						movimentoNaMatrizJogadorEsquerda();
					} else {
						chatEvento.setText("Deu de cara na parede!");
					}
				}
				if (key == KeyEvent.VK_RIGHT) {
					jogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jogadordireita.gif")));
					// IF PARA O JOGADOR NAO PASSAR DA PAREDE
					if (xJogador <= (77 * 16)) {
						movimentoJogadorDireita();
						movimentoNaMatrizJogadorDireita();
					} else {
						chatEvento.setText("Deu de cara na parede!");
					}
				}

				if (key == KeyEvent.VK_UP) {
					jogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jogadorcima.gif")));
					// IF PARA O JOGADOR NAO PASSAR DA PAREDE
					if (yJogador >= 91) {
						movimentoJogadorCima();
						movimentoNaMatrizJogadorCima();

					} else {
						chatEvento.setText("Deu de cara na parede!");
					}
				}

				if (key == KeyEvent.VK_DOWN) {
					jogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jogadorbaixo.gif")));
					// IF PARA O JOGADOR NAO PASSAR DA PAREDE
					if (yJogador <= (70 * 8)) {
						movimentoJogadorBaixo();
						movimentoNaMatrizJogadorBaixo();

					} else {
						chatEvento.setText("Deu de cara na parede!");
					}
				}

				verificadorDeBuracosNaMatriz("jogador");
				//avisoDeBuracos();

				System.out.println("\n\n");
				imprimirLabirintoConsole();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyCode();
				// nada acontece
			}
		});

	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(jogoDoMonstro.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(jogoDoMonstro.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(jogoDoMonstro.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(jogoDoMonstro.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new jogoDoMonstro().setVisible(true);
			}
		});
	}

	private javax.swing.JLabel chatEvento;
	private javax.swing.JLabel b1;
	private javax.swing.JLabel b10;
	private javax.swing.JLabel b11;
	private javax.swing.JLabel b12;
	private javax.swing.JLabel b13;
	private javax.swing.JLabel b14;
	private javax.swing.JLabel b15;
	private javax.swing.JLabel b16;
	private javax.swing.JLabel b17;
	private javax.swing.JLabel b18;
	private javax.swing.JLabel b19;
	private javax.swing.JLabel b2;
	private javax.swing.JLabel b20;
	private javax.swing.JLabel b21;
	private javax.swing.JLabel b22;
	private javax.swing.JLabel b23;
	private javax.swing.JLabel b24;
	private javax.swing.JLabel b25;
	private javax.swing.JLabel b3;
	private javax.swing.JLabel b4;
	private javax.swing.JLabel b5;
	private javax.swing.JLabel b6;
	private javax.swing.JLabel b7;
	private javax.swing.JLabel b8;
	private javax.swing.JLabel b9;
	private javax.swing.JLabel fundo;
	private javax.swing.JLabel fundoChatEvent;
	private javax.swing.JLabel fundoItens;
	private javax.swing.JLabel item1;
	private javax.swing.JLabel item2;
	private javax.swing.JLabel item3;
	private javax.swing.JLabel jogador;
	private javax.swing.JLabel monstro;
	private javax.swing.JLabel tempo;
	private javax.swing.JLabel tempoShow;
	private javax.swing.JLabel vida1;
	private javax.swing.JLabel vida2;
	private javax.swing.JLabel vida3;
}
