package org.example;

import java.util.HashMap;
import java.util.Map;

public class Plateau {
    private final PlateauSize plateauSize;
    private Map<Plateauable, Position> plateauItems = new HashMap<>();

    public Plateau(PlateauSize plateauSize) {
        this.plateauSize = plateauSize;
    }

    public void addItemToPlateau(Plateauable item, Position position) {
        if (item == null) {
            System.out.println("Cannot add null item to plateau");
            return;
        }
        if (position == null) {
            System.out.println("Cannot add item at null position on plateau");
            return;
        }
        if (position.getX() > this.plateauSize.getX() || position.getY() > this.plateauSize.getY()) {
            System.out.println("Cannot add item to plateau because the position is beyond the " +
                    "limits of the plateau.  Plateau size is: " + this.plateauSize +
                    " and the specified position for the item is: " + position);
        }

        this.plateauItems.put(item, position);
    }

    public void removeItemFromPlateau(Plateauable item) {
        if (item == null) {
            System.out.println("Cannot remove null item from plateau");
            return;
        }
        if (this.plateauItems.containsKey(item)) {
            this.plateauItems.remove(item);
        } else {
            System.out.println("cannot remove item because it does not exist on the plateau");
        }
    }

    public Map<Plateauable, Position> getPlateauItems() {
        return plateauItems;
    }
}
