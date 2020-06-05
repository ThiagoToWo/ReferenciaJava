package referência;

import java.io.File;

public class Principal {

	public static void main(String[] args) {
		// cria um objeto GUI
		GUI gui = new GUI();
		// cria um objeto Indice
		Indice ind = new Indice();
		// lê um arquivo de texto e cria os tópicos do índice		
		ind.setTopicos(new File("data", "Índice.txt"));	
		// coloca os tópicos no índice da Gui 
		gui.setIndice(ind.getTopicos());
		// constrói a janela pronta
		gui.construir();		
	}
}
