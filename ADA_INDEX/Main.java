import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        Lista lista = new Lista();

        for(int i = 0;i<n; i++) {
            lista.insereInicioLista(scanner.next());
        }

        for(int j=0;j<q;j++){
           String teste = scanner.next();
           int ocorr = lista.verificarPrefixo(teste);
            System.out.println(ocorr);

        }

    }
}

class No {

    private String conteudo;
    private No proximo;

    public No(){
        proximo = null;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
class Lista {

    private No cabeca;
    private int tamanho;

    public Lista(){

        cabeca = null;
        tamanho = 0;

    }

    // Definição das Operacoes

    /** Verifica se a Lista está vazia */
    public boolean vazia(){

        if(tamanho==0){
            return true;
        }else{
            return false;
        }
    }

    /** Obtem o tamanho da lista */
    public int tamanho(){
        return tamanho;
    }

    /** Obtem o i-ésimo elemento de uma Lista.
     Retorna o valor encontrado. */
    public String elemento(int pos){
        No aux = cabeca;
        int i = 1;

        if( vazia() || ( pos < 1 ) || ( pos > tamanho ) ) return  "false"; //consulta falhou ou posicao invalida

        // Percorre a lista do 1º até o elemento pos
        while (i < pos){
            aux = aux.getProximo();
            i++;
        }

        return aux.getConteudo();
    }

    /** Retorna a posição do elemento pesquisado.
     Retorna -1 caso não encontrado */
    public int posicao(String dado){

        if(vazia()) return 0;

        int i = 0;
        No aux = cabeca;

        while (aux != null){
            if(aux.getConteudo().equals(dado)){
                return i;
            }
            aux = aux.getProximo();
            i++;
        }
        aux = null;
        return -1;
    }

    /** Insere um elemento em uma determinada posição.
     Retorna true se conseguir
     e falso caso contrário. */
    public boolean insere(int pos, String dado){

        if(vazia() && pos !=1 ) return false;

        if(pos == 1){ //insere no inicio da lista
            return insereInicioLista(dado);

        }else if(pos == tamanho+1){ //insere no fim da lista
            return insereFimLista(dado);

        }else{ //insere no meio da lista
            return insereMeioLista(pos,dado);

        }
    }

    public boolean insereInicioLista(String dado){

        //aloca memoria para novo nó e atribui dado a seu conteudo
        No novoNo = new No();
        novoNo.setConteudo(dado);

        //insere na cabeça da lista
        novoNo.setProximo(cabeca);
        cabeca = novoNo;
        tamanho++;

        return true;
    }

    public boolean insereFimLista(String dado){

        //aloca memoria para novo nó e atribui dado a seu conteudo
        No novoNo = new No();
        novoNo.setConteudo(dado);

        //percorre ate o fimlista
        No aux = cabeca;
        int i = 1;

        while (aux.getProximo() != null){
            aux = aux.getProximo();

        }

        //insere no fim da lista
        aux.setProximo(novoNo);
        tamanho++;
        novoNo.setProximo(null);

        aux = null;
        return true;
    }

    public boolean insereMeioLista(int pos, String dado){

        //aloca memoria para novo nó e atribui dado a seu conteudo
        No novoNo = new No();
        novoNo.setConteudo(dado);

        //percorre ate a posicao
        No aux = cabeca;
        int i = 1;
        while ( (i < pos-1) && ( aux != null ) ){
            aux = aux.getProximo();
            i++;
        }

        if (aux == null) return false;

        //insere no meio da lista
        novoNo.setProximo(aux.getProximo());
        aux.setProximo(novoNo);
        tamanho++;

        aux = null;
        return true;
    }


    /**Remove um elemento de uma determinada posição
     Retorna o valor a ser removido.
     -1 se a posição for inválida ou a lista vazia */
    public String remove(int pos){

        if(vazia()) return "erro";

        //remoção na cabeça da lista;
        if(pos == 1){
            return removeInicioLista();

        }else{
            return removeNaLista(pos);

        }


    }

    private String removeInicioLista() {

        String dado = cabeca.getConteudo();
        No aux = new No();
        aux.setProximo(cabeca.getProximo());

        cabeca = null;
        tamanho--;

        return dado;

    }

    private String removeNaLista(int pos){

        No ant = new No();
        No atual = new No();
        int i=1;
        String dado = "";

        atual = cabeca;
        while( (i < pos-1) && (atual != null) ){
            ant = atual;
            atual = atual.getProximo();
            i++;
        }

        if(atual == null) return  "erro";

        //remove elemento da lista
        dado = atual.getConteudo();
        ant.setProximo(atual.getProximo());
        tamanho--;

        atual = null;

        return dado;
    }
    public int verificarPrefixo(String prefixo){

        //percorre ate o fimlista
        No aux = cabeca;
        int ocorrencias = 0;

        while( aux != null){
            if(aux.getConteudo().indexOf(prefixo)==0){
                ocorrencias++;
            }
            aux = aux.getProximo();
        }

        return ocorrencias;
    }

}


