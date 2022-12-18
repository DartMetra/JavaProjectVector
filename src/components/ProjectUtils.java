package components;
import java.awt.*;


public class ProjectUtils {
    private static final String[] projectFontNames = new String[] {"Ubuntu",
                                                                   "Segoe UI",
                                                                   "Tahoma",
                                                                   "Geneva",
                                                                   "Verdana"};
    public static final String fontName = getProjectFontName();
    private static String styleTag = """
        <style>
            h1, p {
                font-family: %s;
                padding: 2px;
            }
            .description {
                padding: 10px 50px 10px 5px;
                border-left: 2px solid black;
            }
        </style>
        """.formatted(fontName);

    private static String getProjectFontName() {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] allowedFontNames = g.getAvailableFontFamilyNames();

        for (String projectFont : projectFontNames)
            for (String systemFont : allowedFontNames)
                if (projectFont.equals(systemFont))
                    return projectFont;

        return Font.SANS_SERIF;
    }

    public static String html(String inner) {
        return "<html>" + styleTag + inner + "</html>";
    }

    public static String paragraph(String inner) {
        return html("<p>" + inner + "</p>");
    }

    public static void setConstraint(GridBagConstraints gbc, int x, int y,
                                     int width, int height) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
    }

    public static void setConstraint(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
    }
}
