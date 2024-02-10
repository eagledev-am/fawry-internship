import factories.ArtDecoFactory;
import factories.FurnatureEnum;
import factories.ModernFactory;
import factories.VictorianFactory;
import furnataure.CoffeTable.VictorianTable;
import furnataure.Furniture;
import furnataure.chair.Chair;

public class Main {
    public static void main(String[] args) {
        ArtDecoFactory artDecoFactory = new ArtDecoFactory();
        // art deco chair
        Furniture artDecoChair = artDecoFactory.getFurniture(FurnatureEnum.CHAR_ART_DECO);
        artDecoChair.create();
        // art dec table
        Furniture artDecoTable = artDecoFactory.getFurniture(FurnatureEnum.TABLE_ART_DECO);
        artDecoTable.create();
        // art deco Sofa
        Furniture artDecoSofa = artDecoFactory.getFurniture(FurnatureEnum.SOFA_ART_DECO);
        artDecoSofa.create();

        System.out.println("----------------------");

        ModernFactory modernFactory = new ModernFactory();
        // modern chair
        Furniture modernChair = modernFactory.getFurniture(FurnatureEnum.CHAIR_MODERN);
        modernChair.create();
        // modern table
        Furniture modernTable = modernFactory.getFurniture(FurnatureEnum.TABLE_MODERN);
        modernTable.create();
        // modern sofa
        Furniture modernSofa = modernFactory.getFurniture(FurnatureEnum.SOFA_MODERN);
        modernSofa.create();

        System.out.println("----------------------");


        VictorianFactory victorianFactory = new VictorianFactory();
        // victorian chair
        Furniture victorianChair = victorianFactory.getFurniture(FurnatureEnum.CHAIR_VICTORIAN);
        victorianChair.create();
        // victorian Table
        Furniture victorianTable = victorianFactory.getFurniture(FurnatureEnum.TABLE_VICTORIAN);
        victorianTable.create();
        // victorian Sofa
        Furniture victorianSofa = victorianFactory.getFurniture(FurnatureEnum.TABLE_VICTORIAN);
        victorianSofa.create();
    }
}