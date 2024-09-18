package rh;
import java.util.concurrent.ThreadLocalRandom;

public class rh {

    static double Rh() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void main(String[] args) {

        double valorPretendido = 2000.00;
        String[] aprovados = new String[5];
        int aprovadosCount = 0;
        String[] espera = new String[10];
        String[] contra_proposta = new String[10];

        String[] candidatos = {
                "GIOVANE", "MÁRCIA", "GILVAN", "PAULO", "BRUNO",
                "MÔNICA", "GABRIEL", "RYDANC ", "RIAN", "LEANDRO",
                "ISMAEL", "FRANCISCO", "REBECA", "LUANE", "ISRAEL"
        };

        for (int i = 0; i < candidatos.length; i++) {
            double salarioPretendido = Rh();
            if (valorPretendido >= salarioPretendido && aprovadosCount < 5) {
                aprovados[aprovadosCount++] = candidatos[i];
                System.out.println("Ligar para " + candidatos[i]);
            } else if (valorPretendido == Rh()) {
                System.out.println("Ligar com uma contra proposta para o " + candidatos[i]);
            } else {
                System.out.println("AGUARDANDO RESULTADO DO CANDIDATO " + candidatos[i]);
            }
        }

        System.out.println("\nCandidatos selecionados:");
        for (int i = 0; i < aprovadosCount; i++) {
            System.out.println(aprovados[i]);
            int tentativas = 0;
            boolean contato = false;
            while (tentativas < 3 && !contato) {
                tentativas++;
                contato = ThreadLocalRandom.current().nextBoolean();
                if (contato) {
                    System.out.println("Conseguimos contato com " + aprovados[i] + " após " + tentativas + " tentativa(s)");
                }
            }
            if (!contato) {
                System.out.println("Não conseguimos contato com o candidato " + aprovados[i]);
            }
        }
    }
}