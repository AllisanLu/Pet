package game;

import java.io.File;

public class Constants {

    public static class Files {

        //File where the informaton is saved
        public static final File SAVED_DATA = new File("bin/SAVED_DATA.txt");
    }

    public static class Paths {
        //Paths to the different folders containing images.
        public static final String PROJECT = Files.class.getResource("").getPath();
        public static final String IMAGES = PROJECT + "Images/";
        public static final String BACKGROUND = IMAGES + "background/";
        public static final String BUTTONS = IMAGES + "buttons/";
        public static final String JERRY = IMAGES + "jerry/";
        public static final String TERRY = IMAGES + "terry/";
    }

    public static class GUIDimensions {
        public static final int GUI_WIDTH = 206;
        public static final int GUI_HEIGHT = 279;
    }

    public static class ImageLocations {

        //Backgrounds placement
        public static final int HEALTH_BAR_X = 65;
        public static final int HEALTH_BAR_Y = 35;

        //Buttons placement
        public static final int BUTTON_HEIGHT = 227;
        public static final int FEED_BUTTON_X = 23;
        public static final int CLEAN_BUTTON_X = 81;
        public static final int RESET_BUTTON_X = 136;
    }
}
