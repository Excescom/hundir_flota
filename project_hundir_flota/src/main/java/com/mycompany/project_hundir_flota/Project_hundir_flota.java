/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project_hundir_flota;


import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class Project_hundir_flota {
    
     static boolean comprobarbarcoalrededor (char[][] tableroin, int fila,char columna)
        {
            boolean resul=false;
            boolean casilla=false,comrpobarbarcos=false,dentroabajoderecha=false,dentroarribaizquierda=false,dentroarribaderecha=false,dentroabajoizquierda=false,dentroderecha=false,dentroizquierda=false,dentroarriba=false,dentroabajo=false;
            casilla = comprobarbarco(tableroin,fila,columna);
            comrpobarbarcos = comprobarbarco(tableroin,fila,columna);
            dentroabajoderecha = comprobarbarco(tableroin,fila + 1, (char) (columna + 1));
            dentroarribaizquierda = comprobarbarco(tableroin,fila - 1, (char) (columna - 1));
            dentroarribaderecha = comprobarbarco(tableroin,fila - 1, (char) (columna + 1));
            dentroabajoizquierda = comprobarbarco(tableroin,fila + 1, (char) (columna - 1));
            dentroderecha = comprobarbarco(tableroin,fila, (char) (columna + 1));
            dentroizquierda = comprobarbarco(tableroin,fila, (char) (columna - 1));
            dentroarriba = comprobarbarco(tableroin,fila + 1,columna);
            dentroabajo = comprobarbarco(tableroin,fila - 1,columna);   
                
                    if( casilla == true && comrpobarbarcos == true && dentroabajoderecha == true && dentroarribaizquierda == true && dentroarribaderecha == true && dentroabajoizquierda == true && dentroderecha == true && dentroizquierda == true && dentroarriba == true && dentroabajo == true )
                    {
                        resul = true;
                    }

                
        return resul;
        
        }
 
    //comprueba que esa casilla está dentro de el tablero
    static boolean comrpobarcasilla(char[][] tablero,int fila,char columna)
    
    {
        boolean resul=true;
        
        int nf = tablero.length;
        
        int nc = tablero[0].length;
        
        
            if ((fila < 0 || columna < 0) || (fila >= nf || columna >= nc) )
            {
                resul = false;
            }
            
       return resul;   
    }
    
    static boolean comprobarbarco(char[][] tablero,int fila,char columna)
    {
        
        boolean resul=true;
        boolean casilla = comrpobarcasilla(tablero,fila,columna);
        if(casilla==true && tablero[fila][columna] == 177)
        {
    
            resul = false; 
                                    
        } 

       return resul;  
        
    }
    
    //comprueba que puedes colocar el barco en esa posición
    static boolean comprobar (char[][] tabla,int fila,char columna)
    {
            boolean resul;
            
            boolean casilla = comrpobarcasilla(tabla,fila,columna);
            boolean barco = comprobarbarco(tabla,fila,columna);
            boolean alrededor = comprobarbarcoalrededor(tabla,fila,columna);
            if(casilla == true && alrededor == true && barco == true )
            {
                resul = true;
            }
            else
            {
                resul = false;
            }
         return resul;
    }
    //elige la dirección hacia la que se va a dirigir el barco
    static int[] direccion(int opt)
    {
        int num[]= new int [2];
         switch(opt)
             
                {
                    case 0:
                        num[0]=1;
                        num[1]=1;
                        break;
                    case 1:
                        num[0]=-1;
                        num[1]=-1;
                        break;
                    case 2:
                        num[0]=-1;
                        num[1]=+1;
                        break;
                    case 3:
                        num[0]=+1;
                        num[1]=-1;
                        break;
                    case 4:
                        num[0]=0;
                        num[1]=1;
                        break;
                    case 5:
                        num[0]=0;
                        num[1]=-1;
                        break;
                    case 6:
                        num[0]=1;
                        num[1]=0;
                        break;
                    case 7:
                        num[0]=-1;
                        num[1]=0;
                        break;
                }
        return num;
    }
    
    static boolean colocarbarcos(char[][] tableroin)
    
    {
        int fila,opt,cont=0,intentos=0;
        char columna;
        boolean entra1,entra2,entra3,entra4,resul=true;
        int nf = tableroin.length;
        int[] donde;
        
        int nc = tableroin[0].length;
        
        fila = (int) (Math.random()*nf);
        columna = (char) (Math.random()*nc);
         
        
        System.out.println("Saliendo los barcos de puerto");
        opt = (int) (Math.random()*8);
        donde = direccion(opt);
        System.out.println("porta aviones llegando a coordenadas...");
        
        for(intentos=0;cont < 1 && intentos < 10 ; intentos++)
            
        {
            entra1 = comprobar (tableroin,fila,columna);
            entra2 = comprobar (tableroin,fila + donde[0], (char) (columna + donde[1]));
            entra3 = comprobar (tableroin,fila + donde[0] + donde[0], (char) (columna + donde[1] + donde[1]));
            entra4 = comprobar (tableroin,fila + donde[0] + donde[0] + donde[0], (char) (columna + donde[1] + donde[1] + donde[1]));
            if(entra1 == true && entra2 ==true && entra3 ==true && entra4 ==true )
            {
                
                tableroin[fila][columna]= 177 ;
                tableroin[fila + donde[0]][columna + donde[1]]= 177 ;
                tableroin[fila + donde[0] + donde[0]][columna + donde[1] + donde[1]]= 177 ;
                tableroin[fila + donde[0] + donde[0]  + donde[0]][columna + donde[1] + donde[1]  + donde[1]]= 177 ;
                cont++;           
            }
            else
            {
                fila = (int) (Math.random()*nf);
                columna = (char) (Math.random()*nc);
            }
   
        }
        
        if (intentos == 10)
        {
           resul= false; 
        }
        
        
        if (resul == true)
        {
            opt = (int) (Math.random()*8);
            donde = direccion(opt);
            cont=0;
            System.out.println("destructores llegando a coordenadas...");
            for(intentos=0;cont < 2 && intentos < 10 ; intentos++)

            {
                entra1 = comprobar (tableroin,fila,columna);
                entra2 = comprobar (tableroin,fila + donde[0], (char) (columna + donde[1]));
                entra3 = comprobar (tableroin,fila + donde[0] + donde[0], (char) (columna + donde[1] + donde[1]));

                if(entra1 == true && entra2 ==true && entra3 ==true )
                {

                    tableroin[fila][columna]= 177 ;
                    tableroin[fila + donde[0]][columna + donde[1]]= 177 ;
                    tableroin[fila + donde[0] + donde[0]][columna + donde[1] + donde[1]]= 177 ;
                    cont++;           
                }
                else
                {
                fila = (int) (Math.random()*nf);
                columna = (char) (Math.random()*nc);
                
                }

            }  
        }
        
        
        if (intentos == 10)
        {

           resul= false; 
        }
        
        if (resul == true)
        {
            opt = (int) (Math.random()*8);
            donde = direccion(opt);
            cont=0;
            System.out.println("corbetas llegando a coordenadas...");
            for(intentos=0;cont < 2 && intentos < 10 ; intentos++)

            {
                entra1 = comprobar (tableroin,fila,columna);
                entra2 = comprobar (tableroin,fila + donde[0], (char) (columna + donde[1]));
                if(entra1 == true && entra2 ==true )
                {
                    tableroin[fila][columna]= 177 ;
                    tableroin[fila + donde[0]][columna + donde[1]]= 177 ;
                    cont++;           
                }
                else
                    {
                        fila = (int) (Math.random()*nf);
                        columna = (char) (Math.random()*nc);
                        
                    }

          }  
        }
        
        
        if (intentos == 10)
        {
            
            resul= false; 
        }
        
        if(resul == true)
        {
                cont=0;
                System.out.println("submarinos sumergiendose...");

                for(intentos=0;cont < 2 && intentos < 10 ; intentos++)
                {
                    entra1 = comprobar (tableroin,fila,columna);
                    if(entra1 == true )
                    {
                        tableroin[fila][columna]= 177 ;
                        cont++;               
                    }
                    else
                        {
                            fila = (int) (Math.random()*nf);
                            columna = (char) (Math.random()*nc);
                            
                        }
                }
        }
        
        if (intentos == 10)
               {  
                   resul = false;
               }
        return resul;
    }
    
    
    static void disparo (char[][] tableroin,char[][] tableroex, int[] puntos)
    
    {
         Scanner sc;
         sc = new Scanner(System.in);
         sc.useLocale(Locale.US);
         int fila;
         char columna;
         System.out.println("Introduce la fila");
            fila = sc.nextInt();
        System.out.println("Introduce la columna");
            columna = sc.next().charAt(0);
            if(columna > 64 && columna < 90)
            {
                columna -=65; 
            }
            else if(columna > 96 && columna < 123)
                    {
                        columna -=97;
                    }
        boolean dentro = comrpobarcasilla(tableroin,fila,columna);
       
        puntos[0]-- ;
        
            if(dentro == true)
            {
                if(tableroin[fila][columna] == 32)
                {
                    System.out.println("*****FALLASTE*****");
                    
                    tableroin[fila][columna] = 216;
                    tableroex[fila][columna] = 216 ;
                }

            else if(tableroin[fila][columna] == 177)
                 {
                    System.out.println("!!!!ACERTASTE!!!!"); 
                    tableroin[fila][columna] = 216;
                    tableroex[fila][columna] = 177;
                      
                    puntos[1]++ ;
                }
                //si disparas en una posición que ya habías disparado antes
                else if(tableroin[fila][columna] == 216)
                    {
                     System.out.println("te quito una bala porque pellizcas cristales");     
                    }
                    //si disparas fuera del tablero sale esto
                    
            }
            else
                    {
                        System.out.println("te quito una bala porque persigues coches aparcados");
                    }
        }
    
    static void disparorandom (char[][] tableroin,char[][] tableroex, int[] puntos)
    
    {
        int fila,acierto=0;
        char columna;
        int nf = tableroin.length;
        
        int nc = tableroin[0].length;
        
        if(puntos[0] < 15)
        {
            System.out.println("Balas insuficientes");
            espera();
        }
        else
        {
            puntos[0] -=15 ;
            fila = (int) (Math.random()*nf);
            columna = (char) ((Math.random()*nc)+65);
            if(columna > 64 && columna < 90)
            {
                columna -=65; 
            }
        
        System.out.println("buscando barco");
        while(acierto !=1)
        {
            if(tableroin[fila][columna] == 177)
            {
                tableroin[fila][columna] = 216;
                tableroex[fila][columna] = 177 ;
                acierto++;
                puntos[1]++;
            }
            else
            {
                fila = (int) (Math.random()*nf);
                columna = (char) ((Math.random()*nc)+65);
                if(columna > 64 && columna < 90)
                {
                    columna -=65; 
                }
            }
            
        }
            
        }
            
        }
    static void barrena(char tablain[][],char[][] tablaex,int puntos[])
    {
        int nf = tablain.length;
        
        int nc = tablain[0].length;
        int fila;
        char columna;
        Scanner sc;
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int opt;
        
        
        System.out.println("Introduce unna opción: ");
        System.out.println("1) fila");
        System.out.println("2) columna");
        opt = sc.nextInt();
         boolean flag;
        
        for(flag=false;flag==false;)
        {
             switch(opt)
                {
                    case 1:
                        if(nf + 2 > puntos[0] )
                        {
                              
                           System.out.println("Balas insuficientes");
                           espera();
                           flag=true;
                        }
                        else
                        {
                           puntos[0]= puntos[0] - (nf + 2); 
                           System.out.println("¿en que fila quieres disparar?");
                           
                           fila = sc.nextInt();
                           
                           if (fila < 0 || fila >= nf)
                           {
                               System.out.println("te quito balas porque peinas calvos");
                                flag=true;
                           }
                           else
                           {
                           for(int i=0;i<nc;i++)
                            {
                                if(tablain[fila][i] == 177)
                                {
                                    tablain[fila][i]=216;
                                    tablaex[fila][i]=177;
                                    puntos[1]++;
                                }
                                else if(tablain[fila][i] == 32)
                                {
                                    tablain[fila][i]=216; 
                                    tablaex[fila][i]=216;
                                }
                                
                            } 
                           flag=true;
                        }
                        }
                    
                        break;
                    case 2:
                        if(nc - 2 > puntos[0] )
                        {
                              
                           System.out.println("Balas insuficientes"); 
                           flag=true;
                        }
                        else
                        {
                           puntos[0]= puntos[0] - (nc + 2); 
                           System.out.println("¿en que columna quieres disparar?");
                           columna = sc.next().charAt(0);
                            if(columna > 64 && columna < 90)
                            {
                                columna -=65; 
                            }
                            else if(columna > 96 && columna < 123)
                                    {
                                        columna -=97;
                                    }
                           if (columna < 0 || columna >= nc)
                           {
                               System.out.println("te quito balas porque peinas calvos");
                                flag=true;
                           }
                           else
                           {
                           if(columna > 64 && columna < 90)
                            {
                                columna -=65; 
                            }
                            else if(columna > 96 && columna < 123)
                                {
                                    columna -=97;
                                }
                           for(int i=0;i<nf;i++)
                            {
                                if(tablain[i][columna] == 177)
                                {
                                    tablain[i][columna]=216;
                                    tablaex[i][columna]=177;
                                    puntos[1]++;
                                }
                                else if(tablain[i][columna] == 32)
                                {
                                    tablain[i][columna]=216; 
                                    tablaex[i][columna]=216;
                                }
                                
                            }
                           flag=true;
                        }
                        }
                        break;
                    default:
                        
                        System.out.println("Introduce unna opción válida: ");
                        System.out.println("1) fila");
                        System.out.println("2) columna");
                        opt= sc.nextInt();                                 
                } 
        }
       
        
        
        
    }
      static void atomica (char[][] tableroin,char[][] tableroex, int[] puntos)
    {
        int aciertos=0, fallos=0;
        
        Scanner sc;
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int fila;
        char columna;
        
        
        //comprueba si tienes balas para esto
        
        if(puntos[0] >= 10)
        {
                System.out.println("Introduce la fila"); 
                fila = sc.nextInt();

            System.out.println("Introduce la columna");   
                columna = sc.next().charAt(0);
                if(columna > 64 && columna < 90)
                {
                    columna -=65; 
                }
                else if(columna > 96 && columna < 123)
                        {
                            columna -=97;
                        }
            boolean dentro = comrpobarcasilla(tableroin,fila,columna);
            boolean dentroabajoderecha = comrpobarcasilla(tableroin,fila + 1, (char) (columna + 1));
            boolean dentroarribaizquierda = comrpobarcasilla(tableroin,fila - 1, (char) (columna - 1));
            boolean dentroarribaderecha = comrpobarcasilla(tableroin,fila - 1, (char) (columna + 1));
            boolean dentroabajoizquierda = comrpobarcasilla(tableroin,fila + 1, (char) (columna - 1));
            boolean dentroderecha = comrpobarcasilla(tableroin,fila, (char) (columna + 1));
            boolean dentroizquierda = comrpobarcasilla(tableroin,fila, (char) (columna - 1));
            boolean dentroarriba = comrpobarcasilla(tableroin,fila + 1,columna);
            boolean dentroabajo = comrpobarcasilla(tableroin,fila - 1,columna);
                puntos[0] -= 10;
            //comprueba y discapara en un cuadrado
            if(dentro == true && tableroin[fila][columna] != 216)
            {
            if(tableroin[fila][columna] == 32)
                    {
                        tableroin[fila][columna] = 216;
                        tableroex[fila][columna] = 216;
                        fallos++;
                    }
                else if(tableroin[fila][columna] == 177)
                        {
                            tableroin[fila][columna] = 216;
                            tableroex[fila][columna] = 177;
                            puntos[1]++ ;
                            aciertos++;
                        }            



            if(dentroabajoderecha == true && tableroin[fila+1][columna+1] != 216)
            {   
                if(tableroin[fila + 1][columna +1] == 32)
                    {
                        tableroin[fila + 1][columna +1] = 216;
                        tableroex[fila + 1][columna +1] = 216;
                        fallos++;
                    }
                else if(tableroin[fila+1][columna+1] == 177)
                        {
                            tableroin[fila + 1][columna +1] = 216;
                            tableroex[fila + 1][columna +1] = 177;
                            puntos[1]++ ;
                            aciertos++;
                        }
            }
            else
            {
                fallos++;
            }
            if(dentroarribaizquierda == true && tableroin[fila-1][columna-1] != 216)
            {           

                  if(tableroin[fila-1][columna-1] == 32)
                    {
                        tableroin[fila-1][columna-1] = 216;
                        tableroex[fila-1][columna-1] = 216;
                        fallos++;
                    }
                else if(tableroin[fila-1][columna-1] == 177)
                        {
                            tableroin[fila-1][columna-1] = 216;
                            tableroex[fila-1][columna-1] = 177;
                            puntos[1]++ ;
                            aciertos++;
                       }         
            }
            else
            {
                fallos++;
            }

            if(dentroabajoizquierda == true && tableroin[fila+1][columna-1] != 216)
            {

                if(tableroin[fila+1][columna-1] == 32)
                    {
                        tableroin[fila+1][columna-1] = 216;
                        tableroex[fila+1][columna-1] = 216;
                        fallos++;
                    }
                else if(tableroin[fila+1][columna-1] == 177)
                        {
                            tableroin[fila+1][columna-1] = 216;
                            tableroex[fila+1][columna-1] = 177;
                            puntos[1]++ ;
                            aciertos++;
                        }
            }
            else
            {
               fallos++; 
            }

            if(fila == 0)
                        {
                            fallos++;
                        }
            else
            {
                if(dentroarribaderecha == true && tableroin[fila-1][columna+1] != 216)
                {
                            if(tableroin[fila-1][columna+1] == 32)
                            {
                                tableroin[fila-1][columna+1] = 216;
                                tableroex[fila-1][columna+1] = 216;
                                fallos++;
                            }
                            else if(tableroin[fila-1][columna+1] == 177)
                            {
                                tableroin[fila-1][columna+1] = 216;
                                tableroex[fila-1][columna+1] = 177;
                                puntos[1]++ ;
                                aciertos++;

                } 
            }
            else
            {
               fallos++; 
            }   
            }


            if(dentroderecha == true && tableroin[fila][columna+1] != 216)
            {
                if(tableroin[fila][columna+1] == 32)
                    {
                        tableroin[fila][columna+1] = 216;
                        tableroex[fila][columna+1] = 216;
                        fallos++;
                    }
                else if(tableroin[fila][columna+1] == 177)
                        {
                            tableroin[fila][columna+1] = 216;
                            tableroex[fila][columna+1] = 177;
                            puntos[1]++ ;
                            aciertos++;
                        }
            }
            else
            {
                fallos++;
            }

            if(dentroizquierda == true && tableroin[fila][columna-1] != 216)
            {

                if(tableroin[fila][columna-1] == 32)
                    {
                        tableroin[fila][columna-1] = 216;
                        tableroex[fila][columna-1] = 216;
                        fallos++;
                    }
                else if(tableroin[fila][columna-1] == 177)
                        {
                            tableroin[fila][columna-1] = 216;
                            tableroex[fila][columna-1] = 177;
                            puntos[1]++ ;
                            aciertos++;
                        }
            }
            else
            {
                fallos++;
            }

            if(fila == 0)
                        {
                            fallos++;
                        }
            else
            {
               if(dentroabajo == true && tableroin[fila-1][columna] != 216)
            {

                if(tableroin[fila-1][columna] == 32)
                    {
                        if(fila == -1)
                        {

                        fallos++;
                        }
                        else
                        {
                            tableroin[fila-1][columna] = 216;
                            tableroex[fila-1][columna] = 216;
                            fallos++;
                        }

                    }
                else if(tableroin[fila-1][columna] == 177)
                        {

                                tableroin[fila-1][columna] = 216;
                                tableroex[fila-1][columna] = 177;
                                puntos[1]++ ;
                                aciertos++;


                        }
            }
               else
               {
                   fallos++;
               }
            }



            if(dentroarriba == true && tableroin[fila+1][columna] != 216)
            {
                if(tableroin[fila+1][columna] == 32)
                    {
                        tableroin[fila+1][columna] = 216;
                        tableroex[fila+1][columna] = 216;
                        fallos++;
                    }
                else if(tableroin[fila+1][columna] == 177)
                        {
                            tableroin[fila+1][columna] = 216;
                            tableroex[fila+1][columna] = 177;
                            puntos[1]++ ;
                            aciertos++;
                        }
            }
            else
            {
                fallos++;
            }
            }
            else
            {
                System.out.println("te quito 10 balas porque persigues cohes aparcados");
                espera();
            }

            if(puntos[0] < 10)
            {
                System.out.println("ACERTASTE "+aciertos+" y fallaste "+fallos);
            }
        }
        else
        {
            System.out.println("balas insuficientes"); 
            espera();
        }
            
  
    }
    static void mostrarmatriz(char num[][] )
    {
        int nf = num.length;
        
        int nc = num[0].length;
        char coorc;
        int coorf=0,i;
        
        //muestra las columnas con letras
        coorc = 65;
        for(i=0;i<nc;i++)
        {
            
            System.out.print("    "+coorc);
            coorc++;
        }
        System.out.println();
        for( coorf=0;coorf<nf;coorf++)
        {
            //te puestra el numero de fila
            String cadena = String.format("%02d" , coorf);
            System.out.print(cadena + "|");
            //dibuja las lineas de la tabla
            for(int j=0;j<nc;j++)
            {
                System.out.print(("  "+num[coorf][j]+" |"));
            }
                System.out.println();
        }
    }
    
    static void mostrarbalas(int[] balas )
    {
        int i;
        char bala = 164;
       System.out.print(balas[0]+" balas: ");
        for(i=1; i< balas[0];i++)
        {
             System.out.print(bala +" ");
        }
        if(balas[0] != 0)
        {
          System.out.println(bala);  
        }
        else
        {
            System.out.println();  
        }
    }
    // te muestra el menú visual al usuario, con sus respectivos costes y nombre
    static void menu(char[][] tablain)
    {
        int nf = tablain.length;
        
        int nc = tablain[0].length;
        System.out.println();
        System.out.println("opciones:");
        System.out.println();
        System.out.println("1) Disparo \t \t |coste 1");
        System.out.println("2) bomba atomica \t |coste 10");
        System.out.println("3) flash \t \t |coste 25");
        System.out.println("4) barrena \t \t |coste fila -> " + (nf +2) + " | coste columna -> " + (nc +2));
        System.out.println("5) pista \t \t |coste 15");
        System.out.println("6) tutorial \t \t |coste 0");
        System.out.println();
    }
    //te dice que hace cada disparo y te deja leerlo durante 5 segundos
    static void tutorial()
    {
        limpiar();
        System.out.println();
        System.out.println("opciones:");
        System.out.println();
        System.out.println("1) Disparo \t \t |dispara a 1 casilla de tu elección.");
        System.out.println("2) bomba atomica \t |dispara a una casilla y a todas las de su alrededor a tu elección, cuidado con salirte.");
        System.out.println("3) flash \t \t |te muestra la ubicación de los barcos en el tablero durante 0,5 segundos, SÉ RÁPIDO.");
        System.out.println("4) barrena \t \t |dispara a una fila o a una columna completa a tu elección.");
        System.out.println("5) pista \t \t |dispara a un barco de forma aleatoria.");
        System.out.println();
        
         System.out.println("Presione enter para continuar...");
            new java.util.Scanner(System.in).nextLine();
      
            
        
    }
    
    
    
    
    static void flash(char[][] tablain, int[] balas)
            
    {
        if(balas[0] <= 25)
        {
           System.out.println("Balas insuficientes");   
        }
        else
            {
                balas[0] -=25;
                limpiar();
                mostrarmatriz(tablain);               
            }        
    }
    
    static void espera()
    {
        try {
      for (int i = 0; i < 2; i++) {
        Thread.sleep(500);
        
      }
    } catch (Exception e) {
      
    }
    }
    
    static void limpiar(){
        try {
            
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando= new ArrayList<>();
            if(sistemaOperativo.contains("Windows")){        
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");
                
            } else {
                comando.add("clear");
            } 
            
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();
            
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
            int fila,columna,opt,i;
            
            //creo y relleno los barcos
            int puntos[]= new int [2];
            Scanner sc;
            sc = new Scanner(System.in);
            sc.useLocale(Locale.US);
            
            System.out.println("Introduce la fila");
            fila = sc.nextInt();
            System.out.println("Introduce la columna");
            columna = sc.nextInt();
            
            //comprueba que la tabla que has introducido no sea demasiada grande ni demasiada pequeña, y en caso de ser incompatible te la vuelve a pedir
            while(fila * columna < 56 || fila > 26 || columna >26 )
            {
                System.out.println("Tabla no válida, tiene que tener como máximo 25 filas o 25 columnas y como minimo 56 celdas");
                System.out.println("Introduce la fila");
                fila = sc.nextInt();
                System.out.println("Introduce la columna");
                columna = sc.nextInt();
            }
            limpiar();
            //colocarbarcos();
            char tablain[][]= new char [fila][columna];
            char tablaex[][]= new char [fila][columna];
            //te rellena con las balas que necesitas
            puntos[0] = (fila * columna) / 3;
            puntos[1] = 0;
            
            //relena la tabla con virgulillas
            for( i=0;i<fila;i++)
            {
                for(int j=0;j<columna;j++)
                {
            
                    tablaex[i][j] = 32;
            
                }
            } 
            
            for(i=0;i<fila;i++)
            {
                for(int j=0;j<columna;j++)
                {

                    tablain[i][j] = 32;

                }
            } 
         boolean barcoscolocados = colocarbarcos(tablain);
         
            if (barcoscolocados == true)
            {
                    mostrarmatriz(tablaex);
                    System.out.println();
                    mostrarbalas(puntos);

                   //programa principal en el que está el menú y se representan los puntos  
                  for(i=0;i<puntos[0] && puntos[1] < 16;)
                 {

                     menu(tablain);
                     System.out.println("Introduce una opción de las siguientes: ");

                     opt= sc.nextInt();
                     //menú de opciones a ejecutar en el programa

                     switch(opt)
                     {
                         case 1:
                             disparo(tablain,tablaex,puntos);
                             break;
                         case 2:
                             atomica(tablain,tablaex,puntos);
                             break;
                         case 3:
                             flash(tablain,puntos);
                             break;
                         case 4:
                             barrena(tablain,tablaex,puntos);
                             break;
                         case 5:
                             disparorandom(tablain,tablaex,puntos);
                             break;
                         case 6:
                             tutorial();
                             break;
                         default:
                             System.out.println("!!!!!!opción no válida!!!!!");
                     }
                     // muestra la matriz actualizada al usuario
                     espera();
                     limpiar();
                     mostrarmatriz(tablaex);
                     mostrarbalas(puntos);
                     System.out.println("tus punntos son: "+puntos[1]+"/16");


                 } 
                if(puntos[1]==16)
                {
                    System.out.println("ILLOOOOO ONDEVÉ QUE Á GANAO");
                }
                else
                {
                    System.out.println("NAAAAAA QUE MALO HAS PERDIO");
                    System.out.println("ESTA ES LA TABLA PRNGAO");
                    mostrarmatriz(tablain);
                }       
            }
            else
                {
                    System.out.println("No se han colocado los barcos correctamente, introduce la tabla de nuevo");
                }
            
    }     
}
