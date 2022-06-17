import java.io.*;
import java.util.ArrayList;

public class practicaArchivos {

    private ArrayList<String> contenidoArchivo = new ArrayList<>();
    private ArrayList<Hexagono> listaEntrada = new ArrayList<>();
    private final String rutaWindows = "C:\\Users\\archi\\Desktop\\subir a git\\java\\Practica 6\\src\\datos.txt";

    public ArrayList<String> getContenidoArchivo() {
        return contenidoArchivo;
    }

    public ArrayList<Hexagono> getListaEntrada() {
        return listaEntrada;
    }

    public void leerArchivo(){
        LeerArchivo leer = new LeerArchivo();
        this.contenidoArchivo =
                leer.leerArchivo(this.rutaWindows);
        for (int i=0; i < this.contenidoArchivo.size();i++){
            String linea = this.contenidoArchivo.get(i);
            String elementosLinea[] = linea.split(",");
            try {
                double cateto = Integer.parseInt(elementosLinea[0]);
                listaEntrada.add(new Hexagono(cateto));
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                listaEntrada.add(new Hexagono(0));
            }
        }


    }

    public void escribirArchivo(ArrayList<Hexagono> lista){
        String archivo = "Resultados.txt";
        File f = new File(archivo);
        //Escritura
        try{
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("");
            wr.append("cateto,  perimetro,   apotema,           area\n");
            for (int i=0; i < lista.size(); i++){
                wr.append(lista.get(i).getCateto() +
                        ",    " + lista.get(i).getPerimetro() +
                        ",    " + lista.get(i).getApotema() + ",  " +
                        lista.get(i).getArea() + "\n");
            }
            wr.close();
            bw.close();
        }catch(IOException e){

        }
    }

    public static void main (String args[]){
        practicaArchivos practica = new practicaArchivos();
        practica.leerArchivo();
        for (int i=0; i < practica.getListaEntrada().size(); i++){
            System.out.println(practica.getListaEntrada().get(i).getCateto() +
                    "\t" + practica.getListaEntrada().get(i).getPerimetro() +
                    "\t" + practica.getListaEntrada().get(i).getApotema() + "\t" +
                    practica.getListaEntrada().get(i).getArea());
        }
        practica.escribirArchivo(practica.getListaEntrada());
    }
}
