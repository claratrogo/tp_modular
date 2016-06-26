/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_modular;

/**
 *
 * @author clara
 * Essa classe define o objeto ItemPedido, que é um item
 * do orçamento. 
 */

public class ItemPedido {
    protected int quantidade;
    protected String descricaoMaterial;
    protected float valor;
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricaoMaterial() {
        return descricaoMaterial;
    }

    public void setDescricaoMaterial(String descricaoMaterial) {
        this.descricaoMaterial = descricaoMaterial;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
   
    
    ItemPedido (int qntd, String descricao, float valor)
    {
        this.quantidade = qntd;
        this.descricaoMaterial = descricao;
        this.valor = valor;
    }
    
    protected float getValorFinalItem()
    {
        float valor;
        valor = this.getQuantidade() * this.getValor();
        valor =  valor + (valor/20); // Calculo do ISS
        return valor;        
    }
}
