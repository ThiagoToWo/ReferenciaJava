package referência;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// classe responsável por manipular os textos dos códigos  
public class Codigo {
	// variável que armazena o texto do capítulo
	private String texto;
	// ArrayList que armazenará cada código separado do capítulo
	private ArrayList<String> listing = new ArrayList<String>();
	// lista de nomes dos capítulos
	private String[] nomeChap = {"Chap2.lst", "Chap3.lst", "Chap4.lst", "Chap5.lst", "Chap6.lst", "Chap7.lst", "Chap8.lst", 
			"Chap9.lst", "Chap10.lst", "Chap11.lst", "Chap12.lst", "Chap13.lst", "Chap14.lst", "Chap15.lst", "Chap16.lst", "Chap17.lst", 
			"Chap18.lst", "Chap19.lst", "Chap20.lst", "Chap21.lst", "Chap22.lst", "Chap23.lst", "Chap24.lst", "Chap25.lst", "Chap26.lst", 
			"Chap27.lst", "Chap28.lst", "Chap29.lst", "Chap30.lst", "Chap31.lst", "Chap32.lst", "Chap33.lst", "Chap34.lst", "Chap35.lst", };
	// lista dos arquivos que compõem os capítulos
	private File[] lst = new File[34];
	
	// é preciso construir a lista de arquivos através deste método
	public void construirListaChap() {
		for (int i = 0; i < 34; i++) {
			lst[i] = new File("data",nomeChap[i]);
		}
	}
	// método de acesso a lista de arquivos
	public File[] getListaChap() {
		return lst;
	}
	// método de captura do texto dos códigos
	public String getTexto() {
		return texto;
	}
	//configura o texto do código copiando ele de um arquivo 
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
	// separa os códigos de um determinado capítulo
	private void separarCodigos(String txt) {

		String[] list = texto.split("listing");
		for (String lst : list) {
			listing.add(lst);
		}

	}
	// acessa a lista de códigos separedos de um capítulo
	public ArrayList<String> getListing() {
		return listing;
	}
}
