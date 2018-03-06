package yurifelix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        //Criar e ler dados do primeiro array
        int sizeA = scanner.nextInt();
        int[] arrayA = new int[sizeA];

        while (count < sizeA){
            arrayA[count] = scanner.nextInt();
            count++;
        }


        //Criar e ler dados do segundo array
        int sizeB = scanner.nextInt();
        int[] arrayB = new int[sizeB];

        count = 0;
        while (count < sizeB){
            arrayB[count] = scanner.nextInt();
            count++;
        }


        boolean aux;
        //verificando semelhanças
        for (int i=0; i < sizeA; i++){
            aux = true;

            for(int j=0; j < sizeB; j++){

                if(arrayA[i]==arrayB[j]){
                    aux = false;
                    break;
                }

            }

            if(aux) System.out.print(" " + arrayA[i]);

        }

    }

}
