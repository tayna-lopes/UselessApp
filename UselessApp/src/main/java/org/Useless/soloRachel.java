package org.Useless;

public class soloRachel {
    private int nEpisodio;
    private String musica;
    private String versaoOriginal;
    private int nota;

    public soloRachel(){
    }

    public soloRachel(int nEpisodio,String musica,String versaoOriginal,int nota){
        this.nEpisodio=nEpisodio;
        this.musica=musica;
        this.versaoOriginal=versaoOriginal;
        this.nota=nota;
    }
    public int getnEpisodio() {
        return nEpisodio;
    }

    public void setnEpisodio(int nEpisodio) {
        this.nEpisodio = nEpisodio;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getVersaoOriginal() {
        return versaoOriginal;
    }

    public void setVersaoOriginal(String versaoOriginal) {
        this.versaoOriginal = versaoOriginal;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    public String toString() {
        return getMusica() +
                " [Episódio:" + getnEpisodio() +
                ", Versão Original: " + getVersaoOriginal() + ", Nota: " + getNota() + "]" ;
    }
}
