package game;

public class Tamas implements java.io.Serializable {
    private Tama[] allTamas;
    private int tamaIndex;


    /**
     * Creates two new Tama Objects with default values to be placed into allTamas.
     */
    public Tamas() {
        tamaIndex = 0;
        allTamas = new Tama[2];

        String[] paths = {Constants.Paths.JERRY, Constants.Paths.TERRY};
        for (int i = 0; i < allTamas.length; i++)
            allTamas[i] = new Tama(paths[i]);
    }

    public void setTamaIndex(int index) {
        if (index >= 0 && index < allTamas.length) {
            tamaIndex = index;
        }
    }

    public void updateTamaPics() {
        for(Tama tama : allTamas) {
            tama.setTamaPic();
        }
    }

    public int getTamaIndex() {
        return tamaIndex;
    }

    public Tama getTama() {
        return allTamas[tamaIndex];
    }

    public Tama[] getallTamas() {
        return allTamas;
    }

    public int getTotalTamas() {
        return allTamas.length;
    }
}
