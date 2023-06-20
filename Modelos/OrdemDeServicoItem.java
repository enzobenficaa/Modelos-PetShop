/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

public class OrdemDeServicoItem {
    private int idItemServico;
    private OrdemDeServicoItem ordemdeservico;
    private Servicos servico;
    private Animal animal;

    public int getIdItemServico() {
        return idItemServico;
    }

    public void setIdItemServico(int idItemServico) {
        this.idItemServico = idItemServico;
    }

    public OrdemDeServicoItem getOrdemdeservico() {
        return ordemdeservico;
    }

    public void setOrdemdeservico(OrdemDeServicoItem ordemdeservico) {
        this.ordemdeservico = ordemdeservico;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    
}
