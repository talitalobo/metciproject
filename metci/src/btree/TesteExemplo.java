package btree;

public class TesteExemplo {
	public static void main(String[] args) {

		BTree b = new BTreeImpl(2);
//		System.out.println("insere 10");
		System.out.println(b.inserir(10));
		System.out.println(b.buscar(10));

//		System.out.println("\n insere 14");

		System.out.println(b.inserir(14));
		System.out.println(b.buscar(14));

		System.out.println(b.getQuantidadePercorridos(14));
//		System.out.println("\n insere 20");

		System.out.println(b.inserir(20));
//		System.out.println("\n insere 30");

		System.out.println(b.inserir(30));
		System.out.println(b.buscar(30));
		System.out.println(b.getQuantidadePercorridos(30));
		
		
		System.out.println("\n insere 25");

		b.inserir(25);
		System.out.println("\n insere 15");

		b.inserir(15);
		System.out.println("\n insere 19");

		b.inserir(19);
		
		System.out.println("\n insere 26");
		b.inserir(26);
		System.out.println("\n insere 28");
		b.inserir(28);
		
		System.out.println("\n insere 35");
		b.inserir(35);

		System.out.println("\n insere 40");
		b.inserir(40);
		
		System.out.println("\n insere 21");
		b.inserir(21);
		
		System.out.println("\n insere 23");
		b.inserir(23);
		
		System.out.println("\n insere 22");
		b.inserir(22);
		
		System.out.println("\n insere 24");
		b.inserir(24);
		System.out.println("\n insere 42");
		b.inserir(42);
		
	}
}