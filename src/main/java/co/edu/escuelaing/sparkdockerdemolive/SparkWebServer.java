    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.escuelaing.sparkdockerdemolive;


import static spark.Spark.port;
import static spark.Spark.get;
import java.lang.Math;

public class SparkWebServer {
    
    public static void main(String... args){
          port(getPort());
          get("hello", (req,res) -> "Hello Docker!");
          get("/", (req,res) -> getIndexResponse());
          //Sin
          get("sin", (req,res) -> Math.sin(Double.parseDouble(req.queryParams("value"))));
          //Cos
          get("cos", (req,res) -> Math.cos(Double.parseDouble(req.queryParams("value"))));
          //Palindrome
          get("palindrome", (req,res) -> {
              String str = req.queryParams("value");
              if(isPalindrome(str)){
                  return "Is palindrome. ";
              }
              return "Not is palindromo. ";
          });
          //Magnitud
          get("magnitude", (req,res) -> {
              double xValue = Double.parseDouble(req.queryParams("value1"));
              double yValue = Double.parseDouble(req.queryParams("value2"));
              return Math.sqrt(Math.pow(xValue, 2)+Math.pow(yValue, 2));
          });
          
          
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String getIndexResponse() {
        String html = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "<style>\n" +
                        "        \n" +
                        "        body {\n" +
                        "            display: flex;\n" +
                        "            justify-content: center;\n" +
                        "            height: 100vh; \n" +
                        "            margin: 0; \n" +
                        "        }\n" +
                        "\n" +
                        "        \n" +
                        "        form {\n" +
                        "            text-align: center; \n" +
                        "            margin: 20px; \n" +
                        "            padding: 20px; \n" +
                        "            border: 1px solid #ccc; \n" +
                        "            border-radius: 5px; \n" +
                        "            background-color: #f9f9f9; \n" +
                        "        }\n" +
                        "\n" +
                        "        \n" +
                        "        input, button {\n" +
                        "            margin: 5px; \n" +
                        "        }\n" +
                        "    </style>" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "    <form id=\"sinForm\">\n" +
                    "        <label for=\"sinValor\">Calculate Sin:</label>\n" +
                    "        <input type=\"text\" id=\"sinValor\" name=\"sinValor\" required>\n" +
                    "        <button type=\"button\" onclick=\"calcuteSin()\">Calculate</button>\n" +
                    "        <div id=\"resultadoSeno\"></div>\n" +
                    "    </form>\n" +
                    "\n" +
                    "    <form id=\"cosForm\">\n" +
                    "        <label for=\"cosValor\">Calculate Cos:</label>\n" +
                    "        <input type=\"text\" id=\"cosValor\" name=\"cosValor\" required>\n" +
                    "        <button type=\"button\" onclick=\"calculateCos()\">Calculate</button>\n" +
                    "        <div id=\"resultadoCoseno\"></div>\n" +
                    "    </form>\n" +
                    "\n" +
                    "    <form id=\"palindromeForm\">\n" +
                    "        <label for=\"palindromeValor\">Verify Palindrome:</label>\n" +
                    "        <input type=\"text\" id=\"palindromeValor\" name=\"palindromeValor\" required>\n" +
                    "        <button type=\"button\" onclick=\"verifyPalindrome()\">Verify</button>\n" +
                    "        <div id=\"resultadoPalindromo\"></div>\n" +
                    "    </form>\n" +
                    "\n" +
                    "    <form id=\"sqrtForm\">\n" +
                    "        <label for=\"sqrtValor1\">Calculate the magnitude of a vector, First value:</label>\n" +
                    "        <input type=\"text\" id=\"sqrtValor1\" name=\"sqrtValor1\" required>\n" +
                    "        <label for=\"sqrtValor2\">Second value:</label>\n" +
                    "        <input type=\"text\" id=\"sqrtValor2\" name=\"sqrtValor2\" required>\n" +
                    "        <button type=\"button\" onclick=\"calculateMagnitude()\">Calculate</button>\n" +
                    "        <div id=\"resultadoRaizCuadrada\"></div>\n" +
                    "    </form>\n" +
                    "\n" +
                    "    <script>\n" +
                    "        function calcuteSin() {\n" +
                    "            const valueInput = document.getElementById('sinValor').value;\n" +
                    "            const resultElement = document.getElementById('resultadoSeno');\n" +
                    "\n" +
                    "            fetch(`/sin?value=${valueInput}`)\n" +
                    "                .then(response => response.text())\n" +
                    "                .then(data => {\n" +
                    "                    resultElement.textContent = `The Sin of ${valueInput} is: ${data}`;\n" +
                    "                })\n" +
                    "                .catch(error => {\n" +
                    "                    console.error('Error:', error);\n" +
                    "                    resultElement.textContent = 'Error communicating with server.';\n" +
                    "                });\n" +
                    "        }\n" +
                    "\n" +
                    "        function calculateCos() {\n" +
                    "            const valueInput = document.getElementById('cosValor').value;\n" +
                    "            const resultElement = document.getElementById('resultadoCoseno');\n" +
                    "\n" +
                    "            fetch(`/cos?value=${valueInput}`)\n" +
                    "                .then(response => response.text())\n" +
                    "                .then(data => {\n" +
                    "                    resultElement.textContent = `The Cos of ${valueInput} is: ${data}`;\n" +
                    "                })\n" +
                    "                .catch(error => {\n" +
                    "                    console.error('Error:', error);\n" +
                    "                    resultElement.textContent = 'Error communicating with server.';\n" +
                    "                });\n" +
                    "        }\n" +
                    "\n" +
                    "        function verifyPalindrome() {\n" +
                    "            const strInput = document.getElementById('palindromeValor').value;\n" +
                    "            const resultElement = document.getElementById('resultadoPalindromo');\n" +
                    "\n" +
                    "            fetch(`/palindrome?value=${strInput}`)\n" +
                    "                .then(response => response.text())\n" +
                    "                .then(data => {\n" +
                    "                    resultElement.textContent = `The word ${strInput} ${data}`;\n" +
                    "                })\n" +
                    "                .catch(error => {\n" +
                    "                    console.error('Error:', error);\n" +
                    "                    resultElement.textContent = 'Error communicating with server.';\n" +
                    "                });\n" +
                    "        }\n" +
                    "\n" +
                    "        function calculateMagnitude() {\n" +
                    "            const value1 = document.getElementById('sqrtValor1').value;\n" +
                    "            const value2 = document.getElementById('sqrtValor2').value;\n" +
                    "            const resultElement = document.getElementById('resultadoRaizCuadrada');\n" +
                    "\n" +
                    "            fetch(`/magnitude?value1=${value1}&value2=${value2}`)\n" +
                    "                .then(response => response.text())\n" +
                    "                .then(data => {\n" +
                    "                    resultElement.textContent = `The magnitude of the vector is: ${data}`;\n" +
                    "                })\n" +
                    "                .catch(error => {\n" +
                    "                    console.error('Error:', error);\n" +
                    "                    resultElement.textContent = 'Error communicating with server.';\n" +
                    "                });\n" +
                    "        }\n" +
                    "    </script>\n" +
                    "</body>\n" +
                    "</html>\n";
            return html;
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