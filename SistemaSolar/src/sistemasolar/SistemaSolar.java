/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import static javafx.application.Application.launch;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.ImageView;

/**
 * Simulación del sistema solar utilizando JavaFX
	 * https://docs.oracle.com/javase/8/javafx/api/index.html
 * @author blackzafiro
 */
public class SistemaSolar extends Application {

	private final static int ANCHO_VENTANA_INICIAL = 1200;
	private final static int ALTO_VENTANA_INICIAL = 800;
	private final static int RADIO_SOL = 30;

	private Astro sol;
	private Satelite luna;

	private Satelite mercurio;
	private Satelite venus;
	private Satelite tierra;

	private Satelite marte;
	private Satelite lunaM1;
	private Satelite lunaM2;

	private Satelite jupiter;
	private Satelite lunaGalileo1;
	private Satelite lunaGalileo2;
	private Satelite lunaGalileo3;
	private Satelite lunaGalileo4;

	private Satelite saturno;
	private Satelite lunaTitan;

	private Satelite urano;
	private Satelite lunaU1;
	private Satelite lunaU2;
 	private Satelite lunaU3;

	private Satelite neptuno;
	private Satelite pluton;

	public static int getSolCentroX() {
		return ANCHO_VENTANA_INICIAL/2;
	}

	public static int getSolCentroY() {
		return ALTO_VENTANA_INICIAL/2;
	}

	/**
	 * Crea al sol, los planteas y sus satélites, asignando quien gira
	 * alrededor de quien.
	 */
	private void creaAstros() {
		sol = new Astro(RADIO_SOL);
		mercurio = new Satelite(Satelite.DatosSatelite.MERCURIO , sol);
		venus = new Satelite(Satelite.DatosSatelite.VENUS, sol);

		tierra = new Satelite(Satelite.DatosSatelite.TIERRA, sol);
		luna = new Satelite(Satelite.DatosSatelite.LUNA, tierra);

		marte = new Satelite(Satelite.DatosSatelite.MARTE,sol);
		lunaM1 = new Satelite(Satelite.DatosSatelite.LUNAG2, marte);
		lunaM2 = new Satelite(Satelite.DatosSatelite.LUNAG1 , marte);

		jupiter = new Satelite(Satelite.DatosSatelite.JUPITER, sol);
		lunaGalileo1 = new Satelite(Satelite.DatosSatelite.LUNAG1, jupiter);
		lunaGalileo2 = new Satelite(Satelite.DatosSatelite.LUNAG2, jupiter);
		lunaGalileo3 = new Satelite(Satelite.DatosSatelite.LUNAG3, jupiter);
		lunaGalileo4 = new Satelite(Satelite.DatosSatelite.LUNAG4, jupiter);

		saturno = new Satelite(Satelite.DatosSatelite.SATURNO, sol);
		lunaTitan = new Satelite(Satelite.DatosSatelite	.LUNA, saturno);

		urano = new Satelite (Satelite.DatosSatelite.URANO, sol);
		lunaU1 = new Satelite(Satelite.DatosSatelite.LUNAG1, urano);
		lunaU2 = new Satelite(Satelite.DatosSatelite.LUNAG2, urano);
		lunaU3 = new Satelite(Satelite.DatosSatelite.LUNAG3, urano);

		neptuno = new Satelite (Satelite.DatosSatelite.NEPTUNO, sol);



	}

	/**
	 * Crea la escena y agrega los primeros nodos, sobre los cuales
	 * se han agregado a los demás astros.
	 * @return la escena con el sol, planetas y satélites.
	 */
	private Scene montaNodos() {

		AnchorPane root = new AnchorPane();
		root.setLayoutX(getSolCentroX() - RADIO_SOL);
		root.setLayoutY(getSolCentroY() - RADIO_SOL);
		root.getChildren().add(sol.getNodo());
		//Fondo ?
		//AQUI IRIA EL FONDO SI TUVIERA UNO
		String fondo = "https://wallpapercave.com/wp/jnSCcKU.jpg";
		root.setStyle("-fx-background-image: url('" + fondo + "'); " );



		Scene scene = new Scene(root, ANCHO_VENTANA_INICIAL, ALTO_VENTANA_INICIAL);
		return scene;
	}

	/**
	 * Acomoda los elementos en la intefaz e inicia la animación.
	 * @param primaryStage
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		creaAstros();

		Scene scene = montaNodos();
		primaryStage.setTitle("Sistema Solar :)");
    primaryStage.setScene(scene);
		primaryStage.show();

	}

	/**
	 * Inicia la simulación.
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
    }

}
