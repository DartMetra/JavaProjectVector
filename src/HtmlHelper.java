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

            .empty-elem,
            .vector-elem {
                margin: 10px 0 30px 0;
            }
            .vector-elem .content,
            .vector-elem .index {
                text-align: center;
                font-weight: 500;
            }
            .vector-elem .content {
                padding: 10px;
                border: 2px solid black;
                border-right: none;
            }
            .vector-elem .index {
                padding: 5px;
            }
            .empty-elem {
                border: 2px solid #5d5d5d;
                border-right: none;
                background-color: #bcbcbc;

                
                padding: 10px 15px;
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
                <p class='content'>%s</p>
                <p class ='index'>%s</p>
            </div>
            """.formatted(content, index);

        return htmlTag(result);
    }

    public static String emptyVectorElem(int index) {
        return htmlTag("<div class='empty-elem'></div>");
    }
}
