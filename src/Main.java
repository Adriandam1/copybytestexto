
/* 2) exercicio copybytestexto

NOTAS IMPORTANTES

Unha vez solucionado o exercicio debes enviar o proxecto completo comprimido co nome copyBytes_teunome.zip

Tamen debes enviar o fonte ( ou fontes)  .java como arquivos separados.

nota : o  numero maximo de arquivos a subir e 4  e non deben totalizar en conxunto mais de 200 MB




 * Neste exercicio trataremos os fluxos de Bytes (binary streams) mediante as clases  FileInputStream, FileOutputStream

Por cada modificacion que se pide deixa comentada a linea como estaba antes da modificacion para deixar constancia de todas as modificacions desenvolvidas no exercicio.

A clase   FileInputStream permite ler bytes dende un ficheiro do sistema .
Para elo imos utilizar o metodo read() de dita clase que leera byte a byte . Cando se pase ao fin do ficheiro devoltara un valor -1 ( polo tanto deberedes preguntar por este valor para detectar o fin do ficheiro,  e non facer mais lecturas que darian un erro)


FileOutputStream e unha clase que permite facer xusto o contrario, escribir bytes nun ficheiro do sistema.
Para elo imos utilizar o metodo write() de dita clase.

nota: a clase FileOutputStream acepta nun dos seus  contructores un segundo parametro tipo boolean que si e “true” indica que  o ficheiro se abre en modo append (engadir) , e dicir que se usamos este parametro co valor “true”  cando voltemos escribir neste ficheiro o seu contido non se sobreescribe

nota IMPORTANTE : lembrar pechar o obxecto OutputStream co seu metodo close() deste xeito os datos que poidan quedar no buffer son trasladados ao ficheiro destino.

1)crea a man cun editor de texto simple (un editor de texto plano de Centos e “gedit” por exemplo) un pequeno ficheiro de texto chamado texto1.txt con tres lineas :
ola
adeus
cecais

APLICACION :

2_1)Desenvolve unha pequena aplicacion  chamada 'copybytestexto'  que usando somente estas duas clases e os metodos indicados  copie  byte a byte o contido do  ficheiro de texto chamado texto1.txt noutro ficheiro chamado texto2.txt

2_2) Fai a modificacion necesaria na aplicacion anterior para que se engada de novo o texto do ficheiro texto1.txt ao ficheiro texto2.txt ( e dicir facer o cambio necesario para que non o sobreescriba , polo que cada vez que executemos a apliciacion , o ficheiro de texto texto2.txt vera aumentado o seu contido cas tres palabras do texto1.txt de novo)

 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (
            // creo e indico los FileInputStream y FileOutputStream
            FileInputStream inputStream = new FileInputStream("texto1.txt");
            // Pongo false para sobreescribir el archivo si lo hubiese de texto2.txt
            FileOutputStream outputStream = new FileOutputStream("texto2.txt", false);

            ){
            // variable para el numero de byte
            int numeroByte;

            // Bucle while para leer byte a byte el archivo texto1.txt
            // cuando llega al final el valor es -1
            while ((numeroByte = inputStream.read()) != -1) {
                // Escribir cada byte en texto2.txt
                outputStream.write(numeroByte);
            }
        // catch IOException
        } catch (IOException e) {

            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }
}