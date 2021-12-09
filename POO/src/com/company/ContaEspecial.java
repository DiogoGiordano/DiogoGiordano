package com.company;

public class ContaEspecial extends ContaCorrente {

    private double limite;


    /*A conta especial é uma conta corrente que possui um limite, ou seja,
    a operação de saque considera o saldo da conta acrescido do limite
    para decidir se o saque é efetuado ou não. Além das operações da conta corrente,
    a conta especial permite alterar o limite.*/

    public ContaEspecial(String nome, Cliente cliente, int senha, double limite) {
        super(nome, cliente, senha);
        this.limite = limite;
    }


    //Altera o limite da conta
    public boolean alterarLimite(int nLimite)
    {
        //A operação só sera efetuada se a conta estiver ativa.
        if(verificaSituacao().equals("Ativa")) {
            if(nLimite > 0) {
                setLimite(nLimite);
                return true;
            }
            return false;
        }
        return false;
    }


    //Apresenta o limite da conta
    public boolean verificarLimite()
    { //A operação só sera efetuada se a conta estiver ativa.
        if(verificaSituacao().equals("Ativa")) {
            getLimite();
            return true;
        }
        return false;
    }


    public boolean saqueCE(double valor)
    {
        //A operação só sera efetuada se a conta estiver ativa.
        if(verificaSituacao().equals("Ativa")) {
            //"A operação de saque considera o saldo da conta acrescido do limite para decidir se o saque é efetuado ou não"
            if (valor <= getSaldo() + getLimite()) {
                saqueCC(valor);
                return true;
            }
            return true;
        }
        return false;
    }


    private void setLimite(double newLimite) { limite = newLimite; }
    private double getLimite() { return limite; }

}
