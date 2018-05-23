package yurifelix;

import java.util.Scanner;

class Main {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testes = Integer.parseInt(scanner.nextLine());

        while (testes-->0){
            char[] entrada = scanner.nextLine().toCharArray();

            ArvBin arvBin = new ArvBin(entrada);
            int saida = arvBin.tamanho(arvBin.raiz);
            System.out.println(saida);


        }

    }


    public static class No {
        private int conteudo;
        private No esq;
        private No dir;

        public No() {
            esq = null;
            dir = null;
        }

        public int getConteudo() {
            return conteudo;
        }

        public void setConteudo(int conteudo) {
            this.conteudo = conteudo;
        }

        public No getEsq() {
            return esq;
        }

        public void setEsq(No esq) {
            this.esq = esq;
        }

        public No getDir() {
            return dir;
        }

        public void setDir(No dir) {
            this.dir = dir;
        }
    }

    public static class ArvBin{

        private No raiz;
        private int contagem = 0 ;
        private char[] entradas;

        public ArvBin(char[] entradas) {

            this.contagem = 0;
            this.entradas = entradas;

            raiz = new No();
            raiz.setConteudo(entradas[0]);

            if(raiz.getConteudo() == 'n'){
                contagem++;
                raiz.setEsq(adicionar(raiz,entradas[contagem]));
                contagem++;
                raiz.setDir(adicionar(raiz,entradas[contagem]));

            }

        }

        private No adicionar(No anterior, char val){
            No no = new No();
            no.setConteudo(val);

            if(val == 'n'){
                contagem++;
                no.setEsq(adicionar(no,entradas[contagem]));
                contagem++;
                no.setDir(adicionar(no, entradas[contagem]));
            }

            return no;
        }

        private int tamanho(No verifica){

            if(verifica==null) return -1;

            int esquerda = tamanho(verifica.getEsq());
            int direita = tamanho(verifica.getDir());

            return Math.max(esquerda,direita) + 1;
        }

    }

}