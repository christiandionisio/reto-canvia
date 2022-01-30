package calculosalarios;

import java.util.ArrayList;
import java.util.List;

public class CalculoSalarios {

    public static void main(String[] args) {
        String [] inputArray = {"NNYN", "NNYN", "NNNN", "NYYN"};
        Empleado[] empleados = new Empleado[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            List<Integer> subordinados = new ArrayList<>();
            empleados[i] = new Empleado();
            for (int j = 0; j < inputArray[i].length(); j++) {
                if (inputArray[i].charAt(j) == 'Y') {
                    if (i == j) {
                        System.out.println("Caracter i del elemento i de la matriz, siempre será \"N\" para todos los i");
                        return;
                    }
                    if (j < i && empleados[j].getSubordinados().contains(i)) {
                        System.out.println("El empleado " + i + " no puede ser jefe del empleado " + j);
                        System.out.println("Subordinados del empleado" + j + " -> " + empleados[j].getSubordinados() );
                        return;
                    }
                    subordinados.add(j);
                }
            }
            empleados[i].setSubordinados(subordinados);
        }

        Integer totalSalarios = 0;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].getSalario() != null) {
                System.out.println("Ya se calculo el salario del empleado " + i);
                System.out.println("Salario empleado" + i + ": " + empleados[i].getSalario());
                System.out.println();
                totalSalarios += empleados[i].getSalario();
            } else {
                empleados[i].setSalario(calcularSalario(empleados, empleados[i]));
                System.out.println("Salario empleado" + i + ": " + empleados[i].getSalario());
                System.out.println(empleados[i].getSubordinados());
                System.out.println();
                totalSalarios += empleados[i].getSalario();
            }

        }

        System.out.println("TOTAL SALARIOS = " + totalSalarios);

    }

    public static Integer calcularSalario(Empleado[] empleados, Empleado empleado) {
        Integer salario = 0;
        if (empleado.getSubordinados().size() == 0) {
            empleado.setSalario(1);
            return empleado.getSalario();
        } else {
            for (int i = 0; i < empleado.getSubordinados().size(); i++) {
                salario += calcularSalario(empleados, empleados[empleado.getSubordinados().get(i)]);
            }

            return salario;
        }
    }

}
