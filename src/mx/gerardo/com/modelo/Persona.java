package mx.gerardo.com.modelo;

import java.util.UUID;

public class Persona {

    private String nombre;
    private int edad;
    private final String nss;
    private double peso;
    private double altura;
    private char sexo; // constante

    public Persona(String nombre, int edad, double peso, double altura, char sexo) {
        this.nombre = (nombre.isEmpty()) ? "" : nombre;
        this.edad = Math.max(edad, 0);
        this.nss = generaNSS();
        this.peso = (peso <= 0) ? 0 : peso;
        this.altura = (altura <= 0) ? 0 : peso;
        this.sexo = (sexo == ' ') ? 'H' : sexo;
    }

    public Persona() {
        this.nss = generaNSS();
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = (Character.valueOf(sexo) != null) ? 'H' : sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre.isEmpty()) ? "" : nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = Math.max(edad, 0);
    }

    public String getNss() {
        return nss;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = (peso <= 0) ? 0 : peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = (altura <= 0) ? 0 : altura;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", nss=" + nss + ", peso=" + peso + ", altura=" + altura + ", sexo=" + sexo + '}';
    }

    public boolean esMayorDeEdad() {
        return (this.edad >= 18);
    }

    private String generaNSS() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public int calculaIMC() {
        double imc = this.peso / Math.pow(this.altura, 2);
        int valor;
        if (sexo == 'H' || sexo == 'h') {
            if (imc < 20) {
                valor = -1;
            } else if (imc >= 20 && imc < 25) {
                valor = 0;
            } else {
                valor = 1;
            }
        } else {
            if (imc < 19) {
                valor = -1;
            } else if (imc >= 19 && imc < 24) {
                valor = 0;
            } else {
                valor = 1;
            }
        }
        return valor;
    }

    private boolean comprobarSexo(char sexo) {
        return ((sexo == 'H' || sexo == 'h') || (sexo == 'M' || sexo == 'm'));
    }

}
