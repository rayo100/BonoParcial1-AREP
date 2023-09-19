/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.*;

public class SparkWebServer {
    
    public static void main(String... args){
          port(getPort());
          get("hello", (req,res) -> "Hello Docker!");
          get("/", (req,res) -> getIndexResponse());
          //Sin
          get("/sin/:numero", (req,res) -> {
              double numero = Double.parseDouble(req.params("numero"));
              return Math.sin(Math.toRadians(numero));
          });
          //Cos
          get("/cos/:numero", (req,res) -> {
              double numero = Double.parseDouble(req.params("numero"));
              return Math.cos(Math.toRadians(numero));
          });
          //Palindrome
          get("/magnitude/:str", (req,res) -> {
              String str = req.params("str");
              if(isPalindrome(str)){
                  return "Es palindromo. ";
              }
              return "No es palindromo. ";
          });
          //Magnitud
          get("/cos/:x/:y", (req,res) -> {
              double xvar = Double.parseDouble(req.params("x"));
              double yvar = Double.parseDouble(req.params("y"));
              return Math.sqrt(xvar * xvar + yvar * yvar);
          });
          
          
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String getIndexResponse() {
        return "";
    }

    public static boolean isPalindrome(String str) {
  
        str = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // No es un palíndromo
            }
            left++;
            right--;
        }
        return true;
    }


    
    
}