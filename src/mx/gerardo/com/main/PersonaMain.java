package mx.gerardo.com.main;

import mx.gerardo.com.modelo.Persona;

import java.util.Scanner;

public class PersonaMain {

    private final Scanner leer = new Scanner(System.in);
    private Persona persona;

    public void registrarPersona() {
        try {
            persona = new Persona();
            System.out.println("\nIngresa Nombre: ");
            persona.setNombre(leer.nextLine());
            System.out.println("\nIngresa edad: ");
            persona.setEdad(Integer.parseInt(leer.nextLine()));
            System.out.println("\nIngresa peso (ejemplo: 98): ");
            persona.setPeso(Double.parseDouble(leer.nextLine()));
            System.out.println("\nIngresa altura (ejemplo: 1.65): ");
            persona.setAltura(Double.parseDouble(leer.nextLine()));
            System.out.println("\nIngresa Sexo (H o M): ");
            persona.setSexo(leer.nextLine().charAt(0));
            System.out.println("\n\nInformacion e IMC del usuario:");
            if (persona.esMayorDeEdad()) {
                System.out.println("\nEl usuario: " + persona.getNombre() + " es mayor de edad");
            } else {
                System.out.println("\nEl usuario: " + persona.getNombre() + " NO es mayor de edad");
            }
        } catch (NumberFormatException e) {
            System.err.println("error en formato de datos.");
            System.err.println(e.getMessage());
        }
    }

    public void imcPersona() {
        switch (persona.calculaIMC()) {
            case -1:
                System.out.println("IMC del usuario: Falta de peso");
            case 0:
                System.out.println("IMC del usuario: Peso normal");
            default:
                System.out.println("IMC del usuario: Sobre peso");
        }
        System.out.println("Información de la persona: " + persona);
    }

    public static void main(String[] args) {
        PersonaMain pm = new PersonaMain();
        pm.registrarPersona();
        pm.imcPersona();
    }
}
