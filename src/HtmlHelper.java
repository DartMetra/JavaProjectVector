/**
 * To format all text of this project
 * we decided to use html markup
 */
public class HtmlHelper {
    /**
     * Basic styles for our Buttons, Labels, etc.
     */
    private static final String basicStyleTag = """
        <style>
            h1, p {
                font-family: %s, sans-serif;
                padding: 2px;
            }
            .welcome-block {
                padding: 10px 50px 10px 5px;
                border-left: 2px solid black;
            }
            .bold {
                font-weight: 500;
            }
            .element {
                margin: 20px 0 30px 0;
                text-align: center;
                font-weight: 500;
            }
            .first-content,
            .content {
                height: 90px;
                width: 75px;
                padding: 10px;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
            }
            .content {
                border: 2px solid black;
                border-left: none;
            }
            .first-content {
                border: 2px solid black;
            }
            .first-empty-content,
            .empty-content {
                padding: 10px 25px;
                background-color: #bcbcbc;
                border: 2px solid #5d5d5d;
                border-left: none;
            }
            .empty-content {
                border: 2px solid #5d5d5d;
                border-left: none;
            }
            .first-empty-content {
                border: 2px solid #5d5d5d;
            }
            .empty-index,
            .index {
                padding: 5px;
            }
            .empty-index {
                color: #bcbcbc;
            }
            .empty-block {
                padding: 10px;
            }
        </style>
        """.formatted(Settings.fontName);

    /**
     * Using to wrap into an <html> tag.
     */
    public static String htmlTag(String inner) {
        return "<html>" + basicStyleTag + inner + "</html>";
    }

    /**
     * Using to wrap into an <p> tag.
     */
    public static String plain(String inner) {
        return htmlTag("<p>" + inner + "</p>");
    }

    /**
     * Using to wrap into an <h1> tag.
     */
    public static String title(String inner) {
        return htmlTag("<h1>" + inner + "</h1>");
    }

    /**
     * Create a graphic vector interpretation.
     * Fills all created elements of a vector.
     */
    public static String vectorElem(String content, int index) {
        String result;

        if (index == 0)
            result = """
                <div class='element'>
                    <p class='first-content'>%s</p>
                    <p class ='index'>%s</p>
                </div>
                """.formatted(content, index);
        else
            result = """
                <div class='element'>
                    <p class='content'>%s</p>
                    <p class ='index'>%s</p>
                </div>
                """.formatted(content, index);

        return htmlTag(result);
    }

    /**
     * Create a graphic vector interpretation.
     * Fills all capacity elements of a vector.
     */
    public static String vectorElem(int index) {
        String result;

        if (index == 0)
            result = """
                <div class='element'>
                    <p class='first-empty-content'></p>
                    <p class ='empty-index'>%s</p>
                </div>
                """.formatted(index);
        else
            result = """
                <div class='element'>
                    <p class='empty-content'></p>
                    <p class ='empty-index'>%s</p>
                </div>
                """.formatted(index);

        return htmlTag(result);
    }

    /**
     * Using to make left`n`right padding.
     */
    public static String emptyBlock() {
        return htmlTag("<div class='empty-block'></div>");
    }
}
