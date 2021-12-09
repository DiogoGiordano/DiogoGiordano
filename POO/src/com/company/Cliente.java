package com.company;

public class Cliente {
    private String nome;
    private long telefone;
    private long CEP;
    private boolean situacao;
    private double renda;
    private String pais;
    private String cidade;
    private String rua;
    private int casa;


    //construtor de cliente
    public Cliente(String nome) {
        this.nome = nome;
        telefone = 0;
        renda = 0;
        CEP = 0;
        situacao = false;
        pais = " ";
        cidade = " ";
        rua = " ";
        casa = 0;
    }

    public String getNome() {
        return nome;
    }
    public long getTelefone() {
        return telefone;
    }
    public long getCEP() {
        return CEP;
    }
    public boolean getSituacao() {
        return situacao;
    }
    public double getRenda() {
        return renda;
    }
    public String getEndereco() {
        return "Pa�s: "+ pais +" Cidade: "+ cidade +" Rua: "+ rua +" N�mero: "+casa;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    public void setRenda(double renda) {
        this.renda = renda;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setCasa(int casa) {
        this.casa = casa;
    }


    //verifica qual a situacap do cliente
    public String verificaSituacao() {
        if(situacao) {
            return "Ativa";
        }
        return "Inativa";
    }


    //retorna as informacoes do cliente
    public String toString() {
        return "Nome: "+ nome + " Telefone: "+ telefone + " Situa��o: "+ verificaSituacao()+ " Renda: "+ renda+ "\n"+ getEndereco();
    }

}
