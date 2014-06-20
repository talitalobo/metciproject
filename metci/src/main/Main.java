package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

	public static void main(String[] args) {
		type_dict = args[0];
		path_datas = args[1];
		path_queries = args[2];

		if (type_dict.toLowerCase().equals(LIST_MAP)) {
			AbstractMap mapList = new MapWithList();
			carregarDados(path_datas, mapList);
			fazerConsultas(path_queries, mapList);
		} else if (type_dict.toLowerCase().equals(TREE_MAP)) {
			AbstractMap mapTree = new MapWithTreeMap();
			carregarDados(path_datas, mapTree);
			fazerConsultas(path_queries, mapTree);
		} else if (type_dict.toLowerCase().equals(HASH_MAP)) {
			AbstractMap mapHash = new MapWithHashTable();
			carregarDados(path_datas, mapHash);
			fazerConsultas(path_queries, mapHash);
		} else {
			System.out.println("Tipos de dicionarios: lista, tree ou hash");
		}
	}

	private static void carregarDados(String path_datas, AbstractMap map) {

		try {
			BufferedReader in = new BufferedReader(new FileReader(path_datas));
			String str;
			while (in.ready()) {
				str = in.readLine();
				map.insert(str.trim().toLowerCase());
			}
			in.close();
		} catch (IOException e) {
			System.out
					.println("Algo errado com o endereco do dados a serem carregados");
		} catch (Exception e) {

		}
	}

	private static String fazerConsultas(String path_queries, AbstractMap map) {
		String result = "";
		return result;

	}

}
