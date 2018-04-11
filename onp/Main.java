package yurifelix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;



public class Main {



    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            for(int i=0;i<t;i++){
                PilhaSeq pilha = new PilhaSeq();
                String saida = "";
                char line[] = null;
                    String linha = br.readLine();
                    line = linha.toCharArray();

                for(int j=0;j<linha.length();j++){

                    char atual = line[j];
                    char removido;

                    if(atual >= 65 && atual <= 122 && atual != '^'  ){
                        saida += atual;

                        //pilha.push(atual);

                    } else if (atual == ')'){
                        while (pilha.top() != '('){
                            removido = pilha.pop();
                            saida+=removido;
                        }
                        pilha.pop();

                    }else if ( atual == '+' || atual == '-' || atual == '*' || atual == '/' || atual == '^' || atual == '(' ){
                        pilha.push(atual);
                    }

                }

                System.out.println(saida);

            }


        }catch (Exception e){
            System.out.print(e.toString());
        }
    }

    //Pilha


}
class PilhaSeq {
    private char dados[]; // Vetor que contém os dados da lista
    private int topo;
    private int tamMax;

    public PilhaSeq(){
        tamMax = 500;
        dados = new char[tamMax];
        topo = -1;
    }



    /** Verifica se a Pilha está vazia */
    public boolean vazia(){
        if (topo == -1)
            return true;
        else
            return false;
    }

    /**Verifica se a Pilha está cheia */
    public boolean cheia(){
        if (topo == (tamMax-1))
            return true;
        else
            return false;
    }

    /**Obtém o tamanho da Pilha*/
    public int tamanho(){
        return topo+1;
    }


    public char top () {
        return dados[topo];
    }

    public boolean push (char valor) {
        if (cheia())
            return false;  // err: pilha cheia

        topo++;
        dados[topo] = valor;
        return true;
    }


    public char pop() {

        char valor = dados[topo];
        topo--;
        return valor;
    }
}