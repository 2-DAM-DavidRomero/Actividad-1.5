package drf.pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) {
        try {
            // Leer lo que el padre envía
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String mensaje = br.readLine();

            System.out.println("Desde el hijo:"+mensaje.toUpperCase());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
