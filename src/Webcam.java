
/**
 * The Webcam class represents a webcam device with properties such as resolution, frames per second (fps),
 * and its current state (on or off). It provides methods to turn the webcam on and off, and to capture a photo.
 * The estimated file size of the captured photo is calculated based on the resolution and fps.
 * 
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * Webcam miCamara = new Webcam("1920x1080", 30);
 * miCamara.tomarFoto(); // Attempt with the camera off
 * miCamara.encender();
 * miCamara.tomarFoto(); // With the camera on
 * miCamara.apagar();
 * }
 * </pre>
 * 
 * <p>Class Invariants:</p>
 * <ul>
 * <li>The resolution must be in the format "widthxheight" (e.g., "1920x1080").</li>
 * <li>The fps (frames per second) must be defined.</li>
 * </ul>
 * 
 * <p>Preconditions:</p>
 * <ul>
 * <li>The webcam must be turned on (encendida must be true) to capture a photo.</li>
 * </ul>
 * 
 * <p>Postconditions:</p>
 * <ul>
 * <li>If the webcam is off, an error message is printed when attempting to capture a photo.</li>
 * <li>If the webcam is on, the resolution and estimated file size of the photo are printed.</li>
 * </ul>
 */
public class Webcam {

    private String resolucion;
    private int fps;
    private boolean encendida;
    private double tamanoArchivo;

    // Constructor
    public Webcam(String resolucion, int fps) {
        this.resolucion = resolucion;
        this.fps = fps;
        this.encendida = false;
    }

    // Getters y Setters
    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void encender() {
        this.encendida = true;
        System.out.println("Cámara encendida.");
    }

    public void apagar() {
        this.encendida = false;
        System.out.println("Cámara apagada.");
    }

    /**
     * Captures a photo using the webcam. If the webcam is not turned on, it prints an error message.
     * The method calculates the estimated file size of the photo based on the resolution and frames per second (fps).
     * 
     * Preconditions:
     * - The webcam must be turned on (encendida must be true).
     * - The resolution must be in the format "widthxheight" (e.g., "1920x1080").
     * - The fps (frames per second) must be defined.
     * 
     * Postconditions:
     * - Prints an error message if the webcam is off.
     * - Prints the resolution and estimated file size of the photo if the webcam is on.
     */
    public void tomarFoto() {
        if (!encendida) {
            System.out.println("Error: La cámara está apagada.");
            return;
        }

        String[] dimensiones = resolucion.split("x");
        int ancho = Integer.parseInt(dimensiones[0]);
        int alto = Integer.parseInt(dimensiones[1]);

        tamanoArchivo = (ancho * alto * fps) / 1000000.0;

        System.out.println("Foto tomada con resolución " + resolucion +
                           " y tamaño estimado de archivo: " + tamanoArchivo + " MB.");
    }

    // Método principal para probar la clase
    /**
     * The main method serves as the entry point for the application.
     * It demonstrates the usage of the Webcam class by performing the following actions:
     * 1. Creates a new Webcam instance with a resolution of 1920x1080 and a frame rate of 30 fps.
     * 2. Attempts to take a photo with the camera turned off.
     * 3. Turns on the camera.
     * 4. Takes a photo with the camera turned on.
     * 5. Turns off the camera.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Webcam miCamara = new Webcam("1920x1080", 30);

        miCamara.tomarFoto(); // Intento con cámara apagada
        miCamara.encender();
        miCamara.tomarFoto(); // Con cámara encendida
        miCamara.apagar();
    }
}
