package ejercicio16b.ejercicio16b.models;

public class likes {
    private int likeImagen1;
    private int likeImagen2;
    private int likeImagen3;

    public likes() {
    }

    public likes(int likeImagen1, int likeImagen2, int likeImagen3) {
        this.likeImagen1 = likeImagen1;
        this.likeImagen2 = likeImagen2;
        this.likeImagen3 = likeImagen3;
    }

    public int getLikeImagen1() {
        return likeImagen1;
    }

    public int getLikeImagen2() {
        return likeImagen2;
    }

    public int getLikeImagen3() {
        return likeImagen3;
    }

    public void setLikeImagen1(int likeImagen1) {
        this.likeImagen1 = likeImagen1;
    }

    public void setLikeImagen2(int likeImagen2) {
        this.likeImagen2 = likeImagen2;
    }

    public void setLikeImagen3(int likeImagen3) {
        this.likeImagen3 = likeImagen3;
    }

   
}