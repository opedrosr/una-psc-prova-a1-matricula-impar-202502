//Pedro hnrique  soares de oliveira 
//RA: 325119201


import java.util.Scanner;

public class MonitoramentoJumentos {

    public static void main(String[] args) {
        
     int populacaoInicial = 1400000;
        int populacaoAtual = 84000;
        

        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos anos futuros você quer simular o impacto dos abates? ");
        int anosSimulados = scanner.nextInt();

        
        double taxaReducao = calcularTaxaReducao(populacaoInicial, populacaoAtual);
        System.out.printf("Análise Inicial - Taxa de Redução Histórica: %.2f%%\n", taxaReducao);

      
        boolean riscoCritico = estaEmRiscoCritico(taxaReducao);
        if (riscoCritico) {
            System.out.println("Status - Espécie em Risco crítico (Redução > 90%)!");
        } else {
            System.out.println("Status  - Espécie não está em risco crítico.");
        }

      
        int populacaoRestante = simularImpactoAbate(populacaoAtual, 50000, anosSimulados);

        exibirDeclaracaoFinal(populacaoRestante, anosSimulados);
        
      
        scanner.close();
    }


    public static double calcularTaxaReducao(int populacaoInicial, int populacaoAtual) {
        return (1 - ((double) populacaoAtual / populacaoInicial)) * 100;
    }

    
    public static boolean estaEmRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90;
    }

    
    public static int simularImpactoAbate(int populacaoAtual, int abatesAnuais, int anosSimulados) {
        return populacaoAtual - (abatesAnuais * anosSimulados);
    }

    
    public static void exibirDeclaracaoFinal(int populacaoRestante, int anos) {
        System.out.println(" RESULTADO DA SIMULAÇÃO");
        System.out.printf("População restante após %d anos: %d jumentos.\n", anos, populacaoRestante);
        
        if (populacaoRestante <= 0) {
            System.out.println("Alerta A espécie pode ter sido extinta!");
        } else {
            System.out.println("Ainda há esperança! Iniciativas de conservação são vitais.");
        }
        
        System.out.println("Programa de Monitoramento Finalizado.");
    }
}
