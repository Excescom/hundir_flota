/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project_hundir_flota;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class Project_hundir_flota 
{
    //comprueba que no hay barcos en todas las diagonales, en caso de encuentre uno
    //devuelve un false y si no encuentra barco devuelve true
    //lo que hace es llamar a la función de comprobar barco para ver si hay o no hay barco
     static boolean comprobarbarcoalrededor (char[][] tableroin, int fila,char columna)
        {
            boolean resul=false;//se crea la variable del resultaddo
            //creo las variables las cuales se van a comprobar si son true o false en las diferentes posiciones
            boolean casilla=false,comrpobarbarcos=false,dentroabajoderecha=false,dentroarribaizquierda=false,dentroarribaderecha=false,dentroabajoizquierda=false,dentroderecha=false,dentroizquierda=false,dentroarriba=false,dentroabajo=false;
            //compruebo todas las direcciones para ver si hay un barco dentro
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
            //comprueba que todas las direcciones son true, y si lo son devuelve un true, si uno da false se queda en false     
            if( casilla == true && comrpobarbarcos == true && dentroabajoderecha == true && dentroarribaizquierda == true && dentroarribaderecha == true && dentroabajoizquierda == true && dentroderecha == true && dentroizquierda == true && dentroarriba == true && dentroabajo == true )
            {
                resul = true;
            }
     
            return resul; 
        }
 
    //comprueba que esa casilla está dentro de el tablero y si no está te devuelve un booleano
    static boolean comrpobarcasilla(char[][] tablero,int fila,char columna)
    
    {
        //creo las bariables 
        boolean resul=true;
        int nf = tablero.length;
        int nc = tablero[0].length;
        
        //comprueblo que la casilla a comprobar no esté fuera de la matríz, si está fuera te devuelve false
        if ((fila < 0 || columna < 0) || (fila >= nf || columna >= nc) )
        {
            resul = false;
        }
            
        return resul;   
    }
    
    //comprueba que en unca sailla hay un barco y te devuelve un booleano
    static boolean comprobarbarco(char[][] tablero,int fila,char columna)
    {
        //creo las bariables
        boolean resul=true,casilla;
        //primero comprueba que la casilla existe
        casilla = comrpobarcasilla(tablero,fila,columna);
        //si la casilla existe y la casilla es un barco te devuelve un false
        if(casilla==true && tablero[fila][columna] == 177)
        {
            resul = false;                          
        } 

        return resul;    
    }
    
    //comprueba que puedes colocar el barco en esa posición
    static boolean comprobar (char[][] tabla,int fila,char columna)
    {
        //creo las bariables
        boolean resul,casilla,alrededor;
        //compruebo que se puede colocar el barco
        casilla = comrpobarcasilla(tabla,fila,columna);//miro que la casilla existe en el tablero
       
        alrededor = comprobarbarcoalrededor(tabla,fila,columna);//comprubebo si hay barco en la posición y sus alrededores
            
        if(casilla == true && alrededor == true )
        {
            resul = true;
        }
        else
            {
                resul = false;
            }
            
        return resul;
    }
    //elige la dirección hacia la que se va a dirigir el barco, dependiendo de la opcón elige una dirección u otra devolvienndo un vector
    static int[] direccion(int opt)
    {
        //creo el vector que voy a devolver como resultado
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
    
    //esta función te coloca los barcos en la matríz y te devuelve un booleano en el caso de que no se coloquen correctamente
    static boolean colocarbarcos(char[][] tableroin)
    {
        //creo las bariables
        int fila,opt,cont=0,intentos=0;
        char columna;
        boolean entra1,entra2,entra3,entra4,resul=true;
        int nf = tableroin.length;
        int[] donde;
        int nc = tableroin[0].length;
        //inicializo las filas y las columnas de forma aleatoria 
        fila = (int) (Math.random()*nf);
        columna = (char) (Math.random()*nc);
        //muestro este mensaje para avisar al usuario que se están colocando lso barcos
        System.out.println("Saliendo los barcos de puerto");

        //escojo de forma aleatoria la dirección a la que se va a dirigir el barco
        opt = (int) (Math.random()*8);
        //le mando la opción a la función para que escoja la dirección    
        donde = direccion(opt);
        //muestro este mensaje para avisar al usuario que se está colocando el porta aviones
        System.out.println("porta aviones llegando a coordenadas...");
        //coloco 1 portaaviones, si no se puede colocar en 10 intentos devuleve false
        for(intentos=0;cont < 1 && intentos < 10 ; intentos++)  
        {
            //compruebo que se puede poner el barco en la posición que le ha tocado de forma aleatoria
            entra1 = comprobar (tableroin,fila,columna);
            entra2 = comprobar (tableroin,fila + donde[0], (char) (columna + donde[1]));
            entra3 = comprobar (tableroin,fila + donde[0] + donde[0], (char) (columna + donde[1] + donde[1]));
            entra4 = comprobar (tableroin,fila + donde[0] + donde[0] + donde[0], (char) (columna + donde[1] + donde[1] + donde[1]));
            
            //si todas las comprobaciones dan true entoneces se coloca el barco en su respectiva posición
            if(entra1 == true && entra2 ==true && entra3 ==true && entra4 ==true )
            {
                tableroin[fila][columna]= 177 ;
                tableroin[fila + donde[0]][columna + donde[1]]= 177 ;
                tableroin[fila + donde[0] + donde[0]][columna + donde[1] + donde[1]]= 177 ;
                tableroin[fila + donde[0] + donde[0]  + donde[0]][columna + donde[1] + donde[1]  + donde[1]]= 177 ;
                cont++;           
            }
            //si no se colocan se vuelve a dar una posición aleatoria
            else
                {
                    fila = (int) (Math.random()*nf);
                    columna = (char) (Math.random()*nc);
                    opt = (int) (Math.random()*8);
                    donde = direccion(opt);
                }
   
        }
        //comprueba si los intentos al colocar los barcos se han excedido y vuleve el resultado a false
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
            //coloca 2 destructores, tiene 10 intentos para colocarlos
            for(intentos=0;cont < 2 && intentos < 10 ; intentos++)
            {
                //compruebo que se puede poner el barco en la posición que le ha tocado de forma aleatoria
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
                //si no se colocan se vuelve a dar una posición aleatoria
                else
                    {
                        fila = (int) (Math.random()*nf);
                        columna = (char) (Math.random()*nc); 
                        opt = (int) (Math.random()*8);
                        donde = direccion(opt);
                    }
            }  
        }
        //comprueba si los intentos al colocar los barcos se han excedido y vuleve el resultado a false
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
            //coloca 2 corbetas, tiene 10 intentos para colocarlos
            for(intentos=0;cont < 2 && intentos < 10 ; intentos++)
            {
                //compruebo que se puede poner el barco en la posición que le ha tocado de forma aleatoria
                entra1 = comprobar (tableroin,fila,columna);
                entra2 = comprobar (tableroin,fila + donde[0], (char) (columna + donde[1]));
                
                if(entra1 == true && entra2 ==true )
                {
                    tableroin[fila][columna]= 177 ;
                    tableroin[fila + donde[0]][columna + donde[1]]= 177 ;
                    cont++;           
                }
                //si no se colocan se vuelve a dar una posición aleatoria
                else
                    {
                        fila = (int) (Math.random()*nf);
                        columna = (char) (Math.random()*nc);
                        opt = (int) (Math.random()*8);
                        donde = direccion(opt);
                    }
            }  
        }
        
        //comprueba si los intentos al colocar los barcos se han excedido y vuleve el resultado a false
        if (intentos == 10)
        {
            
            resul= false; 
        }
        
        if(resul == true)
        {
            cont=0;
            System.out.println("submarinos sumergiendose...");
            //coloca 2 submarinos, tiene 10 intentos para colocarlos
            for(intentos=0;cont < 2 && intentos < 10 ; intentos++)
            {
                //compruebo que se puede poner el barco en la posición que le ha tocado de forma aleatoria
                entra1 = comprobar (tableroin,fila,columna);
                
                if(entra1 == true )
                {
                    tableroin[fila][columna]= 177 ;
                    cont++;               
                }
                //si no se colocan se vuelve a dar una posición aleatoria
                else
                    {
                        fila = (int) (Math.random()*nf);
                        columna = (char) (Math.random()*nc);
                        opt = (int) (Math.random()*8);
                        donde = direccion(opt);
                            
                    }
            }
        }
        //comprueba si los intentos al colocar los barcos se han excedido y vuleve el resultado a false
        if (intentos == 10)
               {  
                   resul = false;
               }
        System.out.println("Presione enter para terminar");//le digo al usuario que presione la tecla enter para continuar
        new java.util.Scanner(System.in).nextLine();//espera a que el usuario pulse enter para iniciar el juego
        limpiar();
        return resul;
    }
    
    
    static void disparo (char[][] tableroin,char[][] tableroex, int[] puntos)
    
    {
        Scanner sc;
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        puntos[0]-- ;//le quito una bala al usuario
        //creo las variables
        int fila;
        char columna;
        boolean dentro;
        //le pregunto al usuario en qué fila quiere disparar
        System.out.println("Introduce la fila");
            fila = sc.nextInt();
        //pregunto al usuario en que columna quiere disparar
        System.out.println("Introduce la columna");
            columna = sc.next().charAt(0);
        //convierto las letras en un número el cual corresponda con la columna dependiendo de la letra que ha introducido en mayúscula
        if(columna > 64 && columna < 90)
        {
            columna -=65; 
        }
        //convierto las letras en un número el cual corresponda con la columna dependiendo de la letra que ha introducido en minúscula
        else if(columna > 96 && columna < 123)
            {
                columna -=97;
            }
        //compruebo que a la casilla que quiere disparar está dentro de la matríz
        dentro = comrpobarcasilla(tableroin,fila,columna);
        //si la coordenada está dentro comprueba si ha fallado o si ha acertado
        if(dentro == true)
        {
                if(tableroin[fila][columna] == 32)
                {
                    System.out.println("*****FALLASTE*****");//si fallas sale esto
                    espera(1000);
                    tableroin[fila][columna] = 216;//cambio el tablero interno la figura de disparo
                    tableroex[fila][columna] = 216 ;//cambio el tablero externo a la figura de fallo
                }
                else if(tableroin[fila][columna] == 177)
                    {
                        System.out.println("!!!!ACERTASTE!!!!");//si aciertas sale esto
                        espera(1000);
                        tableroin[fila][columna] = 216;//cambio el tablero interno la figura de disparo
                        tableroex[fila][columna] = 177;//cambio el tablero externo a la figura de barco indicando el acierto      
                    puntos[1]++ ;
                    }
                    else if(tableroin[fila][columna] == 216)
                        {
                            System.out.println("te quito una bala porque pellizcas cristales");//si disparas en una posición que ya habías disparado antes     
                            espera(1000);
                        }                
        }
        //si dispara fuera le muestra lo siguiente:
        else
            {
                System.out.println("te quito una bala porque persigues coches aparcados");//si disparas fuera del tablero sale esto
                espera(1000);
            }
    }
    
    static void disparorandom (char[][] tableroin,char[][] tableroex, int[] puntos)
    {
        //creo las variables
        int fila;
        boolean acierto=false;
        char columna;
        int nf = tableroin.length;
        int nc = tableroin[0].length;
        
        //compruebo que tengo balas suficientes para disparar
        if(puntos[0] < 15)
        {
            System.out.println("Balas insuficientes");//mensaje que sale en caso de no tener balas
            espera(1000);
        }
        //en el caso de que tengas las balas suficientes
        else
            {
                puntos[0] -=15 ;//le quito los puntos que vale el disparo random
                fila = (int) (Math.random()*nf);//selecciono la fila de forma aleatoria
                columna = (char) ((Math.random()*nc)+65);//selecciono la columna de forma aleatoria
                //convierto las letras en números que conuerden los la columna
                if(columna > 64 && columna < 91)
                {
                   columna -=65; 
                }
                
                //le digo al usuario que está buscando un barco al que disparar
                System.out.println("escaneando zona buscando un barco");
                espera(3000);
                //un bucle que mientras que no hacierte el disparo continúa buscando un barco
                while(acierto == false)
                {
                    //si encuentra un barco hace lo soguiente
                    if(tableroin[fila][columna] == 177)
                    {
                        tableroin[fila][columna] = 216;//cambia el tablero interno a que ha disparado
                        tableroex[fila][columna] = 177 ;//cambia el tablero externo indicando un acierto
                        puntos[1]++;//sumo un ùnto a los barcos que ha acertado
                        acierto = true;//pongo la variable acierto en true para que salga del bucle
                        
                    }
                    //si no encuentra barco buelve a cambiar la fila y la columna para ver si acierta
                    else
                        {
                            fila = (int) (Math.random()*nf);//cambia la fila
                            columna = (char) ((Math.random()*nc)+65);//cambia la columna
                            //convierto las letras en números que conuerden los la columna
                            if(columna > 64 && columna < 91)
                            {
                                columna -=65; 
                            }
                        }
                }
            
            }
            
    }
    //variable que realiza el disparo barrena, el cual dispara en toda una columna o en toda una fila
    static void barrena(char tablain[][],char[][] tablaex,int puntos[])
    {
        //creo las variables
        int nf = tablain.length;
        int nc = tablain[0].length;
        int fila,opt;
        char columna;
        boolean flag;
        
        Scanner sc;
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        
        //menú para preguntar al usuario si quiere disparar en una columna o una fila
        System.out.println("Introduce unna opción: ");
        System.out.println("1) fila");
        System.out.println("2) columna");
        opt = sc.nextInt();//el usuario introduce la opción que quiera
         
        //inicializo la variable flag a false
        flag=false;
        //dentro de este while compruebo que la opción introducida es válida y le pregunto dónde quiere disparar
        while(flag==false)
        {
            switch(opt)
            {
                case 1:
                    if(nf + 2 > puntos[0] )
                    {
                        //combruebo si tiene bálas suficientes para disparar en la fila una bomba barrena
                        System.out.println("Balas insuficientes para las filas");//le digo que no tiene bálas suficientes para disparar en la columna una bomba barrena
                        espera(1000);
                        flag=true;//pongo la centinela en true
                    }
                    else
                        {
                            //resto las balas que cuesnta disaprar en la fila
                            puntos[0]= puntos[0] - (nf + 2); 
                            //le pregunto en qué fila quiere disparar
                            System.out.println("¿en que fila quieres disparar?");
                                fila = sc.nextInt();//introduce la fila
                            //comprueba que has disparado dentro del tablero    
                            if (fila < 0 || fila >= nf)
                            {
                                 System.out.println("te quito balas porque peinas calvos");//te pongo este mensaje si te sales de la matriz
                                 espera(1000);
                                 flag=true;//pongo la centinela en true
                            }
                            else
                            {   //recorre toda la fila comprobando si hay barco
                                for(int i=0;i<nc;i++)
                                {
                                    if(tablain[fila][i] == 216)//en caso de que encuentre una fila en la que ha disparado
                                    {
                                        i = nc;//termino el bucle igualando la i al núemro de columna
                                        System.out.println("te quito balas porque persigues coches aparcados");//le muestro este mensaje al usuario
                                        espera(1000);
                                    }
                                    else if(tablain[fila][i] == 177)//comprueba si hay barco
                                        {
                                        tablain[fila][i]=216;//guardo en el tablero interno que ha disparado
                                        tablaex[fila][i]=177;//le muestra al usuario que ha dado en un barco
                                        puntos[1]++;//sumo un barco a los puntos
                                        }
                                    else if(tablain[fila][i] == 32)//comprueba si hay agua
                                        {
                                            tablain[fila][i]=216;//guardo en el tablero interno que ha disparado
                                            tablaex[fila][i]=216;//muestro que ha disparado y fallado
                                        }

                                } 
                                flag=true;//pongo la centinela en true
                            }
                        }
                        break;
                case 2:
                    //combruebo si tiene bálas suficientes para disparar en la columna una bomba barrena
                    if(nc - 2 > puntos[0] )
                    {
                        System.out.println("Balas insuficientes para las columnas");//le digo que no tiene bálas suficientes para disparar en la columna una bomba barrena
                        espera(1000);
                        flag=true;
                    }
                    else
                        {
                            puntos[0]= puntos[0] - (nc + 2);//resto los puntos que vale el disparo barrena
                            System.out.println("¿en que columna quieres disparar?");//pregunto dónde quiere disparar
                                columna = sc.next().charAt(0);//introduce la columna como letra
                            //convierto las letras en un número el cual corresponda con la columna dependiendo de la letra que ha introducido en mayúscula
                            if(columna > 64 && columna < 90)
                            {
                                columna -=65; 
                            }
                            //convierto las letras en un número el cual corresponda con la columna dependiendo de la letra que ha introducido en minúscula
                            else if(columna > 96 && columna < 123)
                                {
                                    columna -=97;
                                }
                            //comprueba que has disparado dentro
                            if (columna < 0 || columna >= nc)
                            {
                                System.out.println("te quito balas porque peinas calvos");//te mmuestra este mensaje si disparas fuera
                                espera(1000);
                                flag=true;//pongo la centinela en true
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
                                        if(tablain[i][columna] == 216)//en caso de que encuentre una fila en la que ha disparado
                                        {
                                            i = nf;//igualo la i a el número de fila para terminal el bucle
                                            System.out.println("te quito balas porque persigues coches aparcados");//le muestro este mensaje al usuario
                                            espera(1000);
                                        }   
                                        else if(tablain[i][columna] == 177)//comprueba si hay barco
                                        {
                                            tablain[i][columna]=216;//guardo en el tablero interno que ha disparado
                                            tablaex[i][columna]=177;//le muestra al usuario que ha dado en un barco
                                            puntos[1]++;//sumo un barco a los puntos
                                        }
                                        else if(tablain[i][columna] == 32)//comprueba si hay agua
                                            {
                                                tablain[i][columna]=216;//guardo en el tablero interno que ha disparado
                                                tablaex[i][columna]=216;//muestro que ha disparado y fallado
                                            }
                                    }
                                    flag=true;//pongo la centinela en true
                                }
                        }
                        break;
                //si introduce una opción no válida:
                default:
                    //le vuelve a preguntar al usuario que opción quiere para poder ejecutar la función
                    System.out.println("Introduce unna opción válida: ");
                    System.out.println("1) fila");
                    System.out.println("2) columna");
                    opt= sc.nextInt();//introduce la opción por teclado                                 
            } 
        }
    }
    static void atomica (char[][] tableroin,char[][] tableroex, int[] puntos)
    {
        int aciertos=0, fallos=0;//variables que sirven para contar los aciertos y los fallos de las bombas para mostrarlo luego
        //creo el scanner
        Scanner sc;
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int fila;
        char columna;
        
        
        //comprueba si tienes balas para la bomba atómica
        if(puntos[0] >= 10)
        {
            puntos[0] -= 10;
            
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
            //comprueba todas las direcciones a las que va a disparar
            boolean dentro = comrpobarcasilla(tableroin,fila,columna);
            boolean dentroabajoderecha = comrpobarcasilla(tableroin,fila + 1, (char) (columna + 1));
            boolean dentroarribaizquierda = comrpobarcasilla(tableroin,fila - 1, (char) (columna - 1));
            boolean dentroarribaderecha = comrpobarcasilla(tableroin,fila - 1, (char) (columna + 1));
            boolean dentroabajoizquierda = comrpobarcasilla(tableroin,fila + 1, (char) (columna - 1));
            boolean dentroderecha = comrpobarcasilla(tableroin,fila, (char) (columna + 1));
            boolean dentroizquierda = comrpobarcasilla(tableroin,fila, (char) (columna - 1));
            boolean dentroarriba = comrpobarcasilla(tableroin,fila + 1,columna);
            boolean dentroabajo = comrpobarcasilla(tableroin,fila - 1,columna);
                
            //comprueba si está disparando dentro de la matríz y discapara en un cuadrado en caso de que dispare dentro
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
                //te muestra la cantidad de fallos y la cantidad de aciertos que has tenido
                System.out.println("ACERTASTE "+aciertos+" y fallaste "+fallos);
                espera(2000);
            }
            //en caso de que dispare fuera
            else
                {
                    System.out.println("te quito 10 balas porque persigues cohes aparcados");
                    espera(1500);
                }   
        }
        //en caso de que no tenga balas suficientes
        else
            {
                System.out.println("balas insuficientes"); 
                espera(1000);
            }
            
  
    }
    
    //te muestra por pantalla la matríz que le introduzcas con forma de tablero
    static void mostrarmatriz(char num[][] )
    {
        int nf = num.length;
        int nc = num[0].length;
        char coorc;
        int coorf=0,i;

        coorc = 65; //muestra las columnas con letras
        for(i=0;i<nc;i++)
        {
            System.out.print("    "+coorc);// imprime als letras de cadad columna
            coorc++;
        }
        System.out.println();
        
        for( coorf=0;coorf<nf;coorf++)
        {
            //te puestra el numero de fila
            String cadena = String.format("%02d" , coorf);//le pone un 0 antes a las cifras de 1 dígito
            System.out.print(cadena + "|");//pone una linea al lado de las letras
            //dibuja las lineas de la tabla
            for(int j=0;j<nc;j++)
            {
                System.out.print(("  "+num[coorf][j]+" |"));
            }
            
            System.out.println();
        }
    }
    //función que sirve para mostrar las balas que tienes
    static void mostrarbalas(int[] balas )
    {
        int i;
        char bala = 164;// Le doy un símbol para dibujar las balas
        System.out.print(balas[0]+" balas: ");
        
        for(i=1; i< balas[0];i++)
        {
             System.out.print(bala +" "); //imprimo las balas que hay con un espacio menos la última
        }
        // imprimo la última bala sin espacio, para no poner espacios de más 
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
        //inicializo estas variables para poder calcular el coste de balas de la bomba barrena
        int nf = tablain.length;
        int nc = tablain[0].length;
        //se imprime por pantalla el menú de opciones a elegir que tiene el usuario
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
    //pequeño manual para entender como funciona el juego
    static void tutorial()
    {
        limpiar();//limpio la pantalla
        //le muestroo el mabual al usuario
        System.out.println("barcos a encontrar:");
        System.out.println();
        System.out.println("2 submarinos: \t \t ± ±");
        System.out.println("2 corbetas: \t \t ±± ±±");
        System.out.println("2 destructores: \t ±±± ±±±");
        System.out.println("1 porta aviones: \t ±±±±");
        System.out.println();
        System.out.println("opciones:");
        System.out.println();
        System.out.println("1) Disparo \t \t |dispara a 1 casilla de tu elección.");
        System.out.println("2) bomba atomica \t |dispara a una casilla y a todas las de su alrededor a tu elección, cuidado con salirte.");
        System.out.println("3) flash \t \t |te muestra la ubicación de los barcos en el tablero durante 0,5 segundos, SÉ RÁPIDO.");
        System.out.println("4) barrena \t \t |dispara a una fila o a una columna completa a tu elección.");
        System.out.println("5) pista \t \t |dispara a un barco de forma aleatoria.");
        System.out.println();
        
        System.out.println("Presione enter para continuar...");//le digo al usuario que presione la tecla enter para continuar
            new java.util.Scanner(System.in).nextLine();//espera a que el usuario pulse enter para salirse del tutorial   
    }

    static void flash(char[][] tablain, int[] balas)      
    {
        if(balas[0] < 25)
        {
           System.out.println("Balas insuficientes");   
        }
        else
            {
                balas[0] -=25;
                limpiar();
                mostrarmatriz(tablain);
                espera(500);//espera 0,5 segundos para dar una pequeña pausa
            }        
    }
    //función para que el programa se pare durante un tiempo determinado
    static void espera(int tiempo)
    {
        try 
        {
            for (int i = 0; i < 2; i++) 
            {
                Thread.sleep(tiempo);//le indico en milisegundos el tiempo que tiene que esperar el programa 
            }
        } 
        catch (InterruptedException e) 
        {
        }
    }
    
    //esta función limpia la pantalla el windows y en linux
    static void limpiar()
    {
        try 
        {
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando= new ArrayList<>();
            if(sistemaOperativo.contains("Windows"))
            {        
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");  
            } 
            else 
                {
                    comando.add("clear");
                } 
            
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();   
        }
        catch (IOException | InterruptedException e) 
        {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());//si no es capaz de limpiar la pantalla salta este mensaje
        }
    }
    
    public static void main(String[] args) 
    {
        limpiar();//limpia toda la pantalla antes de empezar el juego
        int fila,columna,opt,i; 
        //creo un vector en el que se van a guardar las balas y la cantidad de aciertos que tiene
        int puntos[]= new int [2];
        Scanner sc;
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        //pequeña introducción antes de mepezar el juego
        System.out.println("HUNDIR LA FLOTA EL VIDEOJUEGO");
        System.out.println();
        System.out.print(
            ".\n" +
            "            |\n" +
            "            |_\n" +
            "            |__\n" +
            "            |___\n" +
            "            |____\n" +
            "            |_____\n" +
            "            |______\n" +
            "      ______|_____________​__\n" +
            "~~~~\\____________________/​~~~~\n" +
            ",.-~*´¨¯¨`*•~-.¸,.-~*´¨¯¨`​*•~-.¸,.-~*´¨¯¨`*•~-.¸,.-~​*´¨¯¨`*•~-.¸,.-~*´¨¯¨`*•~-​.¸,.-~*´¨¯¨`*•~-.¸,.-~*´¨¯​¨`*•~-.¸\n"
        );
        System.out.println();
        System.out.println("PULSA INTRO PARA INICIAR EL JUEGO");
            new java.util.Scanner(System.in).nextLine();
        //empieza el juego
        System.out.println("Introduce el tamaño que quieres que tenga la fila");
            fila = sc.nextInt();
        System.out.println("Introduce el tamaño que quieres que tenga la columna");
            columna = sc.nextInt();   
        //comprueba que la tabla que has introducido no sea demasiada grande ni demasiada pequeña,
        //en caso de ser incompatible te la vuelve a pedir
        while(fila * columna < 56 || fila > 26 || columna >26 )//compruebo que la tabla tenga como mínimo 56 celdas y que como máximo las filas y las columnas midan 25
        {
            //en caso de que la tabla no sea válida te la vuelve a pedir
            System.out.println("Tabla no válida, tiene que tener como máximo 25 filas o 25 columnas y como minimo 56 celdas");
            System.out.println("Introduce la fila");
                fila = sc.nextInt();
            System.out.println("Introduce la columna");
                columna = sc.nextInt();
        }
        limpiar();//limpia la pantalla antes de empezar el juego
            
        char tablain[][]= new char [fila][columna];
        char tablaex[][]= new char [fila][columna];
       
        puntos[0] = (fila * columna) / 3;  //te rellena con las balas que necesitas que son un tercio de las celdas
        puntos[1] = 0;//inicializa que los puntos de los barcos son 0
            
        //relena la tabla externa para el usuario con espacios
        for( i=0;i<fila;i++)
        {
            for(int j=0;j<columna;j++)
            {
                tablaex[i][j] = 32;
            }
        } 
        //relena la tabla interna para el usuario con espacios
        for(i=0;i<fila;i++)
        {
            for(int j=0;j<columna;j++)
            {
                tablain[i][j] = 32;
            }
        } 
        //coloco los barcos en su lugar y guardo en una variable si el resultaddo es true o false
        //si el resultado es false es que no se han podido colocar los barcos correctamente
        boolean barcoscolocados = colocarbarcos(tablain); 
        if (barcoscolocados == true)
        {
            //mensaje que sale para dar inmersión al usuario de que se está escanenado la zona para buscar los barcos
            System.out.print("ESCANEANDO LA ZONA");
            espera(500);
            System.out.print(".");
            espera(500);
            System.out.print(".");
            espera(500);
            System.out.print(".");
            espera(500);
            System.out.print(".");
            espera(500);
            System.out.print(".");
            espera(500);
            System.out.println(".");
            limpiar();
            
            mostrarmatriz(tablaex);
            System.out.println();
            mostrarbalas(puntos);

            //programa principal en el que está el menú y se representan los puntos  
            for(i=0;i<puntos[0] && puntos[1] < 16;)
            {
                menu(tablain);// te muestra el menú de opciones
                System.out.println("Introduce una opción de las siguientes: ");
                    opt= sc.nextInt();
                //menú de opciones a ejecutar en el programa
                switch(opt)
                {
                    case 1:
                        disparo(tablain,tablaex,puntos);//ejecuta el disparo normal
                        break;
                    case 2:
                        atomica(tablain,tablaex,puntos);//ejecuta la bomba atómica
                        break;
                    case 3:
                        flash(tablain,puntos);//ejecuta la flash
                        break;
                    case 4:
                        barrena(tablain,tablaex,puntos);//ejecuta la bomba barrena
                        break;
                    case 5:
                        disparorandom(tablain,tablaex,puntos);//ejecuta la pista
                        break;
                    case 6:
                        tutorial();//ejecuta el manual
                        break;
                    default:
                        System.out.println("!!!!!!opción no válida!!!!!");//te pone este mensaje en caso de que la opción introdducida no sea una de las anteriores
                        espera(1000);
                }
                // muestra la matriz actualizada al usuario
                
                limpiar();//limpia la pantalla para actualizar la matíz al usuario
                mostrarmatriz(tablaex);//le muestra la tabla al usuario
                mostrarbalas(puntos);//le dice al usuario la cantidad de balas que le quedan
                System.out.println("tus punntos son: "+puntos[1]+"/16");//te muestra la cantidad de barcos a los que has acertado
            } 
            //auí se decide que ocurre cuando ganas o pierdes
            if(puntos[1]==16)//comprueba que los puntos son 16, es decir, que has ganado
            {
                System.out.println("ILLOOOOO ONDEVÉ QUE Á GANAO");//le muestra un mensaje al usuario indicando que ha ganado
                espera(3000);
            }
            else
                {
                    limpiar();//limpia l apantalla antes de mostrar el resultado
                    System.out.println("NAAAAAA QUE MALO HAS PERDIO");//le muestra un mensaje al usuario mostrando que ha perdido
                    System.out.println("ESTA ES LA TABLA PRNGAO");//le dice al usuario que le va a mostrar la tabla para que pueda ver los barcos que le quedan por disparar
                    mostrarmatriz(tablain);//le mustra la tabla con los barcos al usario 
                    System.out.println("Presione enter para terminar el juego");//le digo al usuario que presione la tecla enter para continuar
                        new java.util.Scanner(System.in).nextLine();//espera a que el usuario pulse enter para salirse del juego
                       
                }       
        }
        else
            {               
                System.out.println("No se han colocado los barcos correctamente, inica el programa de nuevo");//mensaje qie te muestra si los barcos no se han colocado correctamente
                System.out.println("Presione enter para terminar el juego");//le digo al usuario que presione la tecla enter para continuar
                        new java.util.Scanner(System.in).nextLine();//espera a que el usuario pulse enter para salirse del juego
            }       
    }     
}
