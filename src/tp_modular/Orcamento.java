/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_modular;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author clara
 */
public class Orcamento implements Arquivo {
  
   private int codCliente;
   private float numeroHoras;
   private float valorHora;
   private List<ItemPedido> Materiais;
   private int validade;
   private int status;
   private boolean autorizado;
   private Date dataOrcamento;
   private float valorTotal;
   
    public void setNumeroHoras(float numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getNumeroHoras() {
        return numeroHoras;
    }

    public float getValorHora() {
        return valorHora;
    }
   
   public Orcamento(int cod, float numeroHoras, float valorHoras, int validade, boolean autorizado) {
       this.codCliente = cod;
       this.numeroHoras = numeroHoras;
       this.valorHora = valorHoras;
       this.validade = validade;
       this.autorizado = autorizado;
       this.Materiais = new ArrayList<ItemPedido>();
       this.dataOrcamento = new Date();
    }
   
   public void CriarOrcamento(int qtdMaterial, String descr, int qtd, float valor)
   {
      //System.out.println("Informe a quantidade de itens");
      //Scanner sc = new Scanner(System.in);;
      ItemPedido item;
      //String descr;
      //int qtdMaterial;
     // int qtd = sc.nextInt();
     // float valor;
      for(int i=0;i<qtd;i++)
      {
          //System.out.println("Informe a quantidade");
        // qtdMaterial = sc.nextInt();
         // System.out.println("Informe o item");
         // sc.nextLine();
         // descr = sc.nextLine();
         // System.out.println("Informe o valor");
         // valor = sc.nextFloat();
          item = new ItemPedido(qtdMaterial, descr, valor);
          this.AdicionarItem(item);
      }
      this.CalcularOrcamento();
      
   }
     
   protected void AdicionarItem(ItemPedido item)
   {
       this.Materiais.add(item);
   }
   
   protected void AutorizarOrcamento()
   {
       this.autorizado = true;
   }
   
   public void CalcularOrcamento()
   {
       ItemPedido item;
       float valor = 0;
       for (int i=0; i<this.Materiais.size(); i++)
       {
           item = this.Materiais.get(i);
           valor+=item.getValorFinalItem();
       }
       valor = valor + (this.getNumeroHoras() * this.getValorHora());
       this.valorTotal = valor;
   }
   
   protected void SalvarOrcamento()
   {
       
   }

    @Override
    public void LerArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void EscreverArquivo(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        buffWrite.append("Orcamento: \n");
        buffWrite.append("cod cliente: " + this.codCliente + "\n");
        buffWrite.append("data: " +this.dataOrcamento + "\n");
        buffWrite.append("validade: " +this.validade + "\n");
        buffWrite.append("autorizado: " +this.autorizado + "\n");
        for (int i=0; i<this.Materiais.size(); i++)
        {
           buffWrite.append("qtd:  " +this.Materiais.get(i).quantidade + " ");
           buffWrite.append("descricao:  " +this.Materiais.get(i).descricaoMaterial + " ");
           buffWrite.append("qtd:  " +this.Materiais.get(i).valor + "\n");
        }
        buffWrite.append("valor total: " +this.valorTotal + "\n");
        buffWrite.close();
    }
   
}
