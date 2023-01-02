import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * A unified GridPosition class, which is extending a GridBahConstraints class from java.swing.
 * It`s using for setting a concrete constraints to a GridBagLayout layout.
 */
public class GridPosition extends GridBagConstraints {
    public GridPosition(int gridx, int gridy,
                        int gridwidth, int gridheight,
                        double weightx, double weighty,
                        int anchor, int fill,
                        Insets insets, int ipadx, int ipady) {
        super(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady);
    }

    public GridPosition() {
        super();
    }

    /**
     * Moves component onto the next column.
     */
    public GridPosition nextColumn() {
        this.gridx++;
        return this;
    }

    /**
     * Moves component onto the next row.
     */
    public GridPosition nextRow() {
        this.gridy++;
        return this;
    }

    /**
     * Sets a size for a cell.
     */
    public GridPosition setSize(int width, int height) {
        this.gridwidth = width;
        this.gridheight = height;

        return this;
    }

    /**
     * Sets a concrete element position in a grid.
     */
    public GridPosition setPosition(int x, int y) {
        this.gridx = x;
        this.gridy = y;

        return this;
    }

    /**
     * Adds a custom inset for an element.
     */
    public GridPosition setInsets(int left, int top, int right, int bottom) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }
}
