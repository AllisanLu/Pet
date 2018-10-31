package game;

import java.util.Arrays;

public class Tamas {
    private Tama[] allTamas;
    private int tamaIndex;

    public Tamas(Tama[] allTamas, int currentTamaIndex) {
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
            if (!allTamas[i].getName().equalsIgnoreCase(strs)) {
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

    public String toString() {
        return Arrays.toString(allTamas);
    }
}
