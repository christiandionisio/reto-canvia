package buenosamigos;

public class BuenosAmigos {

    public static void main(String[] args) {
        Long D = 10000000000L;
        Integer M = 1;
        Long D1 = 100000000000L;
        Integer N = 1;
        Long D2 = 10L;

        Long camino = 2*D;
        Long recorridoMaximoPorPersona = Math.max(D1, D2);
        Integer personasAyudando = 0;

        if (D >= recorridoMaximoPorPersona) {
            System.out.println(-1);
        }

        if (recorridoMaximoPorPersona < camino) {
            System.out.println("Mas de una persona debe ayudar");
            if (recorridoMaximoPorPersona == D1) {
                for (int i = 0; i < M; i++) {
                    personasAyudando++;
                    camino = camino - D1;
                    if (camino <= 0) {
                        camino = 0L;
                        break;
                    } else {
                        camino = camino*2;
                        System.out.println("Queda " + camino + " del camino");
                    }

                }
                for (int i = 0; i < N; i++) {
                    personasAyudando++;
                    camino = camino - D2;
                    if (camino <= 0) {
                        camino = 0L;
                        break;
                    } else {
                        camino = camino*2;
                        System.out.println("Queda " + camino + " del camino");
                    }

                }
            } else {
                for (int i = 0; i < N; i++) {
                    personasAyudando++;
                    camino = camino - D2;
                    if (camino <= 0) {
                        camino = 0L;
                        break;
                    } else {
                        camino = camino*2;
                        System.out.println("Queda " + camino + " del camino");
                    }

                }
                for (int i = 0; i < M; i++) {
                    personasAyudando++;
                    camino = camino - D1;
                    if (camino <= 0) {
                        camino = 0L;
                        break;
                    } else {
                        camino = camino*2;
                        System.out.println("Queda " + camino + " del camino");
                    }

                }
            }
        } else {
            System.out.println("Solo es necesaria una persona");
            personasAyudando ++;
            camino = 0L;
        }

        if (camino > 0) {
            System.out.println(-1);
        } else {
            System.out.println(personasAyudando);
        }
    }
}
