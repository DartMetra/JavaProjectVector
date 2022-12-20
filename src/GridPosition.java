import java.awt.*;


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

    public GridPosition nextColumn() {
        this.gridx++;
        return this;
    }

    public GridPosition nextRow() {
        this.gridy++;
        return this;
    }

    public GridPosition setSize(int width, int height) {
        this.gridwidth = width;
        this.gridheight = height;

        return this;
    }

    public GridPosition setPosition(int x, int y) {
        this.gridx = x;
        this.gridy = y;

        return this;
    }

    public GridPosition setInsets(int left, int top, int right, int bottom) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    public GridPosition setInsets(int value) {
        this.insets = new Insets(value, value, value, value);
        return this;
    }
}
