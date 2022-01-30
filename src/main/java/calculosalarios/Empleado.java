package calculosalarios;

import java.util.List;

public class Empleado {

    private List<Integer> subordinados;
    private Integer salario;

    public List<Integer> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(List<Integer> subordinados) {
        this.subordinados = subordinados;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "subordinados=" + subordinados +
                ", salario=" + salario +
                '}';
    }
}
