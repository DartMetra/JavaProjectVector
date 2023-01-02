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

            .element {
                margin: 20px 0 30px 0;
                text-align: center;
                font-weight: 500;
            }
            .content {
                height: 90px;
                width: 75px;
                padding: 10px;
                border: 2px solid black;
                border-left: none;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
            }
            .empty-content {
                padding: 10px 25px;
                border: 2px solid #5d5d5d;
                border-left: none;
                background-color: #bcbcbc;
            }
            .index { padding: 5px; }
            .empty-index {
                padding: 5px;
                color: #bcbcbc;
            }
            .empty-block { padding: 25px; }
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
            <div class='element'>
                <p class='content'>%s</p>
                <p class ='index'>%s</p>
            </div>
            """.formatted(content, index);

        return htmlTag(result);
    }

    public static String vectorElem(int index) {
        String result = """
            <div class='element'>
                <p class='empty-content'></p>
                <p class ='empty-index'>%s</p>
            </div>
            """.formatted(index);

        return htmlTag(result);
    }

    public static String emptyBlock() {
        return htmlTag("<div class='empty-block'></div>");
    }
}
