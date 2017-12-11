/*
 * Código utilizado para el curso de Introducción a las Ciencias de la
 * Computación.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package sistemasolar;

/**
 * Clase que describe astros que giran alrededor de otro.
 * @author blackzafiro
 */
public class Satelite extends Astro {

	// Escala para dibujar a los planetas
	private static final double ESCALA_RADIO = 10.0;
	private static final double ESCALA_ORBITA = 400.0;
	private static final double ESCALA_ORBITA_SATELITE = ESCALA_RADIO * 2;
	private static final double ESCALA_TIEMPO = 15.0;

	/**
	 * Datos de cada planeta y satélite.
	 * Deben ser ficticios, pues de otro modo la simulación no cabe en pantalla.
	 */
	public enum DatosSatelite {
		LUNA(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.0739),

		MERCURIO(0.56,ESCALA_ORBITA_SATELITE *0.0056,ESCALA_ORBITA_SATELITE * 0.0056 , 0.2056),
		VENUS(0.81,ESCALA_ORBITA_SATELITE*0.0081,ESCALA_ORBITA_SATELITE * 0.0081,0.8),
		TIERRA(1.0, ESCALA_ORBITA_SATELITE*0.01, ESCALA_ORBITA_SATELITE*0.0099, 1.0),
		MARTE (0.7,ESCALA_ORBITA_SATELITE*0.015 ,ESCALA_ORBITA_SATELITE*0.015, .82),
		JUPITER (2, ESCALA_ORBITA_SATELITE *0.03  , ESCALA_ORBITA_SATELITE* 0.03, 0.9),
		LUNAG1(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.0739),
    LUNAG2(0.273, ESCALA_ORBITA_SATELITE * 0.00259 	, ESCALA_ORBITA_SATELITE * 0.002569, 0.08),
		LUNAG3(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.0939),
		LUNAG4(0.273, ESCALA_ORBITA_SATELITE * 0.00258, ESCALA_ORBITA_SATELITE * 0.002567, 0.0639),

		SATURNO (1.7,ESCALA_ORBITA_SATELITE*0.04 , ESCALA_ORBITA_SATELITE*0.04, 0.7),
		URANO (1.3, ESCALA_ORBITA_SATELITE*0.05,ESCALA_ORBITA_SATELITE*0.05,0.7),
		NEPTUNO(1.9, ESCALA_ORBITA_SATELITE * 0.06, ESCALA_ORBITA_SATELITE*0.06,0.6);
		//LUNA_LUNA(0.17, (ESCALA_ORBITA_SATELITE * 0.00257)/2.1, (ESCALA_ORBITA_SATELITE * 0.002566)/2.1, 0.036);
		;

		private final double diametroEcuatorial;
		private final double semiejeMayor;
		private final double semiejeMenor;
		private final double periodoOrbital;


		DatosSatelite(double diametroEcuatorial,
				double semiejeMayor, double semiejeMenor,
				double periodoOrbital) {
			this.diametroEcuatorial = diametroEcuatorial;
			this.semiejeMayor = semiejeMayor;
			this.semiejeMenor = semiejeMenor;
			this.periodoOrbital = periodoOrbital;
		}
	}

	/// Inician atributos

	private final DatosSatelite datos;
	private OrbitaTransition orbita;
	private Astro foco;


	/// Inician métodos

	/**
	 * Astro alrededor del cual gira este satélite.
	 * @return astro alrededor del cual girar este satélite.
	 */
	public Astro getFoco() {
		return foco;
	}

	/**
	 * Crea la órbita de este planea y lo pone a girar alrededor del foco.
	 */
	private void creaOrbita(Astro foco) {
		foco.getNodo().getChildren().add(this.nodo);
		this.foco = foco;

		orbita = new OrbitaTransition(this,
									  datos.semiejeMayor * ESCALA_ORBITA,
									  datos.semiejeMenor * ESCALA_ORBITA,
									  datos.periodoOrbital * ESCALA_TIEMPO
		);
		orbita.play();
	}

	/**
	 * Constructor.
	 * @param datos información del astro y su órbita.
	 * @param foco astro alrededor del cual gira este satélite.
	 */
	public Satelite(DatosSatelite datos, Astro foco) {
		super(datos.diametroEcuatorial * ESCALA_RADIO);
		this.datos = datos;
		creaOrbita(foco);
	}

	/**
	 * Devuelve el nombre de este satélite.
	 * @return nombre
	 */
	public String getNombre() {
		return this.datos.toString();
	}
}
