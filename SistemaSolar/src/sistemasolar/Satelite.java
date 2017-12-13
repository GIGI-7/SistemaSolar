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
		LUNA(0.273, ESCALA_ORBITA_SATELITE * 0.00257, ESCALA_ORBITA_SATELITE * 0.002566, 0.0739, "https://brazenbelles.files.wordpress.com/2012/01/silver_glitter.jpg"),

		MERCURIO(0.56,ESCALA_ORBITA_SATELITE *0.0056,ESCALA_ORBITA_SATELITE * 0.0056 , 0.2056, "https://main-designyoutrust.netdna-ssl.com/wp-content/uploads/2012/09/black-background-metal-texture-wallpaper-1280x720-750x421.jpg"),
		VENUS(0.81,ESCALA_ORBITA_SATELITE*0.0081,ESCALA_ORBITA_SATELITE * 0.0081,0.8, "http://cdn.mysitemyway.com/etc-mysitemyway/webtreats/assets/posts/765/thumbs/warm-amber-patterns-2.jpg"),
		TIERRA(1.0, ESCALA_ORBITA_SATELITE*0.01, ESCALA_ORBITA_SATELITE*0.0099, 1.0, "https://svs.gsfc.nasa.gov/vis/a000000/a002900/a002915/bluemarble-1024.png"),
		MARTE (0.7,ESCALA_ORBITA_SATELITE*0.016 ,ESCALA_ORBITA_SATELITE*0.016, 1.5, "http://images.all-free-download.com/images/graphiclarge/red_shading_background_05_hd_pictures_169759.jpg"),
		JUPITER (2, ESCALA_ORBITA_SATELITE *0.03  , ESCALA_ORBITA_SATELITE* 0.03, 1.7, "http://www.todoelsistemasolar.com.ar/imagenes/jupiter-mancha-hd.jpg"),
		LUNAG1(0.273, ESCALA_ORBITA_SATELITE * 0.0026, ESCALA_ORBITA_SATELITE * 0.002566, 0.0739,"https://brazenbelles.files.wordpress.com/2012/01/silver_glitter.jpg"),
    LUNAG2(0.273, ESCALA_ORBITA_SATELITE * 0.0026 	, ESCALA_ORBITA_SATELITE * 0.002569, 0.08, "https://brazenbelles.files.wordpress.com/2012/01/silver_glitter.jpg"),
		LUNAG3(0.273, ESCALA_ORBITA_SATELITE * 0.0026, ESCALA_ORBITA_SATELITE * 0.002566, 0.0939, "https://brazenbelles.files.wordpress.com/2012/01/silver_glitter.jpg"),
		LUNAG4(0.273, ESCALA_ORBITA_SATELITE * 0.0025, ESCALA_ORBITA_SATELITE * 0.002567, 0.0639, "https://brazenbelles.files.wordpress.com/2012/01/silver_glitter.jpg"),

		SATURNO (1.7,ESCALA_ORBITA_SATELITE*0.04 , ESCALA_ORBITA_SATELITE*0.04, 1.9 , "https://i.pinimg.com/originals/97/fc/bf/97fcbfd754336ef5239c7427be1b4e15.jpg"),
		URANO (1.3, ESCALA_ORBITA_SATELITE*0.05,ESCALA_ORBITA_SATELITE*0.05,1.999, "https://static.tumblr.com/e144954cdc37cbe4432fad75a75b5217/zaalm7n/z6Soltc2b/tumblr_static_tumblr_static_24zakln09bpc848k00kwsgw4s_640.jpg"),
		NEPTUNO(1.9, ESCALA_ORBITA_SATELITE * 0.06, ESCALA_ORBITA_SATELITE*0.06,2.0, "http://t.motionelements.com/stock-video/science-technology/me1651289-electric-background-abstract-animation-hd-a0120-poster.jpg"),
		PLUTON(1.0,ESCALA_ORBITA_SATELITE * 0.07 , ESCALA_ORBITA_SATELITE*0.07, 1.5, "http://outletminero.org/content/images/2016/02/TUBOS-DE-COBRE.jpg");
		;

		private final double diametroEcuatorial;
		private final double semiejeMayor;
		private final double semiejeMenor;
		private final double periodoOrbital;
		private final String url;


		DatosSatelite(double diametroEcuatorial,
				double semiejeMayor, double semiejeMenor,
				double periodoOrbital, String url ) {
			this.diametroEcuatorial = diametroEcuatorial;
			this.semiejeMayor = semiejeMayor;
			this.semiejeMenor = semiejeMenor;
			this.periodoOrbital = periodoOrbital;
			this.url = url ;
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
		super(datos.diametroEcuatorial * ESCALA_RADIO, datos.url);
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
