package refer�ncia;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// classe respons�vel pela janela do aplicativo
public class GUI {
	private JFrame frame;
	private JComboBox<String> indice;
	private JTextArea textoCodigo = new JTextArea(20, 10);
	private Codigo cdg = new Codigo();
	private int numeroListing = 1;
	// constr�i a janela do aplicativo
	public void construir() {
		frame = new JFrame("Refer�ncia Completa Java");	
		// cria e configura barra de menu
		JMenuBar barraDeMenu = new JMenuBar();
		JMenu menuSobre = new JMenu("Informa��es");
		JMenuItem autoria = new JMenuItem("Autor");
		autoria.addActionListener(new AutorListener());
		JMenuItem versao = new JMenuItem("Sobre o aplicativo");
		versao.addActionListener(new VersaoListener());
		menuSobre.add(autoria);
		menuSobre.add(versao);
		barraDeMenu.add(menuSobre);
		frame.setJMenuBar(barraDeMenu);		
		// usa o m�todo de Codigo para contruir a lista de arquivos
		cdg.construirListaChap();
		// cria fonte vis�vel para o c�digo na �rea de texto
		Font fonteDoCodigo = new Font("Consolas", Font.BOLD, 17);
		// configura �rea de texto
		JPanel background = new JPanel();
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		textoCodigo.setLineWrap(true);
		textoCodigo.setEditable(false);	
		textoCodigo.setFont(fonteDoCodigo);
		//configura o �ndice
		indice.setFont(fonteDoCodigo);
		indice.addItemListener(new ItemListener() {
			// passa o texto do item selecionado da lista de arquivos para o c�digo e depois joga na �rea de texto
			@Override
			public void itemStateChanged(ItemEvent e) {

				int capitulo = indice.getSelectedIndex();
				cdg.setTexto(cdg.getListaChap()[capitulo - 1]);
				textoCodigo.setText(cdg.getListing().get(1));
				textoCodigo.moveCaretPosition(0);
			}
		});
		// cria configura e adiciona a barra de rolagem da �rea de texto ao painel de fundo
		JScrollPane barraDeRolagem = new JScrollPane(textoCodigo);
		barraDeRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		background.add(barraDeRolagem);
		// cria os bot�es de mudan�a de c�digo
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new FlowLayout());
		JButton botaoUltimo = new JButton(">>|");
		botaoUltimo.setFont(fonteDoCodigo);
		botaoUltimo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				numeroListing = cdg.getListing().size() - 1;
				textoCodigo.setText(cdg.getListing().get(numeroListing));
				textoCodigo.moveCaretPosition(0);

			}
		});
		JButton botaoAvan�ar = new JButton(">>");
		botaoAvan�ar.setFont(fonteDoCodigo);
		botaoAvan�ar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (numeroListing < cdg.getListing().size() - 1) {
					numeroListing++;
					textoCodigo.setText(cdg.getListing().get(numeroListing));
					textoCodigo.moveCaretPosition(0);
				} else {					
					numeroListing = cdg.getListing().size() - 1;
				}
			}
		});
		JButton botaoRecuar = new JButton("<<");
		botaoRecuar.setFont(fonteDoCodigo);
		botaoRecuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (numeroListing > 1) {
					numeroListing--;
					textoCodigo.setText(cdg.getListing().get(numeroListing));
					textoCodigo.moveCaretPosition(0);
				}  else {					
					numeroListing = 1;
				}
			}
		});
		JButton botaoPrimeiro = new JButton("|<<");
		botaoPrimeiro.setFont(fonteDoCodigo);
		botaoPrimeiro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				numeroListing = 1;
				textoCodigo.setText(cdg.getListing().get(numeroListing));
				textoCodigo.moveCaretPosition(0);

			}
		});
		painelBotoes.add(botaoPrimeiro);
		painelBotoes.add(botaoRecuar);
		painelBotoes.add(botaoAvan�ar);
		painelBotoes.add(botaoUltimo);
		//adiciona os componentes no frame		
		frame.getContentPane().add(BorderLayout.NORTH,indice);
		frame.add(background);
		frame.getContentPane().add(BorderLayout.SOUTH, painelBotoes);
		// configura o frame
		frame.setSize(800, 1000);
		frame.setLocation(600, 20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	// cria o �ndice da janela colocando ele em um JComboBox ou JLst
	public void setIndice(String[] topicos) {
		indice = new JComboBox<String>(topicos);
	}
	
	public class AutorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			JOptionPane.showMessageDialog(null, "Autor: Thiago de Oliveira Alves\ntowo497@gmail.com", "Sobre mim", JOptionPane.INFORMATION_MESSAGE);

		}

	}
	
	public class VersaoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Vers�o: 1.0 \n 08-04-2020\n\n" +
					"Cole��o de c�digos do livro\nJava: The Complete Reference, Eleventh Edition\r\n" +
					"Authors: Herbert Schildt\r\n" + 
					"Published: November 21st 2018\r\n" + 
					"Edition: 11\r\n" + 
					"ISBN: 9781260440232\r\n",					
					"Sobre este", JOptionPane.INFORMATION_MESSAGE);

		}

	}	
	
}
