package com.company;

public class ContaCorrente extends Conta {

    public ContaCorrente(String nome, Cliente cliente, int senha) {
        super(nome, cliente, senha);
    }

    /*A conta corrente permite as seguintes operações:
    abrir a conta, encerrar a conta, validar a senha, verificar o saldo,
     sacar um valor e depositar um valor.
     A operação de saque é efetuada somente se
     o saldo da conta é igual ou superior ao valor que deve ser sacado.
     A operação de depósito é efetuada se o valor a ser depositado é maior do que zero.*/



    //Deposita o valor na conta
    public boolean deposito(double valor) {
        //A operação só sera efetuada se a conta estiver ativa.
        if(verificaSituacao().equals("Ativa")) {
            //A operação de depósito é efetuada se o valor a ser depositado é maior do que zero.
            if(valor > 0) {
                setSaldo(getSaldo() + valor);
                return true;
            }
        }
        return false;
    }

    //Apresenta o saldo da conta
    public boolean verificarSaldo()
    {
        //A operação só sera efetuada se a conta estiver ativa.
        if(verificaSituacao().equals("Ativa"))
        {
            getSaldo();
            return true;
        }
        return false;
    }


    //Saca o valor da conta
    public boolean saqueCC(double valor) {
        //A operação só sera efetuada se a conta estiver ativa.
        if(verificaSituacao().equals("Ativa")) {
            //A operação de saque é efetuada somente se o saldo da conta é igual ou superior ao valor que deve ser sacado.
            if (valor > getSaldo()) {
                return false;
            }
            setSaldo(getSaldo() - valor);
            return true;
        }
        return false;
    }


}
