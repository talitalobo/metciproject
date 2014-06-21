package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import estruturas.AbstractMap;
import estruturas.MapWithHashTable;
import estruturas.MapWithList;
import estruturas.MapWithTreeMap;

public class Main {
	private static String type_dict;
	private static String path_datas;
	private static String path_queries;
	private static final String LIST_MAP = "lista";
	private static final String TREE_MAP = "tree";
	private static final String HASH_MAP = "hash";
	private static long tempoCarga;
	private static long tempoConsulta;
	private static String nomeArquivo;
	private static PrintWriter saida;
	
	
	public static void main(String[] args) throws FileNotFoundException {		
		
		saida = new PrintWriter(nomeArquivo);
		
		type_dict = args[0];
		path_datas = args[1];
		path_queries = args[2];
		List<String> database = readData(path_datas);
		List<String> queries = readData(path_queries);
		AbstractMap map = null;
		
		if (type_dict.toLowerCase().equals(LIST_MAP)) {
			map = new MapWithList();
		} else if (type_dict.toLowerCase().equals(TREE_MAP)) {
			map = new MapWithTreeMap();
		} else if (type_dict.toLowerCase().equals(HASH_MAP)) {
			map = new MapWithHashTable();
		} else {
			System.out.println("Tipos de dicionarios: lista, tree ou hash");
		}
		
		long antes, dps, ants, depois;
		if( map != null){
			antes = System.currentTimeMillis();
			carregarDados(database, map);
			dps = System.currentTimeMillis();
			
			ants = System.currentTimeMillis();
			System.out.println(fazerConsultas(queries, map));
			
			saida.println(fazerConsultas(queries, map));
			
			depois = System.currentTimeMillis();
			System.out.print("tempo_de_carga : ");
			System.out.println(dps - antes);
			tempoCarga = dps - antes;
			System.out.print("tempo_da_consulta : ");
			System.out.print(depois - ants);	
			tempoConsulta = depois - ants;
			
			saida.println("Tempo de Carga: " + tempoCarga + "\n");
			saida.println("Tempo de Consulta: " + tempoConsulta + "\n");
		}
		
		// long max = Runtime.getRuntime().maxMemory();
		// long free = Runtime.getRuntime().freeMemory();
		//saida.println("Consumo de Memória: " + tempoConsulta + "\n");
	}
	
	private static List<String> readData(String path) {
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String str;
			while (in.ready()) {
				str = in.readLine();
				list.add(str.trim().toLowerCase());
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Algo errado com o endereco do dados a serem carregados");
		} catch (Exception e) {
		}
		
		return list;
	}

	private static void carregarDados(List<String> database, AbstractMap map) {
		try{
			for (String data : database) {
				map.insert(data.trim().toLowerCase());
			}
		} catch (Exception e) {
			System.out.println("Algo errado");
		} 
	}

	private static String fazerConsultas(List<String> queries, AbstractMap map) throws FileNotFoundException {
		
		String result = "";
		try{
			for (String query : queries) {
				result += map.exists(query.trim().toLowerCase())? query + ": S\n": query + ": N\n";
			}
		}catch (Exception e) {
            System.out.println("Algo errado com as queries");
		}
		return result;
	}
}
