package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivoDir;


public class Principal {
public static void main(String[] args) {
	String path = "C:\\TEMP";
	String absolutePath = "C:\\TEMP\\generic_food.csv"; 
	
	ArquivoDir arq = new ArquivoDir();
	try {
		arq.leDiretorio(path);
		arq.leArquivo(absolutePath);
	} catch (IOException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
	}
	
}
}
