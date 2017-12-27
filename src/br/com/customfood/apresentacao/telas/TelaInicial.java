package br.com.customfood.apresentacao.telas;

import br.com.customfood.apresentacao.telas.Cliente.MenuCliente;
import br.com.customfood.apresentacao.telas.Funcionario.MenuFuncionario;
import br.com.customfood.excecoes.CpfInvalidoException;
import br.com.customfood.util.Cpf;
import br.com.customfood.util.Login;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TelaInicial {

    private static Login login = new Login();
    public static void telaLogin() throws IOException, ClassNotFoundException {
        String nome, cpf_numero;
        Cpf cpf;
        Scanner sc = new Scanner(System.in);

        GregorianCalendar gc = new GregorianCalendar();

        //c.isLeapYear(2017);  Se é bissexto ou não


       int hora = gc.get(Calendar.HOUR_OF_DAY);
       //System.out.println(hora);
       String saudacao = null;
       if(hora >= 0 && hora <= 11){
          saudacao = "BOM DIA";
       }else if(hora > 11 && hora <= 17){
           saudacao = "BOA TARDE";
       }else{
           saudacao = "BOA NOITE";
       }

                                                        //argumento
        System.out.println("="+saudacao+"======HOJE: "+data(gc)+"======");
        System.out.println("=CUSTOM FOOD==========BEM VINDO=======");
        System.out.println("=============TELA DE LOGIN============");
        System.out.print("Login: ");
        nome = sc.next();
        System.out.print("CPF: ");
        cpf_numero = sc.next();
        System.out.println("======================================");
        
        try{
            cpf = new Cpf(cpf_numero);
            
            switch(login.validarSenha(nome, cpf)) {

                case "admin":
                    MenuFuncionario.escolher();
                    break;

                case "cliente":
                    MenuCliente.escolher();
                    break;

                default:
                    System.out.println("Login nao encontrado.");
                    break;
                }
        }catch (CpfInvalidoException e ) {
            System.out.println(e.getMessage());
        }
    }
                            //parametro
    public static String data(Calendar c){
        //Exibe data atual
        //A contagem dos meses inicia em 0, por tanto deve-se somar + 1 para que seja exibido o mes correto
        //Utiliza-se o string.format para formatar o dia e o mes com dois digitos, e o ano com 4 digitos
        return  String.format("%02d",c.get(Calendar.DAY_OF_MONTH)) + "/" +
                String.format("%02d", (c.get(Calendar.MONTH) + 1)) + "/" +
                String.format("%02d",c.get(Calendar.YEAR));
    }

}