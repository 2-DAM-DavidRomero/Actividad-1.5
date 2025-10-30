# Mayusculas

## Descripción
La clase `Mayusculas` crea un proceso hijo que convierte cualquier texto que el usuario escriba en mayúsculas. El proceso padre y el hijo se comunican de forma bidireccional usando **Streams**.  

- El **proceso padre** lee texto del usuario y lo envía al hijo.  
- El **proceso hijo** recibe el texto, lo convierte a mayúsculas y lo envía de vuelta al padre.  
- El programa termina cuando el usuario escribe `"fin"`.  

## Funcionalidades
1. Comunicación bidireccional padre-hijo mediante **Streams**.  
2. Conversión de texto a mayúsculas en el proceso hijo.  
3. Manejo de errores con `System.err.println()`.  
4. Espera a que el hijo termine antes de finalizar con `waitFor()`.  

## Ejemplo de ejecución
```bash
$ java Mayusculas
Escribe texto para convertir a mayúsculas. Escribe 'fin' para terminar:
hola
Desde el hijo: HOLA
com va?
Desde el hijo: COM VA?
fin
