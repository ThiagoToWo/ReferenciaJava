package referência;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// classe rresponsável por administrar o índice da referência
public class Indice {
	//ArrayList de strings onde entrarão os tópicos do índice
	private ArrayList<String> topicos = new ArrayList<String>();
	// configura os tópicos no índice copiando eles de um arquivo e adiciona eles no ArrayList
	public void setTopicos(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linha = null;
			while ((linha = br.readLine()) != null) {
				topicos.add(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// transforma o ArrayList em um array de strings para serem usados no JComboBox ou JList
	public String[] getTopicos() {
		String[] top =  new String[topicos.size()];
		top = topicos.toArray(top);
		return top;
	}
}
