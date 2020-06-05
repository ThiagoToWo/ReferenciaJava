package refer�ncia;

import java.io.File;

public class Principal {

	public static void main(String[] args) {
		// cria um objeto GUI
		GUI gui = new GUI();
		// cria um objeto Indice
		Indice ind = new Indice();
		// l� um arquivo de texto e cria os t�picos do �ndice		
		ind.setTopicos(new File("data", "�ndice.txt"));	
		// coloca os t�picos no �ndice da Gui 
		gui.setIndice(ind.getTopicos());
		// constr�i a janela pronta
		gui.construir();		
	}
}
