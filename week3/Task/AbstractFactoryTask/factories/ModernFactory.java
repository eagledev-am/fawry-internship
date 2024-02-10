package factories;

import furnataure.CoffeTable.ModernTable;
import furnataure.Furniture;
import furnataure.chair.ModernChair;
import furnataure.sofa.ModernSofa;

public class ModernFactory implements FurnitureAbstract{
    @Override
    public Furniture getFurniture(FurnatureEnum furnatureEnum) {
        switch (furnatureEnum){
            case SOFA_MODERN  :
                return new ModernSofa();
            case CHAIR_MODERN:
                return new ModernChair();
            case TABLE_MODERN:
                return new ModernTable();
        }
        return null;
    }
}
