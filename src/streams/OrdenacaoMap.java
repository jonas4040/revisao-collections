package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class OrdenacaoMap {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Map<String, Livro> meusLivros = new HashMap<>() {{ //chave=nomeAutor valor=numPaginas
            put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem Inserção\t--");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {{
            put(" Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put(" Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put(" Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem alfabética autores\t--");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem alfabética nomes dos livros\t--");

        //TODO por Comparator
        /*Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new Comparator<Map.Entry<String, Livro>>() {
            @Override
            public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
                return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
            }
        });*/

        //TODO por Functional Interface
        /*Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<String,Livro>,String>(){

            @Override
            public String apply(Map.Entry<String, Livro> livro) {
                return livro.getValue().getNome();
            }
        }));*/

        //TODO por lambda
        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(Comparator.comparing(
                livro -> livro.getValue().getNome()
        ));
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros3)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        //TODO voltar aqui depois
        System.out.println("--\tOrdem número de página (decrescente)\t--");
        /*Stream<Map.Entry<String, Livro>> sortedByNumPaginas = meusLivros1.entrySet().stream().sorted(
                new Comparator<Map.Entry<String, Livro>>() {
                    @Override
                    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
                        Integer numPagLivro1=livro1.getValue().getPaginas();
                        Integer numPagLivro2=livro2.getValue().getPaginas();
                        return numPagLivro2 > numPagLivro1 ? numPagLivro2 : numPagLivro1;
                    }
                }
        );
        Iterator<Map.Entry<String, Livro>> it = sortedByNumPaginas.iterator();
        while(it.hasNext())
            System.out.println(it.next().getKey()+ " - " + it.next().getValue());*/

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}