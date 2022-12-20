public class HtmlHelper {
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
            .bold { font-weight: 500; }
            .vector-elem {
                padding: 10px;
                border: 2px solid black;
                border-right: none;
                font-weight: 500;
                margin: 10px 0 30px 0;
            }
            .empty-vetor-elem {
                background-color: #dddddd;
            }
        </style>
        """.formatted(Settings.fontName);

    public static String htmlTag(String inner) {
        return "<html>" + basicStyleTag + inner + "</html>";
    }

    public static String plain(String inner) {
        return htmlTag("<p>" + inner + "</p>");
    }

    public static String bold(String inner) {
        return htmlTag("<p class='bold'>" + inner + "</p>");
    }

    public static String vectorElem(String inner) {
        return htmlTag("<p class='vector-elem'>" + inner + "</p>");
    }

    public static String emptyVectorElem() {
        return htmlTag("<p class='empty-vector-elem'></p>");
    }
}
