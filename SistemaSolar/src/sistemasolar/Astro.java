/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Sphere;
//Para la figura
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CullFace;

/**
 * Clase que representa a todos los astros alrededor de los cuales pueden girar
 * otros astros.
 * @author blackzafiro
 */
public class Astro {

	/**
	 * Panel sobre el cual se dibuja este astro y sus satélites.
	 */
	protected Pane nodo;

	/**
	 * Figura que representa a este astro.
	 */
	protected Sphere figura;

	/**
	 * Constructor.
	 * @param diametro Pixeles de diámetro.
	 */
	public Astro(double diametro, String textura) {
		nodo = new StackPane();

	  nodo.setMaxSize(100, 100);
		figura = new Sphere(diametro);
		Image relleno = new Image (textura);
		PhongMaterial mat = new PhongMaterial();
      mat.setSelfIlluminationMap(relleno);
			mat.setDiffuseMap(relleno);
			figura.setMaterial(mat);

		nodo.getChildren().add(figura);
	}

	/**
	 * Devuelve al panel sobre el cual se dibujará este astro y sus satélites.
	 * @return nodo
	 */
	public Pane getNodo() {
		return nodo;
	}

	/**
	 * Devuelve el nodo figura que dibuja a este astro.
	 * Sus coordenadas son relativas al panel que la contiene.
	 * @return
	 */
	public Node getFigura() {
		return figura;
	}

}
