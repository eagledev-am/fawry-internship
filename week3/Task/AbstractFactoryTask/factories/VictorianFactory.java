package factories;

import furnataure.CoffeTable.VictorianTable;
import furnataure.Furniture;
import furnataure.chair.VictorianChair;
import furnataure.sofa.VictorainSofa;

public class VictorianFactory implements FurnitureAbstract{
    @Override
    public Furniture getFurniture(FurnatureEnum furnatureEnum) {
        switch (furnatureEnum){
            case CHAIR_VICTORIAN :
                return new VictorianChair();
            case TABLE_VICTORIAN:
                return new VictorianTable();
            case SOFA_VICTORIAN:
                return new VictorainSofa();
        }
        return null;
    }
}
