package drf.pro;


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String palabra;
        Scanner teclado = new Scanner(System.in);

        System.out.println("\nEscribe texto para convertir a mayúsculas. Escribe 'fin' para terminar:");

        do {
            palabra = teclado.nextLine();

            if (!palabra.equalsIgnoreCase("fin")) {
                try {
                    // Comando para lanzar el proceso hijo
                    String classpath = System.getProperty("java.class.path");
                    ProcessBuilder pb = new ProcessBuilder("java", "-cp", classpath, "drf.pro.Hijo");


                    pb.redirectErrorStream(true);

                    // Iniciar el proceso hijo
                    Process hijo = pb.start();

                    // Abrimos el túnel para poderle pasar argumentos al hijo
                    OutputStream os = hijo.getOutputStream();
                    PrintWriter pw = new PrintWriter(os, true);

                    //Abrimos otro túnel para leer la salida del hijo
                    InputStream is = hijo.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    // Enviar mensaje al hijo
                    pw.println(palabra);
                    pw.flush(); // asegurarse de que se envía el mensaje

                    // Leer respuesta del hijo
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }

                    hijo.waitFor(); // esperar a que el hijo termine

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }while (!palabra.equalsIgnoreCase("fin"));
    }
}
