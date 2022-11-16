package com.aantik.demo.match;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CSV = Comma-Separated Values
		  //   text file that uses a comma to separate values
		  
		  String file = "FORMATOEMPR.csv";
		  BufferedReader reader = null;
		  String line = "";
		  int numLineas = 0;
		  int numPreguntas = 0;


		 String[] arr = new String[250];
		  
		  try {
		   reader = new BufferedReader(new FileReader(file));
		   reader.readLine();
		   while((line = reader.readLine()) != null) {



		   
		    String[] row = line.split(",");
		    //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		//use this if your values already contain commas
		    for(String index : row) {
		        index = index.replaceAll("\"", "");
		    
		     System.out.printf("  "+index+"  ");
		     System.out.printf("  "+row[2].charAt(0)+"  ");
		     arr[numPreguntas] = (String)index;
		     numPreguntas++;
		    }
		    System.out.println();
		    numLineas++;
		   }
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		  System.out.println("Numero de lineas: " + numLineas);
		  System.out.println("Numero de preguntas: " + numPreguntas/numLineas);
		  System.out.println("Numero de datos: " + numPreguntas);
		  /*for(int i=0;i<arr.length;i++)
		  {
		      System.out.println(arr[i]);
		  }*/
	}
}