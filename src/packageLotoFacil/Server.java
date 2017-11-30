package packageLotoFacil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
//        verificaBolasQueMaisSairamNaSuaPosicao(ConstantsGame.numero01,
//        									   ConstantsGame.numero02,
//        									   null,
//        									   null,
//        									   null,
//        									   null,
//        									   null,        									   
//        									   null,
//        									   null,
//        									   null);
		
//		organizarArquivos();
//		String valor = "5";
//		int valorint;
		
				
//		valorint = Integer.parseInt(valor.trim());
//		valorint++;
		
//		System.out.println(valorint);
		
		
//		verificaJogosDuplicados("01,02,04,06,08,10,11,13,14,15,16,19,20,22,23");;
//		verificaJogosDuplicados("01,03,04,05,07,09,10,13,15,17,18,19,21,24,25");;
//		
//		verificaJogosDuplicados("01,02,07,09,11,12,14,15,16,17,19,21,22,24,25");;
//		verificaJogosDuplicados("01,02,05,09,11,12,14,15,16,17,19,21,22,24,25");;
//		
//		verificaJogosDuplicados("01,02,03,04,05,07,10,11,13,17,18,19,20,21,25");;
//		verificaJogosDuplicados("01,02,08,09,10,12,13,14,17,18,19,22,23,24,25");;
//		
//		verificaJogosDuplicados("01,02,03,05,06,07,08,11,15,16,17,18,20,21,23");;
//		verificaJogosDuplicados("01,02,03,05,06,11,12,13,15,16,19,20,21,23,25");;
//		
//		verificaJogosDuplicados("01,02,03,04,08,09,10,11,12,14,16,17,19,21,23");;
//verificaJogosDuplicados("01,03,04,06,08,09,10,11,12,14,16,17,19,21,23");;

		
		int i = 0;
		
		for (i = 0; i < 100; i++) {
			if (i % 19 == 0 && i != 0) {
			System.out.println("Achei um número divisível por 19 entre x e y " + i);
			break; 
			}
			} 
		System.out.println(i);
	
	
	
	}
	
	public static boolean organizarArquivos(){
		try {
		ArrayList<String> games = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		FileReader fileReader = new FileReader("lotofacilArch.txt");
		BufferedReader br = new BufferedReader(fileReader);  
		
		
		 while(br.ready()){  
		   String linha = br.readLine();  
//		   System.out.println(linha);
		   games.add(linha);
		
		 }
		 br.close();
		 File arquivo2 = new File("LotoFacilOrdemCrescente.txt");
		 arquivo2.createNewFile();
		 
		 FileWriter fileW = new FileWriter (arquivo2);
		 BufferedWriter buffW = new BufferedWriter (fileW);  
		 System.out.println("Lendo Arquivo");
		 String[] x;
		 int s = 0;
		 for (Object object : games) {
			 x = object.toString().split(",");
			 Arrays.sort(x);
			 String o = "";
			 if(s%100 == 0){
				 System.out.println( s + " arquivos lidos");
			 }
			 for (int i = 0; i < x.length; i++) {
				if (o.equals("")){
					o = o + x[i].toString();
				}else{
					o =  o + "," + x[i].toString();
				}
			}
			 result.add(o);
			s++; 
		}
		 for (Object y : result) {
			 buffW.write(y.toString());
			 buffW.newLine();
		}
		 buffW.close();
		 return true;
		 
		 
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}


	
	/**
	 *  exemplo de implementação: verificaJogosDuplicados("02,03,05,06,09,10,12,13,15,17,18,21,22,24,25");
	 * @param pValor
	 */
	public static void verificaJogosDuplicados(String pValor){
		
		try {
			ArrayList<String> games = lerJogos();
			int l = 0;
				for (Object object : games) {
					if(pValor.toString().equals(object.toString())){
						l++;
					}
				}
				if(l==1){
					System.out.println("Esse jogo " +pValor+ "'   Já saiu na LotoFácil.");
				}else{
					System.out.println("Esse jogo nunca foi jogado na LotoFácil.");
				}
					
			
		} catch (Exception e) {
		}
		
	}
	
	
	public static ArrayList<String> lerJogos(){
		ArrayList<String> games = null;

		
		try {
		FileReader fileReader = new FileReader("LotoFacilOrdemCrescente.txt");
		BufferedReader br = new BufferedReader(fileReader);
		games = new ArrayList<String>();
		String linha;
		while(br.ready()){  
			   linha = br.readLine();
			   games.add(linha.toString());
		}
		br.close();
		return games;
		} catch (Exception e) {
		}
		return games;
	}
		
	
	public static void verificaONumeroQueMaisSaiu(String pNumero){
	
		ArrayList<String> games = lerJogos();
		String[] x;
		int count = 0;

		if(Integer.parseInt(pNumero) < 10){
			pNumero = "0"+ pNumero;
		}
		
		for (Object object : games) {
			x = object.toString().split(",");
			for (int i = 0; i < x.length; i++) {
				if(x[i].equals(pNumero)){
					count++;		
				}
			}
		}
		System.out.println("Bola " + pNumero + " saiu :" + count + " vezes.");
	}
	
	
	public static void verificaBolasQueMaisSairamNaSuaPosicao(String pN1, String pN2, String pN3, String pN4, String pN5, String pN6, String pN7, String pN8, String pN9, String pN10){
		ArrayList<String> games = lerJogos();
		String[] x;
		int count = 0;
		
		boolean n = false;
		
		for (Object object : games) {
			x = object.toString().split(",");

			if(pN1 != null){
				for (int i = 0; i < x.length; i++) {
					if (x[i].toString().equals(pN1)){
						n = true;
						break;
					}else{
						n = false;
					}
				}
				if(n & pN2 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN2)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n & pN3 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN3)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n & pN4 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN4)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n & pN5 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN5)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n & pN6 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN6)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n & pN7 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN7)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n & pN8 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN8)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n & pN9 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN9)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n & pN10 != null){
					for (int i = 0; i < x.length; i++) {
						if (x[i].toString().equals(pN10)){
							n = true;
							break;
						}else{
							n = false;
						}
					}	
				}
				if(n){
					count++;					
				}
			}
			
		}			
		
		pN1 = pN1 != null ? pN1 : "";
		pN2 = pN2 != null ? "," + pN2 : "";
		pN3 = pN3 != null ? "," + pN3 : "";
		pN4 = pN4 != null ? "," + pN4 : "";
		pN5 = pN5 != null ? "," + pN5 : "";
		pN6 = pN6 != null ? "," + pN6 : "";
		pN7 = pN7 != null ? "," + pN7 : "";
		pN8 = pN8 != null ? "," + pN8 : "";
		pN9 = pN9 != null ? "," + pN9 : "";
		pN10 = pN10 != null ? "," + pN10 : "";
		System.out.println("Numeros " + pN1 + pN2 + pN3 + pN4 + pN5 + ": " + count);
	}
	
}
	
