package com.aantik.demo.match;

import java.io.*;
import java.lang.*;
import java.util.*;

import com.aantik.demo.model.ModEmprendimiento;
 
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

    int dijkstra(int src, int end)
    {
        
        int graph[][]= new int[][] { 
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

};
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

        return(dist[end]);
    }
 
}/*
	int match(EstudianteM est, ModEmprendimiento emp){
	  int val = 0;
		ShortestPath t = new ShortestPath();
		int ini = -1;
		int end = -1;
		String arr[] = { 
				"Usaquén",
				"Chapinero",
				"Santa Fe",
				"San Cristóbal",
				"Usme",
				"Tunjuelito",
				"Bosa",
				"Kennedy",
				"Fontibón",
				"Engativá",
				"Suba",
				"Barrios Unidos",
				"Teusaquillo",
				"Los Mártires",
				"Antonio Nariño",
				"Puente Aranda",
				"La Candelaria",
				"Rafael Uribe Uribe",
				"Ciudad Bolívar",
				"Sumapaz"
				};
		
		  for(int i=0; i<20; i++) {
			  if (arr[i]==est.localidad)
				  ini = i;
			  if (arr[i]==emp.localidad)
				  end = i;
			  }
    }
    	  if(est.genero != emp.genero && emp.genero != 'I'){
	    return -999;
	  }else if(est.limitacion==true && emp.limitacion==false){
	    return val-999;
	  }

	  if(ini + end > -1){ 		  
	    val += 20 - t.dijkstra( ini, end)*3;
	  }
	
}*/