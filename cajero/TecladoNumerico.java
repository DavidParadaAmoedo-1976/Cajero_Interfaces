package cajero;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * Teclado numérico en pantalla, reutilizable en varias pantallas.
 *
 *   [ 1 ] [ 2 ] [ 3 ]
 *   [ 4 ] [ 5 ] [ 6 ]
 *   [ 7 ] [ 8 ] [ 9 ]
 *   [ , ] [ 0 ] [ ← ]
 */
// TODO A2.1 — INICIO: Layout del teclado (apartado A2)
//   Nombres que usan los tests: TecladoNumerico (id "teclado", clase "teclado");
//   teclas con clase "tecla" e ids tecla0 … tecla9, teclaComa y teclaBorrar,
//   en 4 filas x 3 columnas con el orden de TECLAS. Obligatorio: comentario // LAYOUT:.
public class TecladoNumerico extends GridPane {
// TODO A2.1 — FIN

    private static final String[] TECLAS = { "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", "0", "←" };
    private final List<Button> BOTONES = new ArrayList();
    private TextField destino;

    public TecladoNumerico(boolean conComa) {
        setId("teclado");
        getStyleClass().add("teclado");
        for (int i = 0; i < TECLAS.length; i++) {
            String t = TECLAS[i];
            Button tecla = new Button(t);
            tecla.getStyleClass().add("tecla");
            tecla.setId("tecla" + (t.equals(",") ? "Coma" : t.equals("←") ? "Borrar" : t));
            tecla.setOnAction(e -> pulsar(t));
            if (t.equals(",") && !conComa) {
                tecla.setDisable(true);
            }
            BOTONES.add(tecla);
            for(Button item: BOTONES){
                for (int f=0;f<3;f++){
                    for (int c=0; c<4; c++){
                    }
                }
            set.add(tecla);
            }
            // TODO D2.1 — INICIO: Las teclas no reciben el foco (apartado D2)
            //   Se comprueba: las teclas (clase "tecla") no reciben el foco.
            // TODO D2.1 — FIN
            // TODO A2.2 — INICIO: Colocar cada tecla en su fila y columna (apartado A2)
            //   Se comprueba: cada tecla en su fila y columna, según el dibujo de arriba.
            // TODO A2.2 — FIN
        
    }

    /** Campo en el que escribe el teclado. Un PasswordField también es un TextField. */
    public void setDestino(TextField campo) {
        this.destino = campo;
    }

    private void pulsar(String tecla) {
        if (destino == null) {
            return;
        }
        if (tecla.equals("←")) {
            String texto = destino.getText();
            if (!texto.isEmpty()) {
                destino.setText(texto.substring(0, texto.length() - 1));
            }
        } else {
            destino.appendText(tecla);
        }
        destino.positionCaret(destino.getText().length());
    }
}
