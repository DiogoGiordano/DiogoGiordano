package com.company;

import java.util.Date;

public class Conta extends Cliente{
    private static  long geraNumeros = 10000;
    private long numero;
    private Date dataAbert;
    private Date dataEncer;
    private int senha;
    private double saldo;
    private boolean situacao;
    private Cliente cliente;
    private int quantContas;

    /*Uma conta bancária possui um número único,
    uma data de abertura, uma data de encerramento,
    uma situação (ativa ou inativa), uma senha,
    um saldo e é vinculada a um cliente do banco.
    Para que uma conta seja aberta é necessário que o cliente já esteja cadastrado.
    Uma conta é aberta como ativa e migra para inativa quando é encerrada.
    Somente contas inativas possuem data de encerramento válida.
    Todas as operações de uma conta bancária
    só podem ser efetuadas mediante a informação prévia da senha,
    à exceção da operação de abertura da conta.*/

    public Conta(String nome, Cliente cliente, int senha) {
        super(nome);
        numero = geraNumeros++;
        this.cliente = cliente;
        this.senha = senha;
        dataAbert = new Date();
        saldo = 0;
        situacao = true;
        cliente.setSituacao(situacao);
    }

    //toda vez que o cliente abre uma conta incrementa em 1 a quantidade de contas
    public void incrementaContas() {
        quantContas++;
    }


    //toda vez que o cliente encerra uma conta decrementa em 1 a quantidade de contas, se chegar a menor ou igual a zero
    //a situacao do cliente se torna "inativa"
    public void decrementaContas() {
        quantContas--;
        if(quantContas <= 0) {
            setSituacao(false);
        }
    }

    //verifica se a senha informada � igual a senha da conta
    public boolean verificaSenha(int senha) {
        return this.senha == senha;
    }

    //verifica a situacao da conta
    public String verificaSituacao() {
        if(situacao) {
            return "Ativa";
        }
        return "Inativa";
    }


    //reativa a conta se a conta estiver com a situacao "inativa" e incrementa na quantidade de contas do cliente
    public boolean ativaConta() {
        if(!situacao) {
            situacao = true;
            return true;
        }
        return false;
    }


    //encerra a conta se ela estiver ativa, muda sua situacao para "Inativa" e decrementa na quantidade de contas do cliente
    public boolean encerraConta() {
        if(situacao) {
            situacao = false;
            dataEncer = new Date();
            return true;
        }
        return false;
    }

    //retorna o numero da conta
    public long getNumeroConta() {
        return numero;
    }

    //retorna o saldo da conta
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo( double newSaldo ) { saldo = newSaldo; }

    //seta uma nova senha se a situcao da conta for ativa
    public boolean setSenha(int newSenha) {
        if(situacao) {
            senha = newSenha;
            return true;
        }
        return false;
    }


    //retorna as informacoes do cliente
    public String toString() {
        return "Nome cliente: "+ cliente.getNome() + " Numero: " + numero + " Saldo: "+ saldo + " Situa��o: " + verificaSituacao() + "\nData abertura: " + dataAbert + " Data encerramento: " + dataEncer;
    }

}
