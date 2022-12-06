package com.aantik.demo.match;

import java.io.*;
import java.lang.*;
import java.util.*;
 
class ShortestPath {

    static final int V = 20;
    int minDistance(int dist[], Boolean sptSet[])
    {

        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 

    void printSolution(int dist[])
    {
        System.out.println(
            "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet);

            sptSet[u] = true;
 
            for (int v = 0; v < V; v++)
 
                if (!sptSet[v] && graph[u][v] != 0
                    && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
 
        printSolution(dist);
    }
 
}/*
public class Main
{
	public static void main(String[] args) {
		    {
		    
//0Usaquén
//1Chapinero
//2Santa Fe
//3San Cristóbal
//4Usme
//5Tunjuelito
//6Bosa
//7Kennedy
//8Fontibón
//9Engativá
//10Suba
//11Barrios Unidos
//12Teusaquillo
//13Los Mártires
//14Antonio Nariño
//15Puente Aranda
//16La Candelaria
//17Rafael Uribe Uribe
//18Ciudad Bolívar
//19Sumapaz

        int graph[][]
            = new int[][] { 
                            { 0, 1, 0, 0, 0,  0, 0, 0, 0, 0,  1, 1, 0, 0, 0,  0, 0, 0, 0, 0 },//Usaquén
                            { 1, 0, 1, 0, 0,  0, 0, 0, 0, 0,  0, 1, 1, 0, 0,  0, 0, 0, 0, 0 },//Chapinero
                            { 0, 1, 0, 1, 0,  0, 0, 0, 0, 0,  0, 0, 1, 1, 1,  0, 1, 0, 0, 0 },//Santa Fe
                            { 0, 0, 1, 0, 1,  0, 0, 0, 0, 0,  0, 0, 0, 1, 1,  0, 0, 1, 0, 0 },//San Cristóbal
                            { 0, 0, 0, 1, 0,  1, 0, 0, 0, 0,  0, 0, 0, 0, 0,  0, 0, 1, 1, 1 },//Usme
                            
                            { 0, 0, 0, 0, 1,  0, 1, 1, 0, 0,  0, 0, 0, 0, 1,  1, 0, 1, 1, 0 },//Tunjuelito
                            { 0, 0, 0, 0, 0,  1, 0, 1, 0, 0,  0, 0, 0, 0, 0,  0, 0, 0, 1, 0 },//Bosa
                            { 0, 0, 0, 0, 0,  1, 1, 0, 1, 0,  0, 0, 0, 0, 0,  1, 0, 0, 0, 0 },//Kennedy
                            { 0, 0, 0, 0, 0,  0, 0, 1, 0, 1,  0, 0, 1, 0, 0,  1, 0, 0, 0, 0 },//Fontibón
                            { 0, 0, 0, 0, 0,  0, 0, 0, 1, 0,  1, 1, 1, 0, 0,  0, 0, 0, 0, 0 },//Engativá
                            
                            { 1, 1, 0, 0, 0,  0, 0, 0, 0, 1,  0, 1, 0, 0, 0,  0, 0, 0, 0, 0 },//Suba
                            { 1, 1, 0, 0, 0,  0, 0, 0, 0, 1,  1, 0, 1, 0, 0,  0, 0, 0, 0, 0 },//Barrios Unidos
                            { 0, 1, 1, 0, 0,  0, 0, 0, 1, 1,  0, 1, 0, 1, 0,  1, 0, 0, 0, 0 },//Teusaquillo
                            { 0, 0, 0, 1, 0,  0, 0, 0, 0, 0,  0, 0, 1, 0, 1,  1, 0, 0, 0, 0 },//Los Mártires
                            { 0, 0, 0, 1, 0,  1, 0, 0, 0, 0,  0, 0, 0, 1, 0,  1, 0, 1, 0, 0 },//Antonio Nariño
                            
                            { 0, 0, 0, 0, 0,  1, 0, 1, 1, 0,  0, 0, 1, 1, 1,  0, 0, 0, 0, 0 },//Puente Aranda
                            { 0, 0, 1, 0, 0,  0, 0, 0, 0, 0,  0, 0, 0, 0, 0,  0, 0, 0, 0, 0 },//La Candelaria
                            { 0, 0, 0, 1, 1,  1, 0, 0, 0, 0,  0, 0, 0, 0, 1,  0, 0, 0, 0, 0 },//Rafael Uribe Uribe
                            { 0, 0, 0, 0, 1,  1, 1, 0, 0, 0,  0, 0, 0, 0, 0,  0, 0, 0, 0, 0 },//Ciudad Bolívar
                            { 0, 0, 0, 0, 1,  0, 0, 0, 0, 0,  0, 0, 0, 0, 0,  0, 0, 0, 0, 0 },//Sumapaz
                
                         

       

            };
        ShortestPath t = new ShortestPath();
 
        t.dijkstra(graph, 1);
    }
	}
}*/