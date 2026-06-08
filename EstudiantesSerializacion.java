
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

class Asignatura implements Serializable {

    public String nombreAsig;
    public double nota1, nota2, promedio;
    public boolean estado;
    public double notasuples = 0;

    public Asignatura(String nombreAsig, double nota1, double nota2) {
        this.nombreAsig = nombreAsig;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public void calcularPromedio(double nota1, double nota2) {
        this.promedio = (this.nota1 + this.nota2) / 2;
    }

    public void calcularEstado() {
        this.estado = (this.promedio >= 7);
    }

    public void calcularSuples(double notasuples) {
        if (this.estado == false) {
            this.notasuples = notasuples;
            this.promedio = notasuples;
        }
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombreAsig=" + nombreAsig + ", nota1=" + nota1 + ", nota2=" + nota2 + ", promedio=" + promedio + ", estado=" + estado + ", notasuples=" + notasuples + '}';
    }

}

class Estudiante implements Serializable {

    public String nombreEst;
    public ArrayList<Asignatura> asignaturas;

    public Estudiante(String nombreEst, ArrayList<Asignatura> asignaturas) {
        this.nombreEst = nombreEst;
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombreEst=" + nombreEst + ", asignaturas=" + asignaturas + '}';
    }
}

public class View {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Asignatura> AsignaturaEst1 = new ArrayList<>(Arrays.asList(new Asignatura("Poo", 8.5, 9), new Asignatura("EstructuraDiscreta", 6, 4)));
        ArrayList<Asignatura> AsignaturaEst2 = new ArrayList<>(Arrays.asList(new Asignatura("Mate", 10, 8), new Asignatura("Humanismo", 10, 10)));
        Estudiante est1 = new Estudiante("Gaby", AsignaturaEst1);
        Estudiante est2 = new Estudiante("Alisson", AsignaturaEst2);

        for (Asignatura asig1 : AsignaturaEst1) {
            asig1.calcularPromedio(asig1.nota1, asig1.nota2);
            asig1.calcularEstado();
            asig1.calcularSuples(6);
            asig1.calcularEstado();
        }

        for (Asignatura asig2 : AsignaturaEst2) {
            asig2.calcularPromedio(asig2.nota1, asig2.nota2);
            asig2.calcularEstado();
            asig2.calcularSuples(9);
            asig2.calcularEstado();

        }

        ObjectOutput foutObjt = new ObjectOutputStream(new FileOutputStream("Estudiantes.dat"));
        foutObjt.writeObject(est1);
        foutObjt.writeObject(est2);
        foutObjt.close();
        ObjectInputStream finObj = new ObjectInputStream(new FileInputStream("Estudiantes.dat"));
        Estudiante esAux = (Estudiante) finObj.readObject();
        System.out.println(esAux);
        esAux = (Estudiante) finObj.readObject();
        System.out.println(esAux);
        finObj.close();

    }
}
