package livrosdabiblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

/**
 * Pequeno exemplo para revisão do framework Collections de uma biblioteca
 *  para futuras implementações olhar no arquivo original dentro da pasta estruturaDeDados
 * 	! substituir buscar por ordenar !
 */

//TODO implementar busca nos métodos
public class Biblioteca{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		List<Livro> livros=new ArrayList<>();
		Livro novoLivro=new Livro();
		
		int opcao=Integer.parseInt(escolheOpcaoMenu(sc));
		
		while(opcao!=0){
		
		//System.out.println(" ENTROU NO WHILE ");
		//System.out.println("--OPCAO: "+opcao);
		switch(opcao){
			case 1:
				adicionarLivro(sc,livros,new Livro());
				break;
			case 2:
				mostraTodos(livros);
				break;
			case 3:
				System.out.print("Digite o titulo do livro a ser pesquisado: ");
				String titulo="";
				
				System.out.println(buscaPorTitulo(leDados(sc,titulo),livros));
				break;
			case 4:
				System.out.print("Digite o autor do livro a ser pesquisado: ");
				String autor="";
				
				System.out.println(buscaPorAutor(leDados(sc,autor),livros));
				break;
			case 5:
				System.out.print("Digite o codigo do livro a ser pesquisado: ");
				int codigo=0;
				
				System.out.println(buscaPorCodigo(leInteiro(sc),livros));
				break;
			case 6:
				System.out.println("Digite o titulo do livro a ser removido");
				String title="";
				title=leDados(sc,title);
				removePorTitulo(title,livros);
				break;
			case 7:
				String resp="n";
				System.out.println("Deseja realmente excluir todos os livros? s/n");
				resp=leDados(sc,resp);
				if(resp.equalsIgnoreCase("s")){
					limpar(livros);
				}
				break;
			default:
				System.out.println("Opcao Invalida, digite novamente.");
				break;
		}
		opcao=Integer.parseInt(escolheOpcaoMenu(sc));
		}
	}
	
	public static String escolheOpcaoMenu(Scanner sc){
		String opcao="";
		System.out.println("Digite um numero para a opcao ou 0 para sair:");
		System.out.println("1-Adicionar novo livro");
		System.out.println("2-Mostrar todos os livros");
		System.out.println("3-Pesquisa pelo titulo");
		System.out.println("4-Pesquisa pelo autor");
		System.out.println("5-Pesquisa pelo codigo");
		System.out.println("6-Remover livro pelo titulo");
		System.out.println("7-Excluir todos os livros");
		System.out.println("0-Sair");
		System.out.printf("\n");
		
		try{
			opcao=leDados(sc,opcao);
			int op=Integer.parseInt(opcao);
			
			if(op<0 || op>7){//opcao invalida caso seja negativa ou maior do que as 7 opcoes
				throw new Exception();
			}
		
		}catch(Exception e){
			System.out.println("Entrada invalida, tente novamente");
		}
		return opcao;
	}
	
	public static int leInteiro(Scanner sc){
		sc=new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static String leDados(Scanner sc, String dado){
		sc=new Scanner(System.in);
		dado=sc.nextLine();
		//System.out.println("DADO: "+dado);
		return dado;
	}
	
	public static void adicionarLivro(Scanner sc,List<Livro> livros,Livro novoLivro){
		System.out.print("Digite o codigo do livro: ");
		novoLivro.setCodigo(leInteiro(sc));
		System.out.print("Digite o titulo: ");
		novoLivro.setTitulo(leDados(sc,novoLivro.getTitulo()));
		System.out.print("Digite o autor: ");
		novoLivro.setAutor(leDados(sc,novoLivro.getAutor()));
		
		livros.add(novoLivro);
	}
	
	public static void mostraTodos(List<Livro> livros){
		System.out.println("-----------LIVROS DA BIBLIOTECA------------");
		System.out.println(livros);
		System.out.println();
		System.out.println();
	}

	/**
	 * ordena por titulo
	 * @param titulo
	 * @param livros
	 * @return
	 */
	public static List<Livro> buscaPorTitulo(String titulo, List<Livro> livros){
		String elemento="";
		Comparator<Livro> comparator =new Comparator<Livro>(){
			@Override
			public int compare(Livro livro1, Livro livro2){
				return livro1.getTitulo().compareToIgnoreCase(livro2.getTitulo());
			}
		};
		livros.sort(comparator);

		//TODO implementar busca

		//int indice = Collections.binarySearch(livros,new Livro(344,titulo,"Jacobim"));
		
//		try{
//			//caso o indice=-1 ou seja, esteja fora dos elementos do arraylist
//			//titulo=(Livro) titulo;
//			System.out.println("  -- "+livros.contains(objeto));
//			elemento=livros.get(livros.indexOf(titulo)).toString();
//		}catch(IndexOutOfBoundsException ie){
//			System.out.println("Nenhum resultado foi encontrado");
//		}
		return livros;
	}
	
	public static String buscaPorAutor(String autor, List<Livro> livros){//TODO APRENDER MAIS TARDE
		return "";
	}
	
	public static int buscaPorCodigo(int codigo,List<Livro> livros){//TODO APRENDER MAIS TARDE
		return 0;
	}
	
	public static void removePorTitulo(String titulo,List<Livro> livros){//TODO APRENDER MAIS TARDE
		if(livros.remove(titulo))
			System.out.println("Livro removido com sucesso");
		else
			System.out.println("Livro nao encontrado");
	}
	
	public static void limpar(List<Livro> livros){
			livros.clear();
			System.out.println("Removendo todos os livros do sistema");
	}
}
