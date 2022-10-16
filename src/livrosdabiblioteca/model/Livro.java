package livrosdabiblioteca.model;

public class Livro {
    private Integer codigo;
    private String titulo;
    private String autor;

    public Livro(){}

    public Livro(int codigo,String titulo,String autor){
        super();
        this.codigo=codigo;
        this.titulo=titulo;
        this.autor=autor;
    }

    //getters & setters
    public Integer getCodigo(){
        return codigo;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setCodigo(int codigo){
        this.codigo=codigo;
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public void setAutor(String autor){
        this.autor=autor;
    }

    @Override
    public String toString(){
        return this.codigo+" "+this.titulo+" "+this.autor;
    }
}
