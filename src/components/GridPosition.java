package components;

import java.awt.GridBagConstraints;
import java.awt.Insets;


public class GridPosition extends GridBagConstraints {
    public GridPosition nextCell() {
        this.gridx++;
        return this;
    }

    public GridPosition nextRow() {
        this.gridy++;
        return this;
    }

    public GridPosition setInsets(int left, int top, int right, int bottom) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    public GridPosition setInsets(int inset) {
        this.insets = new Insets(inset, inset, inset, inset);
        return this;
    }
}