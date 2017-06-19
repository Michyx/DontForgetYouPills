package views;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;

public class Sonido {

    private BasicPlayer player;

    public BasicPlayer getPlayer() {
        return player;
    }

    public void agregarSonido() throws Exception {

        player = new BasicPlayer();
        try {
            String ruta = ("resources\\alarma.wav");
            abrirFichero(ruta);
            play();
        } catch (Exception e) {
        }

    }

    public void play() throws Exception {
        player.play();
    }

    public void abrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));
    }

    public void pausa() throws Exception {
        player.pause();
    }

    public void continuar() throws Exception {
        player.resume();
    }

    public void stop() throws Exception {
        player.stop();
    }

}
