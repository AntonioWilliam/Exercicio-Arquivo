package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoDir implements Ifruit {

	@Override
	public void leDiretorio(String path) throws IOException {
		File dir = new File (path);
		if (dir.exists() && dir.isDirectory()) {
			File[] lista = dir.listFiles(); //
			for (File f: lista) {
				if (f.isDirectory()) {
					System.out.println("["+f.getName()+"]");
				}
			}
			for (File f : lista) {
				if (f.isFile()) {
					System.out.println(f.getName());
				}
			}
		}else {
			throw new IOException("Diretorio inválido");
		}
		
	}

	@Override
	public void leArquivo(String absolutePath) throws IOException {
		 File arquivo = new File(absolutePath);
		 if (arquivo.exists()) {
			 FileInputStream fluxo = 
					 new FileInputStream(arquivo);
			 InputStreamReader leitor =
					 new InputStreamReader(fluxo);
			 BufferedReader buffer = 
					 new BufferedReader(leitor);
			 String linha = buffer.readLine();
			 while (linha != null) {
				 String vet[] = linha.trim().split(",");
					if (vet[2].equals("Fruits")) {
						System.out.printf("| %-30s | %-50s | %-20s |", vet[0], vet[1], vet[3]);
						System.out.println();
					}
				 linha = buffer.readLine();
			 }
			 buffer.close();
			 leitor.close();
			 fluxo.close();
		 }else {
			 throw new IOException("Arquivo inválido");
		 }
	}

}
