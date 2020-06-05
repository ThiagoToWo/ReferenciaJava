package refer�ncia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// classe respons�vel por manipular os textos dos c�digos  
public class Codigo {
	// vari�vel que armazena o texto do cap�tulo
	private String texto;
	// ArrayList que armazenar� cada c�digo separado do cap�tulo
	private ArrayList<String> listing = new ArrayList<String>();
	// lista de nomes dos cap�tulos
	private String[] nomeChap = {"Chap2.lst", "Chap3.lst", "Chap4.lst", "Chap5.lst", "Chap6.lst", "Chap7.lst", "Chap8.lst", 
			"Chap9.lst", "Chap10.lst", "Chap11.lst", "Chap12.lst", "Chap13.lst", "Chap14.lst", "Chap15.lst", "Chap16.lst", "Chap17.lst", 
			"Chap18.lst", "Chap19.lst", "Chap20.lst", "Chap21.lst", "Chap22.lst", "Chap23.lst", "Chap24.lst", "Chap25.lst", "Chap26.lst", 
			"Chap27.lst", "Chap28.lst", "Chap29.lst", "Chap30.lst", "Chap31.lst", "Chap32.lst", "Chap33.lst", "Chap34.lst", "Chap35.lst", };
	// lista dos arquivos que comp�em os cap�tulos
	private File[] lst = new File[34];
	
	// � preciso construir a lista de arquivos atrav�s deste m�todo
	public void construirListaChap() {
		for (int i = 0; i < 34; i++) {
			lst[i] = new File("data",nomeChap[i]);
		}
	}
	// m�todo de acesso a lista de arquivos
	public File[] getListaChap() {
		return lst;
	}
	// m�todo de captura do texto dos c�digos
	public String getTexto() {
		return texto;
	}
	//configura o texto do c�digo copiando ele de um arquivo 
	public void setTexto(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linha = "";
			texto = linha;
			listing.clear();
			while ((linha = br.readLine()) != null) {
				texto += linha + "\n"; 				
			}
			separarCodigos(texto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// separa os c�digos de um determinado cap�tulo
	private void separarCodigos(String txt) {

		String[] list = texto.split("listing");
		for (String lst : list) {
			listing.add(lst);
		}

	}
	// acessa a lista de c�digos separedos de um cap�tulo
	public ArrayList<String> getListing() {
		return listing;
	}
}
