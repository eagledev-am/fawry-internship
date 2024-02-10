package factories;

import furnataure.CoffeTable.ArtDecoTable;
import furnataure.Furniture;
import furnataure.chair.ArtDecoChair;
import furnataure.sofa.ArtDecoSofa;


public class ArtDecoFactory implements FurnitureAbstract{
    @Override
    public Furniture getFurniture(FurnatureEnum furnatureEnum) {
        switch (furnatureEnum){
            case CHAR_ART_DECO :
                return new ArtDecoChair();
            case TABLE_ART_DECO:
                return new ArtDecoTable();
            case SOFA_ART_DECO:
                return new ArtDecoSofa();
        }
        return null;
    }
}
