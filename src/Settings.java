import java.awt.*;

/**
 * Font settings.
 */
public class Settings {
    private static final String[] projectFontNames = new String[] {
        "Ubuntu",
        "Segoe UI",
        "Tahoma",
        "Geneva",
        "Verdana"
    };
    public static final String fontName = getProjectFontName();
    public static final String programName = "Візуалізація вектора";

    /**
     * Using to set a project font of all available.
     */
    private static String getProjectFontName() {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] systemFontNames = g.getAvailableFontFamilyNames();

        for (String projectFont : projectFontNames)
            for (String systemFont : systemFontNames)
                if (projectFont.equals(systemFont))
                    return projectFont;

        return Font.SANS_SERIF;
    }
}
