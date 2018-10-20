package game;

public class Tamas {
    public Tama currentTama;
    private Tama[] allTamas;
    private int tamaIndex;

    public Tamas() {
        currentTama = new Tama();
        allTamas = new Tama[2];
        tamaIndex = 0;
    }

    public Tamas(Tama currentTama, Tama[] allTamas, int currentTamaIndex) {
        this.currentTama = currentTama;
        this.allTamas = allTamas;
        this.tamaIndex = currentTamaIndex;
    }

    public void setTamaIndex(int index) {
        if (index >= 0 && index < allTamas.length) {
            tamaIndex = index;
        }
    }

    public void setTamaIndex(String strs) {
        for (int i = 0; i < allTamas.length; i++) {
            if (allTamas[i].getName().equalsIgnoreCase(strs)) {
                tamaIndex = i;
                break;
            }
        }
    }

    public Tama getTama() {
        return allTamas[tamaIndex];
    }


    public int getTotalTamas() {
        return allTamas.length;
    }
}
