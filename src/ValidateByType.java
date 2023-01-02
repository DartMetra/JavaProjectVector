/**
 * Vector type validator.
 */
public class ValidateByType {

    static boolean validate(String value, ElemType type) {
        switch (type) {
            case INT -> {
                try {
                    Integer.parseInt(value);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            case DOUBLE -> {
                try {
                    Double.parseDouble(value);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            case STRING -> {
                return true;
            }
        }
        return false;
    }
}
