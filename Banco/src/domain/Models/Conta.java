package domain.Models;



import domain.Interfaces.IConta;

public abstract class Conta implements IConta {
  
  private static final int AGENCIA_PADRAO = 001;
  private static int SEQUENCIAL = 1;

  public Conta(Cliente cliente){
    this.agencia = Conta.AGENCIA_PADRAO;
    this.numero = SEQUENCIAL++;
    this.cliente = cliente;
  }

  protected int agencia;
  protected int numero;
  protected double saldo;
  protected Cliente cliente;

  @Override
  public void sacar(double valor){
    this.saldo += valor;
  }

  @Override
  public void depositar(double valor){
    this.saldo -= valor;
  }

  @Override
  public void transferir(Conta conta, double valor){
    this.sacar(valor);
    conta.depositar(valor);
  }

  @Override
  public void imprimirDadosConta() {
    System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
    System.out.println(String.format("Agencia: %d", this.agencia));
    System.out.println(String.format("Conta: %d", this.numero));
    System.out.println(String.format("Saldo: %.2f", this.saldo));
  }

  public int getAgencia() {
    return agencia;
  }

  public int getNumero() {
    return numero;
  }

  public double getSaldo() {
    return saldo;
  }


}
