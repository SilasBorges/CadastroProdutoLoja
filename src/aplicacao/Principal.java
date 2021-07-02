package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> lista = new ArrayList<>();
		
		System.out.print("Entre com o numero de produtos: ");
		int num = sc.nextInt();
		
		for(int i=1; i <= num; i++) {
			
			System.out.println("Dados do produto #" + i);
			System.out.print("Comum, usado ou importado(c/u/i)? ");
			char descricao = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			
			if(descricao == 'c') {
				
				lista.add(new Produto(nome, preco));
				
			}
			else if(descricao == 'u') {
				
				System.out.print("Data de fabricação: ");
				Date data = sdf.parse(sc.next());
				
				lista.add(new ProdutoUsado(nome, preco, data));
				
			}
			else if(descricao == 'i') {
				
				System.out.print("Taxa da alfandega: ");
				double taxaAlfandega = sc.nextDouble();
				
				lista.add(new ProdutoImportado(nome, preco, taxaAlfandega));
				
			}else {
				System.out.println("Produto Invalido!!");
			}

		}
		
		System.out.println();
		System.out.println("Etiqueta de produto:");
		
		for(Produto c : lista) {
			
			System.out.println(c.etiquetaPreco());
			
		}
		
	}

}
