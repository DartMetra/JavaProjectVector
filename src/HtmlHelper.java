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
                margin: 10px 0 30px 0;
            }
            .vector-elem .content,
            .vector-elem .index {
                padding: 5px;
                text-align: center;
                font-weight: 500;
            }
            .vector-elem .content {
                padding: 10px;
                width: 50px;
                height: 50px;
                border: 2px solid black;
                border-right: none;
            }
            .vector-elem .empty {
                border: 2px solid green;
                border-right: none;
                background-color: red;
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

    public static String vectorElem(String content, int index) {
        String result = """
            <div class='vector-elem'>
                <p>%s</p>
                <div>%s</div>
            </div>
            """.formatted(content, index);

        return htmlTag(result);
    }

    public static String emptyVectorElem(int index) {
        String result = """
            <div class='vector-elem'>
                <p class='empty'></p>
                <div>%s</div>
            </div>
            """.formatted(index);

        return htmlTag(result);
    }
}
