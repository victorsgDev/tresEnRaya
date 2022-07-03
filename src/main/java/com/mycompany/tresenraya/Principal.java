
package com.mycompany.tresenraya;

import java.util.Scanner;

public class Principal 
{
    public Principal(){}    //constructor

    static int[][] tablero = new int[3][3];
    
    public void pintarTablero()
    {
        
        for (int x=0; x < tablero.length; x++) 
        {
            for (int y=0; y < tablero[x].length; y++) 
            {
                System.out.print (tablero[x][y]);
                if (y!=tablero[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }
    }
    
    //=============================================================
    // COMPROBACION LINEA 
    public static String coincidenciaLinea() 
    {
 
    int neutro;
    boolean coincidencia;
    String texto="0";
 
    for (int i = 0; i < tablero.length; i++) 
    {
 
        //Reiniciamos la coincidencia
        coincidencia = true;
        //Cogemos el símbolo de la fila
        neutro = tablero[i][0];
        if (neutro != 0) {
            for (int j = 1; j < tablero[0].length; j++) 
            {
                //sino coincide ya no habra ganador en esta fila
                if (neutro != tablero[i][j]) 
                {
                    coincidencia = false;
                }
            }
 
            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                if (neutro==1)
                {
                    texto="El ganador es el player 1" ;
                    return texto;
                }
                else
                {
                    texto="El ganador es el player 2" ;
                    return texto;
                }
            }
        }
    }
    return texto;
 
}
    //=============================================================== 
    
    // COMPROBACION COLUMNA 
    public static String coincidenciaColumna() {
 
    int neutro;
    boolean coincidencia;
    String texto="0";
 
    for (int j = 0; j < tablero.length; j++) {
 
        //Reiniciamos la coincidencia
        coincidencia = true;
        //Cogemos el simbolo de la columna
        neutro = tablero[0][j];
        if (neutro != 0) {
            for (int i = 1; i < tablero[0].length; i++) {
                //sino coincide ya no habra ganador en esta fila
                if (neutro != tablero[i][j]) {
                    coincidencia = false;
                }
            }
 
            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                if (neutro==1)
                {
                    texto="El ganador es el player 1" ;
                    return texto;
                }
                else
                {
                    texto="El ganador es el player 2" ;
                    return texto;
                }
            }
 
        }
 
    }
 
    //Si no hay ganador, devuelvo el simbolo por defecto
    return texto;
 
}
    
 //===============================================================  
    
    public static String coincidenciaDiagonal() {
 
    int neutro;
    boolean coincidencia = true;
    String texto="0";
    
    //Diagonal principal
    neutro = tablero[0][0];
    if (neutro != 0) {
        for (int i = 1; i < tablero.length; i++) {
            //sino coincide ya no habra ganadro en esta fila
            if (neutro != tablero[i][i]) {
                coincidencia = false;
            }
        }
 
        //Si no se mete en el if, devuelvo el simbolo ganador
        if (coincidencia) {
            if (neutro==1)
                {
                    texto="El ganador es el player 1" ;
                    return texto;
                }
                else
                {
                    texto="El ganador es el player 2" ;
                    return texto;
                }
        }
 
    }
 
    coincidencia = true;
 
    //Diagonal inversa
    neutro = tablero[0][2];
    if (neutro != 0) {
        for (int i = 1, j = 1; i < tablero.length; i++, j--) {
            //sino coincide ya no habra ganado en esta fila
            if (neutro != tablero[i][j]) {
                coincidencia = false;
            }
        }
 
        //Si no se mete en el if, devuelvo el simbolo ganador
        if (coincidencia) {
            if (neutro==1)
                {
                    texto="El ganador es el player 1" ;
                    return texto;
                }
                else
                {
                    texto="El ganador es el player 2" ;
                    return texto;
                }
        }
    }
 
    //Si no hay ganador, devuelvo el simbolo por defecto
    return texto;
 
}
    
//===============================================================    
    
    public static void main(String[] args) 
    {
        System.out.println("¡Bienvenido al juego del 3 en raya!");
        
        Scanner scanner= new Scanner(System.in);
        Principal principal= new Principal();
        
        int player1=1;
        int player2=-1;
        int resultado1=0;
        int resultado2=0;
        
        principal.pintarTablero();
                
        // COMIENZO DE PARTIDA:
        while(resultado1!=3 || resultado2!=-3)
        {
            int x1;int y1;int x2;int y2;
            
            System.out.println("Es turno del jugador 1");
            System.out.println("Dime coordenada x");
            x1=scanner.nextInt();
            System.out.println("Dime coordenada y");
            y1=scanner.nextInt();
            principal.tablero[x1][y1]=player1;
            resultado1+=player1;
            
            //PINTAR TABLERO 
            principal.pintarTablero();
                    
            System.out.println("Es turno del jugador 2");
            System.out.println("Dime coordenada x");
            x2=scanner.nextInt();
            System.out.println("Dime coordenada y");
            y2=scanner.nextInt();
            principal.tablero[x2][y2]=player2;
            resultado2+=player2;
            
           //PINTAR TABLERO 
            principal.pintarTablero();
            
           
        }
        // COMPROBACIÓN DE VICTORIA:
           
            System.out.println(principal.coincidenciaColumna());
            System.out.println(principal.coincidenciaLinea());
            System.out.println(principal.coincidenciaDiagonal());
    }
    
}
