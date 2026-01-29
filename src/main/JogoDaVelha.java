package main;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        char[][] jogo = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jogo[i][j] = ' ';
            }
        }

        //char jogadorX = 'X', jogadorO = 'O';
        boolean fimDeJogo = false;
        char player1 = '\u0000', player2 = '\u0000';
        char escolha;
        Scanner ler = new Scanner(System.in);

        //Player escolher X ou O
        do{
            System.out.println("Player 1 escolha 'X' ou 'O':");

            escolha = ler.next().charAt(0);

            if((escolha != 'X' && escolha != 'x') && (escolha != 'O' && escolha != 'o')){
                System.out.println("Escolha invalida, tente novamente.");
            }else{
                if(escolha == 'X' || escolha == 'x'){
                    player1 = 'X';
                    player2 = 'O';
                }else{
                    player1 = 'O';
                    player2 = 'X';
                }
            }
        }while((escolha != 'X' && escolha != 'x') && (escolha != 'O' && escolha != 'o'));

        System.out.println("\n------------");
        System.out.println("Player 1: "+ player1+"\nPlayer 2: "+ player2);
        System.out.println("------------\n");

        int linha, coluna;
        int turno = 0;

        //Tabela jogo da velha
        System.out.println("   1   2   3");
        System.out.print("1 [" + jogo[0][0] + "] [" + jogo[0][1] + "] [" + jogo[0][2] + "]\n");
        System.out.print("2 [" + jogo[1][0] + "] [" + jogo[1][1] + "] [" + jogo[1][2] + "]\n");
        System.out.print("3 [" + jogo[2][0] + "] [" + jogo[2][1] + "] [" + jogo[2][2] + "]\n");

        //While jogo da velha
        while(fimDeJogo == false){

            if(turno % 2 == 0){
                System.out.println("Turno do Player 1 - "+player1+":");
                System.out.println("Escreva a linha: ");
                linha = ler.nextInt();
                System.out.println("Escreva a coluna: ");
                coluna = ler.nextInt();

                if(jogo[linha - 1][coluna - 1] != ' '){
                    System.out.println("Lugar ja preenchido, escolha outro!");
                    continue;""
                }

                jogo[linha - 1][coluna - 1] = player1;
            }else{
                System.out.println("Turno do Player 2 - "+player2+":");
                System.out.println("Escreva a linha: ");
                linha = ler.nextInt();
                System.out.println("Escreva a coluna: ");
                coluna = ler.nextInt();

                if(jogo[linha - 1][coluna - 1] != ' '){
                    System.out.println("Lugar ja preenchido, escolha outro!");
                    continue;
                }
                jogo[linha - 1][coluna - 1] = player2;
            }

            //Tabela jogo da velha atualizada
            System.out.println("   1   2   3");
            System.out.print("1 [" + jogo[0][0] + "] [" + jogo[0][1] + "] [" + jogo[0][2] + "]\n");
            System.out.print("2 [" + jogo[1][0] + "] [" + jogo[1][1] + "] [" + jogo[1][2] + "]\n");
            System.out.print("3 [" + jogo[2][0] + "] [" + jogo[2][1] + "] [" + jogo[2][2] + "]\n");

            if ((jogo[0][0] == 'X' && jogo[0][1] == 'X' && jogo[0][2] == 'X') || (jogo[1][0] == 'X' && jogo[1][1] == 'X' && jogo[1][2] == 'X') || (jogo[2][0] == 'X' && jogo[2][1] == 'X' && jogo[2][2] == 'X') || (jogo[0][0] == 'X' && jogo[1][1] == 'X' && jogo[2][2] == 'X') || (jogo[2][0] == 'X' && jogo[1][1] == 'X' && jogo[0][2] == 'X') || (jogo[0][0] == 'X' && jogo[1][0] == 'X' && jogo[2][0] == 'X') || (jogo[0][1] == 'X' && jogo[1][1] == 'X' && jogo[2][1] == 'X')  || (jogo[0][2] == 'X' && jogo[1][2] == 'X' && jogo[2][2] == 'X')){
                if(player1 == 'X'){
                    System.out.println( "Player 1 Ganhou!");
                    fimDeJogo = true;
                }else{
                    System.out.println( "Player 2 Ganhou!");
                    fimDeJogo = true;
                }

            }else if((jogo[0][0] == 'O' && jogo[0][1] == 'O' && jogo[0][2] == 'O') || (jogo[1][0] == 'O' && jogo[1][1] == 'O' && jogo[1][2] == 'O') || (jogo[2][0] == 'O' && jogo[2][1] == 'O' && jogo[2][2] == 'O') || (jogo[0][0] == 'O' && jogo[1][1] == 'O' && jogo[2][2] == 'O') || (jogo[2][0] == 'O' && jogo[1][1] == 'O' && jogo[0][2] == 'O')  || (jogo[0][0] == 'O' && jogo[1][0] == 'O' && jogo[2][0] == 'O') || (jogo[0][1] == 'O' && jogo[1][1] == 'O' && jogo[2][1] == 'O') || (jogo[0][2] == 'O' && jogo[1][2] == 'O' && jogo[2][2] == 'O')){
                if(player1 == 'O'){
                    System.out.println( "Player 1 Ganhou!");
                    fimDeJogo = true;
                }else{
                    System.out.println( "Player 2 Ganhou!");
                    fimDeJogo = true;
                }
            }else if(turno >= 8){
                System.out.println( "Deu velha!");
                fimDeJogo = true;
            }
        turno++;
        }
    }
}